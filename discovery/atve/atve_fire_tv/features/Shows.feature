Feature: Show Screen
 As a user
 I should be able to see the list of shows in shows screen

 Scenario: Anon - 'TLC - All Shows' rail  Metadata
  Given I am on the Shows screen
  When I go to 'TLC - All Shows' rail
  Then I see Metadata on the 'TLC - All Shows' tile containing thumbnail image, title

 Scenario: Anon - 'Shows' rail Metadata
  Given I am on the Shows screen
  When I go to 'Shows' rail
  Then I see Metadata on the 'Shows' tile containing thumbnail image, title

 Scenario: Anon - 'TLC - All Shows' Shows carousel right scroll
  Given I am on the Shows screen
  When I go to 'TLC - All Shows' rail
  Then I do 'right' scroll in 'TLC - All Shows' and verify functionality

 Scenario: Anon - 'TLC - All Shows' Shows carousel left scroll
  Given I am on the Shows screen
  When I go to 'TLC - All Shows' rail
  Then I do 'left' scroll in 'TLC - All Shows' and verify functionality

 Scenario: Anon - 'Shows' Shows carousel right scroll
  Given I am on the Shows screen
  When I go to 'Shows' rail
  Then I do 'right' scroll in 'Shows' and verify functionality

 Scenario: Anon - 'Shows' Shows carousel left scroll
  Given I am on the Shows screen
  When I go to 'Shows' rail
  Then I do 'left' scroll in 'Shows' and verify functionality

 Scenario: Anon - 'TLC - All shows' shows metadata
  Given I am on the Shows screen
  When I click on show title of "TLC - All Shows" shows
  Then I see the details of shows hero content

 Scenario: Anon - 'Shows' shows metadata
  Given I am on the Shows screen
  When I click on show title of "Shows" shows
  Then I see the details of shows hero content
