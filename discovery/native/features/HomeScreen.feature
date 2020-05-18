Feature: Home Screen

  Scenario: Auth - See recommended for you carousel
    Given I log in with a valid provider
    Then I view the "RECOMMENDED FOR YOU" carousel

  Scenario: Auth - Recent episodes carousel & info
    Given I log in with a valid provider
    When I view the "RECENT EPISODES" carousel
    And I check the episode info
    Then I should see episode details

  Scenario: Auth - Watch recent episodes
    Given I log in with a valid provider
    When I view the "RECENT EPISODES" carousel
    And I should be able to play the recent episode
    Then I should see the video playing

  Scenario: Verify unlocked episode info
    Given I login as anonymous user
    Then I should be able to view unlocked episodes info details

  Scenario: Auth - Play locked episode
    Given I log in with a valid provider
    When I play a locked episode
    Then I should see the video playing

  Scenario: Auth - Verify affiliate logo in header
    Given I log in with a valid provider
    Then I see affiliate logo on top right corner on show screen

  Scenario: Auth - Home screen - play live stream module
    Given I log in with a valid provider
    When I see live et badge on live stream module and click on epicode
    Then I see video playing in portrait mode

  Scenario: Auth - User can view series title on episode tile
    Given I log in with a valid provider
    When I view the "RECENT EPISODES" carousel
    Then I should see series title on episode tile
