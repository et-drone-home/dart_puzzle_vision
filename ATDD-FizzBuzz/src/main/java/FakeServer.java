import com.fasterxml.jackson.jr.ob.JSON;

import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;

public class FakeServer {
    public static void main(String[] args) {
        port(7654);
        get("/todos", (req, res) -> {
            return "{\"userId\": 1,\n" +
                    "\"id\": 1,\n" +
                    "\"title\": \"delectus aut autem\",\n" +
                    "\"completed\": false\n" +
                    "}";
        });
    }
}
