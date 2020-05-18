Feature: Browse

  As a user I should be able to browse for a show, seasons and play episodes

  Scenario: Anon - Browse - Show Season Episode
    Given I navigate to browse screen
    When I select the show from browse screen
    And I click on season and select an episode
    Then I see visit url & activate code

  Scenario: Anon-Browse genre carousel Forward scroll horizantally
    Given I navigate to browse screen
    When I do 'forward scroll' on genres
    Then I verify 'forward' carousel functionality

  Scenario: Anon-Browse genre carousel Backward scroll horizantally
    Given I navigate to browse screen
    When I do 'backward scroll' on genres
    Then I verify 'backward' carousel functionality 

  Scenario: Anon-Browse shows carousel Forward scroll horizantally
    Given I navigate to browse screen
    When I do 'forward scroll' on shows
    Then I verify 'forward' carousel functionality 

  Scenario: Anon-Browse shows carousel Backward scroll horizantally
    Given I navigate to browse screen
    When I do 'backward scroll' on shows
    Then I verify 'backward' carousel functionality
  
  Scenario: Anon - Browse Navigation upon Remote back button click in genre card
    Given I navigate to browse screen
    When I select the show from browse screen and click on Remote back button
    Then I see Browse tab