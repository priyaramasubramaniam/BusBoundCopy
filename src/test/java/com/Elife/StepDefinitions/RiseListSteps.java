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

import javax.lang.model.type.UnionType;

public class RiseListSteps {

      @And("I verify the Future and Past switch should be displayed in Ride List page")
      public void iVerifyTheFutureAndPastSwitchShouldBeDisplayedInRideListPage() {
            Assert.assertTrue(RideListPage.getInstance().isFutureBtnDisplayed());
            Assert.assertTrue(RideListPage.getInstance().isBtnPastDisplayed());
      }

      String rideID = (String) ScenarioContext.getContext("RideIdRC");
      @And("Get the Ride Id from Ride List and compare it with Ride Confirmation Page")
      public void getTheRideIdFromRideListAndCompareItWithRideConfirmationPage() {
            Assert.assertEquals(ScenarioContext.getContext("RideIdRL"), ScenarioContext.getContext("RideIdRC"));
      }

      @And("Verify Ride Status should be {string}")
      public void verifyRideStatusShouldBe(String arg0) {
            Assert.assertEquals(RideListPage.getInstance().getRideStatus(rideID), "Paid");
      }

      @And("Get the Vehicle name from Ride List and compare it with Ride Confirmation Page")
      public void getTheVehicleNameFromRideListAndCompareItWithRideConfirmationPage() {
            Assert.assertEquals(ScenarioContext.getContext("VehicleNameRL"), ScenarioContext.getContext("VehicleNameRC"));
      }

      @And("Get the Vehicle brand from Ride List and compare it with Ride Confirmation Page")
      public void getTheVehicleBrandFromRideListAndCompareItWithRideConfirmationPage() {
            Assert.assertEquals(ScenarioContext.getContext("VehicleBrandRL"), ScenarioContext.getContext("VehicleBrandRC"));
      }

      @And("Get the Ride date and time from Ride List and compare it with Ride Confirmation Page")
      public void getTheRideDateAndTimeFromRideListAndCompareItWithRideConfirmationPage() {
            Assert.assertEquals(ScenarioContext.getContext("RideDateTimeRC"), ScenarioContext.getContext("RideDateTimeRC"));
      }

      @And("Get the Locations from Ride List and compare it with Ride Confirmation Page")
      public void getTheLocationsFromRideListAndCompareItWithRideConfirmationPage() {
            Assert.assertEquals(ScenarioContext.getContext("RideLocationsRL"), ScenarioContext.getContext("FirstLastLocRC"));
      }


      @And("I click on the ride link")
      public void iClickOnTheRideLink() {
            RideListPage.getInstance().clickOnRideIdLink();
      }


      @And("I get the partner name of the ride id")
      public void iGetThePartnerNameOfTheRideId() {
            ScenarioContext.setContext("RidePartnerName", RideListPage.getInstance().getRideIdLinkText());
            ScenarioContext.getContext("RidPartnerName");
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
            Assert.assertEquals(RideListPage.getInstance().isDateInAscendingOrder(), true);
      }

      @When("I click on the past button")
      public void iClickOnThePastButton() {
            RideListPage.getInstance().clickOnPastBtn();
      }
      @And("Verify the part orders are in ascending order")
      public void verifyThePartOrdersAreInAscendingOrder() throws InterruptedException {
            Assert.assertEquals(RideListPage.getInstance().isDateInDescendingOrder(), true);
      }


      @And("Verify the each page contains lesser than or equal to {int} records")
      public void verifyTheEachPageContainsLesserThanOrEqualToRecords(int count) throws InterruptedException {
            Assert.assertEquals(RideListPage.getInstance().getRideCardCount(count), true);
      }

      @And("Verify the dates which is greater than now")
      public void verifyTheDatesWhichIsGreaterThanNow() throws InterruptedException {
            System.out.println(RideListPage.getInstance().isDateGreaterThanNow());
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
