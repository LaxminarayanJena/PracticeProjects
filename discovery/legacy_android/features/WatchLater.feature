Feature:Watch Later
  As a user I'm able to add/remove shows from watch later

  Scenario: Watch later shows can be added
    Given I add a show to my watch later list
    Then I should see a show in the watch list

  Scenario: Watch later shows can be removed
    Given I add a show to my watch later list
    When I remove a show from watch later
    Then I should see no shows in the watch list

  Scenario: Add show to watch later with + icon and verify success message
    Given I am on a show screen
    When I tap on "+ icon" on watch later
    And I should see success message on watch later
    Then I should see - icon on watch later

  Scenario: Remove show from watch later with - icon and verify removal message
    Given I see watch later is enabled
    When I tap on "- icon" on watch later
    And I should see removal message on watch later
    Then I should see + icon on watch later
    
Scenario: Auth - Watch later shows can be removed
    Given I log in with a valid provider
    And I add a show to my watch later list
    When I remove a show from watch later
    Then I should see no shows in the watch list
    And I should see Watch Later empty messages

 Scenario: Navigation of Episode added to Watch Later
    Given I add a show to my watch later list
    And I should see a show in the watch list
    When I click on play button of the show
    Then I should see the video playing  

 Scenario: Episodes Added to Watch Later reflected after login
    Given I add a show to my watch later list
    And I should see a show in the watch list
    When I log in with a valid provider
    Then I should see same show in the watch list

  Scenario: Epsiodes deleted from Watch Later screen reflect after log out
    Given I log in with a valid provider
    And I add a show to my watch later list
    When I remove a show from watch later
    Then I should see no shows in the watch list
    When I sign out from valid provider from any screen
    Then I should see no shows in the watch list

  Scenario: Watch Later - Search functionality
    Given I'm on the landing screen
    And I click on watch later
    When I click on Search icon on screen
    Then I should see search screen should open
