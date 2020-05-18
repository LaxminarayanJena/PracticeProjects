Feature: Continue/Start over watching watching videos
  As a user
  I am able to continue watching the video

  Scenario: Auth-Continue watching the scrubed video
    Given I login with valid provider
    When I watch half of the show
    And I search for the same show and click on continue in continue page
    Then I should see the video playing from the scrubed position 

  Scenario: Start over option to watch the scrubed video from begning
    Given I watch half of the show
    When I search for the same show and click on start over in continue page 
    Then I should see the video playing from the initial position

  Scenario: Continue watching the scrubed video in featured screen
    Given I watch half of the show
    Then I should see continue watching in 'Featured' screen

  Scenario: Continue watching the scrubed video in MyVideos screen
    Given I watch half of the show
    Then I should see continue watching in 'MyVideos' screen

  Scenario: Start over option to watch the scrubed video from begning in MyVideos screen
    Given I watch half of the show
    When I check for the same show from myvideos screen and click on start over in continue page 
    Then I should see the video playing from the initial position

  Scenario: Continue watching the scrubed video in MyVideos screen
    Given I watch half of the show
    When I check for the same show from myvideos screen and click on continue in continue page 
    Then I should see the video playing from the scrubed position

  Scenario:Anon - Continue Watching section update after watching a content for a second under featured
    Given I watch the show for few seconds
    Then I should not see continue watching in 'Featured' screen

  Scenario:Anon - Continue Watching section update after watching a content for a second under featured
    Given I watch the show for few seconds
    Then I should not see continue watching in 'MyVideos' screen