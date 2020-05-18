Feature: Video

  Scenario: Video plays in portrait mode by default
    Given I login as anonymous user
    When I am on video landing screen
    Then video plays in portrait mode by default

  Scenario: Video metadata
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    Then video metadata should be visible

  Scenario: Video plays in landscape
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    And I change the video to landscape
    Then the video plays in landscape mode

  Scenario: Video playback
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    Then the video plays correctly

  Scenario: Video scrubbing forward
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    And the video plays correctly
    When I scrub forward on the Video
    Then the video playback time should be increased by 10 seconds

  Scenario: Video scrubbing backwards
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    And the video plays correctly
    When I scrub backwards on the video
    Then the video playback time should be decreased by 10 seconds

  Scenario: Extra Clips
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    And I scroll till end of the screen
    Then I see Extra Clips

  Scenario: Player Controls
    Given I login as anonymous user
    When I am on video landing screen
    Then video plays in portrait mode by default
    And I see "pause" on the player
    And I see "play" on the player
    And I see "forward" on the player
    And I see "backward" on the player
    And I see "back" on the player
    And I see "full screen" on the player

 Scenario: Functionality of pause button
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    And I tap on "pause" button
    Then video should be paused

 Scenario: Functionality of play button
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    And I tap on "play" button
    Then the video plays correctly

 Scenario: Functionality of back button
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    And I tap on "back" button
    Then I see previous screen from where playback was initiated

 Scenario: Metadata on landscape mode
    Given I login as anonymous user
    When I am on video landing screen
    And video plays in portrait mode by default
    Then I see metadata and validate
