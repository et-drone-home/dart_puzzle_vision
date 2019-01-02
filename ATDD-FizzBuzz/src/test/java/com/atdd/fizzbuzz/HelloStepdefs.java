package com.atdd.fizzbuzz;

import com.fasterxml.jackson.jr.ob.JSON;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HelloStepdefs implements En {
    private String response;

    public HelloStepdefs() {
        Given("a FizzBuzz server is running$", () -> {

        });
        When("^I request hello$", () -> {
            try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("http://localhost:4567/hello").openStream()).useDelimiter("\\A")) {
                response = s.hasNext() ? s.next() : "";
            }

        });
        Then("^you say hello$", () -> {

            assertEquals("delectus aut autem", response);

        });
    }
}
