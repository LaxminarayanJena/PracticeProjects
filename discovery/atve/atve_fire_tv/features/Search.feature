Feature: Search Show

  As a user I should be able to search for a show

  Scenario: Search a show with invalid show's card
    Given I search an invalid show
    Then I should see no results found message and curated recommendations
  
  Scenario: Search a show
    Given I search a show
    When I select the show's card in search screen
    Then I am taken to the shows details screen

  Scenario: Search - Keypad enabled
    Given I am on the Menu Bar
    And I navigate to 'Search' screen
    When I click on search bar
    Then I see keypad is enabled

  Scenario: Search - mock text in search field
    Given I am on the Menu Bar
    And I navigate to 'Search' screen
    When I click on search bar
    Then I see a mock text on the Search input field

  Scenario: Search - Recommended shows
    Given I am on the Menu Bar
    When I navigate to 'Search' screen
    Then I see a manually curated 'Popular Shows' rail of content Recommendations

  Scenario: Search - Recommended shows
    Given I am on the Menu Bar
    When I navigate to 'Search' screen
    Then I see a manually curated 'Trending Now' rail of content Recommendations

  Scenario: Search - Display entered text in search bar
    Given I search a show
    Then I see entered string is displayed on the search bar

  Scenario: Search screen - Refresh
    Given I search a show
    When I navigate to any other screen and back to Search screen
    Then I see a mock text on the Search input field

  Scenario: Search shows carousel Forward/Backward scroll horizantally
    Given I search a show
    When I scroll show list horizontally forward and backward in 'Shows' rail
    Then I verify horizantal carousel functionality

  Scenario: Search shows carousel Forward/Backward scroll horizantally
    Given I search a show
    When I scroll show list horizontally forward and backward in 'Popular Shows this week' rail
    Then I verify horizantal carousel functionality

  Scenario: Search shows carousel Forward/Backward  scroll horizantally
    Given I am on the Menu Bar
    When I navigate to 'Search' screen
    And I scroll show list horizontally forward and backward in 'Trending Now' rail
    Then I verify horizantal carousel functionality

  Scenario: Search shows carousel Forward/Backward  scroll horizantally
    Given I search a show
    When I scroll show list horizontally forward and backward in 'Episodes' rail
    Then I verify horizantal carousel functionality
    