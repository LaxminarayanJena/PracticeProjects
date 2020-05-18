Feature: Continue/Start over watching watching videos
  As a user
  I am able to continue watching the video

  Scenario: Anon - Video lean back
    Given I view an episode
    Then Video should play till end and Autoplay the next episode

 Scenario: Auth-Continue watching in first segment
 	Given I view an episode
    When I watch the video for some time
    And I search and play the same video
    And I should play the video from the scrubed position
    Then I should play the video till next episode

  Scenario: Anon - scrub forward inside segment scenario
    Given I select show and scrub forward inside chapter
    Then I should play the video till next episode
