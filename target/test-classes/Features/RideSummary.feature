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

  Scenario: Verify Ride Info without stops



  Scenario:  Verify Ride Info with multiple stops without itineraries



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
    And I get the vehicle name in the vehicle page
    And I get the vehicle brand in the vehicle page
    And I get the vehicle max passenger count in the vehicle page
    And I get the vehicle max luggage count in the vehicle page
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


# Verify Vehicle Information
  Scenario: Verify vehicle Name and Count is updated properly
    And I click on the price breakdown link
    And I get the vehicle name in the vehicle page
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle name in ride summary page

  Scenario: Modify Vehicle Name and Count is updated properly
    And I click on the price breakdown link
    And I get the vehicle name in the vehicle page
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle name in ride summary page
    And I click on modify vehicle link in the Ride summary page
    And I modify the vehicle in the vehicle page
    And I click on the price breakdown link
    And I get the vehicle name in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the vehicle name in ride summary page

  Scenario Outline: Verify Vehicle count is updated for various vehicle counts
    And I click on the price breakdown link
    And I select vehicle count as <vehicle_quantity>
    And I get the vehicle name in the vehicle page
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle name in ride summary page
    Examples:
      | vehicle_quantity |
      | 3                |
      | 5                |
      | 8                |
      | 12               |

  Scenario: Verify Vehicle Brand is updated properly
    And I get the vehicle brand in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle brand in ride summary page

  Scenario: Modify Vehicle Brand is updated properly
    And I get the vehicle brand in the vehicle page
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle brand in ride summary page
    And I click on modify vehicle link in the Ride summary page
    And I modify the vehicle in the vehicle page
    And I get the vehicle brand in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the vehicle brand in ride summary page

  Scenario: Verify Vehicle Max passenger count and Luggage count is updated properly
    And I get the vehicle max luggage count in the vehicle page
    And I get the vehicle max passenger count in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle max passenger count in ride summary page
    Then Verify the vehicle max luggage in ride summary page

  Scenario: Modify Vehicle Max passenger and luggage count is updated properly
    And I get the vehicle max luggage count in the vehicle page
    And I get the vehicle max passenger count in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle max passenger count in ride summary page
    Then Verify the vehicle max luggage in ride summary page
    And I click on modify vehicle link in the Ride summary page
    And I modify the vehicle in the vehicle page
    And I get the vehicle max luggage count in the vehicle page
    And I get the vehicle max passenger count in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the vehicle max passenger count in ride summary page
    Then Verify the vehicle max luggage in ride summary page

  Scenario: Verify Vehicle image is updated properly
    And I get the vehicle image src in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle src in ride summary page

  Scenario: Modify Vehicle Image is updated properly
    And I get the vehicle image src in the vehicle page
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle src in ride summary page
    And I click on modify vehicle link in the Ride summary page
    And I modify the vehicle in the vehicle page
    And I get the vehicle image src in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the vehicle src in ride summary page

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
    Then Verify the infant count should be equal to infant count in ride summary page
    Then Verify the booster count should be equal to booster count in ride summary page
    Then Verify the child count should be equal to child count in ride summary page
    Examples:
    | infant_count    | booster_count    | child_count    |
    | 3               | 4                | 5              |
    | 1               | 2                | 3              |
    | 2               | 5                | 8              |
    | 0               | 0                | 0              |


  Scenario Outline: Modify the Child Seats Quantity are updated properly
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
    Then Verify the infant count should be equal to infant count in ride summary page
    Then Verify the booster count should be equal to booster count in ride summary page
    Then Verify the child count should be equal to child count in ride summary page
    And I click on modify vehicle link in the Ride summary page
    And I click on the price breakdown link
    And I select infant seat quantity as <infant_count_modify>
    And I select booster seat quantity as <booster_count_modify>
    And I select child seat quantity as <child_count_modify>
    And I get the infant quantity in the vehicle page
    And I get the booster quantity in the vehicle page
    And I get the child quantity in the vehicle page
    And I click on the next button in the vehicle page
    Examples:
      | infant_count | booster_count | child_count | infant_count_modify | booster_count_modify | child_count_modify |
      | 3            | 4             | 5           | 6                   | 8                    | 15                 |
      | 1            | 2             | 3           | 7                   | 12                   | 5                  |
      | 2            | 5             | 8           | 0                   | 0                    | 0                  |

  Scenario: Verify the Unchecked Child Seats Quantity  are updated properly
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the infant count should be equal "-"
    Then Verify the booster count should be equal "-"
    Then Verify the child count should be equal "-"

  Scenario: Verify Meet and Greet is displayed for Yes in the Vehicle Page
    And I click on the price breakdown link
    And I click on meet and greet checkbox
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the meet and greet is displayed in the Ride Summary Page

  Scenario: Verify Meet and Greet is Not displayed for No in the Vehicle Page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the meet and greet price should not be displayed in the Ride Summary Page

  Scenario: Modify Meet and Greet is updated properly in the vehicle page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the meet and greet price should not be displayed in the Ride Summary Page
    And I click on modify vehicle link in the Ride summary page
    And I click on the price breakdown link
    And I click on meet and greet checkbox
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the meet and greet is displayed in the Ride Summary Page


