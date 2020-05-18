Feature: Video Landing

  Scenario: Video playback - view playlist / watch button
    Given I'm on the landing screen
    When I click on View Playlist button
    And I see the details of shows hero content
    And I click on Start Show button
    Then I see video playing on video player

  Scenario: Video playback - loader, player controls, Metadata
    Given I am on the video playing screen
    When I see loader on player till playback starts
    Then I see player controls, Metadata visible on video player screen

  Scenario: Video playback - pause button functionality
    Given I am on the video playing screen
    When I click on pause button on player
    Then I see playback stops and play button is displayed with metadata

  Scenario: Video playback - play button functionality
    Given I am on the video playing screen
    When I click on pause button on player
    And I see playback stops and play button is displayed with metadata
    And I click on play button on player
    Then I see content playback resumed

  Scenario: Video playback - player controls fades out
    Given I am on the video playing screen
    When I see player controls, Metadata visible on video player screen
    Then I see player controls fades out after few seconds

  Scenario: Video playback - Closed Captioning(CC)
    Given I am on the video playing screen
    When CC is in OFF state by default
    Then I turn ON CC option

  Scenario: Video playback - Scrub forward
    Given I am on the video playing screen
    When I scrub 'forward' on the video
    Then I see video playback time 'increased' correctly

  Scenario: Video playback - Scrub backward
    Given I am on the video playing screen
    When I scrub 'backward' on the video
   Then I see video playback time 'decreased' correctly

  Scenario: Video playback - Remote Back button
    Given I am on the video playing screen
    When  I click on Remote Back button
    Then I see player is closed & user lands on screen from where playback was initiated
