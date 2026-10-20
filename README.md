# Concurrent CSV Data Processor

## Project Overview

A Java application that reads employee records from a CSV file, calculates salary increases based on role, experience, and project completion, and exports the updated records using concurrent processing.

## Technologies Used

Java, Maven, ExecutorService, Semaphore, AtomicInteger, and ReentrantLock.

## Setup Instructions

1. Clone the repository and open it in IntelliJ IDEA.
2. Make sure the JDK and Maven dependencies are configured.
3. Place `test_employees.csv` inside `src/main/resources/`.
4. Run `Main.java`.
5. Find the results in `src/main/resources/updated_employees.csv`.

## Code Documentation

| Class | Responsibility |
|---|---|
| `Employee` | Stores employee information |
| `FileManager` | Handles file reading and writing |
| `CsvService` | Reads and writes employee CSV files using `readEmployees()` and `writeEmployees()` |
| `SalaryService` | Calculates salary increases using `calculateSalary()` |
| `EmployeeService` | Processes employees concurrently using `processEmployees()` |
| `Main` | Runs the complete application workflow |

### Salary Calculation Rules

- Employee: 1% increase
- Manager: 2% increase
- Director: 5% increase
- Experience: Additional 2% per completed year
- Project completion below 60%: No salary increase

### Concurrency Implementation

- **ExecutorService:** Creates a fixed thread pool of 4 threads.
- **Semaphore:** Limits concurrent processing to 2 tasks.
- **AtomicInteger:** Tracks processed employees safely.
- **ReentrantLock:** Protects the counter update and related console output.
- **shutdown() and awaitTermination():** Stop accepting new tasks and wait for processing to finish before exporting the CSV.

## Implementation Report

### Objective

Develop a Java application that processes employee salary data concurrently while maintaining thread safety and generating an updated CSV file.

### Implementation

The project follows an object-oriented structure, separating employee data, CSV operations, salary calculations, and concurrent processing into different classes.

A fixed thread pool manages employee-processing tasks, while a semaphore limits concurrent access. AtomicInteger and ReentrantLock are used for safe progress tracking.

### Results

The application was tested using 30 employee records. All 30 salary calculations were verified as correct, and the updated CSV file was generated successfully without changing other employee information.

### Conclusion

The project successfully demonstrates CSV file handling, object-oriented programming, multithreading, and synchronization in Java.

Future improvements could include automated unit testing, improved error handling, and configurable thread pool sizes.
