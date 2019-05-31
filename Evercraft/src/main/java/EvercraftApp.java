import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import static spark.Spark.*;

public class EvercraftApp {
    public static int steveHitPoints = -1;
    public static int bryceHitPoints = -1;

    public static void main(String[] args) throws IOException {
        port(4567);
        get("/", (req, res) -> {

            return "<html><head></head>" +
                    "<body>" +
                    "<h1>Welcome to Evercraft</h1>" +
                    "<form action=\"/new-game\" method=\"post\">" +
                    "<button type=\"submit\" id=\"newGame\">New Game</button>" +
                    "</form>" +
                    "<p>Steve vs. Bryce</p>" +
                    getS() +
                    "</body>" +
                    "</html>";
        });
        post("/attack", (req, res) -> {
            bryceHitPoints--;
            res.redirect("/");
            return "";
        });
        post("/new-game", (req, res) -> {
            steveHitPoints = 5;
            bryceHitPoints = 5;
            res.redirect("/");
            return "";
        });


//        List<String> strings = Files.readAllLines(Paths.get("characters.csv"));
    }

    private static String getS() {
        if(bryceHitPoints == 0) {
            return "<p>Steve wins!</p>";
        } else if(steveHitPoints == -1) {
            return "";
        }
        String s = "<table>" +
                "<thead><th></th><th>Steve</th><th>Bryce</th></thead>" +
                "<tr><td>Hit Points</td><td id=\"steveHitPoints\">" + steveHitPoints + "</td><td id=\"bryceHitPoints\">" + bryceHitPoints + "</td></tr>" +
                "<tr><td>Armor</td><td>10</td><td>10</td></tr>" +
                "<tr><td>Strength</td><td>12</td><td>8</td></tr>" +
                "<tr><td>Dexterity</td><td>8</td><td>12</td></tr>" +
                "<tr><td>Constitution</td><td>10</td><td>10</td></tr>" +
                "</table>" +
                "<form action=\"/attack\" method=\"post\">" +
                "<button type=\"submit\" id=\"attack\">Attack</button>" +
                "</form>";
        return s;
    }
}
