Feature: Shows

  as a user
  I want to be able check show info, sign in and play episodes,
  see episode level info and change to a different season

  Scenario: Check show info
    Given I am on a show screen
    When I check the show info
    Then I should see information about the show

  Scenario: Anon-Play video
  	Given I select the show
  	When I click on play button 
  	Then I should see video playing

  Scenario: Check for continue and start over option for scrubed videos
    Given I select show and scrub forward 
    When I search and play the same show 
    Then I should see continue and start over options 

  Scenario: Anon-Play video without deeplink
    Given I am on shows screen
    When I click on season and select an episode
    Then I see visit url & activate code

  Scenario: Anon-Shows carousel Forward scroll horizantally
    Given I am on shows screen
    When I do 'forward scroll' on seasons
    Then I verify 'forward' carousel functionality

  Scenario: Anon-Shows carousel Backward scroll horizantally
    Given I am on shows screen
    When I do 'backward scroll' on seasons
    Then I verify 'backward' carousel functionality

  Scenario: Anon-Shows seasonslist carousel forward scroll horizantally
    Given I select the show with seasons and episode
    Then I verify 'forward scroll' on seasonslist carousel functionality

  Scenario: Anon-Shows seasonslist carousel backward scroll horizantally
    Given I select the show with seasons and episode
    Then I verify 'backward scroll' on seasonslist carousel functionality

   Scenario: Anon-Shows episodelist carousel forward scroll horizantally
    Given I select the show with seasons and episode
    Then I verify 'forward scroll' on episodelist carousel functionality

  Scenario: Anon-Shows episodelist carousel backward scroll horizantally
    Given I select the show with seasons and episode
    Then I verify 'backward scroll' on episodelist carousel functionality

  Scenario:Anon-check player controls are active on player screen when video paused
    Given I select show and play video
    When I click on pause button
    Then I see playback is paused and player controls are active on video screen

