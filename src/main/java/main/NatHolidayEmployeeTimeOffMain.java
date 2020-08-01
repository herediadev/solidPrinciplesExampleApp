package main;

import logging.ConsoleLogger;
import persistence.EmployeeFileSerializer;
import persistence.EmployeeRepository;
import personnel.Employee;
import personnel.FullTimeEmployee;

import java.util.List;

public class NatHolidayEmployeeTimeOffMain {
    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeRepository(employeeFileSerializer);

        List<Employee> employeeList = employeeRepository.findAll();
        Employee manager = new FullTimeEmployee("Steve Jacksin", 5000);

        for (Employee e : employeeList) {
            e.requestTimeOff(1, manager);
        }
    }
}
