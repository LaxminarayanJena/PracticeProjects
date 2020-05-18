Feature: Euro Black Android compare UI data with graphql api data - Watch Screen

  Background:
    Given I'm on the home screen
    When I click "WATCH" tab on home screen

  Scenario: Compare Eurosport Original carousel series with graphql api
    And I click on one of the EUROSPORT ORIGINALS series on watch hub
    Then I scroll "VERTICAL" and compare video titles on "EUROSPORT ORIGINALS" on "HOME" tab carousel with graphql API

  Scenario: Compare Most Popular videos carousel series on Home tab on Watch Screen with graphql api
    And I see "MOST POPULAR" carousel on Home tab on watch screen
    Then I scroll "HORIZONTAL" and compare video titles on "MOST POPULAR" on "LATEST VIDEOS" tab carousel with graphql API

  Scenario: Compare Latest Premium carousel series with graphql api
    And I see "LATEST PREMIUM" carousel on Home tab on watch screen
    Then I scroll "HORIZONTAL" and compare video titles on "LATEST PREMIUM" on "HOME" tab carousel with graphql API

  Scenario: Compare Latest carousel series with graphql api
    And I see "LATEST" carousel on Home tab on watch screen
    Then I scroll "HORIZONTAL" and compare video titles on "LATEST" on "HOME" tab carousel with graphql API

  Scenario: Compare Tennis carousel series with graphql api
    And I see "TENNIS" carousel on Home tab on watch screen
    Then I scroll "HORIZONTAL" and compare video titles on "TENNIS" on "HOME" tab carousel with graphql API

  Scenario: Compare Cycling carousel series with graphql api
    And I see "CYCLING" carousel on Home tab on watch screen
    Then I scroll "HORIZONTAL" and compare video titles on "CYCLING" on "HOME" tab carousel with graphql API

  Scenario: Compare Football carousel series with graphql api
    And I see "FOOTBALL" carousel on Home tab on watch screen
    Then I scroll "HORIZONTAL" and compare video titles on "FOOTBALL" on "HOME" tab carousel with graphql API

  Scenario: Compare Most Popular videos title on Latest News tab on Watch Screen with graphql api
    And I click "LATEST VIDEOS" tab on watch screen
    And I see "MOST POPULAR" carousel on latest videos tab on watch screen
    Then I scroll "HORIZONTAL" and compare video titles on "MOST POPULAR" on "LATEST VIDEOS" tab carousel with graphql API
