import com.fasterxml.jackson.jr.ob.JSON;

import java.util.Map;

import static spark.Spark.*;

public class FakeServer {
    static String title = "title";

    public static void main(String[] args) {
        port(7654);
        get("/todos", (req, res) -> {
            return "{ \"title\": \"" + title + "\"}";
        });
        put("/todos", (req, res) -> {
            Map<String,Object> map = JSON.std.mapFrom(req.body());
            title = map.get("title").toString();
            return title;
        });
    }
}
