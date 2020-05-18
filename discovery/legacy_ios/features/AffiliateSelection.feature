Feature: iOS - Affiliate Selection

  as a user
  I want to be able to check affiliate screen, check all the affiliate logos, 
  check the search functionality in affiliate screen, logging in with affiliate

  Scenario: Anon - Verify affiliate picker screen and mvpd logos navigating from hamburger menu 
  	Given I see and click on hamburger icon
  	When I see and click on sign in
  	And I see affiliate picker screen
  	Then I see mvpd logos

  Scenario: Anon - Verify affiliate picker screen and mvpd logos navigating from AppSettings screen
    Given I see and click on hamburger icon
    And I see and click 'Settings' on hamburger menu
    When I see and click on sign in
    Then I see affiliate picker screen
    And I see mvpd logos

  Scenario: Anon - Search shows with only 3 letters
    Given I see and click on hamburger icon
    And I see and click on sign in
    When I enter only 3 letters in affiliate search box and verify functionality
