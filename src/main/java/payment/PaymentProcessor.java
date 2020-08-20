package payment;

import notifications.EmployeeNotifier;
import persistence.EmployeeRepository;
import personnel.Employee;

import java.util.List;

public class PaymentProcessor {

    private final EmployeeRepository employeeFileRepository;
    private final EmployeeNotifier emailSender;

    public PaymentProcessor(
            EmployeeRepository employeeFileRepository,
            EmployeeNotifier emailSender
    ) {
        this.employeeFileRepository = employeeFileRepository;
        this.emailSender = emailSender;
    }

    public int sendPayments() {
        List<Employee> employees = employeeFileRepository.findAll();
        int totalPayment = 0;

        for (Employee employee : employees) {
            totalPayment += employee.getMonthlyIncome();
            emailSender.send(employee);
        }

        return totalPayment;
    }
}
