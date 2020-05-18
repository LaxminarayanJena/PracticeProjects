Feature: Home Hero 

  as a user
  I want to verify Home Hero functionality

  Scenario: Home Hero Validation- Show title,Episode title and CTA button is present
    Given I'm on the landing screen
    Then I see show title, episode title and cta button

  Scenario: Home Hero - Tap on CTA button
    Given I'm on the landing screen
    When I tap on CTA button
    Then I check the show info option

