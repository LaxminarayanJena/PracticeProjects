Feature: Show Screen

  As a user I'm able to go to a shows list screen, sort the shows by most recent and alphabetically.
  Also, clicking on a show should take me to the correct show screen.

  Scenario: show screen episode description
    Given I am on an unlocked episode screen
    Then I see the episode description

  Scenario: Show screen play episode
    Given I am on an unlocked show screen
    When I select an unlocked episode to view
    Then I should see the unlocked video playing

  Scenario: Show screen episode details
    Given I am on an unlocked show screen
    When I tap on episode info
    Then I should see the episode screen

  Scenario: Up Next video should be tappable from unlocked episode show video screen
    Given I am on an unlocked episode screen
    And I should see the unlocked video playing
    When I select a up next video
    Then I should see the video playing

  Scenario: Auth - Up Next video should be tappable from locked episode show video screen
    Given I log in with a valid provider
    When I play a locked episode
    Then I should see the video playing
    And I select a up next video
    And I should see the video playing

  Scenario: Show screen anonymous user can view show description
    Given I login as anonymous user
    When I tap on any show on shows list
    Then I see the episode description

  Scenario: Hero show key art on show details screen for selected show
    Given I login as anonymous user
    When I tap on any show on shows list
    Then I see hero show art on show details screen for selected show

  Scenario: Show title on show details screen
    Given I login as anonymous user
    When I tap on any show on shows list
    Then I see Hero show title

  Scenario: Auth - View show description
    Given I log in with a valid provider
    When I tap on any show from shows list for valid user
    Then I see the episode description

  Scenario: Auth - Show key art on show details screen
    Given I log in with a valid provider
    When I tap on any show from shows list for valid user
    Then I see hero show art on show details screen for selected show

  Scenario: Auth - Show title on show details screen
    Given I log in with a valid provider
    When I tap on any show from shows list for valid user
    Then I see Hero show title

  Scenario: Auth - Affiliate logo on show screen
    Given I log in with a valid provider
    When I tap on any show from shows list for valid user
    Then I see affiliate logo on top right corner on show screen


