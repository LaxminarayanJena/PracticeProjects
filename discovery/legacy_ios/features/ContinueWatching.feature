Feature: Continue Watching

  as a user
  I want to be able to continue watching a show from the home screen & hamburger menu

  Scenario: Watch unfinished unlocked videos from home screen
    Given there are no unfinished videos on landing screen
    When I watch an unlocked show for sometime
    Then the show should be on continue watching list on landing screen
    And I should be able to resume watching the video from continue watching carousel card

  Scenario: Watch unfinished unlocked videos from hamburger menu
    Given there are no unfinished videos in continue watching screen
    When I watch an unlocked show for sometime
    Then the show should be on continue watching screen
    And I should be able to resume watching the video from continue watching screen
