Feature: Home Screen

  Scenario: Anon - Featured Show
    Given I navigate to featured option
    When I view & click on one of the featured show
    Then I verify the details in shows show's screen

  @wip # Waiting for locators - QTA-2026
  Scenario: Anon - On Last Night Carousel
    Given I'm on the home screen
    When I view & click on last night carousel
    Then I see visit url & activate code

  Scenario: Anon - Watch Live TV
    Given I'm on the home screen
    When I view & click the watch live
    Then I see visit url & activate code

  Scenario: Anon - Popular Show
    Given I'm on the home screen
    When I view & click the popular show
    Then I verify the details in shows show's screen

  Scenario: Anon - Unlocked Show
    Given I'm on the home screen
    When I view & click an unlocked show
    Then I should see the video playing

  Scenario: Anon - Discovery go lists
    Given I'm on the home screen
    When I view & click the show from discovery go lists
    Then I should see show season episode

  Scenario: Anon - Watch - Popular Show
    Given I'm on the home screen
    When I view & click the popular show
    Then I verify the details in shows show's screen

  Scenario: Anon - Watch - Discovery go lists Show
    Given I'm on the home screen
    When I view & click the show from discovery go lists
    And I see and click on any show episode
    Then I should see the video playing

  Scenario: Auth - On Last Night Carousel
    Given I login with valid provider
    When I'm on the home screen
    And I scroll down till the show
    And I view & click on last night carousel
    Then I should see the video playing

  Scenario: Auth - Watch Live TV
    Given I login with valid provider
    When I'm on the home screen
    And I scroll down till the show
    And I view & click the watch live tv program
    Then I should watch live tv

  Scenario: Anon - Featured carousel forward scroll
    Given I'm on the home screen
    Then I do forward scroll in 'Featured carousel' and verify functionality

  Scenario: Anon - On Last Night carousel forward scroll
    Given I'm on the home screen
    Then I do forward scroll in 'ON LAST NIGHT' and verify functionality

  Scenario: Anon - Unlocked Episodes carousel forward scroll
    Given I'm on the home screen
    Then I do forward scroll in 'Unlocked Episodes' and verify functionality

  Scenario: Anon - Discovery Go list carousel forward scroll
    Given I'm on the home screen
    Then I do forward scroll in 'Discovery GO Lists' and verify functionality

  Scenario: Anon - Featured carousel backward scroll
    Given I'm on the home screen
    Then I do backward scroll in 'Featured carousel' and verify functionality

  Scenario: Anon - On Last Night carousel backward scroll
    Given I'm on the home screen
    Then I do backward scroll in 'ON LAST NIGHT' and verify functionality

  Scenario: Anon - Unlocked Episodes carousel backward scroll
    Given I'm on the home screen
    Then I do backward scroll in 'Unlocked Episodes' and verify functionality

  Scenario: Anon - Discovery Go list carousel backward scroll
    Given I'm on the home screen
    Then I do backward scroll in 'Discovery GO Lists' and verify functionality

  Scenario: Anon - On Last Night Carousel Scrubber
    Given I'm on the home screen
    Then I view the "on last night carousel" scrubber

  Scenario: Anon - Unlocked Episodes Scrubber
    Given I'm on the home screen
    Then I view the "unlocked episodes" scrubber

  Scenario: Anon - Discovery go lists Scrubber
    Given I'm on the home screen
    Then I view the "discovery go lists" scrubber

  Scenario: Anon - Hero carousel functionality
    Given I navigate to featured option
    Then I see Hero carousel rotating automatically

  Scenario: Anon - verify title and show discription
    Given I navigate to featured option
    When I focus on Hero Carousel
    Then I see title and discription of the show

  Scenario: Anon - verify the shows details of hero content
    Given I navigate to featured option
    When I focus on Hero Carousel
    And I click on hero content
    Then I verify the details in shows show's screen
