Feature:Watch Live TV

 Scenario: Anon - Watch Live TV
    Given I navigate to live screen
    When I click on the key icon
    Then I should see an activation screen

 Scenario: Auth - Watch Live TV
    Given I login with valid provider
    When I navigate to live screen
    And I click on live tv play button
    Then I should watch live tv

 Scenario: Anon Auth - Watch Live TV
    Given I navigate to live screen
    When I click on the key icon
    And I get and verify the activation code
    And I log in with valid provider for activate
    Then I should watch live tv
    
  Scenario: Anon - Watch Live TV
    Given I navigate to live screen
    Then I should see UpNext episode information

  Scenario: Auth - Watch Live TV player controls
    Given I login with valid provider
    When I click on live content from Live tab
    Then I see player controls and content metadata 

  Scenario: Auth - Watch Live TV player controls
    Given I login with valid provider
    When I click on live content from Live tab
    And I click on Remote Back button and play the same content again 
    Then I should watch live tv
    

 Scenario: Auth - Watch Live TV show details
    Given I login with valid provider
    When I navigate to live screen
    Then I should see the show details

 Scenario: Auth - confirmation message on app exit
    Given I login with valid provider
    When I navigate to live screen
    Then I should see confirmation message on app exit

 Scenario: Auth - cancel functionality on app exit
    Given I login with valid provider
    When I navigate to live screen
    And I click cancel option from exit app message
    Then I should land on Live tv tab
