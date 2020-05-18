Feature: Search

  As a user I should be able to search for a show

  Scenario: Search a show
  	Given I search a show
  	Then I get to the shows show page

  Scenario: Display No results when search show is not present
    Given I'm on the landing screen
    When I search a show that is not present
    Then no results are returned in the search

  Scenario: Search a show with Login
    Given I log in with a valid provider
    When I search a show
    And I get to the shows show page
    Then I tap on episode card to play the video from show episode list

  Scenario: Search result count
    Given I'm on the landing screen
    When I type a show name on search bar
    Then I see total number of results found

  Scenario: Search clearing text using close button
    Given I'm on the landing screen
    When I type a show name on search bar
    And I see total number of results found
    And I tap on close icon in search bar
    Then I see text entered in the search bar is cleared

  Scenario: Search - back button
    Given I log in with a valid provider
    When I search a show
    And I get to the shows show page
    And I click on back button 
    Then I see total number of results found

  Scenario: Search - Auto populate results
    Given I'm on the landing screen
    When I type any letter on search bar
    Then I see total number of results found

  Scenario: Search and play in landscape mode
    Given I log in with a valid provider
    When I search a show
    And I get to the shows show page
    Then I see video playing in landscape mode

  Scenario: Search - Results Metadata
    Given I'm on the landing screen
    When I type a show name on search bar
    And I see total number of results found
    Then I see metadata of the show

  Scenario: Search - Keypad enabled
    Given I'm on the landing screen
    When I click on search icon
    Then I see keypad is enabled

  Scenario: Search - Device back button
    Given I'm on the landing screen
    When I type a show name on search bar
    And I see total number of results found
    And I click on device back button
    Then I see home hero carousel on home page
