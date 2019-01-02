import com.fasterxml.jackson.jr.ob.*;
import java.util.Map;

import static spark.Spark.*;

public class FizzBuzzServer {
    public static void main(String[] args) {
        get("/hello", (req, res) -> {
            String response;
            try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("http://localhost:7654/todos").openStream()).useDelimiter("\\A")) {
                response = s.hasNext() ? s.next() : "";
                System.out.println(response);
                Map<String,Object> map = JSON.std.mapFrom(response);
                response = map.get("title").toString();
            }
            return response;
        });
    }
}
