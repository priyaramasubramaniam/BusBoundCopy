Feature: Verify The functionalities of Additional Info Page

  Background: This will run before all scenarios
    Given I open bus bound url
    And I switch to frame
    Given I set passenger count as "50"
    When I set luggage count as "25"
    And I click on event type
    And I click on event type
    When the user enters the trip details into the input fields
    | Field       | Value 1    | Value 2    |
    | Location    | SFO        | San Jose   |
    | Day         | 23         |            |
    | Month       | 09         |            |
    | Year        | 2024       |            |
    | Hour        | 08         |            |
    | Minute      | 30         |            |
    | Period      | AM         |            |
    And I click on next button in itinerary page
    When I enter the following details into the form
    | Field                 | Values                       |
    | Name                  | Test                         |
    | Salutation            |  Mr                         |
    | Email                 | sugapriya@elifeTransfer.com  |
    | Phone Number 1 Code   | +91                          |
    | Phone Number 1        | 9750359643                   |
    | Phone Number 2 Code   | +91                          |
    | Phone Number 2        | 9843698673                   |
    | Social Media          | facebook                     |
    | Social Media Name     | TEST                         |
    Then I click on next button in contact page
    And I select the vehicle in the vehicle page
    Then I click on the next button in the vehicle page

  Scenario: Verify the all text in additional info page
    Given Verify "Do you need other services?" title should be present in the Additional Info Page
    Then Verify "We can provide some of these special services." sub title present in the additional info page
#    And Verify "Would you like to add a Meet & Greet sign for" Meet and Greet title present in the additional info page
    And Verify "Do you need a child seat?" Child Seat title present in the additional info page
    And Verify "Special Instructions (Optional)" Special Instructions title present in the additional info page

  Scenario: Verify the all text in additional info page when i click on yes
    Given I click "Meet and Greet" yes radio button
    Then Verify "Input Text Area" is displayed
    And I click "Child seat" yes radio button
    Then Verify "Child seat options" is displayed
    Then Verify "Special Instruction Text Area" is displayed

@1
  Scenario Outline: Add Meet & Greet and Child Seat options
    Given I select "<meetAndGreetOption>" for the Meet & Greet sign
    And I select "<childSeatOption>" for the child seat
    And I set the quantity "<infantSeat>" for the Infant Seat
    And I set the quantity "<boosterSeat>" for the Booster Seat
    And I set the quantity "<childSeat>" for the Child Seat
    Then I get the price of the infant seat
    Then I get the price of the booster seat
    Then I get the price of the child seat seat
    Then I get the price of the meet and greet

    Examples:
      | meetAndGreetOption | childSeatOption | infantSeat | boosterSeat | childSeat |
#      | No                 | No              | 0          | 0           | 0         |
      | Yes                | Yes             | 2          | 3           | 3         |
#      | Yes                | No              | 0          | 0           | 0         |
#      | No                 | Yes             | 2          | 1           | 1         |




