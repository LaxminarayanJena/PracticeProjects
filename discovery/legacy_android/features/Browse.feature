Feature: Browse

Scenario: Validating the browse screen for valid user
	Given I log in with a valid provider
	When User has to be logged in
	And I go to browse
	And I am on BROWSE screen
	Then I see BROWSE screen with affiliate logo, search icon and hamburger menu

Scenario: Validating the hamburger menu icon functionality in browse screen for valid user
	Given I log in with a valid provider
	When User has to be logged in
	And I go to browse
	And I am on BROWSE screen
	Then I see all hamburger menu icon functionality

Scenario: Validating the hamburger menu icon functionality in browse screen for anon user
	Given I'm on the landing screen
	Then I see all hamburger menu icon functionality

Scenario: Validating keyboard is enabled after clicking on search
	Given I'm on the landing screen
	When I go to browse
	And I am on BROWSE screen
	Then I click on search icon
	And I see keypad is enabled

Scenario: Validate back button to exit from app
	Given I'm on the landing screen
	When I go to browse
	And I am on BROWSE screen
	Then I click on device back button
	And I see app exits

