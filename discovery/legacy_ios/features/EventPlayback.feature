Feature: Event Playback

  Scenario: Lean Back - Watch Video
    Given I go to shortform video get the episode title and play it
    Then I should see the video playing till end and next video

  Scenario: Watch Live video for 40 minutes
    Given I log in with a valid provider
    When I watch live for 40 minutes
    And I click on video back button
    Then I see and click on signout 

  Scenario: ad click pause play Functionality in AD Player
    Given I'am watching an video with ad
    When I perform operation on ad
    Then I "Pause" main video and wait for some time
    And I "Play" main video and wait for some time

  Scenario: Anon - Continue watching in first segment - Watch Video
    Given I go to shortform video get the episode title and play it
    When I play a video for 3 minutes and go back to landing screen
    And I go to shortform video get the episode title and play it
    Then I should see the video playing till end and next video
