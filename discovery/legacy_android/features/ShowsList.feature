Feature: Show List screen

  As a user I'm able to go to a shows list screen, sort the shows by most recent and alphabetically.
  Also, clicking on a show should take me to the correct show screen.

  Scenario: I can sort the list either alphabetically or by most recent
    Given I'm on the shows list screen
    When I choose sorting by Most Recent
    Then The list should be sorted by most recent first
    And I choose sorting by A to Z
    Then The list should be sorted correctly

  Scenario: I can navigate to a show from the list
    Given I'm on the shows list screen
    And I select a show from the list
    Then The correct show screen is loaded

  Scenario: Verify list of available shows
    Given I'm on the shows list screen
    Then I see list of available shows

  Scenario: Show Art in Most Recent Shows
    Given I'm on the shows list screen
    When I choose sorting by Most Recent
    Then I see show art on each show in Most Recent

  Scenario: Verify Show Detail of show in Most Recent Shows
    Given I'm on the shows list screen
    When I choose sorting by Most Recent
    And I select a show from Most Recent shows list
    Then I see show title on show detail screen

  Scenario: Verify Show Detail of show in A to Z Shows
    Given I'm on the shows list screen
    When I choose sorting by A to Z
    And I select a show from A to Z shows list
    Then I see show title on show detail screen

  Scenario: Verify Search bar is enabled on shows list
    Given I'm on the shows list screen
    When I click on search icon
    Then I see search bar is enabled

  Scenario: Validating the hamburger menu icon functionality on shows list
    Given I'm on the shows list screen
    Then I see all hamburger menu icon functionality
