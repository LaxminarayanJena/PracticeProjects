@wip
Feature:Event Playback

  Scenario: Watch Video
    Given I go to a short form video
    When I get episode title
    And I view a video
    Then I should see the video playing till end and next video

  Scenario: Watch Live video for 40 minutes
    Given I log in with a valid provider
    When I watch live for 40 minutes

  Scenario: Long Form -Ad play pause scenario
    Given I go to a show page
    When I get episode title
    And I view a video
    When Allow content to play through first ad break
    And I tap on learn more to see the info and resume ad
    Then I pause video during subsequent chapter and resume after sometime

  Scenario: Continue watching in nth segment scenario 
    Given I log in with a valid provider
    When I go to a show page
    And I get episode title
    And I view a video
    And I exit the app after watching first ad pod
    And The show should be on continue watching page
    And I view a video
    Then I observe user automatically pickup from where he left off

