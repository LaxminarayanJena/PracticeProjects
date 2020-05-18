Feature: Search Show

  As a user I should be able to search for a show

  Scenario: Search a show
    Given I search a valid show in Apple TV
    Then I should see no results found message

  Scenario: Anon - Validate network logo on search page
    Given I am on a Search screen in Apple TV
    Then I see network logo on the top left  

  Scenario: Search page - Default/mock text in the Search field
    Given I am on a Search screen in Apple TV
    Then I see a mock text on the Search input field

  Scenario: Anon - Popular Shows this week Carousel
    Given I am on a Search screen in Apple TV
    Then I see and navigate to 'Popular Shows this week' rail on search page

  Scenario: Anon - Popular Shows this week carousel right scroll
    Given I am on a Search screen in Apple TV
    When I see and navigate to 'Popular Shows this week' rail on search page
    Then I do 'right' scroll in 'Popular Shows this week' and verify functionality

  Scenario: Anon - Popular Shows this week carousel left scroll
    Given I am on a Search screen in Apple TV
    When I see and navigate to 'Popular Shows this week' rail on search page
    Then I do 'left' scroll in 'Popular Shows this week' and verify functionality

  Scenario: Anon - Validate Popular Shows this week MetaData 
    Given I am on a Search screen in Apple TV
    When I see and navigate to 'Popular Shows this week' rail on search page
    Then I see Metadata on the 'Popular Shows this week' tile containing thumbnail image, title, network logo  

  Scenario: Anon - Trending Now Carousel
    Given I am on a Search screen in Apple TV
    Then I see and navigate to 'Trending Now ' rail on search page

 Scenario: Anon - Trending Now carousel right scroll
    Given I am on a Search screen in Apple TV
    When I see and navigate to 'Trending Now ' rail on search page
    Then I do 'right' scroll in 'Trending Now ' and verify functionality

  Scenario: Anon - Trending Now carousel left scroll
    Given I am on a Search screen in Apple TV
    When I see and navigate to 'Trending Now ' rail on search page
    Then I do 'left' scroll in 'Trending Now ' and verify functionality

  Scenario: Anon - Validate Trending Now MetaData 
    Given I am on a Search screen in Apple TV
    When I see and navigate to 'Trending Now ' rail on search page
    Then I see Metadata on the 'Trending Now ' tile containing thumbnail image, title, network logo  

  Scenario: Search page - Refresh
    Given I enter search string and click Next from keypad
    When I navigate to any other page
    Then I navigate back to Search screen
    And I see search page is refreshed
