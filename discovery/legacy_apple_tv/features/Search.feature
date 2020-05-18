Feature: Search Show

  As a user I should be able to search for a show

  Scenario: Search a show
    Given I search a valid show in Apple TV
    When I select the show card
    Then I should be on the Show screen

  Scenario: Search a show with an invalid show card
    Given I search an invalid show in Apple TV
    Then I should see no results found message
