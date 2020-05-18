Feature: App Settings

  as a user
  I want to be able change the app settings

  Scenario: Information about Discovery is available from settings
    Given I login as anonymous user
    When I go to the 'About' screen
    Then app details should be visible

  Scenario: Get Help / FAQ from settings
    Given I login as anonymous user
    When I go to the 'Help / FAQ' screen
    Then I should be able to read FAQS

  Scenario: Get Nielsen Details from settings
    Given I login as anonymous user
    When I go to the 'Nielsen Measurements' screen
    Then agreement details should be visible

  Scenario: Read the Online Closed Captioning
    Given I login as anonymous user
    When I go to the 'Online Closed Captioning' screen
    Then online closed captioning details should be visible
  
  Scenario: Read the Privacy Policy
    Given I login as anonymous user
    When I go to the 'Privacy Policy' screen
    Then privacy policy details should be visible

  Scenario: Read the Terms and Conditions
    Given I login as anonymous user
    When I go to the 'Terms & Conditions' screen
    Then terms and conditions should be visible

  @wip
  Scenario: Get Contact Us Details from settings
    Given I login as anonymous user
    When I go to the 'Contact Us / Send Feedback' screen
    Then contact details should be visible

  Scenario: Get Version Details from settings
    Given I login as anonymous user
    When I go to the 'Version Info' screen
    Then version details should be visible

  Scenario: Auth - Settings screen
    Given I log in with a valid provider
    And I am on the settings screen
    Then I see Affiliate icon
    And I see Sign out button on the settings screen 

  Scenario: Header text for signin to verify TV provider
   Given I login as anonymous user
   And I am on the settings screen
   Then I see text Verify your TV provider to access even more videos
   Then I see Sign in button on the settings screen
