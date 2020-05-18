Feature: Favorite Shows

  as a user
  I want to be able to add a show to my favorites and remove it

  Scenario: Anon - Shows can be added to my favorites
    Given there are no favorite shows in the favorite show screen
    When I mark a show as favorite
    Then there are favorite shows in the favorite show screen
    And I remove a favorite show

  Scenario: Anon - Favorite shows can be removed
    Given I have favorite shows
    When I remove a favorite show
    Then there are no favorite shows in the favorite show screen

  Scenario: Anon - Favorite shows list screen elements
    Given I have favorite shows
    When Verify edit button and show title on favorites when show is added
    Then I remove a favorite show

  Scenario: Anon - Navigation of show added to Favorites
    Given I have favorite shows
    When I tap on the show in Favorites screen
    Then I should navigate to show detail screen

  Scenario: Auth - Shows can be added to my favorite
    Given I log in with a valid provider
    When there are no favorite shows in the favorite show screen
    And I mark a show as favorite
    Then there are favorite shows in the favorite show screen
    And I remove a favorite show

  Scenario: Auth - Favorite shows list screen elements
    Given I log in with a valid provider
    When I have favorite shows
    Then Verify edit button and show title on favorites when show is added
    And I remove a favorite show
