Feature: Menu Navigation

  As a user I should be able to navigate between different menu items.

  Scenario: Anon - Navigating to Home menu
    Given I go to 'Home' screen
    Then Validate i am on 'Home' screen 

  Scenario: Anon - Navigating to Shows menu
    Given I go to 'Shows' screen
    Then Validate i am on 'Shows' screen

  Scenario: Anon - Navigating to Live menu
    Given I go to 'Live' screen
    Then Validate i am on 'Live' screen

  Scenario: Anon - Navigating to Search menu
    Given I go to 'Search' screen
    Then Validate i am on 'Search' screen

  Scenario: Anon - Navigating to Account menu
    Given I go to 'Account' screen
    Then Validate i am on 'Account' screen

  Scenario: Anon - Navigate to Search page from Shows page
    Given I go to 'Shows' screen
    When I go to 'Search' screen
    Then Validate i am on 'Search' screen

  Scenario: Anon - Navigate to Home Page from Shows page
    Given I go to 'Shows' screen
    When I go to 'Home' screen
    Then Validate i am on 'Home' screen

  Scenario: Anon - Navigate to Live Page from Shows page
    Given I go to 'Shows' screen
    When I go to 'Live' screen
    Then Validate i am on 'Live' screen

  Scenario: Anon - Navigate to Home Page from Search page
    Given I go to 'Search' screen
    When I go to 'Home' screen
    Then Validate i am on 'Home' screen

  Scenario: Anon - Navigate to Shows page from Search page
    Given I go to 'Search' screen
    When I go to 'Shows' screen
    Then Validate i am on 'Shows' screen

  Scenario: Anon - Navigate to Live page from Search page
    Given I go to 'Search' screen
    When I go to 'Live' screen
    Then Validate i am on 'Live' screen

    Scenario: Anon - Navigate to Home Page from Live page
    Given I go to 'Live' screen
    When I go to 'Home' screen
    Then Validate i am on 'Home' screen

  Scenario: Anon - Navigate to Shows page from Live page
    Given I go to 'Live' screen
    When I go to 'Shows' screen
    Then Validate i am on 'Shows' screen

  Scenario: Anon - Navigate to Search page from Live page
    Given I go to 'Live' screen
    When I go to 'Search' screen
    Then Validate i am on 'Search' screen

    Scenario: Anon - Home page - Screen refresh
    Given I go to 'Home' screen
    When I scroll down
    And I go to 'Home' screen
    Then Validate i am on 'Home' screen

  Scenario: Anon - Search page - Screen refresh
    Given I go to 'Search' screen
    When I scroll down
    And I go to 'Search' screen
    Then Validate i am on 'Home' screen

  Scenario: Anon - Validate Menu bar with scroll behavior in Show details page
    Given I am on show details screen
    When I scroll down
    Then I validate menu bar is not present

  Scenario: Anon - Validate Menu bar with scroll behavior in Video landing page
    Given I am on video landing screen
    When I scroll down
    Then I validate menu bar is not present
