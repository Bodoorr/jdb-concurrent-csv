package com.ga.csv.models;

import java.time.LocalDate;

public class Employee {
    private Long id;
    private String name;
    private double salary;
    private LocalDate startDate;
    private String role;
    private double completedProject;

    public Employee(Long id, String name, double salary, LocalDate startDate, String role, double completedProject) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
        this.role = role;
        this.completedProject = completedProject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getCompletedProject() {
        return completedProject;
    }

    public void setCompletedProject(double completedProject) {
        this.completedProject = completedProject;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", role='" + role + '\'' +
                ", completedProject=" + completedProject +
                '}';
    }
}
