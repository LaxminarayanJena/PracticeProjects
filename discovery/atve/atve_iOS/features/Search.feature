Feature: Search

  As a user I should be able to search for a show

  Scenario: Anon - Display no results when search show is not present
    Given I go to 'Search' screen
    When I search a show that is not present
    Then no results are returned in the search
  
  Scenario: Search clearing text using close button
    Given I go to 'Search' screen
    When I type a show name on search bar
    And I tap on close icon in search bar
    Then I see text entered in the search bar is cleared

  Scenario: Validate TrendingNowRail MetaData
    Given I go to 'Search' screen
    Then I see 'Trending Now ' listname
    Then I see 'Trending Now ' carousel on searchpage
    Then I see Metadata on the 'Trending Now ' tiles containing thumbnail image, title

  Scenario: Validate PopularShowsRail MetaData
    Given I go to 'Search' screen
    Then I see 'Popular Shows this week' listname
    Then I see 'Popular Shows this week' carousel on searchpage
    Then I see Metadata on the 'Popular Shows this week' tiles containing thumbnail image, title