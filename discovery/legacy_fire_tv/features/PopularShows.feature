Feature: Popular Shows

  As a user
  I should verify the caurosal functionality of popular shows in landing and search 

  Scenario: Anon - check popular Show caurosal functionality- right in landing page
    Given I navigate to featured option
    When I view & click the popular show
    And I check the title of the popular show
    And I move the caurosal right
    Then I verfy the title of the show

  Scenario: Anon - check popular Show left caurosal functionality-left in landing page
    Given I navigate to featured option
    When I view & click the popular show
    And I check the title of the popular show
    Then I verfy the title of the show

  Scenario: Anon - Check the popular-shows shows screen details
    Given I navigate to featured option
    When I view & click the popular show
    Then I check for the title info watch later and favourate button
    
  Scenario: Anon - check popular Show caurosal functionality-right in search page
    Given I navigate to search option
    When I view and click the popular show in search screen
    And I check the title of the popular show in search screen
    And I move the caurosal right
    Then I verfy the title of the show

  Scenario: Anon - check popular Show caurosal functionality-left in search page
    Given I navigate to search option
    When I view and click the popular show in search screen
    And I check the title of the popular show in search screen
    And I move the caurosal left
    Then I verfy the title of the show
