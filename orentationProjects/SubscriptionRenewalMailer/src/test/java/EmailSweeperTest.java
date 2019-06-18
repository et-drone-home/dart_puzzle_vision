import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import dependencies.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import subscriptions.EmailSweeper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;

public class EmailSweeperTest {

    List<String> smtpUsers;

    @Before
    public void setupCleanUp() throws Exception {
        UserDb.cleanDB();
        smtpUsers = SmtpBucket.getEmailIds("evan@pillar.com");
        SmtpBucket.deleteEmails(smtpUsers);
    }

    @Test
    public void whenSMTPExistsRetrievesActiveUsersIDs() {
        UserDb.seedDatabase(new User(true, LocalDate.of(2018, 1, 1), "testuser@pillar.test.com"));
        UserRepository userRepository = new RealUserRepository();
        UserMailer userMailer = new RealUserMailer();

        EmailSweeper sweeper = new EmailSweeper(userRepository, userMailer);
        sweeper.sweep();

        smtpUsers = SmtpBucket.getEmailIds("evan@pillar.com");

        assertEquals(1, smtpUsers.size());
    }

    @Test
    public void filtersInactiveUsersOut(){
        EmailSweeper sweeper = new EmailSweeper(null, null);
        User activeUser = new User(true,LocalDate.of(2012, 2, 1), "juan@juan.com");
        List<User> filteredUsers = sweeper.activeUsers(Arrays.asList(
                activeUser,
                        new User(false,LocalDate.of(2012, 2, 1), "evan@evan.com")));
        assertEquals(activeUser, filteredUsers.get(0));
    }

    @After
    public void tearDown() throws Exception {
        SmtpBucket.deleteEmails(smtpUsers);
        UserDb.cleanDB();
    }

}
