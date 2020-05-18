Feature: Euro Black iOS - Watch Screen Home Tab

  Scenario: Verify Home Tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab

  Scenario: Verify What's On carousel on watch screen home
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "WHAT'S ON" video carousel on watch screen home

  Scenario: Verify horizontal functionality of What's On carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "WHAT'S ON" video carousel on watch screen home
    And I see and verify scroll to right horizontal functionality on "WHAT'S ON" carousel

  Scenario: Verify Play Button option on What's On carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I should be on the "HOME" tab
    Then I should see "WHAT'S ON" video carousel on watch screen home
    And I see "PLAY BUTTON" option on what’s on videos

  Scenario: Verify on now option on What's On carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I should be on the "HOME" tab
    Then I should see "WHAT'S ON" video carousel on watch screen home
    And I see "ON NOW" option on what’s on videos

  Scenario: Verify On Next carousel on watch screen home
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "ON NEXT" video carousel on watch screen home

  Scenario: Scroll to right - Verify horizontal functionality of On Next carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "ON NEXT" video carousel on watch screen home
    And I see and verify scroll to right horizontal functionality on "ON NEXT" carousel

  Scenario: Scroll to left - Verify horizontal functionality of On Next carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "ON NEXT" video carousel on watch screen home
    And I see and verify scroll to left horizontal functionality on "ON NEXT" carousel

  Scenario: Verify meta data of On Next carousel videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "ON NEXT" video carousel on watch screen home
    And I see and verify metadata on each video tile of "ON NEXT" carousel

  Scenario: Verify Most Popular carousel on watch screen home
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "MOST POPULAR" video carousel on watch screen home

  Scenario: Scroll to right - Verify horizontal functionality of Most Popular carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "MOST POPULAR" video carousel on watch screen home
    And I see and verify scroll to right horizontal functionality on "MOST POPULAR" carousel

  Scenario: Scroll to left - Verify horizontal functionality of Most Popular carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "MOST POPULAR" video carousel on watch screen home
    And I see and verify scroll to left horizontal functionality on "MOST POPULAR" carousel

  Scenario: Verify meta data of Most Popular carousel videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "MOST POPULAR" video carousel on watch screen home
    And I see and verify metadata on each video tile of "MOST POPULAR" carousel

  Scenario: Verify Play Button on Most Popular carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I should be on the "HOME" tab
    Then I should see "MOST POPULAR" video carousel on watch screen home
    And I see "PLAY BUTTON" on most popular

  Scenario: Verify watch Button on Most Popular carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I should be on the "HOME" tab
    Then I should see "MOST POPULAR" video carousel on watch screen home
    And I see "WATCH BUTTON" on most popular

  Scenario: Verify Eurosport Original carousel on watch screen home
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "EUROSPORT ORIGINALS" video carousel on watch screen home

  Scenario: Scroll to right - Verify horizontal functionality of Eurosport Originals carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "EUROSPORT ORIGINALS" video carousel on watch screen home
    And I see and verify scroll to right horizontal functionality on "EUROSPORT ORIGINALS" carousel

  Scenario: Scroll to left - Verify horizontal functionality of Eurosport Originals carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "EUROSPORT ORIGINALS" video carousel on watch screen home
    And I see and verify scroll to left horizontal functionality on "EUROSPORT ORIGINALS" carousel

  Scenario: Verify meta data of Eurosport Original carousel Series
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "EUROSPORT ORIGINALS" video carousel on watch screen home
    And I see and verify metadata on each video tile of "EUROSPORT ORIGINALS SERIES" carousel

  Scenario: Verify back button option on Eurosport Original carousel series
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I should be on the "HOME" tab
    And I see and click on one of the "EUROSPORT ORIGINALS" series on watch hub
    Then I should see "BACK BUTTON" on EUROSPORT ORIGINALS series videos

  Scenario: Verify watch button option on Eurosport Original carousel series
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I should be on the "HOME" tab
    And I see and click on one of the "EUROSPORT ORIGINALS" series on watch hub
    Then I should see "WATCH BUTTON" on EUROSPORT ORIGINALS series videos

  Scenario: Verify play button option on Eurosport Original carousel series
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I should be on the "HOME" tab
    And I see and click on one of the "EUROSPORT ORIGINALS" series on watch hub
    Then I should see "PLAY BUTTON" on EUROSPORT ORIGINALS series videos

  Scenario: Verify Latest Premium carousel on watch screen home
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "LATEST PREMIUM" video carousel on watch screen home

  Scenario: Scroll to right - Verify horizontal functionality of Latest Premium carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "LATEST PREMIUM" video carousel on watch screen home
    And I see and verify scroll to right horizontal functionality on "LATEST PREMIUM" carousel

  Scenario: Scroll to left - Verify horizontal functionality of Latest Premium carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "LATEST PREMIUM" video carousel on watch screen home
    And I see and verify scroll to left horizontal functionality on "LATEST PREMIUM" carousel

  Scenario: Verify meta data of Latest Premium carousel videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "LATEST PREMIUM" video carousel on watch screen home
    And I see and verify metadata on each video tile of "LATEST PREMIUM" carousel

  Scenario: Verify Latest Free carousel on watch screen home
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "LATEST FREE" video carousel on watch screen home

  Scenario: Scroll to right - Verify horizontal functionality of Latest Free carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "LATEST FREE" video carousel on watch screen home
    And I see and verify scroll to right horizontal functionality on "LATEST FREE" carousel

  Scenario: Scroll to left - Verify horizontal functionality of Latest Free carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "LATEST FREE" video carousel on watch screen home
    And I see and verify scroll to left horizontal functionality on "LATEST FREE" carousel

  Scenario: Verify meta data of Latest Free carousel videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I should be on the "HOME" tab
    And I should see "LATEST FREE" video carousel on watch screen home
    And I see and verify metadata on each video tile of "LATEST FREE" carousel

