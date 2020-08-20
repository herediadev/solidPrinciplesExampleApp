package notifications;

import personnel.Employee;

public interface EmployeeNotifier {
    void send(Employee employee);
}
