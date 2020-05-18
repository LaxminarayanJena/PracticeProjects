Feature: Search Screen

Scenario: Search 
  Given I login as anonymous user
  When I go to the 'Search' screen
  Then I enter a shown name in search text field
  
Scenario: Search - Keypad enabled
  Given I login as anonymous user
  When I go to the 'Search' screen
  And I tap on search bar
  Then I see keypad is enabled

Scenario: Search - No results found
  Given I login as anonymous user
  When I go to the 'Search' screen
  And I type 'aaaaa' in search text field
  Then I see No results found page

Scenario: Search - show search
  Given I login as anonymous user
  When I go to the 'Search' screen
  And I type 'hom' in search text field
  And I see shows results for searched text
  Then keypad should be hidden

Scenario: Search - Clearing text
  Given I login as anonymous user
  When I go to the 'Search' screen
  And I type 'hom' in search text field
  And I see shows results for searched text
  When I tap on 'x' button in search text field
  Then I see text entered in the search bar is cleared

Scenario: Search Help Text Field
  Given I login as anonymous user
  When I go to the 'Search' screen
  And I tap on search bar
  Then I see 'Search for shows, episodes and more' Help text in the search bar

Scenario: Search - Results navigation
  Given I login as anonymous user
  When I go to the 'Search' screen
  And I type 'hom' in search text field
  And I see shows results for searched text
  When I tap on any show in the result
  Then I see shows detail page

Scenario: Search Page 
  Given I login as anonymous user
  When I go to the 'Search' screen
  And I tap on search bar
  And I see keypad is enabled
  Then I see 'Popular Shows this week' and 'Trending Now' rails
