package notifications;

import personnel.Employee;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailSender implements EmployeeNotifier {

    @Override
    public void send(Employee employee) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.mailtrap.io");
        properties.put("mail.smtp.port", "2525");
        properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("5d205e8b9503f6", "969159ed0125ea");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            //to/from

            message.setFrom(new InternetAddress("payment@globomantics.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(employee.getEmail()));

            //subject
            message.setSubject("Salary Notification");

            //content
            String msg = "Salary sent; Value: $" + employee.getMonthlyIncome();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "txt/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            //send and wait (mail server has limit)
            Transport.send(message);
            System.out.println("Notified " + employee.getEmail());
            Thread.sleep(3000);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
