Feature: Favorite Shows

  as a user
  I want to be able to add a show to my favorites and remove it

  Scenario: Shows can be added to my favorites-anon
    Given There are no favorite shows in the favorite show screen
    When I mark a show as favorite
    Then There are favorite shows in the favorite show screen

  Scenario: Favorite shows can be removed
    Given I have favorite shows
    When I remove a favorite show
    Then There are no favorite shows in the favorite show screen
    And I should see Favorite screen empty messages

  Scenario: Shows can be added to my favorite-auth
    Given I log in with a valid provider
    When There are no favorite shows in the favorite show screen
    And I mark a show as favorite
    Then There are favorite shows in the favorite show screen

  Scenario: Favorite shows list screen elements-anon
    Given I have favorite shows  
    When Verify Search button,EDIT button, Show thumbnail and Show title on favorites when show is added

  Scenario: Favorite shows list screen elements-auth
    Given I log in with a valid provider
    When I have favorite shows  
    Then Verify Search button,EDIT button, Show thumbnail and Show title on favorites when show is added

  Scenario: Navigation of show added to Favorites
   Given I have favorite shows
   When I tap on the show in Favorites screen
   Then I should navigate to show detail screen

  Scenario: Shows Added to Favorite reflected after login
    Given I have favorite shows 
    When I log in with a valid provider
    Then I should see same show in favorite screen

  Scenario: Auth- Favorite shows can be removed
    Given I log in with a valid provider
    And I have favorite shows
    When I remove a favorite show
    Then There are no favorite shows in the favorite show screen
    And I should see Favorite screen empty messages

  Scenario: Shows deleted from Favorites Shows screen reflect after log out  
    Given I log in with a valid provider
    And I have favorite shows
    When I remove a favorite show
    Then There are no favorite shows in the favorite show screen
    When I sign out from valid provider from any screen
    Then There are no favorite shows in the favorite show screen

  Scenario: Favorite screen - Search functionality
    Given I'm on the landing screen
    And I am on favorite show screen
    When I click on Search icon on screen
    Then I should see search screen should open
