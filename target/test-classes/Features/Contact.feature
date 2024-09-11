Feature: Verify The functionalities of contact page

  Background: This will run before all scenarios
    Given I open bus bound url
    Given User clicks on passenger add button
    When User clicks on luggage add button
    And I click on event type
    And User selects the event type
    When the user enters the trip details into the input fields
    | Field       | Value 1    | Value 2    |
    | Location    | SFO        | San Jose   |
    | Hour        | 08         |            |
    | Minute      | 30         |            |
    | Period      | AM         |            |
    | Day         | 23         |            |

  Scenario: verify all fields are present in the contact page
    Given Verify the page is redirect to contact page and verify the message "How can we contact you?"
    And Verify the subtitle text "Please fill in your contact information for the driver to serve you." subtext should be present
    And Verify "Name *" name label should be present
    And Verify "Salutation" salutation label should be present
    And Verify "Email *" email label should be present
    And Verify "Phone Number 1 *" phone number one label should be present
    And Verify "Phone Number 2" phone number two label should be present
    And Verify "Social Media" social media label should be present
    And Verify "Name of the customer" name placeholder should be present in the Name input
    And Verify "Select" placeholder should be present in the Salutation dropdown
    And Verify "Email address to receive ride info" email placeholder should be present in the Email input
    And Verify "Select" placeholder should be present in the Phone Number one dropdown
    And Verify "Select" placeholder should be present in the Phone Number two dropdown
    And Verify "Select" placeholder should be present in the Social Media dropdown
    And Verify "Back" back button is present in the contact page
    And Verify "Next" next button is present in the contact page
  @1
  Scenario: Verify form submission with all valid inputs
    When I enter the following details into the form
    | Field | Values |
    | Name  | Test  |
    | Salutation  |  Mr.  |
    | Email  | sugapriya@elifeTransfer.com  |
    | Phone Number 1 Code  | +91  |
    | Phone Number 1  | 9750359643  |
    | Phone Number 2 Code  | +91  |
    | Phone Number 2   | 9843698673  |
    | Social Media   | facebook  |
    | Social Media Name | TEST  |
    Then I click on next button in contact page
    Then Verify the page is redirect to vehicle page and verify the message "Choose the right vehicle for you."

  Scenario: Verify form submission with empty required fields
    Given I click on next button in contact page without Name
    Then I verify the error message for name "Sorry, name is required"
#    And I verify the error message colour for name "red"
    When I click on next button in contact page without Email
    Then I verify the error message for email "Sorry, email is required"
#    And I verify the error message colour for email "red"
    When I click on next button in contact page without cell number one country code
    Then I verify the error message for cell number "Sorry, phone number is required"
#    And I verify the error message colour for cell number "red"


  Scenario: Verify Error message for invalid emails
    When the user enters the following invalid email addresses
      | email                   |
      | john.doe                |
      | @example.com            |
      | jane@.com.my            |
      | alice@company..com     |
      | bob@domain.com.         |
      | mike@domain,com         |
      | susan@domain@domain.com |
      | lisa.domain.com         |
      | george@domain..com      |
      | nancy@domain..com       |
      | henry@.domain.com       |
      | oliver@domain space.com |

  Scenario: Verify salutation dropdown values with expected values
#    And I click on customer salutation
    Then the salutation dropdown values should match the expected values
      | Mr |
      | Mrs |
      | Miss |
      | Other |

  Scenario: Verify dropdown values for social media
    Given Verify the social media dropodown values should match the expected values
    | facebook |
    | skype |
    | 微信 |
    | whatsapp |
    | 淘宝 |

  Scenario: Verify the back button navigates to previous page
    Given I click on Back button
    Then Verify "What is your itinerary?" title should be present

  Scenario: Verify that "Next" button and "Back" button are enabled by default
    Given Verify the Next button is enabled by default
    Then Verify the Back button is enabled by default

  Scenario: Verify form behavior on page refresh
    When I Refresh the page
    Then Verify all fields are cleared in contact form

