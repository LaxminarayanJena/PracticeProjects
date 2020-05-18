Feature: Euro Black iOS - Watch Screen By Competition Tab

  Scenario: Verify Competition Videos Tab
    Given I'm on the eurosports landing screen
    When I click on "WATCH SCREEN"
    And I click "COMPETITION VIDEOS" tab on watch screen
    Then I should be on the "COMPETITION VIDEOS" tab

  Scenario Outline: Verify and see the list of competitions in Competition Videos
    Given I verify "<Competition_Video_Category>" in Competition videos
    Then I see list of competitions in competition videos category dropdown
    Examples:
    | Competition_Video_Category  |
    | Football                    |
    | Cycling                     |
    | Snooker                     |
    | OlympicGames                |
    | Tennis                      |

  Scenario Outline: Verify and see one of the sport from the list of competitions
    Given I verify "<Competition_Video_Category>" in Competition videos
    When I see list of competitions in competition videos category dropdown
    And I click on "<One_Of_The_Sport>" from by competition category
    Then I should be on "<One_Of_The_Sport>" selected sport from by competition category
    Examples:
    | Competition_Video_Category  | One_Of_The_Sport    |
    | Tennis                      | AUSTRALIAN OPEN     |
    | Cycling                     | WORLD CHAMPIONSHIPS |
    | Snooker                     | UK CHAMPIONSHIPS    |
    | Football                    | TRANSFERS           |
    | OlympicGames                | TOKYO 2020          |

