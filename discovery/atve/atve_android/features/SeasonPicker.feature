Feature: Season Picker	

  Scenario: Season Order
    Given I login as anonymous user
    When I am on show with multiple season page
    And I see the season numbers listed
    Then I see the latest season listed first and the other seasons listed in decreasing order

   Scenario: Season Picker - first selected by default
    Given I login as anonymous user
    When I am on show with multiple season page
    And I see the season numbers listed
    Then I see season listed first in the seasons list is selected by Default

  Scenario: Season Picker - Select Season
    Given I login as anonymous user
    When I am on show details page
    And I see the season numbers listed
    And I select any of the available seasons
    Then I see corresponding season is in selected state
    And I see episodes in order of newest episode to oldest episode for that season
