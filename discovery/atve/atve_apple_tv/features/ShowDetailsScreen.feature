Feature: Show Details Screen

  Scenario: Show Details page - Hero screen & Metadata
    Given I am on a Show screen in Apple TV
    When I click on any Show
    Then I see Show details page
    And I see Network logo, 'Keep Watching' text and 'Start Series' or 'Resume' button on the Show Hero screen

  Scenario: Show Details page - Show Hero
    Given I am on a Show screen in Apple TV
    And I navigate to Show details page
    Then I see Show specific hero on top

  Scenario: Show Details page -Show Title over Hero
    Given I am on a Show screen in Apple TV
    When I click on any Show
    And I navigate to Show details page
    Then I see Show Title over the Show Hero

  Scenario: Show Details page - Tap on Back button
    Given I am on a Show screen in Apple TV
    When I click on any Show
    And I navigate to Show details page
    And I press on 'back' button on the remote
    Then I see previous screen
