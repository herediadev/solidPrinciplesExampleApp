package payment;

import notifications.EmailSender;
import persistence.EmployeeFileRepository;
import persistence.EmployeeFileSerializer;
import personnel.Employee;

import java.util.List;

public class PaymentProcessor {

    private final EmployeeFileRepository employeeFileRepository;

    public PaymentProcessor() {
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        employeeFileRepository = new EmployeeFileRepository(employeeFileSerializer);
    }

    public int sendPayments() {
        List<Employee> employees = employeeFileRepository.findAll();
        int totalPayment = 0;

        for (Employee employee : employees) {
            totalPayment += employee.getMonthlyIncome();
            EmailSender.notify(employee);
        }

        return totalPayment;
    }
}
