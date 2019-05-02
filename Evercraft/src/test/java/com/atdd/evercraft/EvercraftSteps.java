package com.atdd.evercraft;

import cucumber.api.java8.En;

import java.io.InputStream;
import java.io.OutputStream;

import static com.atdd.evercraft.StepUtilities.getStreamContent;
import static org.junit.Assert.*;

public class EvercraftSteps implements En {
    InputStream inputStream;
    OutputStream outputStream;
    Process process;

    public EvercraftSteps() {
        When("^I run evercraft$", () -> {
            process = Runtime.getRuntime().exec("java -cp build/libs/Evercraft.jar EvercraftApp");
            inputStream = process.getInputStream();
            outputStream = process.getOutputStream();
        });

        When("^I get started$", () -> {
            StepUtilities.sendOutputCharacter(outputStream, '\n');
        });

        Then("^I see '(.*)'$", (String content) -> {
            String output = getStreamContent(inputStream);
            assertEquals(content, output);
        });
    }

}
