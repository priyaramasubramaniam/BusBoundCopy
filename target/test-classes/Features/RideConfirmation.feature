Feature: Verify The functionalities Ride Confirmation page

  Background: This will run before all scenarios
    Given I open bus bound url
    When I switch to frame


  Scenario: Verify Ride info for without stops in Ride Confirmation Page
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 4 |
      | Location    | SFO        | Sacramento, CA, USA     |
      | Day         | 23         |                         |
      | Month       | October    |                         |
      | Year        | 2024       |                         |
      | Hour        | 08         |                         |
      | Minute      | 30         |                         |
      | Period      | AM         |                         |
    And I get the Ride Dates from Itinerary page
    And I get the Ride Times from Itinerary page
    And I click on next button in itinerary page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the next button in the vehicle page
    Then Verify the Ride dates with actual dates
    And Verify the Ride dates for each days
    And Verify the Ride Time for each days
#    And Verify the Ride locations for each days
    And Verify the vehicle information in ride summary page
    And Verify the vehicle Service price in ride summary page
    And I enter name as "priya"
    And I enter email as "test@elife.com"
    And I select country code as "+91" in contact form
    And I enter cell number as "9597945929" in contact form
    And I click on the payment link
    And I do the payment
    Then Verify the Ride dates with actual dates in Confirmation Page
    And Verify the Ride dates for each days in Confirmation Page
    And Verify the Ride Time for each days in Confirmation Page
#    And Verify the Ride locations for each days in Confirmation Page
    And Verify the vehicle information in in Confirmation Page


  Scenario: Verify Ride info for without stops in Ride Confirmation Page
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    And the user adds 2 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 | Value 3            |  Value 5 |
      | Location    | SFO        | San Jose, CA, USA       | San Mateo, CA, USA |  SFO     |
      | Day         | 1          | 1                       | 1                  |          |
      | Month       | October    | October                 | October            |          |
      | Year        | 2024       | 2024                    | 2024               |          |
      | Hour        | 08         | 12                      | 05                 |          |
      | Minute      | 30         | 12                      | 25                 |          |
      | Period      | AM         | PM                      | PM                 |          |
    And I get the Ride Dates from Itinerary page
    And I get the Ride Times from Itinerary page
    And I click on next button in itinerary page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the next button in the vehicle page
    Then Verify the Ride dates with actual dates
    And Verify the Ride dates for each days
    And Verify the Ride Time for each days
#    And Verify the Ride locations for each days
    And Verify the vehicle information in ride summary page
    And Verify the vehicle Service price in ride summary page
    And I enter name as "priya"
    And I enter email as "test@elife.com"
    And I select country code as "+91" in contact form
    And I enter cell number as "9597945929" in contact form
    And I click on the payment link
    And I do the payment
    Then Verify the Ride dates with actual dates in Confirmation Page
    And Verify the Ride dates for each days in Confirmation Page
    And Verify the Ride Time for each days in Confirmation Page
#    And Verify the Ride locations for each days in Confirmation Page
    And Verify the vehicle information in in Confirmation Page

@1
  Scenario: Create one way ride with multiple stops with itineraries
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    And the user adds 3 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 | Value 3            | Value 4        | Value 5 |
      | Location    | SFO        | San Jose, CA, USA       | San Mateo, CA, USA | San Cruz, USA  | SFO     |
      | Day         | 1          | 1                       | 2                  | 3              |         |
      | Month       | October    | October                 | October            | October        |         |
      | Year        | 2024       | 2024                    | 2024               | 2024           |         |
      | Hour        | 08         | 12                      | 05                 | 08             |         |
      | Minute      | 30         | 12                      | 25                 | 30             |         |
      | Period      | AM         | PM                      | PM                 | PM             |         |
    And I get the Ride Times from Itinerary page
    And I get the Ride Times from Itinerary page
    And I click on next button in itinerary page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the next button in the vehicle page
    And I enter name as "priya"
    And I enter email as "test@elife.com"
    And I select country code as "+91" in contact form
    And I enter cell number as "9597945929" in contact form
    And I click on the payment link
    And I do the payment
    Then Verify the Ride dates with actual dates in Confirmation Page
    And Verify the Ride dates for each days in Confirmation Page
    And Verify the Ride Time for each days in Confirmation Page
