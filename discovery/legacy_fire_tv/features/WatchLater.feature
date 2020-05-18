Feature: Watch Later 

  As a user
  I should be able to add a show to watch later and remove it

  Scenario: Add show to Watch Later from Featured screen
    Given I navigate to featured option
    When I view & click the popular show
    And I add the show to Watch Later
    Then My videos screen should display the show added from 'Featured Screen' as my videos

  Scenario: Remove show in watch Later from Featured screen
    Given I have a show added to watch later from 'Featured Screen'
    When I navigate to featured option
    And I view & click the popular show
    And I remove the show from my videos
    Then My videos screen should not display the show removed from 'Featured Screen' as my videos

  Scenario: Add show to Watch Later from search screen
    Given I am on the shows screen
    When I add the show to Watch Later
    Then My videos screen should display the show added from 'Search Screen' as my videos

  Scenario: Remove show in watch Later from search screen
    Given I have a show added to watch later from 'Search Screen'
    When I am on the shows screen
    And I remove the show from my videos
    Then My videos screen should not display the show removed from 'Search Screen' as my videos

  Scenario: Add show to Watch Later from shows screen
    Given I am on shows screen
    When I click on show season
    And I add the show to Watch Later
    Then My videos screen should display the show added from 'Shows Screen' as my videos

  Scenario: Remove show in watch Later from shows screen
    Given I have a show added to watch later from 'Shows Screen'
    When I am on shows screen
    And I click on show season
    And I remove the show from my videos
    Then My videos screen should not display the show removed from 'Shows Screen' as my videos
  
  Scenario: Add show watch Later from Browse screen
    Given I navigate to browse screen
    When I select the show from browse screen
    And I click on show season
    And I add the show to Watch Later
    Then My videos screen should display the show added from 'Browse Screen' as my videos

  Scenario: Remove show from watch Later in Browse screen
    Given I have a show added to watch later from 'Browse Screen'
    When I navigate to browse screen
    And I select the show from browse screen
    And I click on show season
    And I remove the show from my videos
    Then My videos screen should not display the show removed from 'Browse Screen' as my videos

  Scenario: Episodes are Sorted in watch Later as recently added first and follows
    Given I search a show on Search screen
    When I add few episodes to Watch Later
    And I navigate to My Videos screen from search
    Then I see Episodes are sorted as recently added first and follows

  Scenario: play any watch Later episode from My Videos list
    Given I search a show on Search screen
    When I add few episodes to Watch Later
    And I navigate to My Videos screen from search
    Then I see episode playing from my videos list

  Scenario: My Videos screen has watch Later shows added by anon & auth user
    Given I search a show on Search screen
    When I add few episodes to Watch Later
    And I login with affiliate which has few episodes under My Videos
    Then I see videos added by anon & auth user

  Scenario: Check My Videos has episode title, show title, season number & episode number
    Given I am on the shows screen
    When I add the show to Watch Later
    And I navigate to My Videos screen from search
    Then I see the show details in my video page

  Scenario: My Videos has Episodes organised horizontally
    Given I search a show on Search screen
    When I add few episodes to Watch Later
    And I navigate to My Videos screen from search
    Then I see episode organised horizontally
