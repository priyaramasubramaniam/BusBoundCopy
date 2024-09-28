Feature: Verify the Home Page

  Scenario: Verify the title of the home page
    Given I open bus bound url
    And I switch to frame
    Then I verify the title of the home page "Instant, Reliable, Affordable Charter Bus"

  Scenario: Verify the sub title of the home page
    Given I open bus bound url
    And I switch to frame
    Then I verify the sub title of the home page "Call us at +1 (800) 814-4204 or email customerservice@busbound.com"
@1
  Scenario: Verify By clicking on the "Add Multiple Stops" redirects to right page
    Given I open bus bound url
    And I switch to frame
    When I click on the "Add Multiple Stops" link
    Then I verify the url of the page "https://elifetransfer.s3.us-east-2.amazonaws.com/dev/busbound/quotes/index.html#location=itinary"
