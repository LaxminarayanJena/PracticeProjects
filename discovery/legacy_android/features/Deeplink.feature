Feature: Deeplink

Scenario: To validate show screen
	Given I am on the show with one season screen
	When I see the app launches and navigates to Show screen

Scenario: To validate play Unlocked content for anon user
	Given I'm on the landing screen
	When I enter the deep link URL of any free content
	Then I should see the video playing

Scenario: To validate play locked content for anon user
	Given I'm on the landing screen
	When I enter the deep link URL of any locked content
	And I should not be able to play locked episode without login
	Then I should be able to play the locked episode after logging in

Scenario: To validate play live content for anon user
	Given I'm on the landing screen
	When I enter the deep link URL of any live content
	And I should not be able to play locked episode without login
	Then I should be able to play the live video after logging in

Scenario: To validate play episode for auth user
	Given I log in with a valid provider
    When User has to be logged in
	And I enter the deep link URL of any locked content
	Then I should see the video playing

Scenario: To validate play live content for auth user
	Given I log in with a valid provider
    When User has to be logged in
	And I enter the deep link URL of any live content
	Then I should see live video playing

Scenario: AuthZ provider test for red key content
	Given I log in with an authz provider
	When User has to be logged in for authz user
	And I enter the deep link URL of any red key content
	Then I see the video screen with a proper error message

Scenario: Play Live content for authZ user
	Given I log in with an authz provider
	When User has to be logged in for authz user
	Then I enter the deep link URL of any live content
	
