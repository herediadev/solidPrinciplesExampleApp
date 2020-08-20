package main;

import logging.ConsoleLogger;
import persistence.EmployeeFileSerializer;
import persistence.EmployeeFileRepository;
import persistence.EmployeeRepository;
import personnel.Employee;
import taxes.TaxCalculator;
import taxes.TaxCalculatorFactory;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CalculateTaxesMain {
    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeFileRepository(employeeFileSerializer);

        List<Employee> employeeList = employeeRepository.findAll();

        Locale locale = new Locale("es", "CL");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        Double totalTaxes = employeeList
                .stream()
                .map(employee -> toEmployeeTaxAmount(consoleLogger, currencyFormatter, employee))
                .reduce(0d, Double::sum);

        consoleLogger.writeInfo("Total Taxes = " + currencyFormatter.format(totalTaxes));

    }

    private static Double toEmployeeTaxAmount(ConsoleLogger consoleLogger, NumberFormat currencyFormatter, Employee employee) {
        TaxCalculator taxCalculator = TaxCalculatorFactory.create(employee);

        //compute individual tax
        double tax = taxCalculator.calculate(employee);
        String formattedTax = currencyFormatter.format(tax);
        consoleLogger.writeInfo(employee.getFullName() + " taxes: " + formattedTax);
        return tax;
    }
}
