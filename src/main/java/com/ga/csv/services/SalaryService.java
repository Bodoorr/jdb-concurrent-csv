package com.ga.csv.services;

import com.ga.csv.models.Employee;

import java.time.LocalDate;
import java.time.Period;

public class SalaryService {
    public double calculateSalary(Employee employee){
        if (employee.getCompletedProject() < 0.6){
            return employee.getSalary();
        }

        LocalDate startDate= employee.getStartDate();
        LocalDate today= LocalDate.now();
        //2026 - 2022 = 4
        int workedYears= today.getYear() - startDate.getYear();

        if (today.isBefore(startDate.plusYears(workedYears))){
            workedYears --;
        }

        double roleIncrease= 0;
        if (employee.getRole().equalsIgnoreCase("Director")){
            roleIncrease=0.05;
        } else if (employee.getRole().equalsIgnoreCase("Manager")){
            roleIncrease= 0.02;
        } else if (employee.getRole().equalsIgnoreCase("Employee")){
            roleIncrease= 0.01;
        }

        double total= roleIncrease+ (workedYears*0.02);
        double increaseAmount= employee.getSalary() * total;
        double newSalary= employee.getSalary() + increaseAmount;

        return newSalary;
    }
}
