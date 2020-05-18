Feature: Account

  as a user
  I want to be able change the Account

  Scenario: Anon - Account Do Not Sell My Info
    Given I am on the Account screen in Apple TV
    When I go to the "California Do Not Sell My Info" screen
    Then I see details of "California Do Not Sell My Info" option
	And I tap on back
	And I see Account screen sub menu list

  Scenario: Anon - Get App Info from Account
    Given I am on the Account screen in Apple TV
    When I go to the "App Information" screen
    Then I see details of "App Information" option
	And I tap on back
	And I see Account screen sub menu list

  Scenario: Anon - Read the Account - About
	Given I am on the Account screen in Apple TV
	When I go to the "About" screen
	Then I see details of "About" option
	And I tap on back
	And I see Account screen sub menu list

  Scenario: Anon - Get Help / FAQ from Account
	Given I am on the Account screen in Apple TV
	When I go to the "Help/FAQ" screen
	Then I see details of "Help/FAQ" option
	And I tap on back
	And I see Account screen sub menu list
	
  Scenario: Anon - Read the Terms and Conditions
	Given I am on the Account screen in Apple TV
	When I go to the "Terms and Conditions" screen
	Then I see details of "Terms and Conditions" option
    And I tap on back
	And I see Account screen sub menu list
	
  Scenario: Anon - Read the Privacy Policy
	Given I am on the Account screen in Apple TV
	When I go to the "Privacy Policy" screen
	Then I see details of "Privacy Policy" option
	And I tap on back
	And I see Account screen sub menu list
	
  Scenario: Anon - Get Nielsen Details from Account
	Given I am on the Account screen in Apple TV
	When I go to the "Nielsen Measurement" screen
	Then I see details of "Nielsen Measurement" option
	And I tap on back
	And I see Account screen sub menu list

  Scenario: Anon - Read the Online Closed Captioning
	Given I am on the Account screen in Apple TV
	When I go to the "Online Closed Captioning" screen
	Then I see details of "Online Closed Captioning" option
	And I tap on back
	And I see Account screen sub menu list

  Scenario: Anon - Validate network logo on Account page
    Given I am on the Account screen in Apple TV
    Then I see network logo on the top left
