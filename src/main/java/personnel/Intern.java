package personnel;

public class Intern extends Employee {
    public Intern(String fullName, int monthlyIncome, int nbHours) {
        super(fullName, monthlyIncome);
        setNbHoursPerWeek(nbHours);
    }

    @Override
    public void requestTimeOff(int nbDays, Employee manager) {
        System.out.println("Time off request for intern " +
                getFullName() +
                "; Nb days " + nbDays +
                "; Requested from " + manager.getFullName());
    }
}
