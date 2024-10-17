package com.Elife.StepDefinitions;

import com.Elife.PageComponent.HomePage;
import com.Elife.PageComponent.ItineraryPage;
import com.Elife.PageComponent.QuotesPage;
import com.Elife.PageComponent.VehiclePage;
import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class HomePageSteps {
      @Given("I open bus bound url")
      public void iOpenBusBoundUrl() throws IOException {
            DriverManager.getDriver().get(Utils.getGlobalValue("URL"));
      }

      @When("I switch to frame")
      public void iSwitchToFrame() throws InterruptedException {
            Thread.sleep(3000);
            DriverManager.getDriver().switchTo().frame("front-inc");
      }
      @Then("I click on Get a price Quote button")
      public void iClickOnGetAPriceQuoteButton() {
            HomePage.getInstance().clickOnPriceQuoteBtn();
      }

      @Given("I click on my ride link")
      public void iClickOnMyRideLink() throws IOException {
            HomePage.getInstance().displayHeader();
            HomePage.getInstance().clickOnMyRidesBtn();

      }
      @Given("I click on my ride link from the dropdown")
      public void iClickOnMyRideLinkFromTheDropdown() {
            HomePage.getInstance().clickOnDDMyRides();
      }


      @Given("I open ride confirmation page url {string}")
      public void iOpenRideConfirmationPageUrl(String url) {
            DriverManager.getDriver().get(url);
      }


      @Then("I verify the title of the home page {string}")
      public void iVerifyTheTitleOfTheHomePage(String title) {
            Assert.assertEquals(title, HomePage.getInstance().getTitle());
      }

      @Then("I verify the sub title of the home page {string}")
      public void iVerifyTheSubTitleOfTheHomePage(String subtitle) {
            Assert.assertEquals(subtitle, HomePage.getInstance().getSubTitle());
      }

      @When("I click on the {string} link")
      public void iClickOnTheLink(String arg0) {
            HomePage.getInstance().clickOnAddMultipleStopsLink();
      }

      @Then("I verify the url of the page {string}")
      public void iVerifyTheUrlOfThePage(String URL) {
            Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), URL);
      }


      @When("I enter pickup location as {string} in home page")
      public void iEnterPickupLocationAsInHomePage(String pickup_loc) throws InterruptedException {
            HomePage.getInstance().enterOWPickupLoc(pickup_loc);
      }

      @And("I enter Dropoff location as {string} in home page")
      public void iEnterDropoffLocationAsInHomePage(String dropoff_loc) throws InterruptedException {
            HomePage.getInstance().enterOWDropoffLoc(dropoff_loc);
      }

      @And("I select pickup Month and Year as {string} in home page")
      public void iSelectPickupMonthAndYearAsInHomePage(String pickup_month_year) {
            HomePage.getInstance().selectOnewayPickupYearMonth(pickup_month_year);
      }

      @And("I select pickup Date as {string} in home page")
      public void iSelectPickupDateAsInHomePage(String pickup_date) {
            HomePage.getInstance().selectOWPickupDate(pickup_date);
      }

      @And("I select pickup Hour as {string} in home page")
      public void iSelectPickupHourAsInHomePage(String pickup_hour) throws InterruptedException {
            HomePage.getInstance().enterOWPickupHour(pickup_hour);
      }

      @And("I select pickup Minute as {string} in home page")
      public void iSelectPickupMinuteAsInHomePage(String pickup_minute) {
            HomePage.getInstance().enterOWPickupMinute(pickup_minute);
      }

      @And("I select pickup Period as {string} in home page")
      public void iSelectPickupPeriodAsInHomePage(String pickup_period) {
            HomePage.getInstance().selectOWPickupPeriod(pickup_period);
      }

      @And("I select event type in home page")
      public void iSelectEventTypeInHomePage() throws InterruptedException {
            HomePage.getInstance().selectEventType();
      }

      @Then("Verify the page is redirects to vehicle page and verify url {string}")
      public void verifyThePageIsRedirectsToVehiclePageAndVerifyUrl(String url) {
            Assert.assertEquals(url, DriverManager.getDriver().getCurrentUrl());
      }

      @And("Verify the Homepage Location Information in the vehicle page")
      public void verifyTheHomepageLocationInformationInTheVehiclePage() {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  DriverManager.getDriver().switchTo().frame("front-inc");
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  String homepageFromLocation = HomePage.getInstance().getOWPickupLoc().split(",")[0].trim().toLowerCase();
                  String vehicleFromLocation = VehiclePage.getInstance().getFromLocation().split(",")[0].trim().toLowerCase();
                  System.out.println(homepageFromLocation);
                  System.out.println(vehicleFromLocation);
                  Assert.assertTrue(homepageFromLocation.contains(vehicleFromLocation)
                          || vehicleFromLocation.contains(homepageFromLocation));

                  String homepageToLocation = HomePage.getInstance().getOWDropoffLoc().split(",")[0].trim().toLowerCase();
                  String vehicleToLocation = VehiclePage.getInstance().getToLocation().split(",")[0].trim().toLowerCase();
                  System.out.println(homepageToLocation);
                  System.out.println(vehicleToLocation);
                  Assert.assertTrue(homepageToLocation.contains(vehicleToLocation)
                          || vehicleToLocation.contains(homepageToLocation));

            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }

      }

      @And("Verify the HomePage Time Information in the vehicle page")
      public void verifyTheHomePageTimeInformationInTheVehiclePage() {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  Assert.assertEquals(HomePage.getInstance().getPickupDateTime(),
                          VehiclePage.getInstance().getFromDateTime());

                  Assert.assertEquals(HomePage.getInstance().getPickupDateTime(),
                          VehiclePage.getInstance().getToDateTime());
            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }
      }
}
