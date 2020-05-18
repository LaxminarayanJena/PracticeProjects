Feature: Home Screen

  Scenario: HomeHero show content
	Given I am on the home screen
	When I see the home hero
	Then I should see the series name and description

  Scenario: Anon - Validate network logo on home page
	Given I am on the home screen
	Then I see network logo on the top left

  Scenario: Play hero episode
	Given I am on the home screen
	When I start the home hero series
	Then I should see blank screen

  Scenario: Hero Carousel - Auto Rotate
	Given I am on the home screen
	When I see the focus is on Hero Carousel
	Then I see Hero Carousel auto-rotating

  Scenario: Hero Carousel - Focus on Hero
    Given I am on the home screen
	When I see the focus is on Hero Carousel
	And I go away from Hero carousel and refocus
	Then I see Hero Carousel stops rotating

  Scenario: Anon - Most Popular Shows carousel right scroll
	Given I am on the home screen
	When I see and navigate to 'Most Popular Shows' rail
	Then I do 'right' scroll in 'Most Popular Shows' and verify functionality

  Scenario: Anon - Most Popular Shows carousel left scroll
	Given I am on the home screen
	When I see and navigate to 'Most Popular Shows' rail
	Then I do 'left' scroll in 'Most Popular Shows' and verify functionality

  Scenario: Anon - Just Added carousel right scroll
	Given I am on the home screen
	When I see and navigate to 'Just Added Shows' rail
	Then I do 'right' scroll in 'Just Added Shows' and verify functionality

  Scenario: Anon - Just Added carousel left scroll
	Given I am on the home screen
	When I see and navigate to 'Just Added Shows' rail
	Then I do 'left' scroll in 'Just Added Shows' and verify functionality

  Scenario: Anon - Validate Most Popular Shows MetaData 
    Given I am on the home screen
    When I see and navigate to 'Most Popular Shows' rail
    Then I see Metadata on the 'Most Popular Shows' tile containing thumbnail image, title, network logo  

  Scenario: Anon - Validate Just Added Shows Metadata
    Given I am on the home screen
    When I see and navigate to 'Just Added Shows' rail
    Then I see Metadata on the 'Just Added Shows' tile containing thumbnail image, title, network logo 

  Scenario: Anon - Validate Most Popular Shows Playback 
    Given I am on the home screen
    When I see and navigate to 'Most Popular Shows' rail
    And I click on any tile in the 'Most Popular Shows' rail
    Then the video plays correctly

  Scenario: Anon - Validate Just Added Shows Playback
    Given I am on the home screen
    When I see and navigate to 'Just Added Shows' rail
    And I click on any tile in the 'Just Added Shows' rail
    Then the video plays correctly
