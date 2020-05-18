Feature: Live TV

  Scenario: Watch Live Tv
  Given I login as anonymous user
  When I am on home screen
  And I tap on live tv icon
  Then I should see blank screen

  Scenario: Watch Live video screen metadata
  Given I login as anonymous user
  When I am on home screen
  And I tap on live tv icon
  And I should see series and episode count details
  When I should see episode name below video player
  Then I should see video discription

  Scenario: Watch Live video discription screen metadata
  Given I login as anonymous user
  When I am on home screen
  And I tap on live tv icon
  And I should Navigate to episode details
  When I should see series title
  And I should see episode name on description screen
  Then I should see video discription

  Scenario: Watch Live Next Up video content metadata 
  Given I login as anonymous user
  When I am on home screen
  And I tap on live tv icon
  And I should see next up on tlc section header
  Then I should see live content play's next with info
