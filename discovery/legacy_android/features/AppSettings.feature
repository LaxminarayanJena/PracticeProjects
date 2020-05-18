Feature: App Settings

  as a user
  I want to be able change the app settings

  Scenario: Read About the app
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'About' screen
    Then app details should be visible

  Scenario: Get Help / FAQ from settings
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Help / FAQ' screen
    Then I should be able to read FAQS

  Scenario: Read the Online Closed Captioning
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Online Closed Captioning' screen
    Then online closed captioning details should be visible

  Scenario: Read the Privacy Policy
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Privacy Policy' screen
    Then privacy policy details should be visible

  Scenario: Read the Terms and Conditions
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Terms and Conditions' screen
    Then terms and conditions should be visible

  Scenario: Get Nielsen Details from settings
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'About Nielsen Agreement' screen
    Then agreement details should be visible

  Scenario: Get Version Details from settings
    Given I'm on the landing screen
    When I go to settings
    Then version details should be visible

  Scenario: Back arrow functionality
    Given I'm on the landing screen
    When I go to settings
    And I click on back button
    Then I see home hero carousel on home page

  Scenario: Device back button functionality
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'About' screen
    And I click on device back button
    Then I see settings screen

  @wip
  Scenario: Get Contact Us Details from settings
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Contact US' screen
    Then contact details should be visible

  Scenario: Anon - Verify Settings Sign-in option
    Given I'm on the landing screen
    When I go to settings
    Then I see sign in option on the setting screen

  Scenario:  Auth - Verify Settings Sign-out option
    Given I log in with a valid provider
    When User has to be logged in
    And I go to settings
    Then I see sign out option on the setting screen

  Scenario:  Auth - Verify Settings Sign-in on clicking Sign-out
    Given I log in with a valid provider
    When User has to be logged in
    And I go to settings
    And I click sign out option on the setting screen
    Then I see sign in option on the setting screen
