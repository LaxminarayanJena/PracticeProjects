Feature: Welcome Screen

  As a user

  I should be able to navigate to splash , welcome and home screen

  Scenario: Anon - Welcome screen - Click on 'May be later' button
    Given I am on splash screen
    When I navigate to welcome page
    And I see a Welcome screen with message 'Link your TV provider to unlock thousands of episodes from network discovery'
    And I see 'Link TV Provider'' and 'May be later' buttons
    And I click on 'Maybe Later' button
    Then I should be navigated to home screen

  Scenario: Network branded splash screen (TLC) - first time I installed the app
    Given I am on splash screen after installation of app first time
    Then I navigate to welcome page

  Scenario: Network branded splash screen (TLC) _ App is already installed
    Given I am on splash screen after freshly launch the app
    Then I should be navigated to home screen
