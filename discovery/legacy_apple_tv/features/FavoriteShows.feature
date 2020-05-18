Feature: Favorite Shows

  as a user
  I want to be able to add a show to my favorites and remove it

  Scenario: Add show to Favourite
    Given I select the show under Show tab
    When I add the show to Favorites
    Then Favorite Shows screen should display the show added from 'Shows Screen' as my favorites

  Scenario: Remove show from favorites in Shows screen
    Given I have a Favorite Show in 'Shows Screen'
    When I select the show under Show tab
    And I remove the show from Favorites
    Then Favorite Shows screen should NOT display the show added from 'Shows Screen' as my favorites
