package com.Elife.StepDefinitions;

import com.Elife.PageComponent.RideConfirmationPage;
import com.Elife.PageComponent.RideListPage;
import com.Elife.Utilities.ScenarioContext;
import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import javax.lang.model.type.UnionType;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RiseListSteps {

      @And("I verify the Future and Past switch should be displayed in Ride List page")
      public void iVerifyTheFutureAndPastSwitchShouldBeDisplayedInRideListPage() {
            assertTrue(RideListPage.getInstance().isFutureBtnDisplayed());
            assertTrue(RideListPage.getInstance().isBtnPastDisplayed());
      }

      String rideID = (String) ScenarioContext.getContext("RideIdRC");
      @And("Get the Ride Id from Ride List and compare it with Ride Confirmation Page")
      public void getTheRideIdFromRideListAndCompareItWithRideConfirmationPage() throws InterruptedException {
            Assert.assertEquals(RideListPage.getInstance().getRideId(rideID), ScenarioContext.getContext("RideIdRC"));
      }

      @And("Verify Ride Status should be {string}")
      public void verifyRideStatusShouldBe(String arg0) {
            Assert.assertEquals(RideListPage.getInstance().getRideStatus(rideID), "Paid");
      }

      @And("Get the Vehicle name from Ride List and compare it with Ride Confirmation Page")
      public void getTheVehicleNameFromRideListAndCompareItWithRideConfirmationPage() {
            Assert.assertEquals(RideListPage.getInstance().getRideVehicleName(rideID), ScenarioContext.getContext("VehicleNameRC"));
      }

      @And("Get the Vehicle brand from Ride List and compare it with Ride Confirmation Page")
      public void getTheVehicleBrandFromRideListAndCompareItWithRideConfirmationPage() {
            Assert.assertEquals(RideListPage.getInstance().getRideVehicleBrand(rideID), ScenarioContext.getContext("VehicleBrandRC"));
      }

      @And("Get the Ride date and time from Ride List and compare it with Ride Confirmation Page")
      public void getTheRideDateAndTimeFromRideListAndCompareItWithRideConfirmationPage() {
            Assert.assertEquals(RideListPage.getInstance().getRideDateTime(rideID), ScenarioContext.getContext("RideDateTimeRC"));
      }

      @And("Get the Locations from Ride List and compare it with Ride Confirmation Page")
      public void getTheLocationsFromRideListAndCompareItWithRideConfirmationPage() {
            List<String> rideLocations = RideListPage.getInstance().getRideLocation(rideID);
            List<String> firstAndLastLocations = (List<String>) ScenarioContext.getContext("FirstLastLocRC");

            // Check if each element in firstAndLastLocations is contained in rideLocations
            for (String location : firstAndLastLocations) {
                  assertTrue(rideLocations.contains(location));
            }

      }


      @And("I click on the ride id link")
      public void iClickOnTheRideIdLink() {
            RideListPage.getInstance().clickOnRideIdLink();
      }


      @And("I get the partner name of the ride id")
      public void iGetThePartnerNameOfTheRideId() {
            ScenarioContext.setContext("RidePartnerName", RideListPage.getInstance().getRideIdLinkText());
            ScenarioContext.getContext("RidPartnerName");
      }
      @And("I click on the ride link")
      public void iClickOnTheRideLink() {
            RideListPage.getInstance().clickOnRideIdLink();
      }

      @And("I get the status of the ride in Rid List page")
      public void iGetTheStatusOfTheRideInRidListPage() {
            ScenarioContext.setContext("RideStatusRL", RideListPage.getInstance().getRideStatusText());
            ScenarioContext.getContext("RideStatusRL");
      }
      @When("I click on the future button")
      public void iClickOnTheFutureButton() {
            RideListPage.getInstance().clickOnFutureBtn();
      }
      @And("Verify the future orders are in ascending order")
      public void verifyTheFutureDatesAreInAscendingOrder() throws InterruptedException {
            Assert.assertEquals(RideListPage.getInstance().isDateInAscendingOrder1(), true);
      }

      @When("I click on the past button")
      public void iClickOnThePastButton() {
            RideListPage.getInstance().clickOnPastBtn();
      }
      @And("Verify the part orders are in descending order")
      public void verifyThePartOrdersAreInDescendingOrder() throws InterruptedException {
            Assert.assertEquals(RideListPage.getInstance().isDateInDescendingOrder1(), true);
      }


      @And("Verify the each page contains lesser than or equal to {int} records")
      public void verifyTheEachPageContainsLesserThanOrEqualToRecords(int count) throws InterruptedException {
            Assert.assertEquals(RideListPage.getInstance().getRideCardCount(count), true);
      }

      @And("Verify the dates which is greater than now")
      public void verifyTheDatesWhichIsGreaterThanNow() throws InterruptedException {
            Assert.assertEquals(RideListPage.getInstance().isDateGreaterThanNow(), true);
      }

      @And("Verify the dates which is lesser than now")
      public void verifyTheDatesWhichIsLesserThanNow() throws InterruptedException {
            Assert.assertEquals(RideListPage.getInstance().isDateLesserThanNow(), true);
      }
      @And("I check the ride status updated in Ride List page")
      public void iCheckTheRideStatusUpdatedInRideListPage() {
            Utils.switchToMainWindow();
            System.out.println(RideListPage.getInstance().getRideStatusText());
      }



}
