package com.ga.csv;

import com.ga.csv.models.Employee;
import com.ga.csv.services.CsvService;
import com.ga.csv.services.EmployeeService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvService csvService=new CsvService();
        EmployeeService employeeService=new EmployeeService();

        List<Employee> employees=csvService.readEmployees("src/main/resources/test_employees.csv");

        employeeService.processEmployees(employees);

        csvService.writeEmployees("src/main/resources/updated_employees.csv",employees);
        System.out.println("CSV processing completed.");
    }
}
