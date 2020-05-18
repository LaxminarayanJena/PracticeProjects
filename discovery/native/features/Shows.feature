Feature: Shows

  as a user
  I want to be able check show info, sign in and play episodes,
  see episode level info and change to a different season

  Scenario: Check show info
    Given I login as anonymous user
    When I check unlocked show info from the home screen
    Then I should see information about the show
