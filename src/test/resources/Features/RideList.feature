Feature: Verify The functionalities Ride List
  Background: This will click on my ride link
    Given I open bus bound url
#    Then I switch to frame

  Scenario: Verify the Past and Future switch button is present in the Ride List page
    When I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I verify the Future and Past switch should be displayed in Ride List page

  Scenario: Verify the Ride is redirected to right Right confirmation page
#    Given I click on my ride link
    When I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I get the partner name of the ride id
    And I click on the ride link
    And I switch to Ride Confirmation Page
    Then Verify the url of the Ride Confirmation page

  Scenario: Verify the future rides are in ascending order
    Given I click on my ride link
    When I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the future orders are in ascending order

  Scenario: Verify the past rides are in descending order
    Given I click on my ride link
    When I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    When I click on the past button
    And Verify the part orders are in ascending order

  Scenario: Verify the future page contains only 5 records
#    Given I click on my ride link
    When I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the each page contains lesser than or equal to 5 records

  Scenario: Verify the past page contains only 5 records
#    Given I click on my ride link
    When I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    When I click on the past button
    And Verify the each page contains lesser than or equal to 5 records
@1
  Scenario: Verify the future rides dates are greater than now
    Given I click on my ride link
    When I select country code as "USA"
    When I enter cell number as "1234567890"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the dates which is greater than now

  Scenario: Verify the past rides dates are lesser than now
    Given I click on my ride link
    When I select country code as "USA"
    When I enter cell number as "1234567890"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    When I click on the past button
    And Verify the dates which is lesser than now

  Scenario: Verify More link is displayed in the Ride Confirmation Page
    Given I click on my ride link
    When I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I click on the ride link
    And I switch to Ride Confirmation Page
    And I switch to frame
    Then Verify the More link is displayed in Ride confirmation page

  Scenario: Verify the Ride Info are updated properly or not
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 4 |
      | Location    | SFO        | San francisco, CA, USA     |
      | Day         | 10         |                         |
      | Month       | 10         |                         |
      | Year        | 2024       |                         |
      | Hour        | 08         |                         |
      | Minute      | 30         |                         |
      | Period      | AM         |                         |
    And I click on next button in itinerary page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I click on the next button in the vehicle page
    Then I click on the next button in the additional info page
    And I click on the payment link
    Then I do the payment
    And I get ride info from confirmation page to check it on the Ride List Page
    When I click on my ride link
    And I select country code as "USA"
    When I enter cell number as "9750359646"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Get the Ride Id from Ride List and compare it with Ride Confirmation Page
    And Verify Ride Status should be "Paid"
    And Get the Vehicle name from Ride List and compare it with Ride Confirmation Page
#    And Get the Vehicle brand from Ride List and compare it with Ride Confirmation Page
    And Get the Ride date and time from Ride List and compare it with Ride Confirmation Page
    And Get the Locations from Ride List and compare it with Ride Confirmation Page


