Feature:Login

  Scenario: Affiliate login
    Given I log in with a valid provider
    Then User has to be logged in

  Scenario: Checking Forgot password
    Given I'm on the landing screen
    When I click on sign in
    Then I check if Forgot password is present
  	
  Scenario: Checking Don't see provider
    Given I'm on the landing screen
    When I click on sign in
    And I check if Don't see provider is present
    And I click on Don't see provider 
    Then I see Don't see provider page

  Scenario: Checking FAQ
    Given I'm on the landing screen
    When I click on sign in
    And I check if FAQ is present
    And I click on FAQ
    Then I see FAQ page

 Scenario: Search Reset
    Given I'm on the landing screen
    When I click on sign in
    And I search for "xyz" on affiliate screen
    Then I go back to previous screen from affiliate screen
    When I click on sign in
    Then I see affiliate picker search text field is empty

  Scenario: Anon- Verify all network provider list on affiliate picker screen
    Given I'm on the landing screen
    When I click on sign in
    And I am on affiliate screen
    Then I see all network provider affiliate logos

 Scenario: Search - No results
    Given I'm on the landing screen
    When I click on sign in
    And I search for "xxxx" on affiliate screen
    Then I see no results

 Scenario: Clear search by using close button
    Given I'm on the landing screen
    When I click on sign in
    And I search for "xyz" on affiliate screen
    And I click on close icon on search bar for search providers
    Then I see affiliate picker search text field is empty

 Scenario: Cancel search by using cancel option
    Given I'm on the landing screen
    When I click on sign in
    And I search for "xyz" on affiliate screen
    And I tap on cancel button on search bar
    Then I see all network provider affiliate logos

 Scenario: Activation unsuccessful
    Given I'm on the landing screen
    When I click on sign in
    And I enter wrong credential
    And login is unsuccessful
    And I click on back button
    Then I am on affiliate screen
