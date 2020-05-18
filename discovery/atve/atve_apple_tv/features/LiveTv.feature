Feature: Live TV screen

  Scenario: Anon - Validate network logo on LiveTv page
	Given I am on a Live screen in Apple TV
	Then I see network logo on the top left

  Scenario: Schedule - Display of "LIVE/SCHEDULE" screen
    Given I launch the app
    When I navigate to Live screen in Apple TV
    Then I should see the live screen with Network List that has all the 18 networks,On Now section and Up Next section

  Scenario: Network Selectors - Display of network logo as per default selected network (TLC)
    Given I navigate to Live screen in Apple TV
    When I see the network selectors list with default selected network ex.TLC network
    Then I should see the network logo at the top of the screen as per the default selected network
