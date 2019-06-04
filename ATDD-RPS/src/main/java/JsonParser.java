import com.fasterxml.jackson.jr.ob.JSON;

import java.io.IOException;
import java.io.InputStream;

public class JsonParser {
    public static String getGesture(InputStream inputStream) throws IOException {
        String jsonString = new java.util.Scanner(inputStream).useDelimiter("\\A").next();
        return JSON.std.<String>mapFrom(jsonString).get("gesture").toString();
    }
}
