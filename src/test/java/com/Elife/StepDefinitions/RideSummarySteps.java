package com.Elife.StepDefinitions;

import com.Elife.PageComponent.*;
import com.Elife.Utilities.ScenarioContext;
import com.Elife.Utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.tr.Ve;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;

import javax.lang.model.type.UnionType;
import java.util.List;

public class RideSummarySteps {
      @Then("Verify the Ride dates with actual dates")
      public void verifyTheRideDatesWithActualDates() {
            Assert.assertEquals(ItineraryPage.getInstance().getDates(), RideSummaryPage.getInstance().getRideDates());
      }

      @And("Verify the Ride dates for each days")
      public void verifyTheRideDatesForEachDays() throws InterruptedException {
            Assert.assertEquals(ItineraryPage.getInstance().getRideDateForEachDay(), RideSummaryPage.getInstance().getRideDateForEachDay());
      }

      @And("Verify the Ride Time for each days")
      public void verifyTheRideTimeForEachDays() throws InterruptedException {
//            Assert.assertEquals(ScenarioContext.getContext("PICKUP_TIMES"), RideSummaryPage.getInstance().getRideTimes());
            Assert.assertEquals(ItineraryPage.getInstance().getRideTimes(), RideSummaryPage.getInstance().getRideTimes());
      }

