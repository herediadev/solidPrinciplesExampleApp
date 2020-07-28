package main;

import logging.ConsoleLogger;
import persistence.EmployeeFileSerializer;
import persistence.EmployeeRepository;
import personnel.Employee;

import java.io.IOException;
import java.util.List;

public class SaveEmployeesMain {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeRepository(employeeFileSerializer);

        List<Employee> employeeList = employeeRepository.findAll();

        employeeList
                .forEach(employee -> {
                    try {
                        employeeRepository.save(employee);
                        consoleLogger.writeInfo("Saved employee " + employee.toString());
                    } catch (IOException exception) {
                        consoleLogger.writeError("Error saving employee", exception);
                    }
                });
    }
}
