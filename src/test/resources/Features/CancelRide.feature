Feature: Verify the cancel ride functionality
  Background: This will open the Busbound app
    Given I open bus bound url

  Scenario: Verify Cancel Ride
    Given I switch to frame
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 4 |
      | Location    | SFO        |  Sacramento, CA, USA     |
      | Day         | 23         |           |
      | Month       | 09         |      |
      | Year        | 2024       |        |
      | Hour        | 08         |        |
      | Minute      | 30         |       |
      | Period      | AM         |      |
    And I get the Ride Times from Itinerary page
    And I click on next button in itinerary page
    When I enter the following details into the form
      | Field                 | Values                       |
      | Name                  | Test                         |
      | Salutation            |                              |
      | Email                 | sugapriya@elifeTransfer.com  |
      | Phone Number 1 Code   | +91                          |
      | Phone Number 1        | 9750359643                   |
      | Phone Number 2 Code   | +1                           |
      | Phone Number 2        | 1234567890                   |
      | Social Media          |                      |
      | Social Media Name     |                         |
    Then I click on next button in contact page
    And I select the vehicle in the vehicle page
    And I click on the next button in the vehicle page
    And I click on the next button in the additional info page
    And I click on the payment link
    And I do the payment
    And I click on the More link
    And I click on the cancel ride button
    And I select cell number from the dropdown
    And I click on Get Verification Code Link in ride confirmation page
    And I click on confirm button in the ride confirmation page
    And Verify the Title of the ride confirmation should be changed to "Sorry, your ride has been cancelled."

  @1
  Scenario: Verify Cancel Ride functionality in the Ride Confirmation Page
#    Given I click on my ride link
    When I select country code as "+91"
    When I enter cell number as "9597945929"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I click on the ride link
    And I get the status of the ride in Rid List page
    And I switch to Ride Confirmation Page
    And I switch to frame
    And I click on the cancel ride button and verify the title of the ride status
    And I check the ride status updated in Ride List page

  Scenario: Verify Cancel Ride is displayed only for Paid and Unpaid Rides in the Ride Confirmation Page
    Given I click on my ride link
    When I select country code as "USA"
    When I enter cell number as "9750359646"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I click on the ride link
    And I get the status of the ride in Rid List page
    And I switch to Ride Confirmation Page
    And I switch to frame
    And I verify the Cancel ride is only displayed for the Paid and Unpaid Rides

  Scenario: Verify service policy is displayed only for Paid and Unpaid Rides in the Ride Confirmation Page
    Given I click on my ride link
    When I select country code as "USA"
    When I enter cell number as "9750359646"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I click on the ride link
    And I get the status of the ride in Rid List page
    And I switch to Ride Confirmation Page
    And I switch to frame
    And I verify the Service Policy is only displayed for the Paid and Unpaid Rides




