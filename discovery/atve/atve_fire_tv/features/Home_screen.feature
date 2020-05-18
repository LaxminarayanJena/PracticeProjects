Feature: Home Screen

 Scenario: HomeHero show content
   Given I'm on the landing screen
   Then I should see the details of hero content

 Scenario: Hero Carousel - Auto Rotation functionality
   Given I'm on the landing screen
   Then I see Hero Carousel auto-rotating

 Scenario: Most Popular Shows-rail
   Given I'm on the landing screen
   Then I see 'Most Popular Shows' carousel on homepage
 
 Scenario: Just Added-rail
   Given I'm on the landing screen
   Then I see 'Just Added Shows' carousel on homepage

 Scenario: Most popular Episodes this month-rail
   Given I'm on the landing screen
   Then I see 'Most popular Episodes this month' carousel on homepage
  
 Scenario: Most Popular Shows rail-forward scroll
   Given I'm on the landing screen
   When I see 'Most Popular Shows' carousel on homepage
   Then I do 'forward' scroll on 'Most Popular Shows' and verify functionality
 
Scenario: Most Popular Shows rail-backword scroll
   Given I'm on the landing screen
   When I see 'Most Popular Shows' carousel on homepage
   Then I do 'backword' scroll on 'Most Popular Shows' and verify functionality

Scenario: Just Added Shows rail-forward scroll
   Given I'm on the landing screen
   When I see 'Just Added Shows' carousel on homepage
   Then I do 'forward' scroll on 'Just Added Shows' and verify functionality

Scenario: Just Added Shows rail-backword scroll
   Given I'm on the landing screen
   When I see 'Just Added Shows' carousel on homepage
   Then I do 'backword' scroll on 'Just Added Shows' and verify functionality

Scenario: Most popular Episodes this month-forward scroll
   Given I'm on the landing screen
   When I see 'Most popular Episodes this month' carousel on homepage
   Then I do 'forward' scroll on 'Most popular Episodes this month' and verify functionality

Scenario: Most popular Episodes this month-backword scroll
   Given I'm on the landing screen
   When I see 'Most popular Episodes this month' carousel on homepage
   Then I do 'backword' scroll on 'Most popular Episodes this month' and verify functionality
