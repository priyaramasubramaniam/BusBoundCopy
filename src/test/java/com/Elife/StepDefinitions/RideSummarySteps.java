package com.Elife.StepDefinitions;

import com.Elife.PageComponent.ContactPage;
import com.Elife.PageComponent.ItineraryPage;
import com.Elife.PageComponent.RideConfirmationPage;
import com.Elife.PageComponent.RideSummaryPage;
import com.Elife.Utilities.ScenarioContext;
import com.Elife.Utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;

import javax.lang.model.type.UnionType;
import java.util.List;

public class RideSummarySteps {
      @Then("Verify the Ride dates with actual dates")
      public void verifyTheRideDatesWithActualDates() {
            System.out.println(ItineraryPage.getInstance().getDates());
            System.out.println(RideSummaryPage.getInstance().getRideDates());
            Assert.assertEquals(ItineraryPage.getInstance().getDates(), RideSummaryPage.getInstance().getRideDates());
      }

      @And("Verify the Ride dates for each days")
      public void verifyTheRideDatesForEachDays() throws InterruptedException {
            System.out.println(ItineraryPage.getInstance().getRideDateForEachDay());
            System.out.println(RideSummaryPage.getInstance().getRideDateForEachDay());
//            assert ItineraryPage.getInstance().getRideDateForEachDay().equals(RideSummaryPage.getInstance().getRideDateForEachDay());
            Assert.assertEquals(ItineraryPage.getInstance().getRideDateForEachDay(), RideSummaryPage.getInstance().getRideDateForEachDay());
      }

      @And("Verify the Ride Time for each days")
      public void verifyTheRideTimeForEachDays() throws InterruptedException {
            System.out.println(ScenarioContext.getContext("PICKUP_TIMES"));
            System.out.println(RideSummaryPage.getInstance().getRideTimes());
            Assert.assertEquals(ScenarioContext.getContext("PICKUP_TIMES"), RideSummaryPage.getInstance().getRideTimes());
      }

      @And("Verify the Ride locations for each days")
      public void verifyTheRideLocationsForEachDays() throws InterruptedException {
            System.out.println(RideSummaryPage.getInstance().getRideLocations());
            System.out.println(ItineraryPage.getInstance().getLocations());
            Assert.assertEquals(RideSummaryPage.getInstance().getRideLocations(),
                    ItineraryPage.getInstance().getLocations());

            for (int i = 0; i < RideSummaryPage.getInstance().getRideLocations().size(); i++) {
                  Assert.assertEquals(ItineraryPage.getInstance().getLocations().get(i).
                                  contains(RideSummaryPage.getInstance().getRideLocations().get(i))
                          , "Mismatch at index " + i);
            }
            Thread.sleep(1000);
      }
      @Then("Verify the error message for name {string}")
      public void verifyTheErrorMessageForName(String error_msg) {
            Assert.assertEquals(RideSummaryPage.getInstance().getNameErrorMsg(), error_msg);
      }
      @And("I enter name as {string}")
      public void iEnterNameAs(String name) {
            RideSummaryPage.getInstance().enterCustomerName(name);
      }
      @Then("Verify the error message for email {string}")
      public void verifyTheErrorMessageForEmail(String error_msg) {
            Assert.assertEquals(RideSummaryPage.getInstance().getEmailErrorMsg(), error_msg);
      }
      @And("I enter email as {string}")
      public void iEnterEmailAs(String email) {
            RideSummaryPage.getInstance().enterCustomerEmail(email);
      }
      @And("Verify the error message for Country code {string}")
      public void verifyTheErrorMessageForCountryCode(String error_msg) {
            Assert.assertEquals(RideSummaryPage.getInstance().getCountryCodeErrorMsg(), error_msg);
      }

      @And("I select country code as {string} in contact form")
      public void iSelectCountryCodeAsInContactForm(String country_code) {
            RideSummaryPage.getInstance().selectCountryCode1();
      }

