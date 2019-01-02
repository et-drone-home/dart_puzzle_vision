import dependencies.RealUserMailer;
import dependencies.RealUserRepository;
import org.junit.Test;
import subscriptions.EmailSweeper;

public class EmailSweeperTest {
    @Test
    public void something() {
        EmailSweeper sweeper = new EmailSweeper(new RealUserRepository(), new RealUserMailer());
        sweeper.sweep();

        // assert something
    }
}
