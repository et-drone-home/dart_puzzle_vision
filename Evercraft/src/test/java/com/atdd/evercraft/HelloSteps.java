package com.atdd.evercraft;

import cucumber.api.java8.En;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HelloSteps implements En {
    private String response;

    public HelloSteps() {
        Given("^todo server says '(.*)'$", (String message) -> {
            String content = "{\"title\": \"" + message + "\"}";
            String urlString = "http://localhost:7654/todos";
            int responseCode = StepUtilities.makePutRequest(content, urlString);
            assertEquals(200, responseCode);
        });

        When("^I run the app", () -> {
            String command = "java -cp build/libs/Evercraft.jar HelloApp";
            response = StepUtilities.runCommand(command);
        });

        Then("^you say '(.*)'$", (String message) -> {
            assertEquals(message, response);
        });
    }
}
