import java.util.Arrays;
import java.util.List;

public class RockPaperScissorsGame {
    private String name;
    private String status;

    public String getGameStatus() {
        return status;
    }

    public RockPaperScissorsGame(String name) {
        this.name = name;
        status = name + " is ready to play";
    }

    public String determineWinner(String gesture1, String gesture2) {
        List<String> gestures = Arrays.asList(gesture1, gesture2);
        if(gesture1.equals(gesture2)) {
            return "tie";
        }else if(gestures.contains("paper") && gestures.contains("scissors")) {
            return "scissors";
        } else if(gestures.contains("paper") && gestures.contains("rock")) {
            return "paper";
        }
        return "rock";
    }

    public void play(String playerGesture, String opponentGesture) {
        String winningGesture = determineWinner(playerGesture, opponentGesture);
        if(winningGesture.equals("tie")) {
            status = name + " ties.";
        }
        else if(winningGesture.equals(playerGesture)) {
            status = name + " wins!";
        } else {
            status = name + " loses. :-(";
        }
    }
}
