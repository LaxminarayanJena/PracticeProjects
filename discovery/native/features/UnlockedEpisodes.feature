Feature: Unlocked Episodes

  Scenario: Unauthenticated User can watch unlocked episodes
  	Given I login as anonymous user
  	When I view an unlocked episode
  	Then I should see the video playing

  Scenario: Unauthenticated User can scroll through unlocked episodes
  	Given I login as anonymous user
  	Then I scroll unlocked episodes right and left
  
  Scenario: Anon - Unlocked episode list - Scroll & play
	Given I login as anonymous user
	When I scroll unlocked episodes right and left
	And I tap on any unlocked episode
	Then I see video playing in portrait mode