#    And Verify the Ride locations for each days in Confirmation Page
    And Verify the vehicle information in in Confirmation Page





  Scenario: Verify the Service Policy table
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 4 |
      | Location    | SFO        | Sacramento, CA, USA     |
      | Day         | 23         |                         |
      | Month       | 09         |                         |
      | Year        | 2024       |                         |
      | Hour        | 08         |                         |
      | Minute      | 30         |                         |
      | Period      | AM         |                         |
    And I click on next button in itinerary page
    When I enter the following details into the form
      | Field                 | Values                       |
      | Name                  | Test                         |
      | Salutation            |                              |
      | Email                 | sugapriya@elifeTransfer.com  |
      | Phone Number 1 Code   | +91                          |
      | Phone Number 1        | 9750359643                   |
      | Phone Number 2 Code   |                           |
      | Phone Number 2        |                    |
      | Social Media          |                      |
      | Social Media Name     |                         |
    Then I click on next button in contact page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I click on the next button in the vehicle page
    Then I click on the next button in the additional info page
    And I click on the payment link
    Then I do the payment
    And I get ride info from confirmation page to check it on the Ride List Page
#    And Verify the More link is displayed in Ride confirmation page
#    And I click on the More link
    And I click on Service policy link


  Scenario: Verify the Ride info for stops
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    And the user adds 2 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2    | Value 3      | Value 4 |
      | Location    | SFO        | San Jose   | San cruz, USA| Sacramento, CA, USA     |
      | Day         | 23         |  23        |  24        |         |
      | Month       | 09         |  09        |  09        |       |
      | Year        | 2024       |  2024      |  2024      |      |
      | Hour        | 08         |  08        |  08        |       |
      | Minute      | 30         |  30        |  30        |      |
      | Period      | AM         |  PM        |  PM        |       |
    And I click on next button in itinerary page
    When I enter the following details into the form
      | Field                 | Values                       |
      | Name                  | Test                         |
      | Salutation            |                              |
      | Email                 | sugapriya@elifeTransfer.com  |
      | Phone Number 1 Code   | +91                          |
      | Phone Number 1        | 9750359643                   |
      | Phone Number 2 Code   |                           |
      | Phone Number 2        |                    |
      | Social Media          |                      |
      | Social Media Name     |                         |
    Then I click on next button in contact page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I click on the next button in the vehicle page
    Then I click on the next button in the additional info page
    And I click on the payment link
    Then I do the payment
    And I get ride info

  Scenario: Verify the Modification Text
    Given I open ride confirmation page url "https://elifetransfer.s3.us-east-2.amazonaws.com/dev/busbound_test/rides.html?t_order=0bHljQnyZx2t"
    When I switch to frame
    When I click on the More link
    And I click on Service policy link
    And I click on modification link
    And I get the text of the modification policy and compare it with expected text file

  Scenario: Verify the Overtime and Additional Charge Text
    Given I open ride confirmation page url "https://elifetransfer.s3.us-east-2.amazonaws.com/dev/busbound_test/rides.html?t_order=0bHljQnyZx2t"
    When I switch to frame
    When I click on the More link
    And I click on Service policy link
    And I click on overtime and additional charge link
    And I get the text of the overtime and Additional charge policy and compare it with expected text file


  Scenario: Verify the Modification and Overtime text after creating a ride
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 4 |
      | Location    | SFO        | Sacramento, CA, USA     |
      | Day         | 23         |                         |
      | Month       | 09         |                         |
      | Year        | 2024       |                         |
      | Hour        | 08         |                         |
      | Minute      | 30         |                         |
      | Period      | AM         |                         |
    And I click on next button in itinerary page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I click on the next button in the vehicle page
    And I enter name as "Priya Test"
    And I enter email as "test@elife.com"
    And I select country code as "+91" in contact form
    And I enter cell number as "9750359643" in contact form
    And I click on the payment link
    Then I do the payment
    And I click on the More link
    And I click on Service policy link
    And I click on modification link
    And I get the text of the modification policy and compare it with expected text file
    And I click on overtime and additional charge link
    And I get the text of the overtime and Additional charge policy and compare it with expected text file


  Scenario: Verify the Overtime and Additional Charge Text in Ride Confirmation Page after login
    Given I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And I click on the ride link
    And I switch to Ride Confirmation Page
    And I switch to frame
    When I click on the More link
    And I click on Service policy link
    And I click on overtime and additional charge link
    And I get the text of the overtime and Additional charge policy and compare it with expected text file

