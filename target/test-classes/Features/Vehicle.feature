Feature: Verify The functionalities of Vehicle page

  Background: This will run before all scenarios
    Given I open bus bound url
    When I switch to frame


  Scenario: Verify itinerary information for One-way trip with only 2 locations (Without Stops).
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
    And Verify the Itinerary Location Information in the vehicle page
    And Verify the Itinerary Time Information in the vehicle page
    And verify the Show All Itineraries link is not displayed


  Scenario: Verify itinerary information for One-way trip with more than 2 locations (multiple stops without itineraries).
    When the user adds 2 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 |  Value 4        | Value 5 |
      | Location    | SFO        | San Jose, CA, USA       |  San Cruz, USA  | Santa Rosa, CA, USA|
      | Day         | 1          | 1                       |  1              |         |
      | Month       | October    | October                 |  October        |         |
      | Year        | 2024       | 2024                    |  2024           |         |
      | Hour        | 08         | 12                      |  08             |         |
      | Minute      | 30         | 12                      |  30             |         |
      | Period      | AM         | PM                      |  PM             |         |
    When I click on next button in itinerary page
    And Verify the Itinerary Location Information in the vehicle page
    And Verify the Itinerary Time Information in the vehicle page
    And Verify "Show all itineraries" is displayed for more than two locations
    And I click on the Show all Itineraries link
    Then Verify the Ride dates with actual dates in vehicle page
    And Verify the Ride dates for each days in vehicle page
    And Verify the Ride Time for each days in vehicle page
    And Verify the Ride locations for each days in vehicle page

  Scenario: Verify itinerary information for One-way trip with more than 2 locations (multiple stops with itineraries).
    When the user adds 2 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 |  Value 4        | Value 5 |
      | Location    | SFO        | San Jose, CA, USA       |  San Cruz, USA  | Santa Rosa, CA, USA|
      | Day         | 1          | 2                       |  3              |         |
      | Month       | October    | October                 |  October        |         |
      | Year        | 2024       | 2024                    |  2024           |         |
      | Hour        | 08         | 12                      |  08             |         |
      | Minute      | 30         | 12                      |  30             |         |
      | Period      | AM         | PM                      |  PM             |         |
    When I click on next button in itinerary page
    And Verify the Itinerary Location Information in the vehicle page
    And Verify the Itinerary Time Information in the vehicle page
    And Verify "Show all itineraries" is displayed for more than two locations
    And I click on the Show all Itineraries link
    Then Verify the Ride dates with actual dates in vehicle page
    And Verify the Ride dates for each days in vehicle page
    And Verify the Ride Time for each days in vehicle page

  Scenario: Verify Itinerary list for Round Trip trip with only 2 locations.
    Given I click on Round trip Radio button
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 | Value 5 |
      | Location    | SFO        | San Jose, CA, USA       |  SFO     |
      | Day         | 1          | 2                       |          |
      | Month       | October    | October                 |          |
      | Year        | 2024       | 2024                    |          |
      | Hour        | 08         | 12                      |          |
      | Minute      | 30         | 12                      |          |
      | Period      | AM         | PM                      |          |
    When I click on next button in itinerary page
    And Verify the Itinerary Location Information in the vehicle page
    And Verify the Itinerary Time Information in the vehicle page
    And verify the Show All Itineraries link is not displayed


  Scenario: Verify Itinerary list for Round Trip trip with more than 2 locations.
    Given I click on Round trip Radio button
    And the user adds 1 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 | Value 5              | Value 4 |
      | Location    | SFO        | San Jose, CA, USA       |  Santa cruz, USA     | SFO     |
      | Day         | 1          | 2                       |  3                   |         |
      | Month       | October    | October                 | October              |         |
      | Year        | 2024       | 2024                    | 2024                 |         |
      | Hour        | 08         | 12                      | 05                   |         |
      | Minute      | 30         | 12                      | 25                   |         |
      | Period      | AM         | PM                      | AM                   |         |
    When I click on next button in itinerary page
    And Verify the Itinerary Location Information in the vehicle page
    And Verify the Itinerary Time Information in the vehicle page
    And verify the Show All Itineraries link is displayed
    And I click on the Show all Itineraries link
    Then Verify the Ride dates with actual dates in vehicle page
    And Verify the Ride dates for each days in vehicle page
    And Verify the Ride Time for each days in vehicle page


  Scenario: Verify "Show all itineraries" functionality for Round trip with more than 2 locations.
    Given I click on Round trip Radio button
    When the user adds 1 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 | Value 5              | Value 4 |
      | Location    | SFO        | San Jose, CA, USA       |  Santa cruz, USA     | SFO     |
      | Day         | 1          | 2                       |  3                   |         |
      | Month       | October    | October                 | October              |         |
      | Year        | 2024       | 2024                    | 2024                 |         |
      | Hour        | 08         | 12                      | 05                   |         |
      | Minute      | 30         | 12                      | 25                   |         |
      | Period      | AM         | PM                      | AM                   |         |
    When I click on next button in itinerary page
    And Verify the Itinerary Location Information in the vehicle page
    And Verify the Itinerary Time Information in the vehicle page
    And Verify "Show all itineraries" is displayed for more than two locations
    And I click on the Show all Itineraries link
    And Verify "Show all itineraries" is changed to "Hide itineraries" after clicking the Show All Itineraries link

