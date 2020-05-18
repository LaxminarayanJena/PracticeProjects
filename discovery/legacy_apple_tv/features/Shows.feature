Feature: Shows

  as a user
  I want to be able check show info, sign in and play episodes,
  see episode level info and change to a different season

  Scenario: Check show info & Show detail screen
    Given I am on a show screen in Apple TV
    When I goto show info
    Then I should see information about the show

  Scenario: Scroll-up & Scroll-down Show screen
    Given I am on a show screen in Apple TV
    When I goto Show tab
    Then I should scroll down & scroll up through videos

  Scenario: Anon-Play video
    Given I am on a show screen in Apple TV
    When I select the show under Show tab
    And I click on play button under Show tab
    Then I should see video playing under show tab

  Scenario: Check for Resume Playing and Start from Beginning for scrubbed videos
    Given I select the show under Show tab
    When I scrub forward the same video
    And I click and play the same show from Episodes
    Then I should see Resume Playing and Start from Beginning buttons

  Scenario: Verify More Seasons episode
    Given I select the show under Show tab
    When I click on More seasons and select an episode
    Then I visit one of the season and check season details are same
