Feature: Live Tv Screen

As a user
 I should be able to watch Live,UpNext shows and metadata

  Scenario:Watch Live TV screen
   Given I am on the Menu Bar
   When I navigate to 'Live' screen
   Then I should see the live screen with Network List, On Now and Up Next section

  Scenario:Watch Live TV - network selector list
   Given I am on the Menu Bar
   When I navigate to 'Live' screen
   Then I should see the network list with different networks

  Scenario:Watch Live TV - On Now rail
   Given I am on the Menu Bar
   When I navigate to 'Live' screen
   Then I should see Live content meta data

  Scenario:Watch Live TV - UpNext not VOD 
   Given I am on the Menu Bar
   When I navigate to 'Live' screen
   Then I should see This show is not aired yet with See past episodes button for VOD content

  Scenario:Watch Live TV - On UpNext rail
   Given I am on the Menu Bar
   When I navigate to 'Live' screen
   And I see UpNext rail on Live screen
  	Then I should see Live content meta data


