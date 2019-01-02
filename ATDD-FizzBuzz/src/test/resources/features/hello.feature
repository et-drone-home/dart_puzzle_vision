Feature: Hello
  As a user, I want to say hello

  Scenario: Saying hello
    Given a FizzBuzz server is running
    When I request hello
    Then you say hello