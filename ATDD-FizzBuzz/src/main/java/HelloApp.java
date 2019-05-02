import com.fasterxml.jackson.jr.ob.*;

import java.util.Map;

public class HelloApp {
    public static void main(String[] args) throws Exception {
        String response;
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("http://localhost:7654/todos").openStream()).useDelimiter("\\A")) {
            response = s.hasNext() ? s.next() : "";
            Map<String,Object> map = JSON.std.mapFrom(response);
            response = map.get("title").toString();
        }
        System.out.print(response);
    }
}
