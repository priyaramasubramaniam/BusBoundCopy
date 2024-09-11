package com.Elife.StepDefinitions;

import com.Elife.PageComponent.HomePage;
import com.Elife.PageComponent.LoginPage;
import com.Elife.PageComponent.RideListPage;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;


public class LoginPageSteps {
      @Given("I select country code as {string}")
      public void iSelectCountryCodeAs(String country_code) throws InterruptedException {
            LoginPage.getInstance().selectCountryCode(country_code);
      }

      @When("I enter cell number as {string}")
      public void iEnterCellNumberAs(String cell_number) throws InterruptedException {
            LoginPage.getInstance().enterCellNumber(cell_number);
      }

      @And("I click on Get Verification Code Link")
      public void iClickOnGetVerificationCodeLink() throws InterruptedException {
            LoginPage.getInstance().clickOnGetCodeLink();
            Thread.sleep(30000);
      }

      @And("I click on Service agreement checkbox")
      public void iClickOnServiceAgreementCheckbox() {
            LoginPage.getInstance().clickOnServiceCheckbox();
      }

      @Then("I click on Login button")
      public void iClickOnLoginButton() throws InterruptedException {
            LoginPage.getInstance().clickOnLoginBtn();
            Thread.sleep(10000);
      }

      @And("Verify the User is redirected to my rides list page")
      public void verifyTheUserIsRedirectedToMyRidesListPage() {
            Assert.assertTrue(RideListPage.getInstance().getTitle().contains("Ride list"));
      }

      @Then("Verify the error message {string}")
      public void verifyTheErrorMessage(String error_msg) {
            Assert.assertEquals(error_msg, LoginPage.getInstance().getErrorMsg());
      }

      @Then("Verify the No Rides found pop up window is displayed")
      public void verifyTheNoRidesFoundPopUpWindowIsDisplayed() {
            Assert.assertTrue(LoginPage.getInstance().isPopupDisplayed());
      }

      @Then("Verify the No Rides found pop up window Title and Description as {string} and {string}")
      public void verifyTheNoRidesFoundPopUpWindowTitleAndDescriptionAsAnd(String title, String description) {
            Assert.assertEquals(title, LoginPage.getInstance().getPopupTitle());
            Assert.assertEquals(description, LoginPage.getInstance().getPopupDescription());
      }

      @Then("I click on Get a price Quote button in the pop up")
      public void iClickOnGetAPriceQuoteButtonInThePopUp() {
            LoginPage.getInstance().clickOnGetAQuoteBtn();
      }

      @And("Verify the page is redirect to price quote page and verify the url as {string}")
      public void verifyThePageIsRedirectToPriceQuotePageAndVerifyTheUrlAs(String URL) {
            Assert.assertEquals(URL, DriverManager.getDriver().getCurrentUrl());
      }

      @And("Verify the pop up is closed when clicking on close button")
      public void verifyThePopUpIsClosedWhenClickingOnCloseButton() {
            LoginPage.getInstance().clickOnPopUpCloseBtn();
            Assert.assertEquals(LoginPage.getInstance().getTitle(), "SMS Verification Login");
      }

      @Given("I click on the privacy policy link")
      public void iClickOnThePrivacyPolicyLink() {
            LoginPage.getInstance().clickOnPrivacyPolicy();
      }

      @Then("I verify the url {string}")
      public void iVerifyTheUrl(String URL) {
            Assert.assertEquals(URL, DriverManager.getDriver().getCurrentUrl());
            DriverManager.getDriver().navigate().back();
      }

      @And("I click on the service agreement link")
      public void iClickOnTheServiceAgreementLink() {
            LoginPage.getInstance().clickOnServiceAgreement();
      }


      @Then("Verify the logout button is displayed")
      public void verifyTheLogoutButtonIsDisplayed() {
            Assert.assertTrue(HomePage.getInstance().isLogoutLinkDisplayed());
      }

      @Then("I click on the logout link")
      public void iClickOnTheLogoutLink() {
            HomePage.getInstance().clickOnLogoutLink();
            Assert.assertEquals(LoginPage.getInstance().getTitle(), "SMS Verification Login");
      }

      @Then("Verify the dropdown values as {string}")
      public void verifyTheDropdownValuesAs(String values) {
            List<String> dropdownList = Arrays.asList(values.split(", "));
            Assert.assertEquals(dropdownList, HomePage.getInstance().getMyRideListDD());
      }
}