#  Edit Itinerary


#  Show All Itineraries Functionality
  Scenario: Verify "Show all itineraries" functionality for One-way trip with more than 2 locations.
    When the user adds 2 stops
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 2                 |  Value 4        | Value 5 |
      | Location    | SFO        | San Jose, CA, USA       |  San Cruz, USA  | Santa Rosa, CA, USA     |
      | Day         | 1          | 1                       |  1              |         |
      | Month       | October    | October                 |  October        |         |
      | Year        | 2024       | 2024                    |  2024           |         |
      | Hour        | 08         | 12                      |  08             |         |
      | Minute      | 30         | 12                      |  30             |         |
      | Period      | AM         | PM                      |  PM             |         |
    When I click on next button in itinerary page
    And Verify the Itinerary Location Information in the vehicle page
    And Verify the Itinerary Time Information in the vehicle page
    And Verify "Show all itineraries" is displayed for more than two locations
    And I click on the Show all Itineraries link
    And Verify "Show all itineraries" is changed to "Hide itineraries" after clicking the Show All Itineraries link

#  Verification for Payment breakdown
  Scenario: Verify the vehicle price is updated in price breakdown section
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
    When I select the vehicle in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the price breakdown link
    Then Verify vehicle price should be updated in vehicle pricedown section
    Then Verify the Total price is updated properly in vehicle price break down section


  Scenario Outline: Verify the vehicle price is updated in price breakdown section
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
    When I select the vehicle in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the price breakdown link
    And I select vehicle count as <vehicle_quantity>
    Then Verify vehicle price for <vehicle_quantity> should be updated in vehicle pricedown section
    Then Verify the Total price is updated properly in vehicle price break down section
    Examples:
    | vehicle_quantity |
    | 3                |
    | 6                |
    | 4                |
    | 7                |
    | 10               |
    | 1                |


  Scenario: Verify the Meet and Greet is 0 in price breakdown section
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
    When I select the vehicle in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the price breakdown link
    Then Verify the meet and greet price is "0.00" when its not selected
    Then Verify the Total price is updated properly in vehicle price break down section


  Scenario: Verify the Meet and Greet is updated in price breakdown section
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
    When I select the vehicle in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the price breakdown link
    Then Verify the meet and greet price is "0.00" when its not selected
    And I click on meet and greet checkbox
    Then Verify the meet and greet price should be updated when its selected
    Then Verify the Total price is updated properly in vehicle price break down section


  Scenario: Verify the Meet and Greet is updated after unchecked it in price breakdown section
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
    When I select the vehicle in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the price breakdown link
    Then Verify the meet and greet price is "0.00" when its not selected
    And I click on meet and greet checkbox
    Then Verify the meet and greet price should be updated when its selected
    Then Verify the Total price is updated properly in vehicle price break down section
    And I click on meet and greet checkbox
    Then Verify the meet and greet price is "0.00" when its not selected
    Then Verify the Total price is updated properly in vehicle price break down section


  Scenario: Verify the Child Seats price is 0 in price breakdown section
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
    When I select the vehicle in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the price breakdown link
    Then Verify the child seat price is "0.00" when its not selected
    Then Verify the Total price is updated properly in vehicle price break down section


  Scenario Outline: Verify the Child Seat Price is updated in price breakdown section
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
    When I select the vehicle in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the price breakdown link
    Then Verify the child seat price is "0.00" when its not selected
    And I click on child seat checkbox
    And I select infant seat quantity as <infant_seat_quantity>
    And I select booster seat quantity as <booster_seat_quantity>
    And I select child seat quantity as <child_seat_quantity>
    Then Verify the child seats price should be updated when its selected
    Then Verify the Total price is updated properly in vehicle price break down section
    Examples:
      | infant_seat_quantity | booster_seat_quantity | child_seat_quantity |
      | 2                    | 4                     | 5                   |
      | 1                    | 2                     | 3                   |
      | 10                   | 12                    | 25                  |


  Scenario Outline: Verify the Child Seat Price is updated for 0 quantity in price breakdown section
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
    When I select the vehicle in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the price breakdown link
    Then Verify the meet and greet price is "0.00" when its not selected
    And I click on child seat checkbox
    And I select infant seat quantity as <infant_seat_quantity>
    And I select booster seat quantity as <booster_seat_quantity>
    And I select child seat quantity as <child_seat_quantity>
    Then Verify the child seats price should be updated when its selected
    Then Verify the Total price is updated properly in vehicle price break down section
    And I select infant seat quantity as 0
    And I select booster seat quantity as 0
    And I select child seat quantity as 0
    Then Verify the meet and greet price is "0.00" when its not selected
    Then Verify the Total price is updated properly in vehicle price break down section
    Examples:
      | infant_seat_quantity | booster_seat_quantity | child_seat_quantity |
      | 2                    | 4                     | 5                   |


  Scenario Outline: Verify the Child Seat Price is updated after unchecked it in price breakdown section
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
    When I select the vehicle in the vehicle page
    And I get the vehicle price in the vehicle page
    And I click on the price breakdown link
    Then Verify the meet and greet price is "0.00" when its not selected
    And I click on child seat checkbox
    And I select infant seat quantity as <infant_seat_quantity>
    And I select booster seat quantity as <booster_seat_quantity>
    And I select child seat quantity as <child_seat_quantity>
    Then Verify the child seats price should be updated when its selected
    Then Verify the Total price is updated properly in vehicle price break down section
    When I click on child seat checkbox
    Then Verify the child seat price is "0.00" when its not selected
    Then Verify the Total price is updated properly in vehicle price break down section
    Examples:
      | infant_seat_quantity | booster_seat_quantity | child_seat_quantity |
      | 2                    | 4                     | 5                   |


  #Vehicle Section
  Scenario: Verify Vehicle are in ascending order of price
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
    Then Verify the all vehicles are displayed in the price ascending order

  Scenario: Verify the Vehicles images are uploaded properly
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
    Then Verify the all images are displayed in the vehicle page


  Scenario Outline: Verify that the seating capacity filter works correctly
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
    And I click on the All check box
    When the user applies the seating capacity filter for "<capacity>"
    When I click on apply button in the vehicle page
    Then only vehicles with seating capacity <expectedMinCapacity> to <expectedMaxCapacity> are displayed
    Examples:
      | capacity      | expectedMinCapacity | expectedMaxCapacity |
      | 8-15 Seats    | 8                   | 15                  |
      | 16-36 Seats   | 16                  | 36                  |
      | 37 + Seats    | 37                  | 100                 |


  Scenario: Verify that the seating capacity filter works correctly for combinations
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
    And I click on the All check box
    When the user applies the seating capacity filter for "8-15 Seats"
    When the user applies the seating capacity filter for "16-36 Seats"
    When I click on apply button in the vehicle page
    Then only vehicles with seating capacity 8 to 36 are displayed
    And I click on the clear all filter link
    And I click on the All check box
    When the user applies the seating capacity filter for "16-36 Seats"
    When the user applies the seating capacity filter for "37 + Seats"
    When I click on apply button in the vehicle page
    Then only vehicles with seating capacity 16 to 100 are displayed
    And I click on the clear all filter link
    And I click on the All check box
    When the user applies the seating capacity filter for "8-15 Seats"
    When the user applies the seating capacity filter for "37 + Seats"
    When I click on apply button in the vehicle page
    Then only vehicles with seating capacity 8 to 100 are displayed

  Scenario: Verify error message for no vehicles available for expected filter works correctly
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
    And I click on the clear all filter link
    And I click on the All check box
    Then Verify the error message for no vehicle available for expected filter

  Scenario Outline: Verify that the Price filter works correctly
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
    And I click on the All check box
    And the user enters a minimum price "<minPrice>"
    And the user enters a maximum price "<maxPrice>"
    When I click on apply button in the vehicle page
    Then only vehicles with price between <minPrice> to <maxPrice> are displayed
    Examples:
      | minPrice            | maxPrice            |
      | 0                   | 500                 |
      | 501                 | 1000                |
      | 1001                | 5000                |

  # Both price and seat filter
  Scenario Outline: Apply filters for seating capacity and price range
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
    And I click on the All check box
    When the user applies the seating capacity filter for "<seatingCapacity>"
    And the user enters a minimum price "<minPrice>"
    And the user enters a maximum price "<maxPrice>"
    When I click on apply button in the vehicle page
    Then only vehicles with seating capacity <expectedMinCapacity> to <expectedMaxCapacity> are displayed
    Then only vehicles with price between <minPrice> to <maxPrice> are displayed

    Examples:
      | seatingCapacity  | minPrice | maxPrice  | expectedMinCapacity | expectedMaxCapacity |
      | All              | 0        | 100       | 8                   | 100                 |
      | All              | 101      | 500       | 8                   | 100                 |
      | All              | 501      | 1000      | 8                   | 100                 |
      | All              | 1001     | 5000      | 8                   | 100                 |
      | All              | 5001     | 10000000  | 8                   | 100                 |
      | 8-15 Seats       | 0        | 100       | 8                   | 15                  |
      | 8-15 Seats       | 101      | 500       | 8                   | 15                  |
      | 8-15 Seats       | 501      | 1000      | 8                   | 15                  |
      | 8-15 Seats       | 1001     | 5000      | 8                   | 15                  |
      | 8-15 Seats       | 5001     | 10000000  | 8                   | 15                  |
      | 16-36 Seats      | 0        | 100       | 16                  | 36                  |
      | 16-36 Seats      | 101      | 500       | 16                  | 36                  |
      | 16-36 Seats      | 501      | 1000      | 16                  | 36                  |
      | 16-36 Seats      | 1001     | 5000      | 16                  | 36                  |
      | 16-36 Seats      | 5001     | 10000000  | 16                  | 36                  |
      | 37 + Seats        | 0        | 100       | 37                  | 100                 |
      | 37 + Seats        | 101      | 500       | 37                  | 100                 |
      | 37 + Seats        | 501      | 1000      | 37                  | 100                 |
      | 37 + Seats        | 1001     | 5000      | 37                  | 100                 |
      | 37 + Seats        | 5001     | 10000000  | 37                  | 100                 |


















