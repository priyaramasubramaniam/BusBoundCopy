Feature: Verify The functionalities of Round Trip ride

  Background: This will run before all scenarios
    Given I open bus bound url

  Scenario: Verify User clicks on the Round trip Radio will give Three locations
    Given I click on Round trip radio
    Then Verify the following locations will be displayed
    | 01Pickup |
    | 02Stop |
    | 03Dropoff |

  Scenario: Verify User removes any one of the location will enable One way Radio Button
    Given I click on Round trip radio
    And I remove stop the following stops
    | First Location |
    Then Verify the One Way Radio Button is enabled
    And Verify the following locations will be displayed
    | 01Pickup |
    | 02Dropoff |

  Scenario: Verify user can multiple stops
    Given User clicks on passenger add button
    When User clicks on luggage add button
    And I click on event type
    And User selects the event type
    And I enter pickup location as "SFO"
    And I select pickup location
    And I select pickup date "October 9, 2024"
    And I enter pickup time "10:00 AM"
    And the user adds the following stops:
    | location1 |
    | location2 |
    | location3 |
    Then Verify the sequence of stops should be correct form

  Scenario: Verify user can remove stops when click on Remove a stop link
    Given User clicks on passenger add button
    When User clicks on luggage add button
    And I click on event type
    And User selects the event type
    And I enter pickup location as "SFO"
    And I select pickup location
    And I select pickup date "October 9, 2024"
    And I enter pickup time "10:00 AM"
    And the user adds the following stops:
    | Location 1 |
    | Location 2 |
    | Location 3 |
    Then Verify the sequence of stops should be correct form
    And I remove stop the following stops
    | Location 1 |
    Then Verify the sequence of stops should be correct form

    # Need to check
  Scenario: Verify the pickup and drop off location should be same for round trip
    Given I click on Round trip radio
    When I enter pickup location as "SFO"
    And I select pickup location
    And I Verify the pickup and drop off locations are same
