Feature: iOS - Browse

  as a user
  I want to be able to check browse screen and all the available options

  Scenario: Anon - Browse Tab - Genre card navigation
    Given As an anonymous user i navigate to Browse screen from hamburger menu
    When I tap on any genre
    Then I see genre landing screen

  Scenario: Auth - Browse screen - Header section for Authenticated user
    Given I login with valid provider and go to Browse screen from hamburger menu
    When I see Browse Page title, Affiliate logo & close icon in Header section
    Then I go back from Browse screen and Sign out

  Scenario: Anon - Browse Screen - Close icon functionality
    Given As an anonymous user i navigate to Browse screen from hamburger menu
    When I click on close button
    Then I see and click "Home" on hamburger menu

  Scenario: Anon - Browse screen - Show card metadata
    Given As an anonymous user i navigate to Browse screen from hamburger menu
    Then I see show title, genre icon on the thumbnail
