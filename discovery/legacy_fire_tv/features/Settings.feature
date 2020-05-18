Feature: Settings

Scenario: Sign In
	Given I am on a settings screen
    When I select 'Sign In' option
    Then I should see an activation screen

Scenario: Validate Settings screen options
    Given I am on a settings screen
    Then I see all the settings screen options

Scenario: Get Contact Us details from Settings 
	Given I am on a settings screen
	When I select 'Contact Us' option
	Then I see details of 'Contact Us' option

Scenario: Get Privacy policy details from Settings
	Given I am on a settings screen
	When I select 'Privacy Policy' option
	Then I see details of 'Privacy Policy' option

Scenario: Get Terms of Service details from Settings
	Given I am on a settings screen
	When I select 'Terms of Service' option
	Then I see details of 'Terms of Service' option

Scenario: Get Frequently asked Questions details from Settings
	Given I am on a settings screen
	When I select 'Frequently Asked Questions' option
	Then I see details of 'Frequently Asked Questions' option

Scenario: Get Nielsen Measurement details from Settings
	Given I am on a settings screen
	When I select 'Nielsen Measurement' option
	Then I see details of 'Nielsen Measurement' option

Scenario: Sign out
	Given I am on a settings screen
	When I select 'Sign In' option
	And I get and verify the activation code
	And I log in with valid provider for activate
	Then I see Sign Out option and click on it

Scenario: Get California Do Not Sell My Info details from Settings
	Given I am on a settings screen
	When I select 'California Do Not Sell My Info' option
	Then I see details of 'California Do Not Sell My Info' option
