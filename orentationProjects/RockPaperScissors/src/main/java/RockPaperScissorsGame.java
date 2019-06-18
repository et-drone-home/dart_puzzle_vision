

public class RockPaperScissorsGame {

  final String draw = "draw";
  final String scissorsWin = "scissors beats paper";
  final String rockWin = "rock beats scissors";
  final String paperWin = "paper covers rock";

  public String determineWinner(String gesture1, String gesture2) {
    if(isDraw(gesture1, gesture2)){
      return draw;
    }if(isPaperAndScissors(gesture1, gesture2)){
      return scissorsWin;
    }if(isRockAndPaper(gesture1, gesture2)){
      return paperWin;
    }
    return rockWin;
  }

  private boolean isDraw(String gesture1, String gesture2) {
    return gesture1.equals(gesture2);
  }

  private boolean isPaperAndScissors(String gesture1, String gesture2) {
    return containsPaper(gesture1, gesture2) && containsScissors(gesture1, gesture2);
  }

  private boolean isRockAndPaper(String gesture1, String gesture2) {
    return containsPaper(gesture1, gesture2) && containsRock(gesture1, gesture2);
  }

  private boolean containsRock(String gesture1, String gesture2) {
    return gesture1.equals("rock") || gesture2.equals("rock");
  }

  private boolean containsPaper(String gesture1, String gesture2) {
    return gesture1.equals("paper") || gesture2.equals("paper");
  }

  private boolean containsScissors(String gesture1, String gesture2) {
    return gesture1.equals("scissors") || gesture2.equals("scissors");
  }
}
