Feature: Shows

  as a user
  I want to be able check show info, sign in and play episodes, 
  see episode level info and change to a different season

  Scenario: Auth - Check show info
    Given I login with valid provider and go to Shows screen from hamburger menu
    When I go to a show page
    Then I check the show info option
    And I exit from show list screen and search screen
    And I see and click on signout

  Scenario: Auth - Play an episode
    Given I login with valid provider and go to Shows screen from hamburger menu
    And I go to a show page
    When I should be able to play the episode
    Then I should see the video playing
    And I navigate back from video to landing screen
    And I see and click on signout

  Scenario: Auth - Change to a different season
    Given I login with valid provider and go to Shows screen from hamburger menu
    When I have selected a show that has multiple seasons
    Then I change the season
    And I navigate back from show details screen to landing screen    
    And I see and click on signout

  Scenario: Auth - Check episode level info
    Given I login with valid provider and go to Shows screen from hamburger menu
    When I go to a show page
    Then I check the episode info
    And I navigate back from episode details screen to landing screen
    And I see and click on signout

  Scenario: Auth - Show title on show details screen
    Given I login with valid provider and go to Shows screen from hamburger menu
    When I select any show from show list
    Then I see show title on show detail screen
    And I exit show list screen
    And I see and click on signout

  Scenario: Auth - Verify Show Description and affiliate logo
    Given I login with valid provider and go to Shows screen from hamburger menu
    When I select any show from show list
    Then I check the show info option
    And I exit show list screen
    And I see affiliate logo on top right corner on show detail screen
    And I see and click on signout

  Scenario: Anon - Affiliate screen on playing locked show episode
    Given I search an locked video
    When I click on episode key button and validate functionality
    Then I navigate back from affiliate screen to landing screen
