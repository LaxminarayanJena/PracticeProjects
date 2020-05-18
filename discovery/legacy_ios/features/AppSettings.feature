Feature: iOS - App Settings

  as a user
  I want to be able change the app settings

  Scenario: Anon - Read About the app
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'About' setting screen
    Then app details should be visible

  Scenario: Anon - Get Help / FAQ from settings
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Help / FAQ' setting screen
    Then I should be able to read FAQS

  Scenario: Anon - Read the Online Closed Captioning
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Online Closed Captioning' setting screen
    Then online closed captioning details should be visible

  Scenario: Anon - Read the Privacy Policy
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Privacy Policy' setting screen
    Then privacy policy details should be visible

  Scenario: Anon - Read the Terms and Conditions
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Terms and Conditions' setting screen
    Then terms and conditions should be visible

  Scenario: Anon - Get Contact Details from settings
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'Contact US' setting screen
    Then contact details should be visible

  Scenario: Anon - Get Contract Details from settings
    Given I'm on the landing screen
    When I go to settings
    And I go to the 'About Nielsen Agreement' setting screen
    Then agreement details should be visible

  Scenario: Anon - Verify Settings Sign-in option
    Given I'm on the landing screen
    When I go to settings
    And I see and click on sign in
    Then I see affiliate picker screen

  Scenario: Anon - Settings - Close(X) icon functionality
    Given I'm on the landing screen
    When I go to settings
    And I tap on X button
    Then I see global navigation menu overlay

  Scenario: Auth - Verify Settings sign in button functionality
    Given I'm on the landing screen
    When I login from Settings screen
    Then I see and click on signout

  Scenario: Auth - Verify Settings Sign-in on clicking Sign-out
    Given I log in with a valid provider
    When I click sign out option on the setting screen
    Then I see sign in option on the setting screen

  Scenario: Auth - Verify Settings Sign-out option
    Given I log in with a valid provider
    Then I see sign out option on the setting screen

