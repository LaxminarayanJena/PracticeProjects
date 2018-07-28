Feature: CV_NB
  In order to validate CV_NB
  as a user
  I navigate http://q01apprpds0298:8080

  Scenario: Successful Login with Valid Credentials
    Given User is on Home Page
    When User enters email and password
    And User clicks on signin
    Then the page title should be "Underwriting - Liferay"

  Scenario: New Account Creation
    When User clicks on New Account
    And User enters account name
    And User enters line1
    And User enters city
    And User select state
    And User enters zipcode
    And User select target Product
    And User clicks on save account
    And user clicks on Validate and standardize account address
    Then user should be able to see "Account saved successfully" message Sucessfully

  Scenario: New Contact Creation
    When User clicks on Contact
    And User clicks on Create new contact
    And User enters first name
    And User enters last name
    And User enters address line1
    And User enters contactcity
    And User select contactstate
    And User enters contactzipcode
    And User enters phone number
    And User save contact
    And user clicks on Validate and standardize contact address
    Then user should be able to see "Use account "82856047" to create new policy " message Sucessfully
    And user clicks on "Use account "82856047" to create new policy " message
    And user checks customer Service, Endorsement,Loss Control, Policy
    And user clicks on Done
    Then New window will appear for filling policy details
    And user select state of registration
    And user clicks on OK
    Then user should be able to see policy info page with status as "EMPTYQUOTE"

  Scenario: New Policy Info creation
    When User enters phone number in policy info creation page
    And User clicks on policy question tab
    And User checks Signed Application Reviewed
    And User checks Signed UM/UIM Forms Reviewed
    And User clicks on save
    Then user should be able to see policy info creation page with status as "PENDINGQUOTE"

  Scenario: New Driver creation
    When User clicks on policy info
    And User clicks on drivers from dropdown
    And User clicks on Add Driver
    And user enters firstName
    And user enters  License Number
    And user enters lastName
    And user enters  Daily Driving Vehicle
    And user enters Date of Birth
    And user checks collector car option
    And user selects year licensed
    And user selects losses
    And user selects no of points
    And user clicks on save button
    Then driver details get added

  Scenario: New Garage  creation
    When User clicks on Garages
    And User clicks on New garages
    And User clicks on Copy Primary address
    And user clicks on save in garage info
    Then garage details get added

  Scenario Outline: New Vehicle  creation
    When User clicks on Vehicles
    And User selects vehicle year
    And User selects vehicle make
    And User selects vehicle model
    And User enters agreed value
    And user selects vehicle type
    And user selects modification type
    And user selects modification type
    And user selects Garaging Location
    And user enters "<VIN>"
    And user selects Primary Use
    And user checks on photo Reviewed
    And user clicks on vehicle question tab
    And user clicks on vehicle registered combobox
    And user clicks on save in vehicle page
    Then vehicle details get added

    Examples: 
      | VIN          |
      | 1G4YC82GX25125254  |
      | 6F06C291240|
      | 98A212396  |

  Scenario: Rate the Policy
    When User clicks on rate
    Then Status changed to 'RATED'

  Scenario: Quote Policy
    When User clicks on quote
    And User click on generate documents
    Then Status changed to 'QUOTED'

  Scenario: Bind Policy
    When User clicks on Billing Info
    And User clicks on edit
    And User selects billing contact
    And user clicks on save in billing info
    And User clicks on bind
    And User clicks on override
    Then Status changed to 'BOUND'

  Scenario: Issue Policy
    When User clicks on issue
    And clicks on generate documents only
    Then Status changed to 'ISSUED'

  Scenario: Log Out
    When User clicks on Logout
    Then User is navigated to login page
    
   
