Feature: Home Hero
  As a user I should be able to play videos and view metadata from the home hero.
  Hero videos should be unlocked for anonymous users.
 
  Scenario: Anon - Play hero episode
    Given I login as anonymous user
    When I play the hero episode
    Then I see video playing in portrait mode

  Scenario: Auth - Play hero episode
    Given I log in with a valid provider
    When I play the hero episode
    Then I see video playing in portrait mode

  Scenario: Anon - Home Hero - Up-next
    Given I login as anonymous user
    When I play the hero episode
    And I see video playing in portrait mode
    Then I see up next videos

  Scenario: Auth - Navigation to Home screen on clicking Back Button on video player
    Given I log in with a valid provider
    When I play the hero episode
    And I see video playing in portrait mode
    And I tap on back button
    Then The returning user should be on the homescreen

