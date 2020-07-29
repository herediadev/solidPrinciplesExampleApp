package taxes;

import personnel.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class TaxCalculatorFactory {

    private static final Map<String, Supplier<TaxCalculator>> CALCULATOR_HASH_MAP;

    static {
        CALCULATOR_HASH_MAP = new HashMap<>();
        CALCULATOR_HASH_MAP.put("FullTimeEmployee", FullTimeTaxCalculator::new);
        CALCULATOR_HASH_MAP.put("PartTimeEmployee", PartTimeTaxCalculator::new);
        CALCULATOR_HASH_MAP.put("Intern", InternTaxCalculator::new);
    }


    public static TaxCalculator create(Employee employee) {
        Supplier<TaxCalculator> taxCalculatorSupplier = CALCULATOR_HASH_MAP.get(employee.getClass().getSimpleName());
        TaxCalculator taxCalculator = taxCalculatorSupplier.get();

        Optional.ofNullable(taxCalculator).orElseThrow(() -> new RuntimeException("Invalid employee type"));

        return taxCalculator;
    }
}
