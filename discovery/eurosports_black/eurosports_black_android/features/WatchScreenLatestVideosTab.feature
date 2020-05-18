Feature: Euro Black Android - Watch Screen Latest Videos Tab

Scenario: Verify Most Popular carousel on Latest Videos tab on Watch Screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "LATEST VIDEOS" tab on watch screen
  Then I see "MOST POPULAR" carousel on latest videos tab on watch screen

Scenario: Verify Latest carousel on Latest Videos tab on Watch Screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "LATEST VIDEOS" tab on watch screen
  Then I see "LATEST" carousel on latest videos tab on watch screen

Scenario: Scroll Most Popular carousel video tiles left and right in Latest Videos
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "LATEST VIDEOS" tab on watch screen
  Then I scroll most popular videos left and right

Scenario: Verify metadata on each video tile in Most Popular in latest videos
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "LATEST VIDEOS" tab on watch screen
  Then I see metadata on each video tile in Most Popular in latest videos

Scenario: Scroll Latest carousel video tiles left and right in Latest Videos
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "LATEST VIDEOS" tab on watch screen
  Then I scroll latest carousel videos left and right
