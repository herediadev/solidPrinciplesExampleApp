package personnel;

public class ServiceLicenseAgreement {
    private int minUptimePercent;
    private int problemResolutionTimeDays;

    public ServiceLicenseAgreement(int minUptimePercent, int problemResolutionTimeDays) {
        this.minUptimePercent = minUptimePercent;
        this.problemResolutionTimeDays = problemResolutionTimeDays;
    }

    public int getMinUptimePercent() {
        return minUptimePercent;
    }

    public void setMinUptimePercent(int minUptimePercent) {
        this.minUptimePercent = minUptimePercent;
    }

    public int getProblemResolutionTimeDays() {
        return problemResolutionTimeDays;
    }

    public void setProblemResolutionTimeDays(int problemResolutionTimeDays) {
        this.problemResolutionTimeDays = problemResolutionTimeDays;
    }
}
