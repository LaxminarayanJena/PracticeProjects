Feature: Settings

Scenario: Validate Settings screen options
    Given I am on a settings screen
    Then I see all the settings screen options

Scenario: Get Privacy policy details from Settings
	Given I am on a settings screen
	When I select 'Privacy' option
	Then I see details of 'Privacy' option

Scenario: Get About details from Settings
	Given I am on a settings screen
	When I select 'About' option
	Then I see details of 'About' option

Scenario: Get FAQ details from Settings
	Given I am on a settings screen
	When I select 'FAQ' option
	Then I see details of 'FAQ' option

Scenario: Get Terms and Conditions details from Settings
	Given I am on a settings screen
	When I select 'Terms and Conditions' option
	Then I see details of 'Terms and Conditions' option

Scenario: Get Contact details from Settings
	Given I am on a settings screen
	When I select 'Contact' option
	Then I see details of 'Contact' option

Scenario: Get Nielsen Measurement details from Settings
	Given I am on a settings screen
	When I select 'Nielsen Measurement' option
	Then I see details of 'Nielsen Measurement' option

Scenario: Disable Nielsen Measurement from Settings
	Given I am on a settings screen
	When I see Nielsen Measurement toggle as 'ON' option
	And I select 'Nielsen Measurement' option
	And I click on Nielsen Measurement 'Disable' button
	Then I see Nielsen Measurement toggle as 'OFF' option

Scenario: Enable Nielsen Measurement from Settings
	Given I am on a settings screen
	When I see Nielsen Measurement toggle as 'OFF' option
	And I select 'Nielsen Measurement' option
	And I click on Nielsen Measurement 'Enable' button
	Then I see Nielsen Measurement toggle as 'ON' option
