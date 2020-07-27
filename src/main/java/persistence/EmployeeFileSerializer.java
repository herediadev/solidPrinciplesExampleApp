package persistence;

import personnel.Employee;

public class EmployeeFileSerializer {

    public String invoke(Employee employee) {
        return new StringBuilder()
                .append("### EMPLOYEE RECORD ###")
                .append(System.lineSeparator())
                .append("NAME: ")
                .append(employee.getFullName())
                .append(System.lineSeparator())
                .append("POSITION: ")
                .append(employee.getClass().getTypeName())
                .append(System.lineSeparator())
                .append("EMAIL: ")
                .append(employee.getEmail())
                .append(System.lineSeparator())
                .append("MONTHLY WAGE: ")
                .append(employee.getMonthlyIncome())
                .append(System.lineSeparator())
                .toString();
    }
}
