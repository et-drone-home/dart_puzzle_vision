import com.fasterxml.jackson.jr.ob.JSON;

import java.util.Map;

import static spark.Spark.*;

public class FakeServer {
    static String gesture = "rock";

    public static void main(String[] args) {
        port(7654);
        get("/gesture", (req, res) -> "{\"gesture\": \"" + gesture + "\"}");
        put("/gesture", (req, res) -> {
            Map<String,Object> map = JSON.std.mapFrom(req.body());
            gesture = map.get("gesture").toString();
            return gesture;
        });
    }
}
