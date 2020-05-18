Feature: Video Controls

  As a user I'm able to go to start or pause a video, view show information, share the video and change settings while watching a video

  Scenario: Pause and play a video while watching it
    Given I'am watching an unlocked show
    When I pause the show
    Then the video should pause
    And I should be able to resume watching the show

  Scenario: Check video information while watching it
    Given I'am watching an unlocked show
    When I check the video information
    Then the video information should show up
    And 'info box' should disappear on tapping anywhere on the screen

  Scenario: Share video while watching it
    Given I'am watching an unlocked show
    When I try to share the video
    Then I should see options to share the video
    And 'options to share' should disappear on tapping anywhere on the screen

  Scenario: Disable closed captions while watching video
    Given I'am watching an unlocked show
    When I disable closed captioning
    Then closed captioning should get disabled

  Scenario: Learn More link Functionality in AD Player
    Given I'am watching an video with ad
    When Allow content to play through first ad break and click learn more link
    Then Webview Page displayed

