Feature: Live stream

  Scenario: Anon - User can't watch live
    Given I login as anonymous user
    When I play a live video
    Then I should see the affiliate search screen

  Scenario: Auth - User can watch live tv
    Given I log in with a valid provider
    When I should be able to watch live tv
    Then I can see live tv

  Scenario: Auth - User can deeplink into livestream
    Given I log in with a valid provider
    When I deeplink to watch live
    Then I can see live tv

  Scenario: Anon - Sign in from livestream
    Given I login as anonymous user
    And I play a live video
    When I should see the affiliate search screen
    And I log in with common login steps
    Then I should be able to watch live tv