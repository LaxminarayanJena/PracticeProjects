Feature: Menu Bar Navigation

  Scenario: Anon - Scroll forward & Backward through Menu Bar options
    Given I am on the home screen
    When I navigate to Menu Bar left panel
    Then I should scroll down & scroll up through Menu Bar options

  Scenario: Anon - Home screen - Shows title
    Given I am on the home screen
    Then I should see 'Shows' title on Home screen

  Scenario: Anon - Home screen - Just Added title
    Given I am on the home screen
    Then I should see 'Just Added' title on Home screen

  Scenario: Anon - Home screen - Go Original Series title
    Given I am on the home screen
    Then I should see 'Go Original Series' title on Home screen

  Scenario: Anon - Home screen - Popular Episodes title
    Given I am on the home screen
    Then I should see 'Popular Episodes' title on Home screen

  Scenario: Anon - Shows screen - Check show label
    Given I am on a Show screen in Apple TV
    Then I should see shows label on Shows screen

  Scenario: Anon - Live screen - Check Live screen
    Given I am on a Live screen in Apple TV
    Then I see network logo on the top left

  Scenario: Anon - Search screen - Check Search screen
    Given I am on a Search screen in Apple TV
    Then I should see search box on Search screen

  Scenario: Anon - Account screen - Check Account screen list
    Given I am on the Account screen in Apple TV
    Then I see Account screen sub menu list

  Scenario: Anon - Homepage default selected
    Given I am on the home screen
    Then I see the "Home" menu option is in the selected state

  Scenario: Anon - Navigation options – collapsed
    Given I am on the home screen
    Then I see the navigation bar in "collapsed" state with all the menu options

  Scenario: Anon - Navigation options – expanded
    Given I am on the home screen
    When I navigate to Menu Bar left panel
    Then I see the navigation bar in "expanded" state with all the menu options

  Scenario: Anon - Navigate to Search from Home screen
    Given I am on the home screen
    When I navigate and select "Search" icon from home
    Then I should see search box on Search screen
    And I see the "Search" menu option is in the selected state
    And all the other menu items are in unselected state except "Search"

  Scenario: Anon - Navigate to Account from Home screen
    Given I am on the home screen
    When I navigate and select "Account" icon from home
    Then I am on the Account screen in Apple TV
    And I see the "Account" menu option is in the selected state
    And all the other menu items are in unselected state except "Account"

  Scenario: Anon - Navigate to Home from Search screen
    Given I am on a Search screen in Apple TV
    When I navigate and select "Home" icon from search 
    Then I am on the home screen
    And I see the "Home" menu option is in the selected state
    And all the other menu items are in unselected state except "Home"

  Scenario: Anon - Navigate to Account from Search screen
    Given I am on a Search screen in Apple TV
    When I navigate and select "Account" icon from search
    Then I see Account screen sub menu list
    And I see the "Account" menu option is in the selected state
    And all the other menu items are in unselected state except "Account"

  Scenario: Anon - Navigate to Home from Account screen
    Given I am on the Account screen in Apple TV
    When I navigate and select "Home" icon from Account
    Then I am on the home screen
    And I see the "Home" menu option is in the selected state
    And all the other menu items are in unselected state except "Home"

  Scenario: Anon - Navigate to Search from Account screen
    Given I am on the Account screen in Apple TV
    When I navigate and select "Search" icon from Account
    Then I should see search box on Search screen
    And I see the "Search" menu option is in the selected state
    And all the other menu items are in unselected state except "Search"

  Scenario: Anon - Navigate to Home from Shows/Browse screen
    Given I am on a Show screen in Apple TV
    When I navigate and select "Home" icon from Shows
    Then I am on the home screen
    And I see the "Home" menu option is in the selected state
    And all the other menu items are in unselected state except "Home"

  Scenario: Anon - Navigate to Search from Shows/Browse screen
    Given I am on a Show screen in Apple TV
    When I navigate and select "Search" icon from Shows
    Then I should see search box on Search screen
    And I see the "Search" menu option is in the selected state
    And all the other menu items are in unselected state except "Search"

  Scenario: Anon - Navigate to Account from Shows/Browse screen
    Given I am on a Show screen in Apple TV
    When I navigate and select "Account" icon from Shows
    Then I see Account screen sub menu list
    And I see the "Account" menu option is in the selected state
    And all the other menu items are in unselected state except "Account"

  Scenario: Anon - Navigate to Home from Live screen
    Given I am on a Live screen in Apple TV
    When I navigate and select "Home" icon from Live
    Then I am on the home screen
    And I see the "Home" menu option is in the selected state
    And all the other menu items are in unselected state except "Home"

  Scenario: Anon - Navigate to Search from Live Screen
    Given I am on a Live screen in Apple TV
    When I navigate and select "Search" icon from Live
    Then I should see search box on Search screen
    And I see the "Search" menu option is in the selected state
    And all the other menu items are in unselected state except "Search"

  Scenario: Anon - Navigate to Account from Live Screen
    Given I am on a Live screen in Apple TV
    When I navigate and select "Account" icon from Live
    Then I see Account screen sub menu list
    And I see the "Account" menu option is in the selected state
    And all the other menu items are in unselected state except "Account"

  Scenario: Search screen - Refresh
    Given I am on a Search screen in Apple TV
    When I scroll down on the "Search" screen
    And I tap on "Search" icon
    Then I am taken to the top of the "Search" screen

  Scenario: Home screen - Refresh
    Given I am on the home screen
    When I scroll down on the "Home" screen
    And I tap on "Home" icon
    Then I am taken to the top of the "Home" screen

  Scenario: Show screen - Refresh
    Given I am on a Show screen in Apple TV
    When I scroll down on the "Shows" screen
    And I tap on "Shows" icon
    Then I am taken to the top of the "Shows" screen

  Scenario: Account screen - Refresh
    Given I am on the Account screen in Apple TV
    When I scroll down on the "Account" screen
    And I tap on "Account" icon
    Then I am taken to the top of the "Account" screen
