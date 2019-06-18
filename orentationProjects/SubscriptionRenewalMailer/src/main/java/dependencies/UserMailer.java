package dependencies;

public interface UserMailer {
    void sendBillingProblemEmailTo(User user, String messageText, String emailSender);
}
