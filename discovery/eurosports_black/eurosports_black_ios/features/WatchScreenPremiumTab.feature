Feature: Euro Black iOS - Watch Screen Premium Tab

  Scenario: Verify Premium Videos Tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "PREMIUM VIDEOS" tab on watch screen
    Then I should be on the "PREMIUM VIDEOS" tab

  Scenario: Verify Latest Premium Videos Carousel
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "PREMIUM VIDEOS" tab on watch screen
    Then I should see "LATEST PREMIUM" video carousels

  Scenario: Verify RePlay Button on Latest Premium Videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "PREMIUM VIDEOS" tab on watch screen
    And I should see "LATEST PREMIUM" video carousels
    Then I should see "REPLAY BUTTON" on LATEST PREMIUM videos

  Scenario: Verify Play Button on Latest Premium Videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "PREMIUM VIDEOS" tab on watch screen
    And I should see "LATEST PREMIUM" video carousels
    Then I should see "PLAY BUTTON" on LATEST PREMIUM videos

  Scenario: scroll to right - Verify horizontal functionality of latest Premium carousel on premium tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "PREMIUM VIDEOS" tab on watch screen
    Then I should see "LATEST PREMIUM" video carousels
    And I verify scroll to right horizontally on "LATEST PREMIUM" carousel

  Scenario: scroll to left - Verify horizontal functionality of latest Premium carousel on premium tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "PREMIUM VIDEOS" tab on watch screen
    Then I should see "LATEST PREMIUM" video carousels
    And I verify scroll to left horizontally on "LATEST PREMIUM" carousel

  Scenario: Verify meta data of Latest Premium Carousel videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "PREMIUM VIDEOS" tab on watch screen
    Then I should see "LATEST PREMIUM" video carousels
    And I see meta data of each video of "LATEST PREMIUM" carousel