# Pricing Section

  Scenario: Verify Vehicle price is updated properly in ride summary page
    And I click on the price breakdown link
    And I get the vehicle price in PBS
    And I get the Total price in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the vehicle price is updated in Ride Summary page
    And verify the Total price is updated in Ride Summary page

  Scenario: Modify Vehicle price is updated properly in ride summary page
    And I click on the price breakdown link
    And I get the vehicle price in PBS
    And I get the Total price in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the vehicle price is updated in Ride Summary page
    And verify the Total price is updated in Ride Summary page
    When I click on modify vehicle link in the Ride summary page
    And I modify the vehicle in the vehicle page
    And I click on the price breakdown link
    And I get the vehicle price in PBS
    And I get the Total price in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the vehicle price is updated in Ride Summary page
    And verify the Total price is updated in Ride Summary page

  Scenario Outline: Verify Vehicle price for different vehicle count is updated properly in ride summary page
    And I click on the price breakdown link
    And I select vehicle count as <vehicle_quantity>
    And I get the vehicle price in PBS
    And I get the Total price in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the vehicle price is updated in Ride Summary page
    And verify the Total price is updated in Ride Summary page
    Examples:
      | vehicle_quantity |
      | 3                |
      | 6                |
      | 4                |
      | 7                |
      | 10               |
      | 1                |


  Scenario: Verify Meet and Greet Price is updated properly in Ride Summary page
    And I click on the price breakdown link
    And I click on meet and greet checkbox
    And I get the meet and greet price in vehicle page
    And I get the Total price in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    And Verify the meet and greet price in the Ride Summary Page
    And verify the Total price is updated in Ride Summary page

  Scenario: Modify Meet and Greet Price is updated properly in Ride Summary page
    And I click on the price breakdown link
    And I click on meet and greet checkbox
    And I get the meet and greet price in vehicle page
    And I get the Total price in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    And Verify the meet and greet price in the Ride Summary Page
    And verify the Total price is updated in Ride Summary page
    And I click on modify vehicle link in the Ride summary page
    And I modify the vehicle in the vehicle page
    And I click on the price breakdown link
    And I click on meet and greet checkbox
    And I get the meet and greet price in vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    And verify the Total price is updated in Ride Summary page
