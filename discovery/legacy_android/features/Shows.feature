Feature: Shows

  as a user
  I want to be able check show info, sign in and play episodes,
  see episode level info and change to a different season

  Scenario: Check show info
    Given I am on a show screen
    When I check the show info
    Then I should see information about the show

  Scenario: Check episode level info
    Given I am on a show screen
    When I check the episode info
    Then I should see episode details

  Scenario: Play an episode with and without login
    Given I am on a locked show screen
    Then I should not be able to play any episode
    And I should be able to play the episode after logging in

  Scenario: Change to a different season
    Given I have selected a show that has multiple seasons
    When I change the season
    Then I should see episodes for the new season

  Scenario: Auth - Show title on show details screen
    Given I log in with a valid provider
    When User has to be logged in
    And I am on a show screen
    Then I see show title on show detail screen

  Scenario: Auth - Verify Show Description
    Given I log in with a valid provider
    When User has to be logged in
    And I am on a show screen
    Then I check the show info

  Scenario: Auth - Show Key Art on Show Details screen
    Given I log in with a valid provider
    When User has to be logged in
    And I am on a show screen
    Then I see show key art on show details screen

  Scenario: Auth - Affiliate logo on Show screen
    Given I log in with a valid provider
    When User has to be logged in
    And I am on a show screen
    Then I see affiliate logo on top right corner on show detail screen

  Scenario: Anon - Show Key Art on Show Details screen
    Given I'm on the landing screen
    When I am on a show screen
    Then I see show key art on show details screen

  Scenario: Anon - Affiliate screen on playing locked show episode
    Given I'm on the landing screen
    When I am on a locked show screen
    Then I see affiliate screen on playing locked show episode

  Scenario: Anon - Verify Watch more shows like this option on episodes tile
     Given I'm on the landing screen
     When I am on a show screen
     Then I see Watch more shows like this option on episodes tile

  Scenario: Auth - Verify Watch more shows like this option on episodes tile
     Given I log in with a valid provider
     When User has to be logged in
     And I am on a show screen
     Then I see Watch more shows like this option on episodes tile

  Scenario: Anon - Verify Similar Shows on clicking Watch more shows like this option
     Given I'm on the landing screen
     When I am on a show screen
     And I tap on Watch more shows like this button
     Then I see list of Similar Shows opens in another screen

  Scenario: Anon - Back from Similar Shows
     Given I am on a show screen
     When I tap on Watch more shows like this button
     And I see list of Similar Shows opens in another screen
     Then I go back to Show detail from similar shows

  Scenario: Anon - Back button on show detail screen
     Given I'm on the landing screen
     When I am on a show screen
     And I click on back button
     Then I'm on the shows list screen

   Scenario: Anon - Share icon on show detail screen
     Given I'm on the landing screen
     When I am on a show screen
     Then I see share icon on Show Art

  Scenario: Anon - Verify episode art on each episode
    Given I'm on the landing screen
    When I have selected a show that has multiple seasons
    And I change the season
    Then I see episode art on each episode

  Scenario: Auth - Verify episode art on each episode
    Given I log in with a valid provider
    When User has to be logged in
    And I have selected a show that has multiple seasons
    And I change the season
    Then I see episode art on each episode

  Scenario: Auth - Verify episode_no and title on episode
    Given I log in with a valid provider
    When User has to be logged in
    And I am on a show screen
    And I check the episode info
    Then I should see episode details

  Scenario: Anon - Play icon on episode tiles
    Given I'm on the landing screen
    When I am on a show screen
    Then I see play icon on each episode

  Scenario: Auth - Play icon on episode tiles
    Given I log in with a valid provider
    When User has to be logged in
    And I am on a show screen
    Then I see play icon on each episode

  Scenario: Auth - Play any episode from episode tiles
    Given I log in with a valid provider
    When User has to be logged in
    And I am on a show screen
    And I play any episode
    Then I should see the video playing

  Scenario: Sort Episodes in order of Newest to Oldest in episode list
    Given I have selected a show that has multiple seasons
    When I change the season
    Then I see episode listed in order of newest to oldest

  Scenario: Anon - Lock key on episode tiles
    Given I am on a locked show screen
    When I see locked key for unathenticated content
    Then I should not be able to play any episode

  Scenario: Auth - Select season and verify contents are watchable
    Given I log in with a valid provider
    When User has to be logged in
    And I have selected a show that has multiple seasons
    Then I see all contents are watchable in selected season
