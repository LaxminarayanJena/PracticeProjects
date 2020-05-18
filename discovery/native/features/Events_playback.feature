Feature: Events Playback

Scenario:  Video scrub backward outside segment
  Given I login as anonymous user
  When I view an unlocked episode
  Then Allow content to play through first ad break and Scrub backwards
  Then Autoplay the next episode
  
Scenario:  Video scrub forward outside segment
  Given I login as anonymous user
  When I view an unlocked episode
  Then Allow content to play through first ad break and Scrub forward

Scenario:  Short Form Playback
    Given I login as anonymous user
    When I view an unlocked shortform episode
    Then Video should playing till end
    Then Autoplay the next episode

Scenario: Long Form Playback
    Given I login as anonymous user
    When I view an unlocked episode
    Then Video should playing till end
    Then Autoplay the next episode    

Scenario:  More Episode - Play up next content on Portrait
    Given I login as anonymous user
    When I view an unlocked episode
    And I scroll down to see up next video
    And I Tap on any episode
    Then I see episode playing on portrait mode

Scenario:  Video paused after clicking learn more link ad pause and play
  Given I login as anonymous user
  When I view an unlocked episode
  Then Allow content to play through first ad break and click learn more link

Scenario: Live stream in content
   Given I log in with a valid provider
   When I should be able to watch live tv
   Then I can see live tv
