Feature: Shows

  Scenario: Browse Shows screen
    Given I login as anonymous user
    When I am on Shows screen
    Then A list of shows are displayed

  Scenario: Browse Shows screen - Select a show
    Given I login as anonymous user
    When I am on Shows screen
    And I select a show
    Then I should see blank screen

  Scenario: Episode metadata and episode art
    Given I login as anonymous user
    When I am on show details page
    And I see episode description
    Then I see episode metadata for episode art , title , number and duration

  Scenario: Episode List sorting order
    Given I login as anonymous user
    When I am on show details page
    And I select any of the available seasons
    And I see episode list in the season
    Then I see episodes in order of newest episode to oldest episode for that season

 Scenario: To validate Show Hero image
    Given I login as anonymous user
    When I am on show details page
    Then I see show hero on top

 Scenario: Show Title over Hero
    Given I login as anonymous user
    When I am on show details page
    Then I see Show Title over the Show Hero

  Scenario: Episode rail description (Only Tab)
    Given I login as anonymous user
    When I am on show details page
    And I click "More" option on first available episode description
    Then I see episode description
    