      @And("Verify the error message for cell number {string}")
      public void verifyTheErrorMessageForCellNumber(String error_msg) {
            Assert.assertEquals(RideSummaryPage.getInstance().getCellNumberErrorMsg(), error_msg);
      }
      @And("I enter cell number as {string} in contact form")
      public void iEnterCellNumberAsInContactForm(String cell_number) {
            RideSummaryPage.getInstance().enterCellNumber1(cell_number);
      }

      @And("Verify the vehicle information in ride summary page")
      public void verifyTheVehicleInformationInRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().getVehicleName(),
                    ScenarioContext.getContext("vehicleName"));
            Assert.assertEquals(RideSummaryPage.getInstance().getVehicleBrand(),
                    ScenarioContext.getContext("vehicleBrand"));
            Assert.assertEquals(RideSummaryPage.getInstance().getVehicleMaxPax(),
                    ScenarioContext.getContext("vehicleMaxPax"));
            Assert.assertEquals(RideSummaryPage.getInstance().getVehicleMaxPax(),
                    ScenarioContext.getContext("vehicleMaxLux"));
      }

      @And("Verify the Contact information in ride summary page")
      public void verifyTheContactInformationInRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().getName(),
                    (ContactPage.getInstance().getName().trim()));
            Assert.assertEquals(RideSummaryPage.getInstance().getEmail(),
                    ContactPage.getInstance().getEmail());
            Assert.assertEquals(RideSummaryPage.getInstance().getPhoneNumber1(),
                    ContactPage.getInstance().getCountryCode1().concat(" ").concat(ContactPage.getInstance().getCellNumber1()));
            Assert.assertEquals(RideSummaryPage.getInstance().getPhoneNumber2(),
                    (ContactPage.getInstance().getCountryCode2().concat(" ").concat(ContactPage.getInstance().getCellNumber2())).trim());
//            Assert.assertEquals(RideSummaryPage.getInstance().getSocialMedia().concat(RideSummaryPage.getInstance().getSocialMediaName()),
//                    ContactPage.getInstance().getSocialMedia().concat(" ").concat(ContactPage.getInstance().getSocialMediaName()));
      }



      @And("I click on the payment link")
      public void iClickOnThePaymentLink() throws InterruptedException {
            RideSummaryPage.getInstance().clickOnPaymentBtn();
            Utils.implicitWait(40);
      }

      @Then("I do the payment")
      public void iDoThePayment() throws InterruptedException {
            RideSummaryPage.getInstance().enterPaymentDetails();
            Thread.sleep(10000);
      }

      @And("Verify the additional charges in the Ride Summary Page")
      public void verifyTheAdditionalChargesInTheRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().getInfantSeatPrice(),
                    ScenarioContext.getContext("infant_seat_price"));
            Assert.assertEquals(RideSummaryPage.getInstance().getBoosterSeatPrice(),
                    ScenarioContext.getContext("booster_seat_price"));
            Assert.assertEquals(RideSummaryPage.getInstance().getChildSeatPrice(),
                    ScenarioContext.getContext("child_seat_price"));

      }
      @And("Verify the meet and greet price in the Ride Summary Page")
      public void verifyTheMeetAndGreetPriceInTheRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().getMeetAndGreetPrice(),
                    ScenarioContext.getContext("meet_greet_price"));
      }
      @And("Verify the additional charges are not displayed in ride summary page")
      public void verifyTheAdditionalChargesAreNotDisplayedInRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().isInfantSeatPriceDisplayed(), true);
            Assert.assertEquals(RideSummaryPage.getInstance().isBoosterSeatPriceDisplayed(), true);
            Assert.assertEquals(RideSummaryPage.getInstance().isChildSeatPriceDisplayed(), true);
      }


      @And("Verify the meet and greet price should not be displayed in the Ride Summary Page")
      public void verifyTheMeetAndGreetPriceShouldNotBeDisplayedInTheRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().isMeetAndGreetPriceDisplayed(), true);
      }







}
