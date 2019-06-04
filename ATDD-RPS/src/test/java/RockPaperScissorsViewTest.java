import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RockPaperScissorsViewTest {
    @Test
    public void whenGameNotStartedDisplayNameForm() {
        RockPaperScissorsGame notStartedGame = null;
        RockPaperScissorsView view = new RockPaperScissorsView();

        String page = view.presentPage(notStartedGame);
        assertTrue("Page does not contain name form. " + page, page.contains("<form action=\"enter-name\""));
    }

    @Test
    public void whenGameUnderwayDisplayGameStatus() {
        RockPaperScissorsGame game = new RockPaperScissorsGame("Steve");
        RockPaperScissorsView view = new RockPaperScissorsView();

        String page = view.presentPage(game);
        assertTrue("Page does not contain game status. " + page, page.contains("<p id=\"gameStatus\">"));
    }
}
