Feature: Hello
  As a user, I want to say hello

  Scenario: Saying hello
    Given todo server says 'hello'
    When I run the app
    Then you say 'hello'