package taxes;

import personnel.Employee;

public class InternTaxCalculator implements TaxCalculator {
    private static final int INCOME_TAX_PERCENTAGE = 16;

    @Override
    public double calculate(Employee employee) {
        int monthlyIncome = employee.getMonthlyIncome();

        if (monthlyIncome < 350)
            return 0;

        return (monthlyIncome * INCOME_TAX_PERCENTAGE) / 100d;
    }
}
