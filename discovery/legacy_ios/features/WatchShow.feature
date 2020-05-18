Feature:Watching Videos

  Background:
    Given I'm on the home screen
    When I log in with a valid provider
    And I navigate to Shows from hamburger menu
    Then I'm taken to Shows List Page

  Scenario: Watch Video
    Given I go to a show page
    When I view a video
    Then I should see the video playing