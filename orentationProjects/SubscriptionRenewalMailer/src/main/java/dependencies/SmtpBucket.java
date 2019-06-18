package dependencies;

import com.fasterxml.jackson.jr.ob.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SmtpBucket {
    public static List<String> getEmailIds(String senderEmail) {
        List<String> emailIds = new ArrayList<String>();
        try
        {
            Process process = Runtime.getRuntime().exec(new String[] {
                    "curl",
                    "-G",
                    "https://api.smtpbucket.com/emails",
                    "--data-urlencode",
                    "sender=" + senderEmail});
            while(process.isAlive()) {
                Thread.sleep(10);
            }
            String jsonString = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A").next();
            List<Object> results = (List<Object>) JSON.std.<String>mapFrom(jsonString).get("results");
            for(Object o : results) {
//                emailIds.add(((Map<String, Object>) o).get("email").toString());
                emailIds.add(((Map<String, Object>) o).get("id").toString());
            }
        } catch(Exception e) {
        }
        return emailIds;
    }

    public static void deleteEmails(List<String> ids) throws IOException {
        for(String id : ids) {
            Runtime.getRuntime().exec(new String[] {
                    "curl",
                    "-X",
                    "DELETE",
                    "https://api.smtpbucket.com/emails/" + id});
        }
    }
}