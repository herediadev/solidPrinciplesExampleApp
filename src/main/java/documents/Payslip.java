package documents;

import personnel.Employee;

import java.time.Month;

public class Payslip implements ExportableText {

    private final String employeeName;
    private final int monthlyIncome;
    private final Month month;

    public Payslip(Employee employee, Month month) {
        employeeName = employee.getFullName();
        monthlyIncome = employee.getMonthlyIncome();
        this.month = month;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public Month getMonth() {
        return month;
    }

    @Override
    public String toTxt() {
        return "MONTH: " +
                month +
                System.lineSeparator() +
                "NAME: " +
                employeeName +
                System.lineSeparator() +
                "INCOME " +
                monthlyIncome +
                System.lineSeparator();
    }
}
