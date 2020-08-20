package payment;

import notifications.EmployeeNotifier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import persistence.EmployeeRepository;
import personnel.Employee;
import personnel.FullTimeEmployee;
import personnel.Intern;
import personnel.PartTimeEmployee;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PaymentProcessorTest {

    private EmployeeRepository employeeRepositoryMock;
    private EmployeeNotifier employeeNotifierMock;

    @Test
    void send_payments_should_pay_all_employees_salaries() {
        //arrange
        List<Employee> employees = Arrays.asList(
                new FullTimeEmployee("Anna Smith", 1000),
                new PartTimeEmployee("John Doe", 500),
                new Intern("Gabriel Ortega", 200, 10)
        );

        employeeRepositoryMock = Mockito.mock(EmployeeRepository.class);
        employeeNotifierMock = Mockito.mock(EmployeeNotifier.class);

        PaymentProcessor paymentProcessor = new PaymentProcessor(employeeRepositoryMock, employeeNotifierMock);

        Mockito.when(employeeRepositoryMock.findAll()).thenReturn(employees);

        //act
        int payments = paymentProcessor.sendPayments();

        //assert
        assertEquals(1700, payments);

    }
}