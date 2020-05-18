Feature: Unlocked Episodes

  Scenario: Anon-Unauthenticated User can watch unlocked episodes
  	When I view an unlocked episode
  	Then I should see the video playing

  Scenario: Unauthenticated User can scroll through unlocked episodes
  	Given I'm on the landing screen
  	Then I scroll unlocked episodes right and left
  
  
