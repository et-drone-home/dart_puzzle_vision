import static org.junit.Assert.*;

import org.junit.Test;

public class RockPaperScissorsGameTest {
   RockPaperScissorsGame game = new RockPaperScissorsGame();

  @Test
  public void rockCrushesScissors() {
    String actualResult = game.determineWinner("rock", "scissors");
    String expectedResult = game.rockWin;
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void scissorsBeatsPaper() {
    String actualResult = game.determineWinner("scissors", "paper");
    String expectedResult = game.scissorsWin;
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void paperCutByScissors() {
    String actualResult = game.determineWinner("paper", "scissors");
    String expectedResult = game.scissorsWin;
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void paperCoversRock() {
    String actualResult = game.determineWinner( "paper", "rock");
    String expectedResult = game.paperWin;
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void rockGetsCoveredByPaper() {
    String actualResult = game.determineWinner("rock", "paper");
    String expectedResult = game.paperWin;
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void rockDrawsAgainstRock() {
    String actualResult = game.determineWinner( "rock", "rock");
    String expectedResult = game.draw;
    assertEquals(expectedResult, actualResult);
  }

}
