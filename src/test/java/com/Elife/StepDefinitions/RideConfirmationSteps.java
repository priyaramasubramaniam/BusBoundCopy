package com.Elife.StepDefinitions;

import com.Elife.PageComponent.ItineraryPage;
import com.Elife.PageComponent.RideConfirmationPage;
import com.Elife.PageComponent.RideSummaryPage;
import com.Elife.Utilities.ExcelUtils;
import com.Elife.Utilities.FileUtils;
import com.Elife.Utilities.ScenarioContext;
import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import javax.lang.model.type.UnionType;
import java.io.IOException;
import java.util.List;

public class RideConfirmationSteps {


      @Then("Verify the Ride dates with actual dates in Confirmation Page")
      public void verifyTheRideDatesWithActualDatesInConfirmationPage() {
            Assert.assertEquals(RideConfirmationPage.getInstance().getRideDates(), ItineraryPage.getInstance().getDates());
      }

      @And("Verify the Ride dates for each days in Confirmation Page")
      public void verifyTheRideDatesForEachDaysInConfirmationPage() throws InterruptedException {
            Assert.assertEquals(ItineraryPage.getInstance().getRideDateForEachDay(), RideConfirmationPage.getInstance().getRideDateForEachDay());

      }

      @And("Verify the Ride Time for each days in Confirmation Page")
      public void verifyTheRideTimeForEachDaysInConfirmationPage() throws InterruptedException {
            Assert.assertEquals(ScenarioContext.getContext("PICKUP_TIMES"), RideConfirmationPage.getInstance().getRideTimes());
      }

      @And("Verify the Ride locations for each days in Confirmation Page")
      public void verifyTheRideLocationsForEachDaysInConfirmationPage() throws InterruptedException {
            Assert.assertEquals(RideConfirmationPage.getInstance().getRideLocations(),
                    ItineraryPage.getInstance().getLocations());

            for (int i = 0; i < RideConfirmationPage.getInstance().getRideLocations().size(); i++) {
                  Assert.assertEquals(ItineraryPage.getInstance().getLocations().get(i).
                                  contains(RideConfirmationPage.getInstance().getRideLocations().get(i))
                          , "Mismatch at index " + i);
            }
            Thread.sleep(1000);
      }

      @And("Verify the vehicle information in in Confirmation Page")
      public void verifyTheVehicleInformationInInConfirmationPage() {
//            Assert.assertEquals(RideConfirmationPage.getInstance().getVehicleName(),
//                    ScenarioContext.getContext("vehicleName"));
//            Assert.assertEquals(RideConfirmationPage.getInstance().getVehicleBrand(),
//                    ScenarioContext.getContext("vehicleBrand"));
            Assert.assertEquals(RideConfirmationPage.getInstance().getVehicleMaxPax(),
                    ScenarioContext.getContext("vehicleMaxPax"));
            Assert.assertEquals(RideConfirmationPage.getInstance().getVehicleMaxPax(),
                    ScenarioContext.getContext("vehicleMaxLux"));
      }


      @And("I switch to Ride Confirmation Page")
      public void iSwitchToRideConfirmationPage() throws InterruptedException {
            Utils.switchToWindow();
            Thread.sleep(6000);
      }
      @And("Verify the More link is displayed in Ride confirmation page")
      public void verifyTheMoreLinkIsDisplayedInRideConfirmationPage() {
            System.out.println(RideConfirmationPage.getInstance().isMoreLinkDisplayed());
      }

      @And("I click on the More link")
      public void iClickOnTheMoreLink() {
            RideConfirmationPage.getInstance().clickOnMoreLink();
      }

      @And("I click on Service policy link")
      public void iClickOnServicePolicyLink() throws InterruptedException {
            RideConfirmationPage.getInstance().clickOnServicePolicyLink();
      }

      @And("I get ride info")
      public void iGetRideInfo() {
            System.out.println(RideConfirmationPage.getInstance().getRideId());
            System.out.println(RideConfirmationPage.getInstance().getStartDate().concat(" ").
                    concat(RideConfirmationPage.getInstance().getStartTime()));
            System.out.println(RideConfirmationPage.getInstance().getVehicleName());
            System.out.println(RideConfirmationPage.getInstance().getFirstAndLastLocation());
//            System.out.println(RideConfirmationPage.getInstance().getVehicleBrand());
      }


