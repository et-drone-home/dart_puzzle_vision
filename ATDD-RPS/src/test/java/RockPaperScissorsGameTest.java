import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RockPaperScissorsGameTest {
    RockPaperScissorsGame game = new RockPaperScissorsGame("Steve");

    @Test
    public void rockCrushScissors() {
        assertEquals("rock", game.determineWinner("rock", "scissors"));
    }

    @Test
    public void scissorsCutPaper() {
        assertEquals("scissors", game.determineWinner("paper", "scissors"));
    }

    @Test
    public void paperCoversRock() {
        assertEquals("paper", game.determineWinner("paper", "rock"));
    }

    @Test
    public void paperTiesPaper() {
        assertEquals("tie", game.determineWinner("paper", "paper"));
    }

    @Test
    public void reversedPaperCoversRock() {
        assertEquals("paper", game.determineWinner("rock", "paper"));
    }

    @Test
    public void reversedScissorsCutPaper() {
        assertEquals("scissors", game.determineWinner("scissors", "paper"));
    }

    @Test
    public void initialGameStatusIsPlayerIsReadyToPlay() {
        assertEquals("Steve is ready to play", game.getGameStatus());
    }

    @Test
    public void whenPlayerOneWinsThenDisplayWins() {
        game.play("rock", "scissors");
        assertEquals("Steve wins!", game.getGameStatus());
    }

    @Test
    public void whenPlayerOneLosesThenDisplayLoses() {
        game.play("scissors", "rock");
        assertEquals("Steve loses. :-(", game.getGameStatus());
    }

    @Test
    public void whenPlayerOneTiesThenDisplayTies() {
        game.play("paper", "paper");
        assertEquals("Steve ties.", game.getGameStatus());
    }

}

