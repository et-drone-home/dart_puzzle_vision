package com.atdd.rps;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GameSteps implements En {
    EventFiringWebDriver webDriver;
    String name = "Steve";
    public static final String ROCK_PAPER_SCISSORS_GAME_URL = "http://localhost:4567/";
    public static final String FAKE_GESTURE_SERVER_URL = "http://localhost:9876/gesture";

    public GameSteps() {
        Before(() -> {
            loadRockPaperScissorsGamePage();
        });

        After(() -> webDriver.close());

        Given("a new game", () -> {
            startNewGame();
        });

        When("I enter my name", () -> {
            enterPlayerName(this.name);
        });

        Then("I am ready to play", () -> {
            checkForReadyToPlayStatus();
        });

        Given("I am already ready to play", () -> {
            startNewGame();
            enterPlayerName(this.name);
            checkForReadyToPlayStatus();
        });

        Given("my opponent will play gesture '(.*)'", (String gesture) -> {
            setupOpponentGesture(gesture);
        });

        When("I play gesture '(.*)'", (String gesture) -> {
            playGesture(gesture);
        });

        Then("I win", () -> {
            assertEquals(name + " wins!", webDriver.findElement(By.id("gameStatus")).getText());
        });

        Then("I lose", () -> {
            assertEquals(name + " loses. :-(", webDriver.findElement(By.id("gameStatus")).getText());
        });
    }

    private void loadRockPaperScissorsGamePage() {
        webDriver = new EventFiringWebDriver(new ChromeDriver());
        webDriver.get(ROCK_PAPER_SCISSORS_GAME_URL);
    }

    private void setupOpponentGesture(String gesture) throws IOException {
        String content = "{\"gesture\":\"" + gesture + "\"}";
        int responseCode = StepUtilities.makePutRequest(content, FAKE_GESTURE_SERVER_URL);
        assertEquals(200, responseCode);
    }

    private void playGesture(String gesture) {
        webDriver.findElement(By.id("gesture")).sendKeys(gesture);
        webDriver.findElement(By.id("play")).click();
    }

    private void checkForReadyToPlayStatus() {
        assertEquals(name + " is ready to play", webDriver.findElement(By.id("gameStatus")).getText());
    }

    private void enterPlayerName(String name) {
        webDriver.findElement(By.id("name")).sendKeys(name);
        webDriver.findElement(By.id("submitName")).click();
    }

    private void startNewGame() {
        webDriver.findElement(By.id("newGame")).click();
    }
}
