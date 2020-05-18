Feature: SeasonPicker

Scenario: Validating the seasons are in sorted order
	Given I am on the show with multiple season screen
	When I click on season picker option
	Then I see seasons are in sorted order

Scenario: Validate for only one season in season picker
   Given I am on the show with one season screen
   When I click on season picker option
   Then I see there is only one season in show

 Scenario: Validating the seasons are in sorted order
	Given I am on the show with multiple season screen
	When I click on season picker option
	And I select season from season picker
	Then I see opened season as per selected season
