package main;

import notifications.EmailSender;
import payment.PaymentProcessor;
import persistence.EmployeeFileRepository;
import persistence.EmployeeFileSerializer;

public class PayEmployeesMain {

    public static void main(String[] args) {
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmailSender emailSender = new EmailSender();
        EmployeeFileRepository employeeFileRepository = new EmployeeFileRepository(employeeFileSerializer);

        PaymentProcessor paymentProcessor = new PaymentProcessor(employeeFileRepository, emailSender);

        int totalPayments = paymentProcessor.sendPayments();
        System.out.println("Total Payments = " + totalPayments);
    }
}
