Feature: Favorite Shows

  as a user
  I want to be able to add a show to my favorites and remove it

  Scenario: Add show to favorites from Featured screen
    Given I navigate to featured option
    When I view & click the popular show
    And I add the show to favorites
    Then the my videos screen should display the show added from 'Featured Screen' as my favorite

  Scenario: Remove show from favorites in Featured screen
    Given I have a favorite show in 'Featured Screen'
    When I navigate to featured option
    And I view & click the popular show
    And I remove the show from favorites
    Then the my videos screen should not display the show removed from 'Featured Screen' as my favorite

  Scenario: Add show to favorites from Search screen
    Given I am on the shows screen
    When I add the show to favorites
    Then the my videos screen should display the show added from 'Search Screen' as my favorite

  Scenario: Remove show from favorites in Search screen
     Given I have a favorite show in 'Search Screen'
     When I am on the shows screen
     And I remove the show from favorites
     Then the my videos screen should not display the show removed from 'Search Screen' as my favorite

    Scenario: Add show to favorites from Shows screen
    Given I am on shows screen
    When I click on show season
    And I add the show to favorites
    Then the my videos screen should display the show added from 'Shows Screen' as my favorite

   Scenario: Remove show from favorites in Shows screen
     Given I have a favorite show in 'Shows Screen'
     When I am on shows screen
     And I click on show season
     And I remove the show from favorites
     Then the my videos screen should not display the show removed from 'Shows Screen' as my favorite

  Scenario: Add show to favorites from Browse screen
    Given I navigate to browse screen
    When I select the show from browse screen
    And I click on show season
    And I add the show to favorites
    Then the my videos screen should display the show added from 'Browse Screen' as my favorite

  Scenario: Remove show from favorites in Browse screen
     Given I have a favorite show in 'Browse Screen'
     When I navigate to browse screen
     And I select the show from browse screen
     And I click on show season
     And I remove the show from favorites
     Then the my videos screen should not display the show removed from 'Browse Screen' as my favorite