Feature: Login

  Scenario: Anon - Affiliate login
    Given I navigate to sign in option
    Then I see visit url & activate code

  Scenario: Auth - Affiliate login
    Given I navigate to sign in option
    When I get and verify the activation code
    And I log in with valid provider for activate
    Then I see the activation success message
