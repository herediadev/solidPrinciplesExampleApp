package personnel;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private int monthlyIncome;
    private int nbHoursPerWeek;

    public Employee(String fullName, int monthlyIncome) {
        setMonthlyIncome(monthlyIncome);
        String[] names = fullName.split(" ");
        firstName = names[0];
        lastName = names[1];
    }

    public String getEmail() {
        return firstName + "." + lastName + "@globomantishr.com";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                '}';
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        if (monthlyIncome < 0)
            throw new IllegalArgumentException("Income must be positive");

        this.monthlyIncome = monthlyIncome;
    }

    public int getNbHoursPerWeek() {
        return nbHoursPerWeek;
    }

    public void setNbHoursPerWeek(int nbHoursPerWeek) {
        if (nbHoursPerWeek <= 0)
            throw new IllegalArgumentException("Income must be positive");

        this.nbHoursPerWeek = nbHoursPerWeek;
    }

    public String getFullName() {
        return firstName + " " + this.lastName;
    }
}
