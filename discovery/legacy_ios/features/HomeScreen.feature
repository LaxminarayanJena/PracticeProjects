Feature: Home Screen

  as a user
  I want to verify home screen/landing page functionality

  Scenario: Check Shows in hamburger menu is present-Anon
    Given I'm on the landing screen
    When I click on hamburger menu
    And I see and click "Shows" on hamburger menu
    Then I'm on the shows list screen

  Scenario: Check Continue Watching in hamburger menu is present-Anon
    Given I'm on the landing screen
    When I click on hamburger menu
    And I see and click "Continue Watching" on hamburger menu
    Then I should see "Continue Watching" page

  Scenario: Check Favorite Shows in hamburger menu is present-Anon
    Given I'm on the landing screen
    When I click on hamburger menu
    And I see and click "Favorite Shows" on hamburger menu
    Then I should see "Favorite Shows" page

  Scenario: Check Watch Later in hamburger menu is present-Anon
    Given I'm on the landing screen
    When I click on hamburger menu
    And I see and click "Watch Later" on hamburger menu
    Then I should see "Watch Later" page

  Scenario: Check Watch Live TV in hamburger menu is present-Anon
    Given I'm on the landing screen
    When I click on hamburger menu
    And I see and click "Watch Live TV" on hamburger menu
    Then I should see sign in to unlock all shows

  Scenario: Check Browse in hamburger menu is present-Anon
    Given I'm on the landing screen
    When I click on hamburger menu
    And I see and click "Browse" on hamburger menu
    Then I should see "Browse" page

  Scenario: Check Settings in hamburger menu is present-Anon
    Given I'm on the landing screen
    When I click on hamburger menu
    And I see and click "Settings" on hamburger menu
    Then I should see "Settings" page

  Scenario: Check Shows in hamburger menu is present-Auth
    Given I log in with a valid provider
    When I see and click "Shows" on hamburger menu
    Then I'm on the shows list screen
    And I see and click on signout

  Scenario: Check Continue Watching in hamburger menu is present-Auth
    Given I log in with a valid provider
    When I see and click "Continue Watching" on hamburger menu
    Then I should see "Continue Watching" page
    And I tap on X button
    And I see and click on signout

  Scenario: Check Favorite Shows in hamburger menu is present-Auth
    Given I log in with a valid provider
    When I see and click "Favorite Shows" on hamburger menu
    Then I should see "Favorite Shows" page
    And I tap on X button
    And I see and click on signout

  Scenario: Check Watch Later in hamburger menu is present-Auth
    Given I log in with a valid provider
    When I see and click "Watch Later" on hamburger menu
    Then I should see "Watch Later" page
    And I tap on X button
    And I see and click on signout

  Scenario: Check Browse in hamburger menu is present-Auth
    Given I log in with a valid provider
    When I see and click "Browse" on hamburger menu
    Then I should see "Browse" page
    And I click on close button
    And I see and click on signout

  Scenario: Check Settings in hamburger menu is present-Auth
    Given I log in with a valid provider
    When I see and click "Settings" on hamburger menu
    Then I should see "Settings" page
    And I tap on X button
    And I see and click on signout

  Scenario: Anon - Series tile
    Given I'm on the landing screen
    When I tap on any series tile
    Then I should see that particular series show page

  Scenario: Anon - Playlist tile
    Given I'm on the landing screen
    When I tap on any playlist tile
    Then I should see that particular playlist page

  Scenario: Anon - Playlist tile
    Given I'm on the landing screen
    When I tap on any playlist tile
    And I tap on watch button on episode tile
    Then I should see the video playing

  Scenario: Check in Header- Hamburger icon,Network logo and Search icon is present-Anon
    Given I'm on the landing screen
    Then I see hamburger icon, network logo and search icon
    
  Scenario: Check in Header- Hamburger icon,Network logo,Affilate logo and Search icon is present-Auth
    Given I log in with a valid provider
    When I see and click "Home" on hamburger menu
    Then I see hamburger icon, network logo and search icon
    And I see "AFFILIATE LOGO" on header
    And I see and click on signout
