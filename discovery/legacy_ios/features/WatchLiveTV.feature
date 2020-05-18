Feature:Watch Live TV

  Scenario: Watch Live TV Without Login
    Given I go to main menu
    When I click on watch live tv
    Then I should see sign in to unlock all shows

  Scenario: Watch Live TV With Login
    Given I log in with a valid provider
    And I click on watch live tv
    Then I should see live video playing

  Scenario: Watch Live TV Video Through Key Icon Using Provider Login
    Given I go to main menu
    When I click on watch live tv
    And I search provider and login with valid credential
    Then I should see live video playing
