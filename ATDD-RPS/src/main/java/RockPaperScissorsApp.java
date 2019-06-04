import spark.Response;

import static spark.Spark.get;
import static spark.Spark.post;

public class RockPaperScissorsApp {
    private static RockPaperScissorsGame game;
    private static RockPaperScissorsView view = new RockPaperScissorsView();

    public static void main(String[] args) {
        get("/", (req, res) -> {
            return view.presentPage(game);
        });
        post("/enter-name", ((request, response) -> {
            game = new RockPaperScissorsGame(request.queryParams("name"));
            return redirectHome(response);
        }));
        post("/new-game", ((request, response) -> {
            game = null;
            return redirectHome(response);
        }));
        post("/play", ((request, response) -> {
            String opponentGesture = JsonParser.getGesture(new java.net.URL("http://localhost:7654/gesture").openStream());
            String gesture = request.queryParams("gesture");
            game.play(gesture, opponentGesture);
            return redirectHome(response);
        }));
    }

    private static String redirectHome(Response response) {
        response.redirect("/");
        return "";
    }

}
