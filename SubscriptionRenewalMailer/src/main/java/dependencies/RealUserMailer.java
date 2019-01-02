package dependencies;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class RealUserMailer implements UserMailer {

    @Override
    public void sendBillingProblemEmailTo(User user, String message) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        try(PrintWriter output = new PrintWriter(user.getName() + ".email.txt")) {
            output.println(message);
        } catch (FileNotFoundException e) {

        }
    }
}