@1
  Scenario: Verify Meet and Greet Price is Not displayed when no meet and greet in Ride Summary page
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    And Verify the meet and greet price is not displayed in the Ride Summary Page

  Scenario Outline: Verify Child Seats price is updated properly in Ride Summary page
    And I click on the price breakdown link
    And I click on child seat checkbox
    And I select infant seat quantity as <infant_seat_quantity>
    And I select booster seat quantity as <booster_seat_quantity>
    And I select child seat quantity as <child_seat_quantity>
    And I get the infant seat price in vehicle page
    And I get the booster seat price in vehicle page
    And I get the Child seat price in vehicle page
    And I get the Total price in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    And Verify the Infant price in the Ride Summary Page
    And Verify the Booster price in the Ride Summary Page
    And Verify the Child price in the Ride Summary Page
    And verify the Total price is updated in Ride Summary page
    Examples:
      | infant_seat_quantity | booster_seat_quantity | child_seat_quantity |
      | 2                    | 4                     | 5                   |
      | 1                    | 2                     | 3                   |
      | 10                   | 12                    | 25                  |


  Scenario Outline: Modify Child Seats price is updated properly in Ride Summary page
    And I click on the price breakdown link
    And I click on child seat checkbox
    And I select infant seat quantity as <infant_seat_quantity>
    And I select booster seat quantity as <booster_seat_quantity>
    And I select child seat quantity as <child_seat_quantity>
    And I get the infant seat price in vehicle page
    And I get the booster seat price in vehicle page
    And I get the Child seat price in vehicle page
    And I get the Total price in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    And Verify the Infant price in the Ride Summary Page
    And Verify the Booster price in the Ride Summary Page
    And Verify the Child price in the Ride Summary Page
    And verify the Total price is updated in Ride Summary page
    Then I click on modify vehicle link in the Ride summary page
    And I modify the vehicle in the vehicle page
    And I click on the price breakdown link
    And I select infant seat quantity as <infant_seat_modify_quantity>
    And I select booster seat quantity as <booster_seat_modify_quantity>
    And I select child seat quantity as <child_seat_modify_quantity>
    And I get the infant seat price in vehicle page
    And I get the booster seat price in vehicle page
    And I get the Child seat price in vehicle page
    And I get the Total price in the vehicle page
    And I click on the next button in the vehicle page
    And I switch to frame
    And Verify the Infant price in the Ride Summary Page
    And Verify the Booster price in the Ride Summary Page
    And Verify the Child price in the Ride Summary Page
    And verify the Total price is updated in Ride Summary page
    Examples:
      | infant_seat_quantity | booster_seat_quantity | child_seat_quantity | infant_seat_modify_quantity | booster_seat_modify_quantity| child_seat_modify_quantity|
      | 2                    | 4                     | 5                   | 8                           | 12                          | 18                        |
      | 1                    | 2                     | 3                   | 5                           | 8                           | 9                         |
      | 10                   | 12                    | 25                  | 6                           | 15                          | 12                        |









  Scenario: Verify Vehicle Modified Information is updated
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
    And I get the vehicle brand in the vehicle page
    And I get the vehicle max passenger count in the vehicle page
    And I get the vehicle max luggage count in the vehicle page
    And I get the vehicle image src in the vehicle page
    And I click on the price breakdown link
    And I get the vehicle name in the vehicle page
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle name in ride summary page
#    Then Verify the vehicle brand in ride summary page
    Then Verify the vehicle max passenger count in ride summary page
    Then Verify the vehicle max luggage in ride summary page
    Then Verify the vehicle src in ride summary page
    And I click on modify vehicle link in the Ride summary page
    And I modify the vehicle in the vehicle page
    And I get the vehicle brand in the vehicle page
    And I get the vehicle max passenger count in the vehicle page
    And I get the vehicle max luggage count in the vehicle page
    And I get the vehicle image src in the vehicle page
    And I click on the price breakdown link
    And I get the vehicle name in the vehicle page
    And I click on the next button in the vehicle page
    Then I switch to frame
    Then Verify the vehicle name in ride summary page
#    Then Verify the vehicle brand in ride summary page
    Then Verify the vehicle max passenger count in ride summary page
    Then Verify the vehicle max luggage in ride summary page
    Then Verify the vehicle src in ride summary page



#    Verify the Meet and greet Information

  Scenario: Verify Meet and Greet is displayed for Yes in the Vehicle Page
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
    And I click on the price breakdown link
    And I click on meet and greet checkbox
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the meet and greet is displayed in the Ride Summary Page


  Scenario: Verify Meet and Greet is Not displayed for No in the Vehicle Page
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
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the meet and greet price should not be displayed in the Ride Summary Page


  Scenario: Verify Modify Meet and Greet is displayed for Yes in the vehicle page
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
    And I click on the price breakdown link
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the meet and greet price should not be displayed in the Ride Summary Page
    And I click on modify vehicle link in the Ride summary page
    And I click on the price breakdown link
    And I click on meet and greet checkbox
    And I click on the next button in the vehicle page
    And I switch to frame
    Then Verify the meet and greet is displayed in the Ride Summary Page



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




