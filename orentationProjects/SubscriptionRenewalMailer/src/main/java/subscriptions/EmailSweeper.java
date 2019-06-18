package subscriptions;

import dependencies.User;
import dependencies.UserMailer;
import dependencies.UserRepository;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmailSweeper {

    private static final String EMAIL_SENDER = "evan@pillar.com";
    private final UserMailer mailer;
    private final UserRepository repository;

    public EmailSweeper(UserRepository repository, UserMailer mailer) {
        this.mailer = mailer;
        this.repository = repository;
    }

    public void sweep() {

        repository
                .getUsers()
                .stream()
                .filter(user -> activeUsers(user))
                .forEach(sendEmailToUser());
    }

    private Consumer<User> sendEmailToUser() {
        return user -> mailer.sendBillingProblemEmailTo(user, "", EMAIL_SENDER);
    }

    public Stream<User> activeUsers(List<User> asList) {
        return asList.stream().filter(user -> user.isActive());
    }
}
