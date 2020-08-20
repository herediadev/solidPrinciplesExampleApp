package main;

import documents.Payslip;
import logging.ConsoleLogger;
import persistence.EmployeeFileSerializer;
import persistence.EmployeeFileRepository;
import persistence.EmployeeRepository;
import personnel.Employee;

import java.time.Month;
import java.util.List;

public class ExportPayslipMain {
    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeFileRepository(employeeFileSerializer);

        List<Employee> employeeList = employeeRepository.findAll();

        for (Employee employee : employeeList) {
            Payslip payslip = new Payslip(employee, Month.AUGUST);
            String exportableText = payslip.toTxt().toUpperCase();
            System.out.println(exportableText);
        }

    }
}