      @And("I get ride info from confirmation page to check it on the Ride List Page")
      public void iGetRideInfoFromConfirmationPageToCheckItOnTheRideListPage() {
            ScenarioContext.setContext("RideIdRC", RideConfirmationPage.getInstance().getRideId());
            ScenarioContext.setContext("RideDateTimeRC", RideConfirmationPage.getInstance().getStartDate().
                    concat(RideConfirmationPage.getInstance().getStartTime()));
            ScenarioContext.setContext("VehicleNameRC", RideConfirmationPage.getInstance().getVehicleName());
//            ScenarioContext.setContext("VehicleBrandRC", RideConfirmationPage.getInstance().getVehicleBrand());
            ScenarioContext.setContext("FirstLastLocRC", RideConfirmationPage.getInstance().getFirstAndLastLocation());
      }
      @Then("Verify the url of the Ride Confirmation page")
      public void verifyTheUrlOfTheRideConfirmationPage() throws IOException {
            String url = RideConfirmationPage.getInstance().getUrl();
            if (ScenarioContext.getContext("RidePartnerName").toString().contains("Elife"))
            {
                  Assert.assertTrue(url.contains(Utils.getGlobalValue("URL_RideConfirmation_Elife")));
            }
            else if(ScenarioContext.getContext("RidePartnerName").toString().contains("Busbound"))
            {
                  Assert.assertTrue(url.contains(Utils.getGlobalValue("URL_RideConfirmation_Busbound")));
            }
      }


      @And("I verify the Cancel ride is only displayed for the Paid and Unpaid Rides")
      public void iVerifyTheCancelRideIsOnlyDisplayedForThePaidAndUnpaidRides() {
            if (ScenarioContext.getContext("RideStatusRL").toString().trim().equals("Paid"))
            {
                  System.out.println(ScenarioContext.getContext("RideStatusRL"));
                  Assert.assertTrue(RideConfirmationPage.getInstance().isMoreLinkDisplayed());
                  RideConfirmationPage.getInstance().clickOnMoreLink();
                  System.out.println(RideConfirmationPage.getInstance().isCancelRideBtnDisplayed());
                  Assert.assertTrue(RideConfirmationPage.getInstance().isCancelRideBtnDisplayed());
            }
            else if (ScenarioContext.getContext("RideStatusRL").toString().trim().equals("Unpaid"))
            {
                  System.out.println(ScenarioContext.getContext("RideStatusRL"));
                  Assert.assertTrue(RideConfirmationPage.getInstance().isMoreLinkDisplayed());
                  RideConfirmationPage.getInstance().clickOnMoreLink();
                  System.out.println(RideConfirmationPage.getInstance().isCancelRideBtnDisplayed());
                  Assert.assertEquals(RideConfirmationPage.getInstance().isCancelRideBtnDisplayed(), false);
            }
            else if (ScenarioContext.getContext("RideStatusRL").toString().trim().equals("Cancelled"))
            {
                  System.out.println(ScenarioContext.getContext("RideStatusRL"));
                  System.out.println(RideConfirmationPage.getInstance().isCancelRideBtnDisplayed());
                  Assert.assertFalse(RideConfirmationPage.getInstance().isMoreLinkDisplayed());
            }
      }


      @And("I click on the cancel ride button and verify the title of the ride status")
      public void iClickOnTheCancelRideButtonAndVerifyTheTitleOfTheRideStatus() throws InterruptedException {
            String rideStatus = (String) ScenarioContext.getContext("RideStatusRL");

            if ("Cancelled".equals(rideStatus)) {
                  System.out.println(rideStatus);
                  Assert.assertEquals("Sorry, your ride has been cancelled.", RideConfirmationPage.getInstance().getTitle());
            } else if ("Unpaid".equals(rideStatus)) {
                  System.out.println(rideStatus);
                  Assert.assertEquals("Your ride has not been paid yet.", RideConfirmationPage.getInstance().getTitle());
            } else if ("Paid".equals(rideStatus)) {
                  RideConfirmationPage.getInstance().clickOnMoreLink();
                  Thread.sleep(15000);
                  RideConfirmationPage.getInstance().clickOnCancelBtn();
                  Thread.sleep(15000);
                  System.out.println(rideStatus);
                  Assert.assertEquals("Sorry, your ride has been cancelled.", RideConfirmationPage.getInstance().getTitle());
            }
      }

