Feature: Settings

  Scenario: Anon - Settings subnav
	Given I am on the Settings screen
	Then I see TV Provider, My List, About, Help, Nielsen Measurements

  Scenario: Anon - TV Provider subnav
	Given I am on the Settings screen
	When I go to the "TV Provider" subnav
	Then I see details of "TV Provider"

  Scenario: Anon - My List subnav
	Given I am on the Settings screen
	When I go to the "My List" subnav
	Then I see details of "My List"

  Scenario: Anon - About subnav
	Given I am on the Settings screen
	When I go to the "About" subnav
	Then I see details of "About"

  Scenario: Anon - Help subnav
	Given I am on the Settings screen
	When I go to the "Help" subnav
	Then I see details of "Help"

  Scenario: Anon - Nielsen Measurements subnav
	Given I am on the Settings screen
	When I go to the "Nielsen Measurements" subnav
	Then I see details of "Nielsen Measurements"

  Scenario: Anon - About subnav URLs
	Given I am on the Settings screen
	When I go to the "About" subnav
	Then I see related info with URLs
