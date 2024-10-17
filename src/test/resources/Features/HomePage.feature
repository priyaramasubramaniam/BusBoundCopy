Feature: Verify the Home Page

  Scenario: Verify the title of the home page
    Given I open bus bound url
    And I switch to frame
    Then I verify the title of the home page "Instant, Reliable, Affordable Charter Bus"

  Scenario: Verify the sub title of the home page
    Given I open bus bound url
    And I switch to frame
    Then I verify the sub title of the home page "Call us at +1 (800) 814-4204 or email customerservice@busbound.com"


  Scenario: Verify By clicking on the "Add Multiple Stops" redirects to right page
    Given I open bus bound url
    And I switch to frame
    When I click on the "Add Multiple Stops" link
    Then I verify the url of the page "https://elifetransfer.s3.us-east-2.amazonaws.com/dev/busbound/quotes/index.html#location=itinary"
@1
  Scenario: Book One Way Ride
    Given I open bus bound url
    And I switch to frame
    When I enter pickup location as "SFO" in home page
    And I enter Dropoff location as "San Jose" in home page
    And I select pickup Month and Year as "October 2024" in home page
    And I select pickup Date as "23" in home page
    And I select pickup Hour as "08" in home page
    And I select pickup Minute as "08" in home page
    And I select pickup Period as "AM" in home page
    And I select event type in home page
    And I click on Get a price Quote button
    Then Verify the page is redirects to vehicle page and verify url "https://elifetransfer.s3.us-east-2.amazonaws.com/dev/busbound/quotes/index.html#location=vehicle"
    And Verify the Homepage Location Information in the vehicle page
    And Verify the HomePage Time Information in the vehicle page
    And verify the Show All Itineraries link is not displayed