      @And("I verify the Service Policy is only displayed for the Paid and Unpaid Rides")
      public void iVerifyTheServicePolicyIsOnlyDisplayedForThePaidAndUnpaidRides() {
            if (ScenarioContext.getContext("RideStatusRL").toString().trim().equals("Paid"))
            {
                  System.out.println(ScenarioContext.getContext("RideStatusRL"));
                  Assert.assertTrue(RideConfirmationPage.getInstance().isMoreLinkDisplayed());
                  RideConfirmationPage.getInstance().clickOnMoreLink();
                  System.out.println(RideConfirmationPage.getInstance().isServicePolicyDisplayed());
                  Assert.assertTrue(RideConfirmationPage.getInstance().isServicePolicyDisplayed());
            }
            else if (ScenarioContext.getContext("RideStatusRL").toString().trim().equals("Unpaid"))
            {
                  System.out.println(ScenarioContext.getContext("RideStatusRL"));
                  Assert.assertTrue(RideConfirmationPage.getInstance().isMoreLinkDisplayed());
                  RideConfirmationPage.getInstance().clickOnMoreLink();
                  System.out.println(RideConfirmationPage.getInstance().isServicePolicyDisplayed());
                  Assert.assertEquals(RideConfirmationPage.getInstance().isServicePolicyDisplayed(), false);
            }
            else if (ScenarioContext.getContext("RideStatusRL").toString().trim().equals("Cancelled"))
            {
                  System.out.println(ScenarioContext.getContext("RideStatusRL"));
                  System.out.println(RideConfirmationPage.getInstance().isMoreLinkDisplayed());
                  Assert.assertFalse(RideConfirmationPage.getInstance().isServicePolicyDisplayed());
            }
      }

      @And("I click on the cancel ride button")
      public void iClickOnTheCancelRideButton() {
            RideConfirmationPage.getInstance().clickOnCancelBtn();
      }

      @And("I select cell number from the dropdown")
      public void iSelectCellNumberFromTheDropdown() throws InterruptedException {
            RideConfirmationPage.getInstance().selectCellNumber();
      }

      @And("I click on Get Verification Code Link in ride confirmation page")
      public void iClickOnGetVerificationCodeLinkInRideConfirmationPage() throws InterruptedException {
            RideConfirmationPage.getInstance().clickOnVerificationCodeLink();
            Thread.sleep(25000);
      }

      @And("I click on confirm button in the ride confirmation page")
      public void iClickOnConfirmButtonInTheRideConfirmationPage() {
            RideConfirmationPage.getInstance().clickOnConfirmBtn();
      }

      @And("Verify the Title of the ride confirmation should be changed to {string}")
      public void verifyTheTitleOfTheRideConfirmationShouldBeChangedTo(String title) {
            Assert.assertEquals(RideConfirmationPage.getInstance().getTitle(), title);
      }

      @And("I click on modification link")
      public void iClickOnModificationLink() {
            DriverManager.getDriver().switchTo().defaultContent();
            RideConfirmationPage.getInstance().clickOnModificationLink();
      }

      @And("I get the text of the modification policy and compare it with expected text file")
      public void iGetTheTextOfTheModificationPolicyAndCompareItWithExpectedTextFile() throws IOException {
            String filePath = "src/test/java/com/Elife/TestData/Modification.txt";
            Assert.assertEquals(RideConfirmationPage.getInstance().getModificationText(), FileUtils.getFileTextAsIs(filePath));
      }
      @And("I click on overtime and additional charge link")
      public void iClickOnOvertimeAndAdditionalChargeLink() {
            DriverManager.getDriver().switchTo().defaultContent();
            RideConfirmationPage.getInstance().clickOnAdditionalChargeLink();
      }
      @And("I get the text of the overtime and Additional charge policy and compare it with expected text file")
      public void iGetTheTextOfTheOvertimeAndAdditionalChargePolicyAndCompareItWithExpectedTextFile() throws IOException {
            String filePath = "src/test/java/com/Elife/TestData/Overtime and additional charge.txt";
            Assert.assertEquals(RideConfirmationPage.getInstance().getAdditionalChargeText(), FileUtils.getFileTextAsIs(filePath));
      }


      @And("I click on modify vehicle link in the Ride summary page")
      public void iClickOnModifyLinkInTheRideSummaryPage() {
            RideSummaryPage.getInstance().clickOnModifyVehicleInfoLink();
      }
}
