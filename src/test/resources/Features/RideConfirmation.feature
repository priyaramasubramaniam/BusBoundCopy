Feature: Verify The functionalities Ride Summary

  Background: This will run before all scenarios
    Given I open bus bound url
    And I switch to frame
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 4 |
      | Location    | SFO        | Sacramento, CA, USA     |
      | Day         | 23         |                         |
      | Month       | October    |                         |
      | Year        | 2024       |                         |
      | Hour        | 08         |                         |
      | Minute      | 30         |                         |
      | Period      | AM         |                         |
    When I click on next button in itinerary page


# Verify Vehicle Information
  Scenario: Verify vehicle Name and Count is updated properly
    And I click on the price breakdown link
    And I get the vehicle name in the vehicle page
    And I click on the next button in the vehicle page
    Then I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    When I click on the payment link
    And I do the payment
    Then Verify the vehicle name in ride confirmation page

  Scenario: Verify Vehicle Brand is updated properly
    And I get the vehicle brand in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    Then I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    When I click on the payment link
    And I do the payment
    Then Verify the vehicle brand in ride confirmation page

  Scenario: Verify Vehicle Max passenger count and Luggage count is updated properly
    And I get the vehicle max luggage count in the vehicle page
    And I get the vehicle max passenger count in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    Then I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    When I click on the payment link
    And I do the payment
    Then Verify the vehicle max passenger count in ride confirmation page
    Then Verify the vehicle max luggage in ride confirmation page

  Scenario: Verify Vehicle image is updated properly
    And I get the vehicle image src in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    Then I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    When I click on the payment link
    And I do the payment
    Then Verify the vehicle src in ride confirmation page

  # Additional Information
  Scenario: Verify Meet and Greet is displayed for Yes in the Vehicle Page
    And I click on the price breakdown link
    And I click on meet and greet checkbox
    And I click on the next button in the vehicle page
    And I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    When I click on the payment link
    And I do the payment
    Then Verify the meet and greet is "Yes" displayed in the Ride Confirmation Page

  Scenario: Verify Meet and Greet is Not displayed for No in the Vehicle Page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    When I click on the payment link
    And I do the payment
    Then Verify the meet and greet is "No" displayed in the Ride Confirmation Page
@1
  Scenario: Verify Sign message is displayed
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    And I enter special instruction as "TEST SPECIAL INSTRUCTION" in ride summary page
    When I click on the payment link
    And I do the payment
    Then Verify Special Instruction is "TEST SPECIAL INSTRUCTION" displayed in the Ride Confirmation Page
@1
  Scenario: Verify Sign message is not displayed
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    When I click on the payment link
    And I do the payment
    Then Verify Special Instruction is "" displayed in the Ride Confirmation Page

  Scenario Outline: Verify the Child Seats Quantity are updated properly
    And I click on the price breakdown link
    And I click on child seat checkbox
    And I select infant seat quantity as <infant_count>
    And I select booster seat quantity as <booster_count>
    And I select child seat quantity as <child_count>
    And I get the infant quantity in the vehicle page
    And I get the booster quantity in the vehicle page
    And I get the child quantity in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    When I click on the payment link
    And I do the payment
    Then Verify the infant count should be equal to infant count in ride confirmation page
    Then Verify the booster count should be equal to booster count in ride confirmation page
    Then Verify the child count should be equal to child count in ride confirmation page
    Examples:
      | infant_count    | booster_count    | child_count    |
      | 3               | 4                | 5              |
      | 1               | 2                | 3              |
      | 2               | 5                | 8              |
      | 0               | 0                | 0              |


  Scenario: Verify the Unchecked Child Seats Quantity  are updated properly
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    When I enter name as "Priya"
    And I enter email as "test@elife.com"
    And I select country code as "USA" in contact form
    And I enter cell number as "1234567890" in contact form
    When I click on the payment link
    And I do the payment
    Then Verify the infant count should be equal "-" in ride confirmation page
    Then Verify the booster count should be equal "-" in ride confirmation page
    Then Verify the child count should be equal "-" in ride confirmation page






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

#
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

