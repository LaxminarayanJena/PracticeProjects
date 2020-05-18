Feature: Account
  
  Scenario: Account-About
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'About' screen
    Then I should see blank screen

  Scenario: Account-Help
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'Help' screen
    Then I see web view of help page

  Scenario:Account-App Information
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'App Information' screen
    Then I should be able to see app info

  Scenario:Account-Terms of Use
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'Terms of Use' screen
    Then I should see blank screen

  Scenario:Account-Nielsen Measurement
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'Nielsen Measurement' screen
    Then I should see blank screen

  Scenario:Account-Privacy Policy
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'Privacy Policy' screen
    Then I should see blank screen

  Scenario:Account-California Do Not Sell My Info
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'California Do Not Sell My Info' screen
    Then I should see blank screen

  Scenario:Account-Online Closed Captioning
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'Online Closed Captioning' screen
    Then online closed captioning details should be visible

  Scenario: Display My List
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'My List' screen
    Then I should see blank screen

  Scenario: Push Notifications
    Given I login as anonymous user
    When I am on home screen
    And I go to account
    And I go to 'Push Notifications' screen
    Then online closed captioning details should be visible
