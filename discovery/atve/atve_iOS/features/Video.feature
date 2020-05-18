Feature: Video

  As a user I should be able to watch a video

  Scenario: Anon - Video plays in portrait mode by default
    Given I am on video landing screen
    Then video plays in portrait mode by default

  Scenario: Anon - Video plays in landscape
    Given I am on video landing screen
    When video plays in portrait mode by default
    And I change the video to landscape
    Then the video plays in landscape mode

  Scenario: Anon - Video metadata
    Given I am on video landing screen
    When video plays in portrait mode by default
    Then video metadata should be visible

  Scenario: Anon - Meta data on landscape mode
    Given I am on video landing screen
    When video plays in portrait mode by default
    Then I Validate metadata on landscape mode

  Scenario: Anon - close button functionality on video player
    Given I am on video landing screen
    When video plays in portrait mode by default
    Then I close video player and validate

  Scenario: Anon - Video playback
    Given I am on video landing screen
    When video plays in portrait mode by default
    Then The video plays correctly

  Scenario: Anon -  Video scrubbing forward
    Given I am on video landing screen
    When video plays in portrait mode by default
    Then I scrub forward on the video and check playback time increased correctly

  Scenario: Anon -  Video scrubbing backward
    Given I am on video landing screen
    When video plays in portrait mode by default
    Then I scrub backward on the video and check playback time decreased correctly
