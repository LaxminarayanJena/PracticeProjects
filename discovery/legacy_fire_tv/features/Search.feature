Feature: Search

  As a user I should be able to search for a show

  Scenario: Search a show
    Given I search a show
    And I select the show's card
    Then I should be on the show's show screen
    
  Scenario: Search a show with invalid show's card
    Given I search show with a invalid show
    Then I should be displayed with no results found message

  Scenario: Anon- verify activation message for unauthorized users
    Given I search for a locked show
    When I select the show's card
    And I verify the details in shows show's screen
    And I click on the lock or play btn 
    Then I should see the activation mesasge

  Scenario: Auth- verify activation message for unauthorized users
    Given I login with valid provider
    When I search for a locked show
    And I select the show's card
    And I verify the details in shows show's screen
    And I click on the lock or play btn 
    Then I should see the video playing

  Scenario: Anon- verify the search result
    Given I search for a string
    Then I verify the search result

  Scenario: Anon- verify search result on clicking back button from shows details
    Given I search for a string
    When I select a show from result searched
    And I click on back button
    Then I verify the actual and expected search count

  Scenario: Anon- search result refresh
    Given I search for a string
    When I verify searched result
    And I navigate to my videos
    Then I should see search screen is refreshed

  Scenario: Auth - confirmation message on app exit
    Given I login with valid provider
    When I navigate to search screen
    Then I should see confirmation message on app exit

 Scenario: Auth - cancel functionality on app exit
    Given I login with valid provider
    When I navigate to search screen
    And I click cancel option from exit app message
    Then I should land on search tab
