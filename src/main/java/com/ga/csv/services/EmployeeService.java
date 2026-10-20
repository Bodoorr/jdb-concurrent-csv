package com.ga.csv.services;

import com.ga.csv.models.Employee;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class EmployeeService {
    public void processEmployees(List<Employee> employees){
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(4);
        Semaphore semaphore=new Semaphore(2);

        SalaryService salaryService= new SalaryService();

        for (Employee employee: employees){
            fixedThreadPool.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " acquired connection.");
                    double newSalary= salaryService.calculateSalary(employee);
                    employee.setSalary(newSalary);
                    System.out.println(employee.getName() + " processed by "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+ " released connection ...........");
                }

            });
        }
        fixedThreadPool.shutdown();
    }
}