      @And("Verify the Ride locations for each days")
      public void verifyTheRideLocationsForEachDays() throws InterruptedException {

            for (int i = 0; i < RideSummaryPage.getInstance().getRideLocations().size(); i++) {
                  System.out.println(ItineraryPage.getInstance().getLocations().get(i).split(",")[0]);
                  System.out.println(RideSummaryPage.getInstance().getRideLocations().get(i).split(",")[0]);

                  Assert.assertTrue(RideSummaryPage.getInstance().getRideLocations().get(i).split(",")[0].
                          contains(ItineraryPage.getInstance().getLocations().get(i).split(",")[0])
                          || ItineraryPage.getInstance().getLocations().get(i).split(",")[0].
                          contains(RideSummaryPage.getInstance().getRideLocations().get(i).split(",")[0]));

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

      @Then("Verify the vehicle src in ride summary page")
      public void verifyTheVehicleSrcInRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("vehicleImageSrc"),
                    RideSummaryPage.getInstance().getVehicleImageSrc());
      }
      @Then("Verify the vehicle name in ride summary page")
      public void verifyTheVehicleNameInRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("vehicleName"),
                    RideSummaryPage.getInstance().getVehicleName());
      }
      @Then("Verify the vehicle brand in ride summary page")
      public void verifyTheVehicleBrandInRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("vehicleBrand"),
                    RideSummaryPage.getInstance().getVehicleBrand());
      }
      @Then("Verify the vehicle max passenger count in ride summary page")
      public void verifyTheVehicleMaxPassengerCountInRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("vehicleMaxLux"),
                    RideSummaryPage.getInstance().getVehicleMaxPax());
      }

      @Then("Verify the vehicle max luggage in ride summary page")
      public void verifyTheVehicleMaxLuggageInRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("vehicleMaxPax"),
                    RideSummaryPage.getInstance().getVehicleMaxLux());
      }

      @And("Verify the vehicle Service price in ride summary page")
      public void verifyTheVehicleServicePriceInRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().getVehiclePrice(), ScenarioContext.getContext("vehiclePrice"));
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
            Utils.implicitWait(50);
      }

      @Then("I do the payment")
      public void iDoThePayment() throws InterruptedException {
            RideSummaryPage.getInstance().enterPaymentDetails();
            Thread.sleep(10000);
      }

      @And("Verify the additional charges in the Ride Summary Page")
      public void verifyTheAdditionalChargesInTheRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().getInfantPrice(),
                    ScenarioContext.getContext("infant_seat_price"));
            Assert.assertEquals(RideSummaryPage.getInstance().getBoosterPrice(),
                    ScenarioContext.getContext("booster_seat_price"));
            Assert.assertEquals(RideSummaryPage.getInstance().getChildPrice(),
                    ScenarioContext.getContext("child_seat_price"));

      }
      @And("Verify the meet and greet price in the Ride Summary Page")
      public void verifyTheMeetAndGreetPriceInTheRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().getMeetGreetPrice(),
                    ScenarioContext.getContext("meetAndGreetPrice"));
      }

      @Then("Verify the meet and greet is displayed in the Ride Summary Page")
      public void verifyTheMeetAndGreetIsDisplayedInTheRideSummaryPage() {
            System.out.println(RideSummaryPage.getInstance().isMeetAndGreetSectionDisplayed());
            Assert.assertEquals(RideSummaryPage.getInstance().isMeetAndGreetSectionDisplayed(), true);
      }

      @And("Verify the meet and greet price should not be displayed in the Ride Summary Page")
      public void verifyTheMeetAndGreetPriceShouldNotBeDisplayedInTheRideSummaryPage() {
            System.out.println(RideSummaryPage.getInstance().isMeetAndGreetSectionDisplayed());
            Assert.assertEquals(RideSummaryPage.getInstance().isMeetAndGreetSectionDisplayed(), false);
      }

      @Then("Verify the infant count should be equal to infant count in ride summary page")
      public void verifyTheInfantCountShouldBeEqualToInfantCountInRideSummaryPage() {
            System.out.println("Vehicle Page :" + ScenarioContext.getContext("infant_count"));
            System.out.println("Ride Page :" + RideSummaryPage.getInstance().getInfantCount());
            Assert.assertEquals(ScenarioContext.getContext("infant_count"),
                    RideSummaryPage.getInstance().getInfantCount());
      }

      @Then("Verify the booster count should be equal to booster count in ride summary page")
      public void verifyTheBoosterCountShouldBeEqualToBoosterCountInRideSummaryPage() {
            System.out.println("Vehicle Page :" + ScenarioContext.getContext("booster_count"));
            System.out.println("Ride Page :" + RideSummaryPage.getInstance().getBoosterCount());
            Assert.assertEquals(ScenarioContext.getContext("booster_count"),
                    RideSummaryPage.getInstance().getBoosterCount());
      }

      @Then("Verify the child count should be equal to child count in ride summary page")
      public void verifyTheChildCountShouldBeEqualToChildCountInRideSummaryPage() {
            System.out.println("Vehicle Page :" + ScenarioContext.getContext("child_count"));
            System.out.println("Ride Page :" + RideSummaryPage.getInstance().getChildCount());
            Assert.assertEquals(ScenarioContext.getContext("child_count"),
                    RideSummaryPage.getInstance().getChildCount());
      }

      @Then("Verify the infant count should be equal {string}")
      public void verifyTheInfantCountShouldBeEqual(String count) {
            Assert.assertEquals(count, RideSummaryPage.getInstance().getInfantCount());
      }

      @Then("Verify the booster count should be equal {string}")
      public void verifyTheBoosterCountShouldBeEqual(String count) {
            Assert.assertEquals(count, RideSummaryPage.getInstance().getBoosterCount());
      }

      @Then("Verify the child count should be equal {string}")
      public void verifyTheChildCountShouldBeEqual(String count) {
            Assert.assertEquals(count, RideSummaryPage.getInstance().getChildCount());
      }

      @Then("Verify the vehicle price is updated in Ride Summary page")
      public void verifyTheVehiclePriceIsUpdatedInRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("vehiclePriceInPBS"),
                    RideSummaryPage.getInstance().getVehiclePrice());
      }
      @And("Verify the Infant price in the Ride Summary Page")
      public void verifyTheInfantPriceInTheRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("InfantPrice"),
                    RideSummaryPage.getInstance().getInfantPrice());
      }
      @And("Verify the Booster price in the Ride Summary Page")
      public void verifyTheBoosterPriceInTheRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("BoosterPrice"),
                    RideSummaryPage.getInstance().getBoosterPrice());
      }
      @And("Verify the Child price in the Ride Summary Page")
      public void verifyTheChildPriceInTheRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("ChildPrice"),
                    RideSummaryPage.getInstance().getChildPrice());
      }

      @And("verify the Total price is updated in Ride Summary page")
      public void verifyTheTotalPriceIsUpdatedInRideSummaryPage() {
            Assert.assertEquals(ScenarioContext.getContext("totalPrice"),
                    RideSummaryPage.getInstance().getTotalPrice());
      }


      @And("Verify the meet and greet price is not displayed in the Ride Summary Page")
      public void verifyTheMeetAndGreetPriceIsNotDisplayedInTheRideSummaryPage() {
            Assert.assertEquals(RideSummaryPage.getInstance().isMeetAndGreetPriceDisplayed(), false);
      }
}
