Feature: Splash-Welcome Screen

As a user
 
 I should be able to navigate to splash , welecome and home screen

  Scenario: Anon - Home Screen
    Given I am in splash screen
    When I navigate to welcome page
    And I see the details in welcome page
    And I click on maybe later button
    Then I should be navigated to home screen
