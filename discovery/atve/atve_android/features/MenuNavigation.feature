Feature: Menu Navigation 

  Scenario: Home 
    Given I login as anonymous user
    When I go to the 'Home' screen
    Then I am on 'Home' screen

  Scenario: Shows
   Given I login as anonymous user
   When I go to the 'Shows' screen
   Then I am on 'Shows' screen

  Scenario: Live
    Given I login as anonymous user
    When I go to the 'Live' screen
    Then I am on 'Live' screen

  Scenario: Search 
    Given I login as anonymous user
    When I go to the 'Search' screen
    Then I am on 'Search' screen

  Scenario: Settings  
    Given I login as anonymous user 
    When I go to the 'Account' screen
    Then I am on 'Account' screen
