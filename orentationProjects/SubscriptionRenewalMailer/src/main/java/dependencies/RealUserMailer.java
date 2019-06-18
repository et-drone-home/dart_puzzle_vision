package dependencies;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class RealUserMailer implements UserMailer {

    @Override
    public void sendBillingProblemEmailTo(User user, String messageText, String emailSender) {
        try {
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", "mail.smtpbucket.com");
            properties.setProperty("mail.smtp.port", "8025");
            Session session = Session.getDefaultInstance(properties);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailSender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject("Billing Inquiry");
            message.setText(messageText);

            Transport.send(message);
        } catch(Exception ex) {

        }
    }
}
