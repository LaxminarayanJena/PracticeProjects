@wip
Feature: CuratedList

  Scenario: Anon - Curated playlist hero image on playlist screen
    Given I login as anonymous user
    When I tap on any tile in curated playlist
    Then I see recommended show content on hero

  Scenario: Anon - Title on curated playlist screen
    Given I login as anonymous user
    When I tap on any tile in curated playlist
    Then I see Hero show title

  Scenario: Anon - Validate episode art view for each epicode
    Given I login as anonymous user
    When I tap on any tile in curated playlist
    Then I see episode art on each episode

  Scenario: Auth - Curated playlist hero image on playlist screen
    Given I log in with a valid provider
    When I tap on any tile in curated playlist for valid user
    Then I see recommended show content on hero

  Scenario: Auth - Title on curated playlist screen
    Given I log in with a valid provider
    When I tap on any tile in curated playlist for valid user
    Then I see Hero show title

  Scenario: Auth - Validate episode art view for each epicode
    Given I log in with a valid provider
    When I tap on any tile in curated playlist for valid user
    Then I see episode art on each episode
