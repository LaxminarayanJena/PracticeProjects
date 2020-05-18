Feature: Home Hero

  Scenario: Anon - Hero show content
    Given I'm on the landing screen
    When I check for "home hero"
    And I check for "show logo"
    Then I check for "episode title"

  Scenario: Anon - Play hero episode
    Given I'm on the landing screen
    When I see and click on home hero
    And I play any episode
    Then I should see the video playing

  Scenario: Anon - Short description
    Given I'm on the landing screen
    When I see and click on home hero
    Then I check the show info

  Scenario: Anon - Add to favorites
    Given I'm on the landing screen
    When I see and click on home hero
    Then I click on add to favorites
    And I click on back button
    Then There are favorite shows in the favorite show screen

  Scenario: Home Hero - Show title
    Given I'm on the home screen
    And  I see Show Title

  Scenario: Home Hero - episode title
    Given I'm on the home screen
    And  I see episode title

  Scenario: Home Hero - CTA button
    Given I'm on the home screen
    And  I see CTA button

  Scenario: Home Hero - Tap on CTA button and back
    Given I'm on the home screen
    When I tap on CTA button
    And I see show info screen
    And I click on back button
    Then I'm on the home screen

  Scenario: Home Hero - Tap on CTA button
    Given I'm on the home screen
    When I tap on CTA button
    And I see show info screen
