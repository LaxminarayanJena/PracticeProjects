Feature: Home Screen 

  Scenario: Anon - HomeHero Show Content
    Given I am on home screen
    When I see home hero
    Then I should see the series name and description

  Scenario: Anon - Play hero episode
    Given I am on home screen
    When I start home hero series
    Then I should see blank screen

  Scenario: Anon - Most Popular shows Carousel
    Given I am on home screen
    Then I see 'Most Popular Shows' carousel on homepage

  Scenario: Anon - Shows Carousel
    Given I am on home screen
    Then I see 'Shows' carousel on homepage

  Scenario: Anon - Home hero auto advance check
    Given I am on home screen
    When I see home hero
    Then I see home hero carousel is updating periodically

  Scenario: Anon - Home hero auto advance check after performing action
    Given I am on home screen
    When I see home hero
    Then I scroll down and up and see home hero carousel not automatically updating

  Scenario: Anon - Home hero verify CTA based on the content type in the Hero Carousel
    Given I am on home screen
    When I see home hero
    Then I click on Home hero and verify CTA based on the content type

  Scenario: Anon - Global Header - Network logo
    Given I am on home screen
    Then I open all the navigation screens and check network logo is present in it

  Scenario: Anon - Global Header - Network logo click from Home screen
    Given I am on home screen
    When I click on tlc logo
    Then Validate i am on 'Home' screen

  Scenario: Anon - Global Header - Network logo click from Shows screen
    Given I go to 'Shows' screen
    When I click on tlc logo
    Then Validate i am on 'Home' screen

  Scenario: Anon - Global Header - Network logo click from Live screen
    Given I go to 'Live' screen
    When I click on tlc logo
    Then Validate i am on 'Home' screen

  Scenario: Anon - Global Header - Network logo click from Search screen
    Given I go to 'Search' screen
    When I click on tlc logo
    Then Validate i am on 'Home' screen

  Scenario: Anon - Global Header - Network logo click from Settings screen
    Given I go to 'Settings' screen
    When I click on tlc logo
    Then Validate i am on 'Home' screen

  Scenario: Validate Just Added Shows Rail
    Given I am on home screen
    Then I see "Just Added Shows" carousel on homepage
    Then I see Metadata on the "Just Added Shows" tile containing thumbnail image, title

  Scenario: Validate ShowRail MetaData 
    Given I am on home screen
    Then I see "Shows" carousel on homepage
    Then I see Metadata on the "Shows" tile containing thumbnail image, title

  Scenario: Validate MostPopularShows MetaData 
    Given I am on home screen
    Then I see "Most Popular Shows" carousel on homepage
    Then I see Metadata on the "Most Popular Shows" tile containing thumbnail image, title

  Scenario: Horizontal forward scroll in Just Added Shows carousel in Home screen
    Given I am on home screen
    Then I see 'Just Added Shows' carousel on homepage
    Then I scroll forward horizontally in 'Just Added Shows' carousel and verify it

  Scenario: Horizontal forward scroll in Shows carousel in Home screen
    Given I am on home screen
    When I see 'Shows' carousel on homepage
    Then I scroll forward horizontally in 'Shows' carousel and verify it

  Scenario: Horizontal forward scroll in Most Popular Shows carousel in Home screen
    Given I am on home screen
    When I see 'Most Popular Shows' carousel on homepage
    Then I scroll forward horizontally in 'Most Popular Shows' carousel and verify it

  Scenario: Horizontal backward scroll in Most Popular Shows carousel in Home screen
    Given I am on home screen
    When I see 'Most Popular Shows' carousel on homepage
    Then I scroll backward horizontally in 'Most Popular Shows' carousel and verify it

  Scenario: Horizontal backward scroll in Just Added Shows carousel in Home screen
    Given I am on home screen
    When I see 'Just Added Shows' carousel on homepage
    Then I scroll backward horizontally in 'Just Added Shows' carousel and verify it

  Scenario: Horizontal backward scroll in Shows carousel in Home screen
    Given I am on home screen
    When I see 'Shows' carousel on homepage
    Then I scroll backward horizontally in 'Shows' carousel and verify it

