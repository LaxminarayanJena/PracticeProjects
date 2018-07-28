$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CV_NB.feature");
formatter.feature({
  "line": 1,
  "name": "CV_NB",
  "description": "In order to validate CV_NB\r\nas a user\r\nI navigate http://q01apprpds0298:8080",
  "id": "cv-nb",
  "keyword": "Feature"
});
formatter.before({
  "duration": 232370600,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "id": "cv-nb;successful-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User enters email and password",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "User clicks on signin",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the page title should be \"Underwriting - Liferay\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 951295200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_email_and_password()"
});
formatter.result({
  "duration": 481401100,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_signin()"
});
formatter.result({
  "duration": 2850362600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Underwriting - Liferay",
      "offset": 26
    }
  ],
  "location": "CV_NB.the_page_title_should_be(String)"
});
formatter.result({
  "duration": 4944000,
  "status": "passed"
});
formatter.after({
  "duration": 221200,
  "status": "passed"
});
formatter.before({
  "duration": 321782900,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "New Account Creation",
  "description": "",
  "id": "cv-nb;new-account-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "User clicks on New Account",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User enters account name",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "User enters line1",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User enters city",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User select state",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "User enters zipcode",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User select target Product",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "User clicks on save account",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "user clicks on Validate and standardize account address",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "user should be able to see \"Account saved successfully\" message Sucessfully",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_New_Account()"
});
formatter.result({
  "duration": 694280500,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_account_name()"
});
formatter.result({
  "duration": 197069200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 16
    }
  ],
  "location": "CV_NB.user_enters_line(int)"
});
formatter.result({
  "duration": 152836900,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_city()"
});
formatter.result({
  "duration": 162592600,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_select_state()"
});
formatter.result({
  "duration": 259116800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_zipcode()"
});
formatter.result({
  "duration": 95318900,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_select_target_Product()"
});
formatter.result({
  "duration": 377726500,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_account()"
});
formatter.result({
  "duration": 206269400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Validate_and_standardize_account_address()"
});
formatter.result({
  "duration": 1760736200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Account saved successfully",
      "offset": 28
    }
  ],
  "location": "CV_NB.user_should_be_able_to_see_message_Sucessfully(String)"
});
formatter.result({
  "duration": 136200,
  "status": "passed"
});
formatter.after({
  "duration": 66400,
  "status": "passed"
});
formatter.before({
  "duration": 189220300,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "New Contact Creation",
  "description": "",
  "id": "cv-nb;new-contact-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "User clicks on Contact",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "User clicks on Create new contact",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User enters first name",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User enters last name",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User enters address line1",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "User enters contactcity",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "User select contactstate",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "User enters contactzipcode",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "User enters phone number",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "User save contact",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "user clicks on Validate and standardize contact address",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "user should be able to see \"Use account \"82856047\" to create new policy \" message Sucessfully",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "user clicks on \"Use account \"82856047\" to create new policy \" message",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "user checks customer Service, Endorsement,Loss Control, Policy",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "user clicks on Done",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "New window will appear for filling policy details",
  "keyword": "Then "
});
formatter.step({
  "line": 41,
  "name": "user select state of registration",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "user clicks on OK",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "user should be able to see policy info page with status as \"EMPTYQUOTE\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Contact()"
});
formatter.result({
  "duration": 11453754500,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Create_new_contact()"
});
formatter.result({
  "duration": 45800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_first_name()"
});
formatter.result({
  "duration": 1195714500,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_last_name()"
});
formatter.result({
  "duration": 146960300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 24
    }
  ],
  "location": "CV_NB.user_enters_address_line(int)"
});
formatter.result({
  "duration": 110630400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_contactcity()"
});
formatter.result({
  "duration": 116498200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_select_contactstate()"
});
formatter.result({
  "duration": 258808300,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_contactzipcode()"
});
formatter.result({
  "duration": 169503100,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_phone_number()"
});
formatter.result({
  "duration": 268300200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_save_contact()"
});
formatter.result({
  "duration": 178118400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Validate_and_standardize_contact_address()"
});
formatter.result({
  "duration": 4314759700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Use account ",
      "offset": 28
    },
    {
      "val": "82856047",
      "offset": 41
    },
    {
      "val": " to create new policy ",
      "offset": 50
    }
  ],
  "location": "CV_NB.user_should_be_able_to_see_message_Sucessfully(String,int,String)"
});
formatter.result({
  "duration": 297300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Use account ",
      "offset": 16
    },
    {
      "val": "82856047",
      "offset": 29
    },
    {
      "val": " to create new policy ",
      "offset": 38
    }
  ],
  "location": "CV_NB.user_clicks_on_message(String,int,String)"
});
formatter.result({
  "duration": 2178080700,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_checks_customer_Service_Endorsement_Loss_Control_Policy()"
});
formatter.result({
  "duration": 632509200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Done()"
});
formatter.result({
  "duration": 81884200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.new_window_will_appear_for_filling_policy_details()"
});
formatter.result({
  "duration": 25700,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_select_state_of_registration()"
});
formatter.result({
  "duration": 473316500,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_OK()"
});
formatter.result({
  "duration": 149506400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "EMPTYQUOTE",
      "offset": 60
    }
  ],
  "location": "CV_NB.user_should_be_able_to_see_policy_info_page_with_status_as(String)"
});
formatter.result({
  "duration": 224800,
  "status": "passed"
});
formatter.after({
  "duration": 56200,
  "status": "passed"
});
formatter.before({
  "duration": 165220700,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "New Policy Info creation",
  "description": "",
  "id": "cv-nb;new-policy-info-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 46,
  "name": "User enters phone number in policy info creation page",
  "keyword": "When "
});
formatter.step({
  "line": 47,
  "name": "User clicks on policy question tab",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "User checks Signed Application Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "User checks Signed UM/UIM Forms Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "User clicks on save",
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "user should be able to see policy info creation page with status as \"PENDINGQUOTE\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_enters_phone_number_in_policy_info_creation_page()"
});
formatter.result({
  "duration": 35459534400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_policy_question_tab()"
});
formatter.result({
  "duration": 93232200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_checks_Signed_Application_Reviewed()"
});
formatter.result({
  "duration": 274187700,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_checks_Signed_UM_UIM_Forms_Reviewed()"
});
formatter.result({
  "duration": 133492400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save()"
});
formatter.result({
  "duration": 2227068300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "PENDINGQUOTE",
      "offset": 69
    }
  ],
  "location": "CV_NB.user_should_be_able_to_see_policy_info_creation_page_with_status_as(String)"
});
formatter.result({
  "duration": 104700,
  "status": "passed"
});
formatter.after({
  "duration": 23800,
  "status": "passed"
});
formatter.before({
  "duration": 174208300,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "New Driver creation",
  "description": "",
  "id": "cv-nb;new-driver-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 54,
  "name": "User clicks on policy info",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "User clicks on drivers from dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "User clicks on Add Driver",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "user enters firstName",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "user enters  License Number",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "user enters lastName",
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "user enters  Daily Driving Vehicle",
  "keyword": "And "
});
formatter.step({
  "line": 61,
  "name": "user enters Date of Birth",
  "keyword": "And "
});
formatter.step({
  "line": 62,
  "name": "user checks collector car option",
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "user selects year licensed",
  "keyword": "And "
});
formatter.step({
  "line": 64,
  "name": "user selects losses",
  "keyword": "And "
});
formatter.step({
  "line": 65,
  "name": "user selects no of points",
  "keyword": "And "
});
formatter.step({
  "line": 66,
  "name": "user clicks on save button",
  "keyword": "And "
});
formatter.step({
  "line": 67,
  "name": "driver details get added",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_policy_info()"
});
formatter.result({
  "duration": 6078526600,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_drivers_from_dropdown()"
});
formatter.result({
  "duration": 32900,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Add_Driver()"
});
formatter.result({
  "duration": 425618700,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_firstName()"
});
formatter.result({
  "duration": 1154306800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_License_Number()"
});
formatter.result({
  "duration": 95547600,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_lastName()"
});
formatter.result({
  "duration": 90653400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_Daily_Driving_Vehicle()"
});
formatter.result({
  "duration": 71716300,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_Date_of_Birth()"
});
formatter.result({
  "duration": 86043400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_checks_collector_car_option()"
});
formatter.result({
  "duration": 85762600,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_year_licensed()"
});
formatter.result({
  "duration": 172834000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_losses()"
});
formatter.result({
  "duration": 274962500,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_no_of_points()"
});
formatter.result({
  "duration": 1711707500,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_button()"
});
formatter.result({
  "duration": 129224100,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.driver_details_get_added()"
});
formatter.result({
  "duration": 43200,
  "status": "passed"
});
formatter.after({
  "duration": 49000,
  "status": "passed"
});
formatter.before({
  "duration": 120571600,
  "status": "passed"
});
formatter.scenario({
  "line": 69,
  "name": "New Garage  creation",
  "description": "",
  "id": "cv-nb;new-garage--creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 70,
  "name": "User clicks on Garages",
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "User clicks on New garages",
  "keyword": "And "
});
formatter.step({
  "line": 72,
  "name": "User clicks on Copy Primary address",
  "keyword": "And "
});
formatter.step({
  "line": 73,
  "name": "user clicks on save in garage info",
  "keyword": "And "
});
formatter.step({
  "line": 74,
  "name": "garage details get added",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Garages()"
});
formatter.result({
  "duration": 2519873000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_New_garages()"
});
formatter.result({
  "duration": 123678200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Copy_Primary_address()"
});
formatter.result({
  "duration": 2891594400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_in_garage_info()"
});
formatter.result({
  "duration": 238710800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.garage_details_get_added()"
});
formatter.result({
  "duration": 24500,
  "status": "passed"
});
formatter.after({
  "duration": 21800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 76,
  "name": "New Vehicle  creation",
  "description": "",
  "id": "cv-nb;new-vehicle--creation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 77,
  "name": "User clicks on Vehicles",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "User selects vehicle year",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "User selects vehicle make",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User selects vehicle model",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User enters agreed value",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "user selects vehicle type",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "user selects Garaging Location",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "user enters \"\u003cVIN\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "user selects Primary Use",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "user checks on photo Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "user clicks on vehicle question tab",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "user clicks on vehicle registered combobox",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "user clicks on save in vehicle page",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "vehicle details get added",
  "keyword": "Then "
});
formatter.examples({
  "line": 94,
  "name": "",
  "description": "",
  "id": "cv-nb;new-vehicle--creation;",
  "rows": [
    {
      "cells": [
        "VIN"
      ],
      "line": 95,
      "id": "cv-nb;new-vehicle--creation;;1"
    },
    {
      "cells": [
        "1G4YC82GX25125254"
      ],
      "line": 96,
      "id": "cv-nb;new-vehicle--creation;;2"
    },
    {
      "cells": [
        "6F06C291240"
      ],
      "line": 97,
      "id": "cv-nb;new-vehicle--creation;;3"
    },
    {
      "cells": [
        "98A212396"
      ],
      "line": 98,
      "id": "cv-nb;new-vehicle--creation;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 96100200,
  "status": "passed"
});
formatter.scenario({
  "line": 96,
  "name": "New Vehicle  creation",
  "description": "",
  "id": "cv-nb;new-vehicle--creation;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 77,
  "name": "User clicks on Vehicles",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "User selects vehicle year",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "User selects vehicle make",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User selects vehicle model",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User enters agreed value",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "user selects vehicle type",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "user selects Garaging Location",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "user enters \"1G4YC82GX25125254\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "user selects Primary Use",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "user checks on photo Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "user clicks on vehicle question tab",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "user clicks on vehicle registered combobox",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "user clicks on save in vehicle page",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "vehicle details get added",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Vehicles()"
});
formatter.result({
  "duration": 5109656800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_year()"
});
formatter.result({
  "duration": 2681549900,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_make()"
});
formatter.result({
  "duration": 1000768900,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_model()"
});
formatter.result({
  "duration": 821514000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_agreed_value()"
});
formatter.result({
  "duration": 1165397000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_type()"
});
formatter.result({
  "duration": 361108300,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "duration": 222558000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "duration": 92990800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_Garaging_Location()"
});
formatter.result({
  "duration": 241819500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1G4YC82GX25125254",
      "offset": 13
    }
  ],
  "location": "CV_NB.user_enters(String)"
});
formatter.result({
  "duration": 1120733600,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_Primary_Use()"
});
formatter.result({
  "duration": 249832800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_checks_on_photo_Reviewed()"
});
formatter.result({
  "duration": 990712900,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_question_tab()"
});
formatter.result({
  "duration": 1211885600,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_registered_combobox()"
});
formatter.result({
  "duration": 1543690100,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_in_vehicle_page()"
});
formatter.result({
  "duration": 280095000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.vehicle_details_get_added()"
});
formatter.result({
  "duration": 52500,
  "status": "passed"
});
formatter.after({
  "duration": 59600,
  "status": "passed"
});
formatter.before({
  "duration": 208611500,
  "status": "passed"
});
formatter.scenario({
  "line": 97,
  "name": "New Vehicle  creation",
  "description": "",
  "id": "cv-nb;new-vehicle--creation;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 77,
  "name": "User clicks on Vehicles",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "User selects vehicle year",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "User selects vehicle make",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User selects vehicle model",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User enters agreed value",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "user selects vehicle type",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "user selects Garaging Location",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "user enters \"6F06C291240\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "user selects Primary Use",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "user checks on photo Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "user clicks on vehicle question tab",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "user clicks on vehicle registered combobox",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "user clicks on save in vehicle page",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "vehicle details get added",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Vehicles()"
});
formatter.result({
  "duration": 6468793400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_year()"
});
formatter.result({
  "duration": 2276565600,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_make()"
});
formatter.result({
  "duration": 922150000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_model()"
});
formatter.result({
  "duration": 482759100,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_agreed_value()"
});
formatter.result({
  "duration": 1197038100,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_type()"
});
formatter.result({
  "duration": 387425200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "duration": 346914000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "duration": 85421800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_Garaging_Location()"
});
formatter.result({
  "duration": 316233200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6F06C291240",
      "offset": 13
    }
  ],
  "location": "CV_NB.user_enters(String)"
});
formatter.result({
  "duration": 1198196100,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_Primary_Use()"
});
formatter.result({
  "duration": 316858000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_checks_on_photo_Reviewed()"
});
formatter.result({
  "duration": 1009155200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_question_tab()"
});
formatter.result({
  "duration": 1221020500,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_registered_combobox()"
});
formatter.result({
  "duration": 1500372500,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_in_vehicle_page()"
});
formatter.result({
  "duration": 286377400,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.vehicle_details_get_added()"
});
formatter.result({
  "duration": 20300,
  "status": "passed"
});
formatter.after({
  "duration": 29900,
  "status": "passed"
});
formatter.before({
  "duration": 145634600,
  "status": "passed"
});
formatter.scenario({
  "line": 98,
  "name": "New Vehicle  creation",
  "description": "",
  "id": "cv-nb;new-vehicle--creation;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 77,
  "name": "User clicks on Vehicles",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "User selects vehicle year",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "User selects vehicle make",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User selects vehicle model",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User enters agreed value",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "user selects vehicle type",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "user selects Garaging Location",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "user enters \"98A212396\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "user selects Primary Use",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "user checks on photo Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "user clicks on vehicle question tab",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "user clicks on vehicle registered combobox",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "user clicks on save in vehicle page",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "vehicle details get added",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Vehicles()"
});
formatter.result({
  "duration": 6625058200,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_year()"
});
formatter.result({
  "duration": 2250467800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_make()"
});
formatter.result({
  "duration": 1089358700,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_model()"
});
formatter.result({
  "duration": 507093000,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_enters_agreed_value()"
});
formatter.result({
  "duration": 1116879100,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_type()"
});
formatter.result({
  "duration": 293647300,
  "stformatter.result({
  "duration": 186028684500,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Info\u0027)] (tried for 180 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:265)\r\n\tat scripts.CV_NB.user_clicks_on_policy_info(CV_NB.java:417)\r\n\tat ✽.When User clicks on policy info(CV_NB.feature:54)\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Info\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"94\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Info\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nCommand duration or timeout: 10.40 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\n*** Element info: {Using\u003dxpath, value\u003d//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Info\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor33.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat scripts.CV_NB.user_clicks_on_policy_info(CV_NB.java:417)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepConformatter.result({
  "duration": 18330418700,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.clicks_on_generate_documents_only()"
});
formatter.result({
  "duration": 32796127800,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.status_changed_to_ISSUED()"
});
formatter.result({
  "duration": 15475827000,
  "status": "passed"
});
formatter.after({
  "duration": 25100,
  "status": "passed"
});
formatter.before({
  "duration": 91499100,
  "status": "passed"
});
formatter.scenario({
  "line": 123,
  "name": "Log Out",
  "description": "",
  "id": "cv-nb;log-out",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 124,
  "name": "User clicks on Logout",
  "keyword": "When "
});
formatter.step({
  "line": 125,
  "name": "User is navigated to login page",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Logout()"
});
formatter.result({
  "duration": 673542900,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_is_navigated_to_login_page()"
});
formatter.result({
  "duration": 53100,
  "status": "passed"
});
formatter.after({
  "duration": 28400,
  "status": "passed"
});
});:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:142)\r\n\t... 51 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Info\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"94\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Info\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_drivers_from_dropdown()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Add_Driver()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_enters_firstName()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_enters_License_Number()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_enters_lastName()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_enters_Daily_Driving_Vehicle()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_enters_Date_of_Birth()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_checks_collector_car_option()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_year_licensed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_losses()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_no_of_points()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.driver_details_get_added()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 337203900,
  "status": "passed"
});
formatter.before({
  "duration": 172072600,
  "status": "passed"
});
formatter.scenario({
  "line": 69,
  "name": "New Garage  creation",
  "description": "",
  "id": "cv-nb;new-garage--creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 70,
  "name": "User clicks on Garages",
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "User clicks on New garages",
  "keyword": "And "
});
formatter.step({
  "line": 72,
  "name": "User clicks on Copy Primary address",
  "keyword": "And "
});
formatter.step({
  "line": 73,
  "name": "user clicks on save in garage info",
  "keyword": "And "
});
formatter.step({
  "line": 74,
  "name": "garage details get added",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Garages()"
});
formatter.result({
  "duration": 120174545800,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Garages\u0027)] (tried for 120 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:265)\r\n\tat scripts.CV_NB.user_clicks_on_Garages(CV_NB.java:540)\r\n\tat ✽.When User clicks on Garages(CV_NB.feature:70)\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Garages\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"97\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Garages\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nCommand duration or timeout: 10.31 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\n*** Element info: {Using\u003dxpath, value\u003d//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Garages\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor33.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat scripts.CV_NB.user_clicks_on_Garages(CV_NB.java:540)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:142)\r\n\t... 51 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Garages\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"97\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceMnuBarItemLabel\u0027) and contains (text(),\u0027Garages\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_New_garages()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Copy_Primary_address()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_in_garage_info()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.garage_details_get_added()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 242885700,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 76,
  "name": "New Vehicle  creation",
  "description": "",
  "id": "cv-nb;new-vehicle--creation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 77,
  "name": "User clicks on Vehicles",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "User selects vehicle year",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "User selects vehicle make",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User selects vehicle model",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User enters agreed value",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "user selects vehicle type",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "user selects Garaging Location",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "user enters \"\u003cVIN\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "user selects Primary Use",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "user checks on photo Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "user clicks on vehicle question tab",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "user clicks on vehicle registered combobox",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "user clicks on save in vehicle page",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "vehicle details get added",
  "keyword": "Then "
});
formatter.examples({
  "line": 94,
  "name": "",
  "description": "",
  "id": "cv-nb;new-vehicle--creation;",
  "rows": [
    {
      "cells": [
        "VIN"
      ],
      "line": 95,
      "id": "cv-nb;new-vehicle--creation;;1"
    },
    {
      "cells": [
        "1G4YC82GX25125254"
      ],
      "line": 96,
      "id": "cv-nb;new-vehicle--creation;;2"
    },
    {
      "cells": [
        "6F06C291240"
      ],
      "line": 97,
      "id": "cv-nb;new-vehicle--creation;;3"
    },
    {
      "cells": [
        "98A212396"
      ],
      "line": 98,
      "id": "cv-nb;new-vehicle--creation;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 157919500,
  "status": "passed"
});
formatter.scenario({
  "line": 96,
  "name": "New Vehicle  creation",
  "description": "",
  "id": "cv-nb;new-vehicle--creation;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 77,
  "name": "User clicks on Vehicles",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "User selects vehicle year",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "User selects vehicle make",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User selects vehicle model",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User enters agreed value",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "user selects vehicle type",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "user selects Garaging Location",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "user enters \"1G4YC82GX25125254\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "user selects Primary Use",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "user checks on photo Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "user clicks on vehicle question tab",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "user clicks on vehicle registered combobox",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "user clicks on save in vehicle page",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "vehicle details get added",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Vehicles()"
});
formatter.result({
  "duration": 361052456600,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)] (tried for 60 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:265)\r\n\tat scripts.CV_NB.user_clicks_on_Vehicles(CV_NB.java:606)\r\n\tat ✽.When User clicks on Vehicles(CV_NB.feature:77)\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"99\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nCommand duration or timeout: 180.57 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\n*** Element info: {Using\u003dxpath, value\u003d//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor33.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat scripts.CV_NB.user_clicks_on_Vehicles(CV_NB.java:606)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:142)\r\n\t... 69 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"99\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_year()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_make()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_model()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_enters_agreed_value()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_type()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_Garaging_Location()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1G4YC82GX25125254",
      "offset": 13
    }
  ],
  "location": "CV_NB.user_enters(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_Primary_Use()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_checks_on_photo_Reviewed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_question_tab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_registered_combobox()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_in_vehicle_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.vehicle_details_get_added()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 309832800,
  "status": "passed"
});
formatter.before({
  "duration": 158456600,
  "status": "passed"
});
formatter.scenario({
  "line": 97,
  "name": "New Vehicle  creation",
  "description": "",
  "id": "cv-nb;new-vehicle--creation;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 77,
  "name": "User clicks on Vehicles",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "User selects vehicle year",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "User selects vehicle make",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User selects vehicle model",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User enters agreed value",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "user selects vehicle type",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "user selects Garaging Location",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "user enters \"6F06C291240\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "user selects Primary Use",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "user checks on photo Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "user clicks on vehicle question tab",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "user clicks on vehicle registered combobox",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "user clicks on save in vehicle page",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "vehicle details get added",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Vehicles()"
});
formatter.result({
  "duration": 360963212300,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)] (tried for 60 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:265)\r\n\tat scripts.CV_NB.user_clicks_on_Vehicles(CV_NB.java:606)\r\n\tat ✽.When User clicks on Vehicles(CV_NB.feature:77)\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"99\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nCommand duration or timeout: 180.41 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\n*** Element info: {Using\u003dxpath, value\u003d//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor33.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat scripts.CV_NB.user_clicks_on_Vehicles(CV_NB.java:606)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:142)\r\n\t... 69 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"99\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_year()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_make()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_model()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_enters_agreed_value()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_type()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_Garaging_Location()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "6F06C291240",
      "offset": 13
    }
  ],
  "location": "CV_NB.user_enters(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_Primary_Use()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_checks_on_photo_Reviewed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_question_tab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_registered_combobox()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_in_vehicle_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.vehicle_details_get_added()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 345919300,
  "status": "passed"
});
formatter.before({
  "duration": 221913100,
  "status": "passed"
});
formatter.scenario({
  "line": 98,
  "name": "New Vehicle  creation",
  "description": "",
  "id": "cv-nb;new-vehicle--creation;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 77,
  "name": "User clicks on Vehicles",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "User selects vehicle year",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "User selects vehicle make",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "User selects vehicle model",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "User enters agreed value",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "user selects vehicle type",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "user selects modification type",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "user selects Garaging Location",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "user enters \"98A212396\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "user selects Primary Use",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "user checks on photo Reviewed",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "user clicks on vehicle question tab",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "user clicks on vehicle registered combobox",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "user clicks on save in vehicle page",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "vehicle details get added",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Vehicles()"
});
formatter.result({
  "duration": 361165415000,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)] (tried for 60 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:265)\r\n\tat scripts.CV_NB.user_clicks_on_Vehicles(CV_NB.java:606)\r\n\tat ✽.When User clicks on Vehicles(CV_NB.feature:77)\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"99\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nCommand duration or timeout: 180.56 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\n*** Element info: {Using\u003dxpath, value\u003d//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor33.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat scripts.CV_NB.user_clicks_on_Vehicles(CV_NB.java:606)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:142)\r\n\t... 69 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"99\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//span[(@class\u003d\u0027iceOutTxt  iceMnuItmLabel\u0027) and (text()\u003d\u0027New Vehicle\u0027)]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_year()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_make()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_model()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_enters_agreed_value()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_vehicle_type()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_modification_type()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_Garaging_Location()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "98A212396",
      "offset": 13
    }
  ],
  "location": "CV_NB.user_enters(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_Primary_Use()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_checks_on_photo_Reviewed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_question_tab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_vehicle_registered_combobox()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_in_vehicle_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.vehicle_details_get_added()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 534425900,
  "status": "passed"
});
formatter.before({
  "duration": 414260800,
  "status": "passed"
});
formatter.scenario({
  "line": 100,
  "name": "Rate the Policy",
  "description": "",
  "id": "cv-nb;rate-the-policy",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 101,
  "name": "User clicks on rate",
  "keyword": "When "
});
formatter.step({
  "line": 102,
  "name": "Status changed to \u0027RATED\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_rate()"
});
formatter.result({
  "duration": 130893638500,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for element to be clickable: By.xpath: //*[text()\u003d\u0027Rate\u0027]//ancestor::a[1] (tried for 120 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:265)\r\n\tat scripts.CV_NB.user_clicks_on_rate(CV_NB.java:736)\r\n\tat ✽.When User clicks on rate(CV_NB.feature:101)\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//*[text()\u003d\u0027Rate\u0027]//ancestor::a[1]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"62\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//*[text()\u003d\u0027Rate\u0027]//ancestor::a[1]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nCommand duration or timeout: 10.40 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\n*** Element info: {Using\u003dxpath, value\u003d//*[text()\u003d\u0027Rate\u0027]//ancestor::a[1]}\r\n\tat sun.reflect.GeneratedConstructorAccessor33.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$22.apply(ExpectedConditions.java:651)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$22.apply(ExpectedConditions.java:644)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat scripts.CV_NB.user_clicks_on_rate(CV_NB.java:736)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:142)\r\n\t... 53 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//*[text()\u003d\u0027Rate\u0027]//ancestor::a[1]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"62\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//*[text()\u003d\u0027Rate\u0027]//ancestor::a[1]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CV_NB.status_changed_to_RATED()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 364471000,
  "status": "passed"
});
formatter.before({
  "duration": 754255300,
  "status": "passed"
});
formatter.scenario({
  "line": 104,
  "name": "Quote Policy",
  "description": "",
  "id": "cv-nb;quote-policy",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 105,
  "name": "User clicks on quote",
  "keyword": "When "
});
formatter.step({
  "line": 106,
  "name": "User click on generate documents",
  "keyword": "And "
});
formatter.step({
  "line": 107,
  "name": "Status changed to \u0027QUOTED\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_qoute()"
});
formatter.result({
  "duration": 65176294800,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for element to be clickable: By.xpath: //*[text()\u003d\u0027Quote\u0027]//ancestor::a (tried for 60 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:265)\r\n\tat scripts.CV_NB.user_clicks_on_qoute(CV_NB.java:752)\r\n\tat ✽.When User clicks on quote(CV_NB.feature:105)\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//*[text()\u003d\u0027Quote\u0027]//ancestor::a\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"60\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//*[text()\u003d\u0027Quote\u0027]//ancestor::a\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nCommand duration or timeout: 10.56 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\n*** Element info: {Using\u003dxpath, value\u003d//*[text()\u003d\u0027Quote\u0027]//ancestor::a}\r\n\tat sun.reflect.GeneratedConstructorAccessor33.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$22.apply(ExpectedConditions.java:651)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$22.apply(ExpectedConditions.java:644)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat scripts.CV_NB.user_clicks_on_qoute(CV_NB.java:752)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:142)\r\n\t... 53 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//*[text()\u003d\u0027Quote\u0027]//ancestor::a\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"60\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//*[text()\u003d\u0027Quote\u0027]//ancestor::a\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CV_NB.user_click_on_generate_documents()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.status_changed_to_QUOTED()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 515436700,
  "status": "passed"
});
formatter.before({
  "duration": 144562100,
  "status": "passed"
});
formatter.scenario({
  "line": 109,
  "name": "Bind Policy",
  "description": "",
  "id": "cv-nb;bind-policy",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 110,
  "name": "User clicks on Billing Info",
  "keyword": "When "
});
formatter.step({
  "line": 111,
  "name": "User clicks on edit",
  "keyword": "And "
});
formatter.step({
  "line": 112,
  "name": "User selects billing contact",
  "keyword": "And "
});
formatter.step({
  "line": 113,
  "name": "user clicks on save in billing info",
  "keyword": "And "
});
formatter.step({
  "line": 114,
  "name": "User clicks on bind",
  "keyword": "And "
});
formatter.step({
  "line": 115,
  "name": "User clicks on override",
  "keyword": "And "
});
formatter.step({
  "line": 116,
  "name": "Status changed to \u0027BOUND\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Billing_Info()"
});
formatter.result({
  "duration": 10434591200,
  "error_message": "org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//*[text()\u003d\u0027Billing Info\u0027]//ancestor::a\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"67\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//*[text()\u003d\u0027Billing Info\u0027]//ancestor::a\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nCommand duration or timeout: 10.44 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\n*** Element info: {Using\u003dxpath, value\u003d//*[text()\u003d\u0027Billing Info\u0027]//ancestor::a}\r\n\tat sun.reflect.GeneratedConstructorAccessor33.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat scripts.CV_NB.user_clicks_on_Billing_Info(CV_NB.java:778)\r\n\tat ✽.When User clicks on Billing Info(CV_NB.feature:110)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:142)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat scripts.CV_NB.user_clicks_on_Billing_Info(CV_NB.java:778)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//*[text()\u003d\u0027Billing Info\u0027]//ancestor::a\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"67\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//*[text()\u003d\u0027Billing Info\u0027]//ancestor::a\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_edit()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_selects_billing_contact()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_save_in_billing_info()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_bind()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.user_clicks_on_override()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.status_changed_to_BOUND()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 462196700,
  "status": "passed"
});
formatter.before({
  "duration": 73537900,
  "status": "passed"
});
formatter.scenario({
  "line": 118,
  "name": "Issue Policy",
  "description": "",
  "id": "cv-nb;issue-policy",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 119,
  "name": "User clicks on issue",
  "keyword": "When "
});
formatter.step({
  "line": 120,
  "name": "clicks on generate documents only",
  "keyword": "And "
});
formatter.step({
  "line": 121,
  "name": "Status changed to \u0027ISSUED\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_issue()"
});
formatter.result({
  "duration": 87233287800,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //*[text()\u003d\u0027Issue\u0027]//ancestor::a[1] (tried for 80 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:265)\r\n\tat scripts.CV_NB.user_clicks_on_issue(CV_NB.java:859)\r\n\tat ✽.When User clicks on issue(CV_NB.feature:119)\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//*[text()\u003d\u0027Issue\u0027]//ancestor::a[1]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"63\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//*[text()\u003d\u0027Issue\u0027]//ancestor::a[1]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nCommand duration or timeout: 10.28 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.phantomjs.PhantomJSDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, handlesAlerts\u003dfalse, databaseEnabled\u003dfalse, version\u003d2.1.1, platform\u003dXP, browserConnectionEnabled\u003dfalse, proxy\u003d{proxyType\u003ddirect}, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, driverVersion\u003d1.2.0, locationContextEnabled\u003dfalse, webStorageEnabled\u003dfalse, browserName\u003dphantomjs, takesScreenshot\u003dtrue, driverName\u003dghostdriver, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3067eec0-1e89-11e7-87b7-556cece7f181\n*** Element info: {Using\u003dxpath, value\u003d//*[text()\u003d\u0027Issue\u0027]//ancestor::a[1]}\r\n\tat sun.reflect.GeneratedConstructorAccessor33.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:473)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat scripts.CV_NB.user_clicks_on_issue(CV_NB.java:859)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:142)\r\n\t... 51 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: {\"errorMessage\":\"Unable to find element with xpath \u0027//*[text()\u003d\u0027Issue\u0027]//ancestor::a[1]\u0027\",\"request\":{\"headers\":{\"Accept-Encoding\":\"gzip,deflate\",\"Connection\":\"Keep-Alive\",\"Content-Length\":\"63\",\"Content-Type\":\"application/json; charset\u003dutf-8\",\"Host\":\"localhost:17111\",\"User-Agent\":\"Apache-HttpClient/4.5.2 (Java/1.8.0_51)\"},\"httpVersion\":\"1.1\",\"method\":\"POST\",\"post\":\"{\\\"using\\\":\\\"xpath\\\",\\\"value\\\":\\\"//*[text()\u003d\u0027Issue\u0027]//ancestor::a[1]\\\"}\",\"url\":\"/element\",\"urlParsed\":{\"anchor\":\"\",\"query\":\"\",\"file\":\"element\",\"directory\":\"/\",\"path\":\"/element\",\"relative\":\"/element\",\"port\":\"\",\"host\":\"\",\"password\":\"\",\"user\":\"\",\"userInfo\":\"\",\"authority\":\"\",\"protocol\":\"\",\"source\":\"/element\",\"queryKey\":{},\"chunks\":[\"element\"]},\"urlOriginal\":\"/session/3067eec0-1e89-11e7-87b7-556cece7f181/element\"}}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:48:19 -0700\u0027\nSystem info: host: \u0027W00PISVDI247\u0027, ip: \u002710.60.202.198\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CV_NB.clicks_on_generate_documents_only()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CV_NB.status_changed_to_ISSUED()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 229187700,
  "status": "passed"
});
formatter.before({
  "duration": 108644300,
  "status": "passed"
});
formatter.scenario({
  "line": 123,
  "name": "Log Out",
  "description": "",
  "id": "cv-nb;log-out",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 124,
  "name": "User clicks on Logout",
  "keyword": "When "
});
formatter.step({
  "line": 125,
  "name": "User is navigated to login page",
  "keyword": "Then "
});
formatter.match({
  "location": "CV_NB.user_clicks_on_Logout()"
});
formatter.result({
  "duration": 1138072600,
  "status": "passed"
});
formatter.match({
  "location": "CV_NB.user_is_navigated_to_login_page()"
});
formatter.result({
  "duration": 50300,
  "status": "passed"
});
formatter.after({
  "duration": 44500,
  "status": "passed"
});
});