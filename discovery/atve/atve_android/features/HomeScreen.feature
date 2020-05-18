Feature: Home Screen 	

  Scenario: HomeHero Show Content
    Given I login as anonymous user
    When I am on home screen
    And I see home hero
    Then I should see the series name and description

  Scenario: Play hero episode
    Given I login as anonymous user
    When I am on home screen
    And I start home hero series
    Then I should see blank screen

  Scenario: Shows Carousel
    Given I login as anonymous user
    When I am on home screen
    Then I see "Shows" carousel on homepage
 
  Scenario: Just Added Carousel
    Given I login as anonymous user
    When I am on home screen
    Then I see "Just Added" carousel on homepage

  Scenario: Most Popular shows Carousel
    Given I login as anonymous user
    When I am on home screen
    Then I see "Most Popular Shows" carousel on homepage

  Scenario: Continue Watching Carousel
    Given I login as anonymous user
    When I am on home screen
    Then I see "Continue Watching" carousel on homepage

  Scenario: Most popular Episodes this month shows Carousel
    Given I login as anonymous user
    When I am on home screen
    Then I see "Most popular Episodes this month" carousel on homepage

  Scenario: Home Screen - Just Added Rail
    Given I login as anonymous user
    When I am on home screen
    When I see "Just Added Shows" carousel on homepage
    Then I see Just Added Shows rail with tiles
  
  Scenario: Home Screen - Just Added Rail- Horizontal scroll
    Given I login as anonymous user
    When I am on home screen
    When I see "Just Added Shows" carousel on homepage
    And I scroll horizontally "left" for "Just Added Shows" rail tiles and verify
    Then I scroll horizontally "right" for "Just Added Shows" rail tiles and verify
