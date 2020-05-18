Feature: Login

  As a user I would like to verify that I can login using the given providers

  Scenario: Affiliate login
    Given I log in with a valid provider
    Then I see and click on signout

  Scenario: Checking Forgot password
    Given I see and click on hamburger icon
    When I see and click on sign in
    Then I check if Forgot password is present

  Scenario: Checking Don't see provider
    Given I see and click on hamburger icon
    When I see and click on sign in
    And I check if Don't see provider is present
    And I click on Don't see provider
    Then I see Don't see provider page

  Scenario: Checking FAQ
    Given I see and click on hamburger icon
    When I see and click on sign in
    And I check if FAQ is present
    And I click on FAQ
    Then I see FAQ page
