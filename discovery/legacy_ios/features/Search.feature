Feature: Search

  As a user I should be able to search for a show

  Scenario: Anon - Search a show
  	Given I search a show
  	Then I get to the shows show page

  Scenario: Anon - Display no results when search show is not present
    Given I'm on the landing screen
    When I search a show that is not present
    Then no results are returned in the search

  Scenario: Anon - Search result count/auto populate results
    Given I'm on the landing screen
    When I type a show name on search bar
    Then I see total number of results found

  Scenario: Anon - Search clearing text using close button
    Given I'm on the landing screen
    When I type a show name on search bar
    And I tap on close icon in search bar
    Then I see text entered in the search bar is cleared

  Scenario: Anon - Search back button
    Given I search a show
    When I get to the shows show page
    And I click on back button
    Then I see total number of results found

  Scenario: Auth - Search a show and play
    Given I log in with a valid provider
    And I see and click "Home" on hamburger menu
    When I search a show
    And I get to the shows show page
    And I tap on unlocked episode card to play the video from show episode list
    Then I should see the video playing

  Scenario: Auth - Search and play a locked show after click on lock button
    Given I search an locked video
    When I tap on locked episode card to play the video from show episode list
    And I search provider and login with valid credential
    Then I should see the video playing
