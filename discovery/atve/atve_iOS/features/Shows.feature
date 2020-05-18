Feature: Shows

  Scenario: Anon - Browse Shows screen
    Given I am on shows screen
    Then A list of shows are displayed

  Scenario: Anon - Browse Shows screen - Select a show
    Given I am on shows screen
    When I select a show
    Then I see the season listed

  Scenario: Validate AllShowsRail MetaData
    Given I am on shows screen
    When I select a show
    Then I see the Metadata on the tiles containing thumbnail image, title

  Scenario: Anon - Selecting a Season
  	Given I am on show details screen
  	When I see the season listed
  	And I can select any of the available seasons
  	Then I see episodes in order of newest episode to oldest episode for that season

  Scenario: Anon - Season Order
  	Given I am on show details screen
  	When I see the season listed
  	Then I see the latest season listed first and the other seasons listed in decreasing order

  Scenario: Anon – Selecting a clip
  	Given I am on show details screen
  	When I see the clips rail below the series rail
  	Then I can select any of the available clips to view

  Scenario: Anon – Validate More button functionality
  	Given I am on show details screen
  	When I see the season listed
  	Then I click on More button on description for first available episode and validate it

  Scenario: Anon – Validate Less button functionality
  	Given I am on show details screen
  	When I see the season listed
  	Then I click on Less button on description for first available episode and validate it

  Scenario: Anon - Validate show description
  	Given I am on show details screen
  	When I see the season listed
  	Then I check episode description and click on episode and validate description in video screen

  Scenario: Anon - Validate Show hero image
    Given I am on show details screen
    When I see the season listed
    Then I see a Show hero image

  Scenario: Anon - Validate netwrork logo on Show hero
    Given I am on show details screen
    When I see the season listed
    Then I see a network logo on Show hero

  Scenario: Anon - Validate Show title over hero
    Given I am on show details screen
    When I see the season listed
    Then I see Show title over show hero

  Scenario: Anon - Validate back button functionality
    Given I am on show details screen
    When I see the season listed
    Then I click on back button and validate functionality

  Scenario: Anon - Validate episode metadata and episode art
    Given I am on show details screen
    When I see list of all episodes
    Then I see Episode metadata
    