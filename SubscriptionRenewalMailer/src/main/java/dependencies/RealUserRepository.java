package dependencies;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RealUserRepository implements UserRepository {
    Random random = new Random();
    @Override
    public List<User> getUsers() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        if(random.nextBoolean()) {
            return null;
        } else {
            return Arrays.asList(new User(true, LocalDate.of(2018, 12, 12), "Steve"));
        }
    }
}
