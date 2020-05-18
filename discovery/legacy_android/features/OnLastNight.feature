Feature: On Last Night

  as a user
  I want to be able to see all Last Night Shows 

 Scenario: Check Show Last Night Description
    Given I'm on the landing screen
    Then I see on last night header description

 Scenario: Add Show Last Night to Watch Later
    Given I'm on the landing screen
    When I check shows home info option
    Then I add a show to watch later from on last night shows

 Scenario: Watch On Last Night Video
    Given I log in with a valid provider
    When I view a on last night video
    Then I should see the video playing

Scenario: Watch On Last Night Video for locked video with anon user
    Given I'm on the home screen
    When I view a on last night video
    And I should not be able to play on last night episode
    Then I should be able to play the on last night episode after logging in

