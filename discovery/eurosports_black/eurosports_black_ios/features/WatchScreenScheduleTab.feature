Feature: Euro Black iOS - Watch Screen Schedule Tab

  Scenario: Verify Schedule Tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "SCHEDULE" tab on watch screen
    Then I should be on the "SCHEDULE" tab

  Scenario: Verify seven days forward from today's day in calendar in Schedule tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I see calendar on schedule tab on watch screen
    And Calendar should start from today
    Then I should see seven days in calendar starting from today

  Scenario: Verify seven days backward from today's day in calendar in Schedule tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    Then I see calendar on schedule tab on watch screen
    And Calendar should start from today
    Then I should see seven days in calendar prior from today

  Scenario: Verify “Show/Hide earlier today” button
    Given I'm on watch hub schedule tab
    When I tap on "SHOW EARLIER TODAY" button
    And I see button should be changed to "HIDE EARLIER TODAY"
    Then I tap on "HIDE EARLIER TODAY" button
    And I see button should be changed to "SHOW EARLIER TODAY"

