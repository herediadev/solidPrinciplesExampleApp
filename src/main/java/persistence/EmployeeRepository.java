package persistence;

import personnel.Employee;
import personnel.FullTimeEmployee;
import personnel.Intern;
import personnel.PartTimeEmployee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class EmployeeRepository {

    private final EmployeeFileSerializer employeeFileSerializer;

    public EmployeeRepository(EmployeeFileSerializer employeeFileSerializer) {
        this.employeeFileSerializer = employeeFileSerializer;
    }

    public List<Employee> findAll() {
        Employee anna = new FullTimeEmployee("Anna Smith", 2000);
        Employee billy = new FullTimeEmployee("Billy Leech", 920);
        Employee steve = new FullTimeEmployee("Steve Jones", 800);
        Employee magda = new FullTimeEmployee("Magda Iovan", 920);
        Employee john = new Intern("John Lee", 290);
        Employee catherine = new PartTimeEmployee("Catherine Allison", 500);

        return Arrays.asList(anna, billy, steve, magda, john, catherine);
    }

    public void save(Employee employee) throws IOException {
        String serializedEmployee = employeeFileSerializer.invoke(employee);

        Path path = Paths.get("src/main/resources/" + employee.getFullName().replace(" ", "_") + ".rec");
        Files.write(path, serializedEmployee.getBytes());
    }

}
