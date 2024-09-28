Feature: Verify The functionalities Ride List
  Background: This will click on my ride link
    Given I open bus bound url

  Scenario: Verify the Past and Future switch button is present in the Ride List page
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "+91"
    When I enter cell number as "9597945929"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I verify the Future and Past switch should be displayed in Ride List page

  Scenario: Verify the Future Ride is redirected to right Right confirmation page
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "+91"
    When I enter cell number as "9597945929"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I get the partner name of the ride id
    And I click on the ride link
    And I switch to Ride Confirmation Page
    Then Verify the url of the Ride Confirmation page

  Scenario: Verify the Past Ride is redirected to right Right confirmation page
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "USA"
    When I enter cell number as "1234567890"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I click on the past button
    And I get the partner name of the ride id
    And I click on the ride link
    And I switch to Ride Confirmation Page
    Then Verify the url of the Ride Confirmation page

    @1
  Scenario: Verify the future rides are in ascending order
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "USA"
    When I enter cell number as "12345"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the future orders are in ascending order

  @1
  Scenario: Verify the past rides are in descending order
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "USA"
    When I enter cell number as "12345"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    When I click on the past button
    And Verify the part orders are in descending order

  Scenario: Verify the future page contains only 5 records
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "USA"
    When I enter cell number as "1234567890"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the each page contains lesser than or equal to 5 records

  Scenario: Verify the past page contains only 5 records
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "+91"
    When I enter cell number as "9597945929"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    When I click on the past button
    And Verify the each page contains lesser than or equal to 5 records


  Scenario: Verify the future rides dates are greater than now
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "+91"
    When I enter cell number as "9597945929"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the dates which is greater than now


  Scenario: Verify the past rides dates are lesser than now
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "+91"
    When I enter cell number as "9597945929"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    When I click on the past button
    And Verify the dates which is lesser than now

  Scenario: Verify More link is displayed in the Ride Confirmation Page
#    Given I click on my ride link
#    Then I click on my ride link from the dropdown
    When I select country code as "+91"
    When I enter cell number as "9597945929"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I click on the ride link
    And I switch to Ride Confirmation Page
    And I switch to frame
    Then Verify the More link is displayed in Ride confirmation page


  Scenario: Verify the Ride Info are updated properly or not
    Given I switch to frame
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 4 |
      | Location    | San Jose, CA, USA      | SFO     |
      | Day         | 15         |                         |
      | Month       | October    |                         |
      | Year        | 2024       |                         |
      | Hour        | 12         |                         |
      | Minute      | 30         |                         |
      | Period      | AM         |                         |
    And I click on next button in itinerary page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I click on the next button in the vehicle page
    And I enter name as "priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    And I click on the payment link
    Then I do the payment
    And I get ride info from confirmation page to check it on the Ride List Page
    When I click on my ride link
    And I click on my ride link from the dropdown
    And I select country code as "USA"
    When I enter cell number as "1234567890"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Get the Ride Id from Ride List and compare it with Ride Confirmation Page
    And Verify Ride Status should be "Paid"
#    And Get the Vehicle name from Ride List and compare it with Ride Confirmation Page
#    And Get the Vehicle brand from Ride List and compare it with Ride Confirmation Page
    And Get the Ride date and time from Ride List and compare it with Ride Confirmation Page
    And Get the Locations from Ride List and compare it with Ride Confirmation Page


