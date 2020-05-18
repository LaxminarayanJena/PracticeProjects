Feature:
  As a user ( Authorized or anonymous )
  I am able to Browse the videos based on genre

  Scenario: Browse - Card Metadata
    Given I am on Browse screen as an authorized user
    When  I scroll through the genre
    And I select any genre
    Then I see card thumbnail & show name below the thumbnail

  Scenario: Browse - Scroll through card
    Given I am on Browse screen as an authorized user
    And I select any genre
    Then I see user is able to access all cards by scrolling horizontally & vertically
