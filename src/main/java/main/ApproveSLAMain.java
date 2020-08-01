package main;

import logging.ConsoleLogger;
import persistence.EmployeeFileSerializer;
import persistence.EmployeeRepository;
import personnel.ServiceLicenseAgreement;
import personnel.Subcontractor;

import java.util.Arrays;
import java.util.List;

public class ApproveSLAMain {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeRepository(employeeFileSerializer);

        //Define SLA
        int minTimeOffPercent = 98;
        int maxResolutionDays = 2;
        ServiceLicenseAgreement serviceLicenseAgreement = new ServiceLicenseAgreement(minTimeOffPercent, maxResolutionDays);

        Subcontractor rebekah = new Subcontractor("Rebekah Jackson", "rebekah_jackson@abc.com", 3000, 15);
        Subcontractor harry = new Subcontractor("Harry Fitz", "harry_fitz@abc.com", 3000, 15);

        List<Subcontractor> subcontractors = Arrays.asList(rebekah, harry);

        for (Subcontractor subcontractor : subcontractors) {
            subcontractor.approveSLA(serviceLicenseAgreement);
        }
    }
}
