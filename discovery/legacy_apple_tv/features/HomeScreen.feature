Feature: Home Screen

  Scenario: Anon - Featured Show
    Given I navigate to featured option
    When I view & click on one of the featured show
    And I should see show description

  Scenario: Anon - Just Added
    Given I navigate to featured option
    When I see 'Just Added' title
    And I click on one of 'Just Added' Video
    Then I should see 'Just Added' video playing

  Scenario: Anon - Popular Shows
    Given I navigate to featured option
    When I see 'Popular Shows' title
    And I click on one of 'Popular Shows' Video
    Then I should see 'Popular Shows' video playing

  Scenario: Anon - Stream Free Episodes
    Given I navigate to featured option
    When I see 'Stream Free Episodes' title
    And I click on one of 'Stream Free Episodes' Video
    Then I should see 'Stream Free Episodes' video playing

  Scenario: Anon - Classic Series For Free
    Given I navigate to featured option
    When I see 'Classic Series for Free' title
    And I click on one of 'Classic Series for Free' Video
    Then I should see show description

  Scenario: Anon - Featured carousel forward scroll
    Given I'm on the home screen
    Then I do 'forward' scroll in 'Featured carousel' and verify functionality

  Scenario: Anon - Just Added carousel forward scroll
    Given I'm on the home screen
    Then I do 'forward' scroll in 'Just Added' and verify functionality

  Scenario: Anon - Popular Shows carousel forward scroll
    Given I'm on the home screen
    Then I do 'forward' scroll in 'Popular Shows' and verify functionality

  Scenario: Anon - Stream Free Episodes carousel forward scroll
    Given I'm on the home screen
    Then I do 'forward' scroll in 'Stream Free Episodes' and verify functionality

  Scenario: Anon - Classic Series for Free carousel forward scroll
    Given I'm on the home screen
    Then I do 'forward' scroll in 'Classic Series for Free' and verify functionality

  Scenario: Anon - Featured carousel backward scroll
    Given I'm on the home screen
    Then I do 'backward' scroll in 'Featured carousel' and verify functionality

  Scenario: Anon - Just Added carousel backward scroll
    Given I'm on the home screen
    Then I do 'backward' scroll in 'Just Added' and verify functionality

  Scenario: Anon - Popular Shows carousel backward scroll
    Given I'm on the home screen
    Then I do 'backward' scroll in 'Popular Shows' and verify functionality

  Scenario: Anon - Stream Free Episodes carousel backward scroll
    Given I'm on the home screen
    Then I do 'backward' scroll in 'Stream Free Episodes' and verify functionality

  Scenario: Anon - Classic Series for Free carousel backward scroll
    Given I'm on the home screen
    Then I do 'backward' scroll in 'Classic Series for Free' and verify functionality

  Scenario: - Hero Carousel - Auto Rotate
    Given I navigate to featured option
    When The focus is on Featured header
    Then I see Hero Carousel rotating automatically in the loop 5 sec

  Scenario: - Hero Carousel - Focus on Hero
    Given I navigate to featured option
    When The focus is on Hero Carousel
    Then I see Hero Carousel stops rotating

  Scenario: Episode list - content metadata (On Last night, Free episode, Recent episode etc) for authorised users
    Given I am on Featured screen as 'authorised' user.
    When I navigate to any Episode list Ex: 'Just Added' as 'authorised' user.
    Then I see Episode Thumbnail, Show Name, Season Number, Episode Number as a metadata for 'Just Added' list.

  Scenario: Episode list - content metadata (On Last night, Free episode, Recent episode etc) for anonymous users
    Given I am on Featured screen as 'anonymous' user.
    When I navigate to any Episode list Ex: 'Stream Free Episodes' as 'anonymous' user.
    Then I see Episode Thumbnail, Show Name, Season Number, Episode Number as a metadata for 'Stream Free Episodes' list.
