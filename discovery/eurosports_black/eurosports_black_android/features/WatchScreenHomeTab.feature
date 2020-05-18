Feature: Euro Black Android - Watch Screen Home Tab

Scenario: Verify What's On/On Now carousel on Home tab on Watch Screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I see "WHAT'S ON" carousel on Home tab on watch screen

Scenario: Verify Most Popular carousel on Home tab on Watch Screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I see "MOST POPULAR" carousel on Home tab on watch screen

Scenario: Verify Eurosport Originals carousel on Home tab on Watch Screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I see "EUROSPORT ORIGINALS" carousel on Home tab on watch screen

Scenario: Verify Latest Premium carousel on Home tab on Watch Screen
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I see "LATEST PREMIUM" carousel on Home tab on watch screen

Scenario: Navigate to EUROSPORT ORIGINALS series
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  And I click on one of the EUROSPORT ORIGINALS series on watch hub

Scenario: Verify back button option on Eurosport Original carousel series
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  And I click on one of the EUROSPORT ORIGINALS series on watch hub
  Then I should see back button on selected EUROSPORT ORIGINALS series

Scenario: Verify latest filter on Eurosport Original carousel series
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  And I click on one of the EUROSPORT ORIGINALS series on watch hub
  Then I verify "LATEST" filter on series videos

Scenario: Verify Most Popular filter on Eurosport Original carousel series
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  And I click on one of the EUROSPORT ORIGINALS series on watch hub
  Then I verify "MOST POPULAR" filter on series videos

Scenario: Verify series details on Eur. Original Series on Home Tab
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I see "EUROSPORT ORIGINALS" carousel on Home tab on watch screen
  And I verify series details on Eurosport Original Series on Home Tab

Scenario: Verify list of available videos in Eurosport Original series
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  And I click on one of the EUROSPORT ORIGINALS series on watch hub
  Then I see list of available videos in latest filter

Scenario: Verify video details on each video in Eurosport Original Series
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I click on one of the EUROSPORT ORIGINALS series on watch hub
  And I verify video details on each video in latest filter

Scenario: Scroll WHAT'S ON carousel video tiles left and right in Home Tab
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I scroll what's on carousel videos left and right

Scenario: Scroll MOST POPULAR carousel video tiles left and right in Home Tab
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I scroll most popular carousel videos left and right

Scenario: Scroll LATEST PREMIUM carousel video tiles left and right in Home Tab
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I scroll latest premium carousel videos left and right

Scenario: Verify metadata on each video tile in WHAT'S ON in Home Tab
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I see metadata on each video tile in WHAT'S ON in Home Tab

Scenario: Verify metadata on each video tile in MOST POPULAR in Home Tab
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I see metadata on each video tile in MOST POPULAR in Home Tab

Scenario: Verify metadata on each video tile in LATEST PREMIUM in Home Tab
  Given I'm on the home screen
  When I click "WATCH" tab on home screen
  And I click "HOME" tab on watch screen
  Then I see metadata on each video tile in LATEST PREMIUM in Home Tab
