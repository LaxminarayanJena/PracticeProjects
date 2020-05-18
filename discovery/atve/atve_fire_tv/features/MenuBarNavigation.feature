Feature: MenuBar Navigation

  As a user I should be able to Navigate through MenuBar

  Scenario: Anon - Navigate to Home Screen
    Given I am on the Menu Bar
    Then  I navigate to 'Home' screen

  Scenario: Anon - Navigate to Live Screen
    Given I am on the Menu Bar
    Then  I navigate to 'Live' screen

  Scenario: Anon - Navigate to Shows Screen
    Given I am on the Menu Bar
    Then  I navigate to 'Shows' screen

  Scenario: Anon - Navigate to Search Screen
    Given I am on the Menu Bar
    Then  I navigate to 'Search' screen

  Scenario: Anon - Navigate to Settings Screen
    Given I am on the Menu Bar
    Then  I navigate to 'Settings' screen

  Scenario: Anon - Navigate to Signin Screen
    Given I am on the Menu Bar
    Then  I navigate to 'Sign In' screen

  Scenario: Anon - Scroll forward & Backward through Menu Bar options
    Given I am on the Menu Bar
    Then I should scroll down & scroll up through Menu Bar options
