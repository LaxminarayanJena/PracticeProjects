Feature: Continue Watching Videos

  As a user
  I want to be able to view videos in Continue Watching section

Scenario: Videos to be present in Home page Continue Watching carousel
    Given I log in with a valid provider
    When  I go to a show page
    And   I view a video
    And   I watch half of the show
    Then  The show should be on continue watching page

Scenario: Anon-User can watch video by clicking play button in episode info
    Given I'm on the landing screen
    When I should be able to view unlocked episodes info details
    And I should be able to click on play button
    Then I should see the video playing 

Scenario: Auth - Continue Watching show tile is present
    Given I log in with a valid provider
    When I go to a show page
    And I view a video
    And I watch half of the show
    Then I should see the show tile on home page
 
Scenario:  Anon - Video player UI - CC - on landscape mode
    When I view an unlocked episode
    Then I see CC option on player UI   
