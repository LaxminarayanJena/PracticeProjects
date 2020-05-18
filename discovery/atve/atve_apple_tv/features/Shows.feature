Feature: Shows

  Scenario: Browse Shows screen
    Given I am on a Show screen in Apple TV
    Then A list of shows are displayed

  Scenario: Anon - Validate network logo on Shows page
    Given I am on a Show screen in Apple TV
    Then I see network logo on the top left 

  Scenario: Browse Shows screen - Select a show
    Given I am on a Show screen in Apple TV
    When I select a show
    Then I should see blank screen

  Scenario: Anan - Season Order
    Given I am on show details screen with seasons
    When I see the season listed
    Then I see the latest season listed first and the other seasons listed in decreasing order

  Scenario: Anon -  Selecting a Season and Validating Focus
    Given I am on show details screen with seasons
    When I see the season listed
    Then I can select any of the seasons and validate focus

  Scenario: Anon -  Selecting a Season and Validating Episode Order
    Given I am on show details screen with seasons
    When I see the season listed
    And I can select any of the available seasons
    Then I see episodes in order of newest episode to oldest episode for that season

  Scenario: Anon -  Selecting a Season and Validating Episode List
    Given I am on show details screen with seasons
    When I see the season listed
    And I can select any of the available seasons
    Then I see episodes list for the selected season below season picker

  Scenario: Anon - Validating Episode Metadata and Episode Art
    Given I am on show details screen with seasons
    When I see list of all episodes
    Then I see Episode Metadata
  
  Scenario: Anon -  Selecting a clip
    Given I am on show details screen with clip rail
    When I see the clips rail below the series rail
    Then I can select any of the available clips to view

  Scenario: Shows Content Grid - Default Network
    Given I am on a Show screen in Apple TV
    Then I see default network "TLC" is selected

  Scenario: Shows Content Grid - Content grids
    Given I am on a Show screen in Apple TV
    Then I see shows of the selected network "TLC" organised in content grids

  Scenario: Shows Content Grid - Show Title and Show art
    Given I am on a Show screen in Apple TV
    Then I see the Show tiles with Show key art image and Show Title for selected network "TLC" organised in content grids

  Scenario: Shows Content Grid - Click on Show
    Given I am on a Show screen in Apple TV
    When  I click on any show tile of the selected network "TLC" organised in content grids
    Then I am taken to the selected network's "TLC" Show Details page
