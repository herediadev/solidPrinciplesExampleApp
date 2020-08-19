package persistence;

import personnel.Employee;

public class EmployeeFileSerializer {

    public String serialize(Employee employee) {
        return "### EMPLOYEE RECORD ###" +
                System.lineSeparator() +
                "NAME: " +
                employee.getFullName() +
                System.lineSeparator() +
                "POSITION: " +
                employee.getClass().getTypeName() +
                System.lineSeparator() +
                "EMAIL: " +
                employee.getEmail() +
                System.lineSeparator() +
                "MONTHLY WAGE: " +
                employee.getMonthlyIncome() +
                System.lineSeparator();
    }
}
