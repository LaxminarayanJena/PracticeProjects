Feature:Watching Videos

  Scenario: Watch Video
    Given I log in with a valid provider
    Given I go to a show page
    When I view a video
    Then I should see the video playing