package main;

import payment.PaymentProcessor;

public class PayEmployeesMain {

    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        int totalPayments = paymentProcessor.sendPayments();
        System.out.println("Total Payments = " + totalPayments);
    }
}
