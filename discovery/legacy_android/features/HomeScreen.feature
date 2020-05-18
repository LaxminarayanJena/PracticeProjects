Feature: Home Screen

  Scenario: Check Home Hero carousel is present
    Given I'm on the home screen
    Then I see home hero carousel on home page

  Scenario: Check On Last Night carousel is present
    Given I'm on the home screen
    Then I see "ON LAST NIGHT" carousel on home page

  Scenario: Check Unlocked Episodes carousel is present
    Given I'm on the home screen
    Then I see "POPULAR" carousel on home page

  Scenario: Check Popular carousel is present
    Given I'm on the home screen
    Then I see "UNLOCKED EPISODES" carousel on home page

  Scenario: Check AHC Lists carousel is present
    Given I'm on the home screen
    Then I see "AHC LISTS" carousel on home page

  Scenario: Check More Full Episodes carousel is present
    Given I'm on the home screen
    Then I see "MORE FULL EPISODES" carousel on home page

  Scenario: Check Shows in hamburger menu is present-Anon
    Given I'm on the landing screen
    When I click on hamburger menu
    Then I see and click "Shows" on hamburger menu
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

  Scenario: Episode info modal- home screen check show info-Anon
    Given I'm on the landing screen
    Then I should see info icon is displayed

  Scenario: Episode info modal loads-Anon
    Given I'm on the landing screen
    When I tap on info icon
    Then I see Info modal loads

  Scenario: Episode info modal-watch later icon and close button-Anon
    Given I'm on the landing screen
    When I tap on info icon
    Then I tap on info modal close icon

  Scenario: Episode info modal-tap on play button-Anon
    Given I tap on info button of locked content
    When I tap on Play Episode button on info modal
    Then I see affiliate picker screen

  Scenario: Episode info modal-tap on play button-Auth
    Given I log in with a valid provider
    When I tap on info icon
    And I tap on Play Episode button on info modal
    Then I should see live video playing

  Scenario: Episode info modal-Show screen from Info screen-Auth
    Given I log in with a valid provider
    When I tap on info icon
    And I tap on show title on info modal
    Then I see specific show screen

  Scenario: Check in Header- Hamburger icon is present
    Given I'm on the home screen
    Then I see "HAMBURGER ICON" on home page

  Scenario: Check in Header- Network logo is present
    Given I'm on the home screen
    Then I see "NETWORK_LOGO" on home page

  Scenario: Check in Header- Search icon is present
    Given I'm on the home screen
    Then I see "SEARCH ICON" on home page

  Scenario: Check in Header- provider icon is present-Auth
    Given I'm on the home screen
    When I log in with a valid provider
    Then I see "Provider ICON" on home page present on sign-in

  Scenario: Check in Header- Hamburger icon is present-Auth
    Given I'm on the home screen
    When I log in with a valid provider
    Then I see "HAMBURGER ICON" on home page present on sign-in

  Scenario: Check in Header- Network logo is present-Auth
    Given I'm on the home screen
    When I log in with a valid provider
    Then I see "NETWORK_LOGO ICON" on home page present on sign-in

  Scenario: Check in Header- Search icon is present-Auth
    Given I'm on the home screen
    When I log in with a valid provider
    Then I see "SEARCH ICON" on home page present on sign-in

  Scenario: Tap on any video tile with locked key and verify the affiliate picker screen
    Given I'm on the home screen
    When I tap on any video tile with locked key
    Then I see affiliate picker screen

    Scenario: Home Screen - Show Shelf
      Given I'm on the landing screen
      And I see "POPULAR" carousel on home page

    Scenario: Home Screen - Playlist Shelf
      Given I'm on the landing screen
      And I see "AHC LISTS" carousel on home page

    Scenario: Show Tile - Metadata
      Given I'm on the landing screen
      When I see "UNLOCKED EPISODES" carousel on home page
      Then I see series artwork along with title as metadata on show card

    Scenario: Episode Tile - Metadata
      Given I'm on the landing screen
      When I see "UNLOCKED EPISODES" carousel on home page
      Then I see episode title,episode number & show art on episode tile

    Scenario: Tap on Playlist tile
      Given I'm on the landing screen
      When I see "AHC LISTS" carousel on home page
      And I tap on AHC LISTS
      Then I see that particular playlist page
