 Feature: Euro Black iOS - Watch Screen By Sport Tab

  Scenario: Verify Sport Videos Tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "SPORT VIDEOS" tab on watch screen
    Then I should be on the "SPORT VIDEOS" tab

  Scenario: Verify Popular & All Sports in Sport Videos Tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "SPORT VIDEOS" tab on watch screen
    Then I should see popular and all sports

  Scenario: Verify one of the popular sports on By Sports Tab
    Given I'm on the "SPORT VIDEOS" tab
    When I click on one of the sport from "POPULAR" sports category
    Then I should be on a selected sport category

  Scenario Outline: Verify one of the popular sports carousels on By Sports Tab
    Given I'm on the "SPORT VIDEOS" tab
    When I click on one of the sport from "POPULAR" sports category
    Then I should be on a selected sport category
    And I see "<sport_video_carousel>" carousel
    Examples:
    | sport_video_carousel  |
    | UPCOMING              |
    | LATEST VIDEOS         |
    | MOST POPULAR          |

  Scenario: Verify one of the all sports on By Sports Tab
    Given I'm on the "SPORT VIDEOS" tab
    When I click on one of the sport from "ALL" sports category
    Then I should be on a selected sport category

  Scenario Outline: Verify one of the all sports carousels on By Sports Tab
    Given I'm on the "SPORT VIDEOS" tab
    When I click on one of the sport from "ALL" sports category
    Then I should be on a selected sport category
    And I see "<sport_video_carousels>" carousel
    Examples:
    | sport_video_carousels  |
    | UPCOMING               |
    | LATEST VIDEOS          |

