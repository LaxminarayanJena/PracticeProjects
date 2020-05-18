Feature: Show List screen on Ios

  As a user I'm able to go to a shows list screen, sort the shows by most recent and alphabetically.
  Also, clicking on a show should take me to the correct show screen.

  Background:
    Given I'm on the home screen
    When I navigate to Shows from hamburger menu
    Then I'm taken to Shows List Page

  Scenario: Anon - I can sort the list either alphabetically or by most recent
    Given I'm on the shows list screen
    When I choose sorting by Most Recent
    Then The list should be sorted by most recent first
    And I choose sorting by A to Z
    Then The list should be sorted correctly

  Scenario: Anon - I can navigate to a show by Letter
    Given I'm on the shows list screen
    And I select a letter to see a show starting from that letter
    Then The correct show screen is loaded

  Scenario: Anon - A-Z Sorting - Verifying show title in show details 
    Given I'm anonymous user and go to Shows screen from hamburger menu
    When I choose sorting by A to Z
    And I select any show from show list
    Then I see show title on show detail screen
    
  Scenario: Anon - Most recent Sorting - Verifying show title in show details 
    Given I'm anonymous user and go to Shows screen from hamburger menu
    When I choose sorting by Most Recent
    And I select any show from show list
    Then I copy show title, go back to show list, scroll down and select show and compare titles
