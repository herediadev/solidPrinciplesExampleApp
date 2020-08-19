package persistence;

import personnel.Employee;
import personnel.FullTimeEmployee;
import personnel.Intern;
import personnel.PartTimeEmployee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeFileRepository {
    private final EmployeeFileSerializer employeeFileSerializer;

    public EmployeeFileRepository(EmployeeFileSerializer employeeFileSerializer) {
        this.employeeFileSerializer = employeeFileSerializer;
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        String path = getClass().getClassLoader()
                .getResource("employees.csv")
                .getPath();

        try (Scanner scanner = new Scanner(new File(path))) {
            //skip header
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Employee employee = createEmployeeFromCsvRecord(line);
                employees.add(employee);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void save(Employee employee) throws IOException {
        String serializedEmployee = employeeFileSerializer.serialize(employee);

        Path path = Paths.get("src/main/resources/" + employee.getFullName().replace(" ", "_") + ".rec");
        Files.write(path, serializedEmployee.getBytes());
    }

    private Employee createEmployeeFromCsvRecord(String line) {
        String[] employeeRecord = line.split(",");
        String name = employeeRecord[0];
        int income = Integer.parseInt(employeeRecord[1]);
        int nbHours = Integer.parseInt(employeeRecord[2]);
        Employee employee;

        if (nbHours == 40)
            employee = new FullTimeEmployee(name, income);
        else if (nbHours == 20)
            employee = new PartTimeEmployee(name, income);
        else
            employee = new Intern(name, income, nbHours);

        return employee;
    }
}
