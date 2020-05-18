Feature: Euro Black Android - Home Screen

  Scenario: Verify Home Screen
    Given I'm on the home screen
    Then I see "HOME" tab on home screen

  Scenario: Verify Watch Screen
    Given I'm on the home screen
    When I see "WATCH" tab on home screen
    Then I click "WATCH" tab on home screen

  Scenario: Verify Results Screen
    Given I'm on the home screen
    When I see "RESULTS" tab on home screen
    Then I click "RESULTS" tab on home screen

  Scenario: Verify Sports Screen
    Given I'm on the home screen
    When I see "SPORTS" tab on home screen
    Then I click "SPORTS" tab on home screen

  Scenario: Verify Account option
    Given I'm on the home screen
    Then I see and tap on account option
