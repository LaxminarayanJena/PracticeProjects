Feature: Ad Player

Scenario: Ad Player UI 
  Given I view an unlocked episode
  When I play video till advert
  Then I see "volume button" on player
  And I see "CC button" on player
  Then I see "Play button" on player
  And I see "Seek bar" on player
  Then I see "Start time" on player
  And I see "End time" on player
  Then I see "Ad countdown" on ad player
  And I see "Ad countdown" on ad player

Scenario: Functionality of Learn More link
  Given I view an unlocked episode
  When I play video till advert
  Then I click on learn more to see web view