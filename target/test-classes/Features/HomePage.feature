Feature: Verify the Home Page

  Scenario: Verify the title of the home page
    Given I open bus bound url
    And I switch to frame
    Then I verify the title of the home page "Instant, Reliable, Affordable Charter Bus"

  Scenario: Verify the sub title of the home page
    Given I open bus bound url
    And I switch to frame
    Then I verify the sub title of the home page "Call us at +1 (800) 814-4204 or email customerservice@busbound.com"