Feature: Login
 
  Scenario: Login with valid credentials
    Given I login with valid credentials
    Then User should be logged in

  Scenario: Logout 
    Given I login with valid credentials
    And User should be logged in
    Then I tap on "logout"

 Scenario: Error message
    Given I login with invalid credentials
    Then I see error message
