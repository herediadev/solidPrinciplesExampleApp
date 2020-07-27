package main.java.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmployeeRepository {
    private Employee employee;

    public EmployeeRepository(Employee employee) {
        this.employee = employee;
    }

    public void invoke() {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("### EMPLOYEE RECORD ###")
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
                    .append(System.lineSeparator());

            Path path = Paths.get(employee.getFullName().replace(" ", "_") + ".rec");
            Files.write(path, builder.toString().getBytes());
            System.out.println("Saved employee" + employee.toString());
        } catch (IOException e) {
            System.out.println("Error: could not save employee . " + e);
        }
    }
}
