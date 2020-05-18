Feature: Euro Black iOS - Watch Screen Latest News Tab

  Scenario: Verify Latest News Tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "Latest News" tab on watch screen
    Then I should be on the "Latest News" tab

  Scenario: Verify Most Popular videos on Latest News Tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "Latest News" tab on watch screen
    Then I should see "MOST POPULAR" video carousels on watch screen latest news

  Scenario: Verify Latest Free videos on Latest News Tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "Latest News" tab on watch screen
    Then I should see "LATEST" video carousels on watch screen latest news

  Scenario: Scroll to right - Verify horizontal functionality of Most Popular carousel on latest videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "Latest News" tab on watch screen
    Then I should see "MOST POPULAR" video carousels on watch screen latest news
    And I verify scroll to right horizontally on "MOST POPULAR" carousel

  Scenario: Scroll to right - Verify horizontal functionality of latest carousel on latest videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "Latest News" tab on watch screen
    Then I should see "LATEST" video carousels on watch screen latest news
    And I verify scroll to right horizontally on "LATEST" carousel

  Scenario: Scroll to left - Verify horizontal functionality of Most Popular carousel on latest videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "Latest News" tab on watch screen
    Then I should see "MOST POPULAR" video carousels on watch screen latest news
    And I verify scroll to left horizontally on "MOST POPULAR" carousel

  Scenario: Scroll to left - Verify horizontal functionality of latest carousel on latest videos
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "Latest News" tab on watch screen
    Then I should see "LATEST" video carousels on watch screen latest news
    And I verify scroll to left horizontally on "LATEST" carousel

