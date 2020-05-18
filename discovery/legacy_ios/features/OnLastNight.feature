Feature: On Last Night

  as a user
  I want to be able to see all Last Night Shows 

 Scenario: Check show last night description
    Given I'm on the landing screen
    Then I see on last night header description

 Scenario: Check last night show home info
    Given I'm on the landing screen
    Then I check shows home info option

 Scenario: Watch last night video
 	Given I log in with a valid provider
    When I see and click "Home" on hamburger menu
    Then I view a on last night show video

