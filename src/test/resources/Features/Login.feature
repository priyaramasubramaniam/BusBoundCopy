Feature: Verify The functionalities Login
  Background: This will click on my ride link
    Given I open bus bound url
    Given I click on my ride link

  Scenario: Verify the login with Existing Number
    Given I click on my ride link from the dropdown
    Given I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the User is redirected to my rides list page
  @1
  Scenario: Verify the login with Non Existing Number
    Given I click on my ride link from the dropdown
    Given I select country code as "+91"
    When I enter cell number as "8825884999"
    And I click on Get Verification Code Link
    Then Verify the No Rides found pop up window is displayed
    Then Verify the No Rides found pop up window Title and Description as "No ride order found" and "Sorry, you haven’t book a ride with us. Ride with BusBound Now!"

  Scenario: Verify the login with Non Existing number, The Price quote btn is redirects to quotes page
    Given I click on my ride link from the dropdown
    Given I select country code as "+91"
    When I enter cell number as "8825884999"
    And I click on Get Verification Code Link
    Then Verify the No Rides found pop up window is displayed
    Then I click on Get a price Quote button in the pop up
    And Verify the page is redirect to price quote page and verify the url as "https://busbound.com/quotes/"

  Scenario: Verify the login with Non Existing number, The close button closes the pop up
    Given I click on my ride link from the dropdown
    Given I select country code as "+91"
    When I enter cell number as "8825884999"
    And I click on Get Verification Code Link
    Then Verify the No Rides found pop up window is displayed
    And Verify the pop up is closed when clicking on close button

  Scenario: Verify the login with invalid verification code
    Given I click on my ride link from the dropdown
    Given I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    Then Verify the error message "Incorrect SMS code, please try again."

  Scenario: Verify the login without click on service checkbox
    Given I click on my ride link from the dropdown
    Given I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    Then I click on Login button
    Then Verify the error message "Please check the box if you want to proceed."

  Scenario: Verify the privacy policy and service policy redirects to right pages
    Given I click on my ride link from the dropdown
    Given I click on the privacy policy link
    Then I verify the url "https://busbound.com/privacy-policy/"
    And I click on the service agreement link
    And I verify the url "https://busbound.com/terms-and-conditions/"

  Scenario: Verify the Logout is displayed after successful login
    Given I click on my ride link from the dropdown
    Given I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the User is redirected to my rides list page
    And I click on my ride link
    Then Verify the logout button is displayed

  Scenario: Verify the Logout is working
    Given I click on my ride link from the dropdown
    Given I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the User is redirected to my rides list page
    And I click on my ride link
    Then Verify the logout button is displayed
    Then I click on the logout link

  Scenario: Verify the My ride dropdown after login
    Given I click on my ride link from the dropdown
    Given I select country code as "+91"
    When I enter cell number as "9750359643"
    And I click on Get Verification Code Link
    And I click on Service agreement checkbox
    Then I click on Login button
    And Verify the User is redirected to my rides list page
    And I click on my ride link
    Then Verify the dropdown values as "My Rides, Logout"
