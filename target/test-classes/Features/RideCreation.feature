Feature: Verify The functionalities of One way ride

  Background: This will run before all scenarios
    Given I open bus bound url
    When I switch to frame
@1
  Scenario Outline: Verify Create ride with all fields
    Given I set passenger count as "<Passenger count>"
    When I set luggage count as "<Luggage count>"
    And I click on event type
    And User selects the event type as "<Event Type>"
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
#    When I enter the following details into the form
#      | Field                 | Values                       |
#      | Name                  | Test                         |
#      | Salutation            |                              |
#      | Email                 | sugapriya@elifeTransfer.com  |
#      | Phone Number 1 Code   | +91                          |
#      | Phone Number 1        | 9750359643                   |
#      | Phone Number 2 Code   |                           |
#      | Phone Number 2        |                    |
#      | Social Media          |                      |
#      | Social Media Name     |                         |
#    Then I click on next button in contact page
    And I select the vehicle in the vehicle page
    And I get the vehicle info in the vehicle page
    And I click on the next button in the vehicle page
#    Then I click on the next button in the additional info page
    Then Verify the Ride dates with actual dates
    And Verify the Ride dates for each days
    And Verify the Ride Time for each days
    And Verify the Ride locations for each days
    And Verify the vehicle information in ride summary page
    And Verify the Contact information in ride summary page
    And I click on the payment link
    Then I do the payment
    Examples:
    | Passenger count | Luggage count | Event Type |
    | 10              | 25            | Wedding    |

  Scenario: Create one way ride without stops
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
    Then Verify the Ride dates with actual dates
    And Verify the Ride dates for each days
    And Verify the Ride Time for each days
#    And I click on the payment link
#    Then I do the payment
#    And Verify the More link is displayed in Ride confirmation page


  Scenario: Create one way ride with multiple stops without itineraries
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
    Then Verify the Ride dates with actual dates
    And Verify the Ride dates for each days
    And Verify the Ride Time for each days


  Scenario: Create one way ride with multiple stops with itineraries
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
    Then Verify the Ride dates with actual dates
    And Verify the Ride dates for each days
    And Verify the Ride Time for each days

  Scenario: Verify contact form is displayed when the vehicle is not available
    Given I set passenger count as "25"
    When I set luggage count as "18"
    And I click on event type
    And User selects the event type as "Wedding"
    When the user enters the trip details into the input fields
      | Field       | Value 1    | Value 4 |
      | Location    | Chennai International Airport, Chennai        | Chennai, Tamil Nadu, India     |
      | Day         | 23         |                         |
      | Month       | 10         |                         |
      | Year        | 2024       |                         |
      | Hour        | 08         |                         |
      | Minute      | 30         |                         |
      | Period      | AM         |                         |
    And I click on next button in itinerary page













