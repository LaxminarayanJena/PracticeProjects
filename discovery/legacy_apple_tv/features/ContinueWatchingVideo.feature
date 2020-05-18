Feature: Continue/Start over watching videos
  As a user
  I am able to continue watching the video

  Scenario: Continue watching the scrubbed video - Resume Playing
    Given I watch some contents for more than '2'% in Apple TV 'greater' than 1 min
    When I go to Continue Watching list
    And I click on Resume Playing button
    Then I should see that video playing from the last watched timestamp

  Scenario: Continue watching - Start from the Beginning
    Given I watch some contents for more than '2'% in Apple TV 'greater' than 1 min
    When I go to Continue Watching list
    And Click on Start from Beginning button
    Then I should see that video is playing from the beginning

  Scenario: Continue watching - Update section after watching video < 1 min
    Given I watch some contents for more than '0.5'% in Apple TV 'less' than 1 min
    Then I should see that Continue Watching tray is NOT listed under Featured section
