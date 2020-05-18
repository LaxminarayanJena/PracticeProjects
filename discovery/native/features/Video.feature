Feature: Video Playback

  Scenario: Anon - Video scrub forward
    Given I login as anonymous user
    When I view an unlocked episode
    Then I should be able to scrub forward

  Scenario: Anon - Video scrub backward
    Given I login as anonymous user
    When I view an unlocked episode
    Then I should be able to scrub backward

  Scenario: Anon - Video Ad Play
    Given I login as anonymous user
    When I view an unlocked episode
    Then I should "Play" the AD

  Scenario: Anon - Video Ad Pause
    Given I login as anonymous user
    When I view an unlocked episode
    Then I should 'Pause' the AD

  Scenario: Anon - User can play the episode
    Given I login as anonymous user
    When I should be able to play the episode
    Then I see episode playing on portrait mode

  Scenario: Anon - Video Playback -Change orientation to full screen
    Given I login as anonymous user
    When I should be able to play the episode
    And I see video is playing
    Then I change device orientation to landscape
    And I see episode playing on landscape mode

  Scenario: Auth - Transition from Portrait to Landscape Orientation Change
    Given I log in with a valid provider
    When I play the hero episode
    Then I change phone orientation to landscape mode

  Scenario: Auth - Transition from Landscape to Portrait Orientation Change
    Given I log in with a valid provider
    When I play the hero episode
    Then I change phone orientation to landscape mode
    And I change phone orientation to portrait mode

  Scenario: Anon - User can watch video by clicking play button in episode info
    Given I login as anonymous user
    When I should be able to view unlocked episodes info details
    And I should be able to click on play button
    Then I should see the video playing

  Scenario: Anon - Video player UI - Play-pause on portrait mode
    Given I login as anonymous user
    When I view an unlocked episode
    Then I see Play and Pause option on Player UI

  Scenario:  Anon - Video player UI - CC - on portrait mode
    Given I login as anonymous user
    When I view an unlocked episode
    Then I see CC option on player UI

  Scenario: Anon-Video scrub forward with button
    Given I login as anonymous user
    When I view an unlocked episode
    And I tap on forward button
    Then I see video advances ten seconds

 Scenario: Anon-Video scrub backward with button
    Given I login as anonymous user
    When I view an unlocked episode
    And I tap on rewind button
    Then I see video rewinds ten seconds
