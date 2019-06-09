package com.atdd.evercraft;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.junit.Assert.*;

public class EvercraftSteps implements En {
    EventFiringWebDriver webDriver;
    public EvercraftSteps() {
        Before(() -> {
            webDriver = new EventFiringWebDriver(new ChromeDriver());
            webDriver.get("http://localhost:4567/");
        });

        After(() -> webDriver.close());

        Given("^I start a new game$", () -> {
        });

        When("^I make an attack$", () -> {
        });

        Then("^my opponent loses 1 hit point$", () -> {
        });
    }

}
