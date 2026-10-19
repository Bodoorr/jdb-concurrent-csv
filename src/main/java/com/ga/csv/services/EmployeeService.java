package com.ga.csv.services;

import com.ga.csv.models.Employee;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeService {
    public void processEmployees(List<Employee> employees){
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(4);
        SalaryService salaryService= new SalaryService();

        for (Employee employee: employees){
            fixedThreadPool.submit(()->{
                double newSalary= salaryService.calculateSalary(employee);
                employee.setSalary(newSalary);
                System.out.println(employee.getName() + " processed by "+Thread.currentThread().getName());
            });
        }
        fixedThreadPool.shutdown();
    }
}
