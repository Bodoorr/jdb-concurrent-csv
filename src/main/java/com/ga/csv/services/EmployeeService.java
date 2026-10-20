package com.ga.csv.services;

import com.ga.csv.models.Employee;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EmployeeService {
    public void processEmployees(List<Employee> employees){
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(4);
        Semaphore semaphore=new Semaphore(2);

        SalaryService salaryService= new SalaryService();
        AtomicInteger processedCount= new AtomicInteger(0);
        Lock lock= new ReentrantLock();

        for (Employee employee: employees){
            fixedThreadPool.execute(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

                try {
                    System.out.println(Thread.currentThread().getName() + " acquired connection.");
                    double newSalary= salaryService.calculateSalary(employee);
                    employee.setSalary(newSalary);

                    lock.lock();

                    try {
                        processedCount.incrementAndGet();
                        System.out.println("Processed employees: "+processedCount.get());

                        System.out.println(employee.getName() + " processed by "+Thread.currentThread().getName());
                    } finally {
                        lock.unlock();
                    }

                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+ " released connection ...........");
                }

            });
        }
        fixedThreadPool.shutdown();
    }
}
