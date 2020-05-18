Feature: Search

  As a user I should be able to search for a show

  Scenario: Anon - Search page must contain All Shows and For you tab
    Given I login as anonymous user
    When I go to the search shows page
    Then I see all shows tab
    And I see for you tab

  Scenario: Anon - Search a show
    Given I login as anonymous user
    When I go to the search shows page
    Then I enter show name in search field
    And I select the show from results

  Scenario: Anon - For you tab displays show cards
    Given I login as anonymous user
    When I go to the search shows page
    And I click for you tab
    Then For you tab displays show cards

  Scenario: Anon - Display No results when search show is not present
    Given I login as anonymous user
    When I go to the search shows page
    And I search the show which is not present
    Then no shows are returned in the search

 Scenario: Auth - Search and Play video on shows page
    Given I log in with a valid provider
    When I go to the search shows page
    Then I enter show name in search field
    And I select the show from results
    Then I see detail view of searched show
    And I tap on episode card to play the video from show episode list