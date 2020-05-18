Feature: Account

  As a user I should be able to work on account

  Scenario: My List
    Given I'm on the landing screen
    When I go to 'Account' screen
    And I click on 'My List' 
    Then 'My List' details should be visible

  Scenario: Get App Info from  Account
    Given I'm on the landing screen
    When I go to 'Account' screen
    And I click on 'App Information'
    Then 'App Information' details should be visible

  Scenario: Get Help from Account
    Given I'm on the landing screen
    When I go to 'Account' screen
    And I click on 'Help'
    Then I should be able to navigate to "Help" website

  Scenario: Account - About
    Given I'm on the landing screen
    When I go to 'Account' screen
    And I click on 'About'
    Then 'About' details should be visible

  Scenario: Get Push Notifications from Account
    Given I'm on the landing screen
    When I go to 'Account' screen
    And I click on 'Push Notifications'
    Then I should be able to navigate to "Push Notifications" website

  Scenario: Debug Settings from Account
    Given I'm on the landing screen
    When I go to 'Account' screen
    And I click on 'Debug Settings'
    Then 'Debug Settings' details should be visible