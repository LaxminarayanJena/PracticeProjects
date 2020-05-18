Feature:Login

  Scenario: Auth - Affiliate login
    Given I log in with a valid provider
    Then User has to be logged in

  @wip
  Scenario: Auth - Returning user
    Given I log in with a valid provider
    And User has to be logged in
    When I restart the application
    Then The returning user should be on the homescreen

  @wip
  Scenario: Anon - Sign in from locked video should return you to video screen
    Given I'm on the home screen
    When I play a locked episode
    And I log in with common login steps
    Then I should see the video playing

  Scenario: Anon Auth - Login from home screen
    Given I login as anonymous user
    When I log in with a valid provider from the home screen
    Then User has to be logged in

  Scenario: AuthZ - Login
    Given I log in with an authz provider
    Then User has to be logged in

  Scenario: Anon - Navigation to home page on clicking close icon on affiliate login screen
    Given I am on affiliate login screen
    When I close the affiliate picker
    Then The returning user should be on the homescreen

  Scenario: Anon- Close affiliate picker screen
    Given I login as anonymous user
    When I click on sign in button on Home Page
    And I close the affiliate picker
    Then The returning user should be on the homescreen

  Scenario: Anon- Verify all provider list on affiliate picker screen
    Given I login as anonymous user
    When I click on sign in button on Home Page
    And I am on affiliate picker screen
    Then I see all providers list including mvpd
	