#  Scenario: Verify that the user can edit the itinerary.
#
#  Scenario: Verify the "Show all itineraries" link functionality.
#
#  Scenario: Verify the functionality of vehicle class filters.
#
#  Scenario: Verify that the seating capacity filter works correctly.
#
#  Scenario: Verify that the price filter works correctly.
#
#  Scenario: Verify that the "Clear all filters" button resets the filter values.
#
#  Scenario: Verify that no vehicles are displayed when the filters match no vehicles.
#
#  Scenario: Verify that the "View Details" link in "Cancellation Policy" works.
#
#  Scenario: Verify the minimum and maximum price filter boundary conditions.
#
#  Scenario: Verify the default state of filters when first landing on the page.
#
#  Scenario: Verify that the filters persist after page refresh.
#
#
#
#  Scenario: Verify that the correct prices are displayed for different vehicle classes.
#
#  Scenario: Verify that clicking on vehicle class tabs updates vehicle options dynamically.
#
#  Scenario: Verify the behavior when there is only one itinerary and the "Show all itineraries" link.
#
#  Scenario: Verify that the price range filter displays an error message for invalid inputs.
#
#  Scenario: Verify that the itinerary section shows the correct source and destination.
#
#  Scenario: Verify that clicking the "Edit" button allows users to edit the itinerary details.
#
#  Scenario: Verify that vehicles are sorted by price in ascending order.
#
#  Scenario: Verify error handling when no itineraries are available.
#
#  Scenario: Verify the responsiveness of the "Choose a Vehicle" page on different screen sizes.
#
#  Scenario: Verify that the system handles large price ranges in the filter.
#
#  Scenario: Verify the behavior of the "Clear all filters" button when no filters are applied.
#
#  Scenario: Verify the default selection of vehicle classes when landing on the page.
#
#
