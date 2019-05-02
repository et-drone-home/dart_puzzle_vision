Feature: Evercraft
  Scenario: I can launch the Evercraft app
    Given I run evercraft
    And I see 'Hello, welcome to Evercraft. Press return to get started.'
    When I get started
    Then I see 'Attack!'

