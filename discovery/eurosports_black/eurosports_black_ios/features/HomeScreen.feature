Feature: Euro Black iOS - Home Screen

  Scenario: Verify Home Screen
    Given I'm on the eurosports landing screen
    Then I should see "HOME SCREEN" options

  Scenario: Verify Watch Screen
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should see "WATCH SCREEN" options

  Scenario: Verify Result Screen
    Given I'm on the eurosports landing screen
    When I click on "RESULT SCREEN"
    Then I should see "RESULT SCREEN" options

  Scenario: Verify Sports Screen
    Given I'm on the eurosports landing screen
    When I click on "SPORTS SCREEN"
    Then I should see "SPORTS SCREEN" options

