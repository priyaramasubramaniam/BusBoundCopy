Feature: Verify The functionalities Ride Summary
@1
  Scenario: Verify Ride Info without stops
    Given I open bus bound url
    And I switch to frame
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
    And I get the Ride Times from Itinerary page
    And I click on next button in itinerary page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I click on the next button in the vehicle page
    Then Verify the Ride dates with actual dates
    And Verify the Ride dates for each days
    And Verify the Ride Time for each days
    And Verify the Ride locations for each days
    And Verify the vehicle information in ride summary page

@1
  Scenario:  Verify Ride Info with multiple stops without itineraries
    Given I open bus bound url
    And I switch to frame
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    And the user adds 3 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 | Value 3       | Value 4        | Value 5 |
      | Location    | SFO        | Sacramento, CA, USA     | San jose, USA | San Cruz, USA  | SFO     |
      | Day         | 1          | 1                       | 1             | 1              |         |
      | Month       | 10         | 10                      | 10            | 10             |         |
      | Year        | 2024       | 2024                    | 2024          | 2024           |         |
      | Hour        | 08         | 12                      | 05            | 08             |         |
      | Minute      | 30         | 12                      | 25            | 30             |         |
      | Period      | AM         | PM                      | PM            | PM             |         |
    And I get the Ride Times from Itinerary page
    And I click on next button in itinerary page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I click on the next button in the vehicle page
    Then Verify the Ride dates with actual dates
    And Verify the Ride dates for each days
    And Verify the Ride Time for each days
    And Verify the Ride locations for each days
    And Verify the vehicle information in ride summary page
@1
  Scenario: Create one way ride with multiple stops with itineraries
    Given I open bus bound url
    And I switch to frame
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    And the user adds 3 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 | Value 3       | Value 4        | Value 5 |
      | Location    | SFO        | Sacramento, CA, USA     | San jose, USA | San Cruz, USA  | SFO     |
      | Day         | 1          | 1                       | 2             | 3              |         |
      | Month       | 10         | 10                      | 10            | 10             |         |
      | Year        | 2024       | 2024                    | 2024          | 2024           |         |
      | Hour        | 08         | 12                      | 11            | 08             |         |
      | Minute      | 30         | 12                      | 25            | 30             |         |
      | Period      | AM         | PM                      | PM            | PM             |         |
    And I get the Ride Times from Itinerary page
    And I click on next button in itinerary page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I click on the next button in the vehicle page
    Then Verify the Ride dates with actual dates
    And Verify the Ride dates for each days
    And Verify the Ride Time for each days
    And Verify the Ride locations for each days
    And Verify the vehicle information in ride summary page


  Scenario: Verify the Error message for Contact form
    Given I open bus bound url
    And I switch to frame
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
    And I click on the payment link
    Then Verify the error message for name "Sorry, name is required"
    And I enter name as "priya"
    And I click on the payment link
    Then Verify the error message for email "Sorry, email is required"
    And I enter email as "test@elife.com"
    When I click on the payment link
    And Verify the error message for Country code "Sorry, country code is required"
    And I select country code as "+91"
    And I click on the payment link
    And Verify the error message for cell number "Sorry, phone number is required"
    And I enter cell number as "9750359643" in contact form




  Scenario: Verify the Ride dates with actual dates
#    Given I click on the next button in the additional info page
    Then Verify the Ride dates with actual dates

  Scenario: Verify the Ride dates for each days
#    Given I click on the next button in the additional info page
    And Verify the Ride dates for each days

  Scenario: Verify the ride times
#    Given I click on the next button in the additional info page
    And Verify the Ride Time for each days

  Scenario: Verify Ride Locations
    And Verify the Ride locations for each days

  Scenario: Verify Vehicle Information
    And Verify the vehicle information in ride summary page

  Scenario: Verify Contact Information
    And Verify the Contact information in ride summary page

  Scenario: Verify the Additional charges
    Given I select "Yes" for the Meet & Greet sign
    And I get the price of the meet and greet
    And I select "Yes" for the child seat
    And I set the quantity "4" for the Infant Seat
    And I get the price of the infant seat
    And I set the quantity "2" for the Booster Seat
    And I get the price of the booster seat
    And I set the quantity "3" for the Child Seat
    And I get the price of the child seat seat
    Then I click on the next button in the additional info page
    And Verify the meet and greet price in the Ride Summary Page
    And Verify the additional charges in the Ride Summary Page

  Scenario: Verify the Meet and Greet should not be displayed for No
    Given I select "No" for the Meet & Greet sign
    Then I click on the next button in the additional info page
    And Verify the meet and greet price should not be displayed in the Ride Summary Page

  Scenario: Verify the Additional charges should not displayed when i click on No in the Additional info
    And I select "No" for the child seat
    Then I click on the next button in the additional info page
    And Verify the additional charges are not displayed in ride summary page

  Scenario: Verify the Additional charges should not be displayed for 0 counts
    And I select "Yes" for the child seat
    And I set the quantity "0" for the Infant Seat
    And I set the quantity "0" for the Booster Seat
    And I set the quantity "0" for the Child Seat
    Then I click on the next button in the additional info page
    And Verify the additional charges are not displayed in ride summary page




