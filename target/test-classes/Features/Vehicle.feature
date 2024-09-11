Feature: Verify The functionalities of Vehicle page

  Background: This will run before all scenarios
    Given I open bus bound url
    And I click on event type
    And User selects the event type
    And I enter pickup location as "SFO"
    And I select pickup location
    And I select pickup date "October 9,2024"
    And I enter pickup time "10:00 AM"
    And I enter Drop off location as "San Jose"
    And I select Dropoff location

  Scenario Outline: Verify the Maximum passengers is correctly updated in Vehicle page
    Given I set passenger count as "<Passenger Count>"
    Then I set luggage count as "<Luggage Count>"
    When I click on next button in itinerary page
    And I enter customer name as "TEST"
    And I select customer salutation
    And I enter customer email as "test@elife.com"
    And I select customer cell number one
    And I enter customer cell number one as "9750359643"
    And I select customer cell number two
    And I enter customer cell number two as "545454545"
    And I select social media
    And I enter social media as "TEST SOCIAL MEDIA"
    Then I click on next button in contact page
    When I click on the "Recommended" vehicle class link
    Then Verify the maximum passenger capacity count in "Recommended" is greater than the <Passenger Count>
    Then Verify the maximum luggage capacity count is in "Recommended" greater than the <Luggage Count>
    When I click on the "Buses" vehicle class link
    Then Verify the maximum passenger capacity count in "Buses" is greater than the <Passenger Count>
    Then Verify the maximum luggage capacity count is in "Buses" greater than the <Luggage Count>
    When I click on the "Limo" vehicle class link
    Then Verify the maximum passenger capacity count in "Limo" is greater than the <Passenger Count>
    Then Verify the maximum luggage capacity count is in "Limo" greater than the <Luggage Count>
    When I click on the "Minibus" vehicle class link
    Then Verify the maximum passenger capacity count in "Minibus" is greater than the <Passenger Count>
    Then Verify the maximum luggage capacity count is in "Minibus" greater than the <Luggage Count>
    Examples:
    | Passenger Count | Luggage Count |
    | 70 | 35                         |

  Scenario Outline: Verify the Vehicles group are in price ascending order
    Given I set passenger count as "<Passenger Count>"
    Then I set luggage count as "<Luggage Count>"
    When I click on next button in itinerary page
    And I enter customer name as "TEST"
    And I select customer salutation
    And I enter customer email as "test@elife.com"
    And I select customer cell number one
    And I enter customer cell number one as "9750359643"
    And I select customer cell number two
    And I enter customer cell number two as "545454545"
    And I select social media
    And I enter social media as "TEST SOCIAL MEDIA"
    Then I click on next button in contact page
    When I click on the "Recommended" vehicle class link
    Then Verify the "Recommended" section vehicles are in price ascending order
    When I click on the "Buses" vehicle class link
    Then Verify the "Buses" section vehicles are in price ascending order
    When I click on the "Limo" vehicle class link
    Then Verify the "Limo" section vehicles are in price ascending order
    When I click on the "Minibus" vehicle class link
    Then Verify the "Minibus" section vehicles are in price ascending order
    Examples:
      | Passenger Count | Luggage Count |
      | 70 | 35                         |


  Scenario Outline: Verify the Vehicles images are uploaded properly
    Given I set passenger count as "<Passenger Count>"
    Then I set luggage count as "<Luggage Count>"
    When I click on next button in itinerary page
    And I enter customer name as "TEST"
    And I select customer salutation
    And I enter customer email as "test@elife.com"
    And I select customer cell number one
    And I enter customer cell number one as "9750359643"
    And I select customer cell number two
    And I enter customer cell number two as "545454545"
    And I select social media
    And I enter social media as "TEST SOCIAL MEDIA"
    Then I click on next button in contact page
    When I click on the "Recommended" vehicle class link
    Then Verify image is uploaded in "Recommended" section
    When I click on the "Buses" vehicle class link
    Then Verify image is uploaded in "Buses" section
    When I click on the "Limo" vehicle class link
    Then Verify image is uploaded in "Buses" section
    When I click on the "Minibus" vehicle class link
    Then Verify image is uploaded in "Buses" section
    Examples:
      | Passenger Count | Luggage Count |
      | 70 | 35                         |
@1
  Scenario Outline: Verify Minimum amount is displaying in the Vehicles Class Header
    Given I set passenger count as "<Passenger Count>"
    Then I set luggage count as "<Luggage Count>"
    When I click on next button in itinerary page
    And I enter customer name as "TEST"
    And I select customer salutation
    And I enter customer email as "test@elife.com"
    And I select customer cell number one
    And I enter customer cell number one as "9750359643"
    And I select customer cell number two
    And I enter customer cell number two as "545454545"
    And I select social media
    And I enter social media as "TEST SOCIAL MEDIA"
    Then I click on next button in contact page
    When I click on the "Recommended" vehicle class link
    Then Verify the "Recommended" section header has Minimum Amount
    When I click on the "Buses" vehicle class link
    Then Verify the "Buses" section header has Minimum Amount
    When I click on the "Limo" vehicle class link
    Then Verify the "Limo" section header has Minimum Amount
    When I click on the "Minibus" vehicle class link
    Then Verify the "Minibus" section header has Minimum Amount
    Examples:
      | Passenger Count | Luggage Count |
      | 70 | 35                         |


