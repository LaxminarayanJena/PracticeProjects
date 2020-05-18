Feature: Video Landing - Verify basic playback and controls

  Scenario: Video playback - Scrub forward
    Given I am on the video landing screen in Apple Tv
    And Start the video on clicking 'Resume' button
    And the video plays correctly
    When I scrub 'forward' on the video
    Then the video playback time should be 'increased' correctly

  Scenario: Video playback - Scrub backward
    Given I am on the video landing screen in Apple Tv
    And Start the video on clicking 'Resume' button
    And the video plays correctly
    When I scrub 'backward' on the video
    Then the video playback time should be 'decreased' correctly

  Scenario: Video playback  - No navigation bar
    Given I watch the video
    Then I do not see the navigation bar on the side navigation

  Scenario: Video playback - Video skip backward 15 sec
    Given I watch the video
    When video starts playing for few seconds
    And I tap on 15 sec backward
    Then I see it should skip 15 sec back
    And video plays continuously without any issue
