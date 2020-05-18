Feature: Euro Black Android - Watch Screen

Scenario: Navigate to Home tab on watch screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  Then I click "HOME" tab on watch screen

Scenario: Navigate to Scehdule tab on watch screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  Then I click "SCHEDULE" tab on watch screen

Scenario: Navigate to Latest Videos videos tab on watch screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  Then I click "LATEST VIDEOS" tab on watch screen

Scenario: Navigate to Premium videos tab on watch screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  Then I click "PREMIUM" tab on watch screen

Scenario: Navigate to Sport videos tab on watch screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "SPORT VIDEOS" tab on watch screen
  Then I see content of sport videos load successfully

Scenario: Navigate to Competition videos tab on watch screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "COMPETITON VIDEOS" tab on watch screen
  Then I should see list of sports in competition videos

Scenario Outline: Verify Sport Videos Categories and list of sports in respective categories
  Given I verify and tap "<Sport_Video_Category>" in Sport videos
  Then I see list of sports in sport videos category dropdown
  Examples:
| Sport_Video_Category  |
| POPULAR SPORTS        |
| ALL SPORTS            |

Scenario: Navigate to sport page from Sport Videos dopdown on watch screen
  Given I select a sport from popular sports in Sport videos
  Then I should be on selected sport page

Scenario: Navigate to competition page from list of sports in competition videos category
  Given I tap on a sport in competition videos category
  When I see list of competitions in selected sport
  And I tap on first competition from selected sport
  And I should be on selected competion page
  Then I should be navigated back to Watch screen

Scenario: Verify seven days forward from today's day in calennder in Schedule tab
  Given I see calender on schedule tab on watch screen
  When Calender should start from today
  Then I should see seven days in calender starting from today

Scenario: Verify seven days backward from today's day in calennder in Schedule tab
  Given I see calender on schedule tab on watch screen
  When Calender should start from today
  Then I should see seven days in calender prior to today

Scenario: Verify Show earlier today button on today's date
  Given I see calender on schedule tab on watch screen
  When I see Show Earlier Today button for today's date
  Then I should not see any button if any other day is selected

Scenario: Verify past programs list with “Show/Hide earlier today” button
  Given I'm on the home screen
  When I navigate to the schedule tab on the watch screen
  And I tap on "Show Earlier Today" button
  Then I see past programs list should be displayed
  And I tap on "Hide Earlier Today" button
  And I see past programs list should not be displayed

Scenario: Verify Previous and Next day button at the bottom of Schedule tab
  Given I'm on the home screen
  When I navigate to the schedule tab on the watch screen
  Then I see Previous and Next day button at bottom of Schedule tab
  And I navigate to next day
  Then I should be on next day of Schedule Calender

Scenario: Verify On Now shows for today's date on Schedule tab
  Given I'm on the home screen
  When I navigate to the schedule tab on the watch screen
  Then I see On Now shows for today's date

Scenario: Verify upcoming program list and its show card on Schedule tab
  Given I'm on the home screen
  When I navigate to the schedule tab on the watch screen
  And I see upcoming program list on schedule tab
  Then I verify show card on upcoming program list

Scenario: Verify Latest Premium carousel on Premium tab on Watch Screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "PREMIUM" tab on watch screen
  Then I see latest premium carousel on Premium tab on watch screen
