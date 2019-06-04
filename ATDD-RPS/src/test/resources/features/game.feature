Feature: Rock Paper Scissors game
  As a user, I want to play rock, paper, scissors with an online opponent.

  Scenario: Entering my name to get ready to play
    Given a new game
    When I enter my name
    Then I am ready to play

  Scenario: Winning a round
    Given I am already ready to play
    And my opponent will play gesture 'rock'
    When I play gesture 'paper'
    Then I win

  Scenario: Losing a round
    Given I am already ready to play
    And my opponent will play gesture 'rock'
    When I play gesture 'scissors'
    Then I lose