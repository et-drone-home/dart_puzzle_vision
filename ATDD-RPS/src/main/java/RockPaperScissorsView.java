public class RockPaperScissorsView {
    public String presentPage(RockPaperScissorsGame game) {
        if (gameUnderWay(game)) {
            return pageStart() + newGameForm() + displayGameStatus(game) + displayGestureInput() + pageEnd();
        } else {
            return pageStart() + newGameForm() + enterNameForm() + pageEnd();
        }
    }

    private boolean gameUnderWay(RockPaperScissorsGame game) {
        return game != null;
    }

    private String displayGameStatus(RockPaperScissorsGame game) {
        return "<p id=\"gameStatus\">" + game.getGameStatus() + "</p>";
    }

    private String pageEnd() {
        return "</body></html>";
    }

    private String pageStart() {
        return "<html><body>";
    }

    private String enterNameForm() {
        return "<form action=\"enter-name\" method=\"post\"><input type=\"text\" id=\"name\" name=\"name\"></input><button type=\"submit\" id=\"submitName\">Submit</button></form>";
    }

    private String newGameForm() {
        return "<form action=\"new-game\" method=\"post\"><button type=\"submit\" id=\"newGame\">New Game</button></form>";
    }

    private String displayGestureInput() {
        return "<form action=\"play\" method=\"post\"><input type=\"text\" id=\"gesture\" name=\"gesture\"></input><button type=\"submit\" id=\"play\">Play</button></form>";
    }
}
