package taxes;

import personnel.Employee;

public class FullTimeTaxCalculator implements TaxCalculator {

    private static final int BASE_HEALTH_INSURANCE = 10;
    private static final int RETIREMENT_TAX_PERCENTAGE = 16;
    private static final int INCOME_TAX_PERCENTAGE = 100;

    @Override
    public double calculate(Employee employee) {
        int monthlyIncome = employee.getMonthlyIncome();

        return BASE_HEALTH_INSURANCE
                + (monthlyIncome * RETIREMENT_TAX_PERCENTAGE) / 100d
                + (monthlyIncome * INCOME_TAX_PERCENTAGE) / 100d;
    }
}
