package com.ga.csv.services;

import com.ga.csv.models.Employee;
import com.ga.csv.utils.FileManager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//"src/main/resources/test_employees.csv"
public class CsvService {
    public List<Employee> readEmployees(String filename) throws IOException {
        List<String> lines= FileManager.readAllLines(filename);
        List<Employee> employees= new ArrayList<>();

        for (String line : lines){
            String [] data= line.split(",");

            Employee employee= new Employee(
                    Long.parseLong(data[0].trim()),
                    data[1].trim(),
                    Double.parseDouble(data[2].trim()),
                    LocalDate.parse(data[3].trim()),
                    data[4].trim(),
                    Double.parseDouble(data[5].trim())
            );
            employees.add(employee);
        }
        return employees;
    }

    public void writeEmployees(String filename, List<Employee> employees){
    List<String> lines=new ArrayList<>();

        for (Employee employee: employees){
            String line= employee.getId()+","+employee.getName()+","+ employee.getSalary()+","+employee.getStartDate()+","+
                    employee.getRole()+","+employee.getCompletedProject();
            lines.add(line);
        }
        FileManager.overWriteFile(filename, lines);
    }
}
