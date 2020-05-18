Feature:Watch Live TV

  Scenario: Watch Live TV Without Login
    Given I go to main menu
    When I click on watch live tv
    Then I should see sign in to unlock all shows

  Scenario: Watch Live TV With Login
    Given I log in with a valid provider
    And I go to main menu
    And I click on watch live tv
    Then I should see live video playing

  Scenario: Watch Live TV Video Through Key Icon Using Provider Login
    Given I go to main menu
    When I click on watch live tv
    And Search provider and login with valid credential
    Then I should see live video playing

  Scenario: Check Live Icon - Watch Live TV With Login
    Given I log in with a valid provider
    When I go to main menu
    And I click on watch live tv
    Then I see live icon on the screen

  Scenario: Back Button Functionality - Watch Live TV With Login
    Given I log in with a valid provider
    When I go to main menu
    And I click on watch live tv
    When I click on live tv back button
    Then I should navigate to home screen

  Scenario: Player Controls visibility - Watch Live TV With Login
    Given I log in with a valid provider
    When I go to main menu
    And I click on watch live tv
    Then I see "back button" on player
    And I see "volume button" on player
    And I see "CC button" on player
