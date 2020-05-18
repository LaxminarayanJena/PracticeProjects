Feature:Watch Later
  As a user I'm able to add/remove shows from watch later

  Scenario: Anon - Watch later shows can be added
    Given I add a show to my watch later list
    Then I should see a show in the watch list
    And I remove a show from watch later

  Scenario: Anon - Watch later shows can be removed
    Given I add a show to my watch later list
    When I remove a show from watch later
    Then I should see no shows in the watch list

  Scenario: Anon - Add/Remove - watch later - verify success/removal message
    Given I go to a show page
    When I add a show to watch later
    Then I should see success/removal message on watch later
