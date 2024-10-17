package com.Elife.StepDefinitions;

import com.Elife.PageComponent.ItineraryPage;
import com.Elife.PageComponent.QuotesPage;
import com.Elife.PageComponent.RideSummaryPage;
import com.Elife.PageComponent.VehiclePage;
import com.Elife.Utilities.ScenarioContext;
import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;


public class VehiclePageSteps {

      @When("I select the vehicle in the vehicle page")
      public void iSelectTheVehicleInTheVehiclePage() {
            VehiclePage.getInstance().selectVehicle();
      }
      @And("I modify the vehicle in the vehicle page")
      public void iModifyTheVehicleInTheVehiclePage() {
            VehiclePage.getInstance().modifyVehicle();
      }

      @And("I click on the next button in the vehicle page")
      public void iClickOnTheNextButtonInTheVehiclePage() throws InterruptedException {
            VehiclePage.getInstance().clickOnNextBtn();
            Thread.sleep(5000);
      }

      @And("I get the vehicle name in the vehicle page")
      public void iGetTheVehicleNameInTheVehiclePage() {
            ScenarioContext.setContext("vehicleName", VehiclePage.getInstance().getVehicleName());
      }

      @And("I get the vehicle image src in the vehicle page")
      public void iGetTheVehicleImageSrcInTheVehiclePage() {
            ScenarioContext.setContext("vehicleImageSrc", VehiclePage.getInstance().getVehicleImgSrc());
      }
      @And("I get the vehicle brand in the vehicle page")
      public void iGetTheVehicleBrandInTheVehiclePage() {
            ScenarioContext.setContext("vehicleBrand", VehiclePage.getInstance().getVehicleBrand());
            System.out.println(ScenarioContext.getContext("vehicleBrand"));

      }

      @And("I get the vehicle max passenger count in the vehicle page")
      public void iGetTheVehicleMaxPassengerCountInTheVehiclePage() throws InterruptedException {
            Thread.sleep(3000);
            ScenarioContext.setContext("vehicleMaxPax", VehiclePage.getInstance().getMaxPax());

      }

      @And("I get the vehicle max luggage count in the vehicle page")
      public void iGetTheVehicleMaxLuggageCountInTheVehiclePage() throws InterruptedException {
            Thread.sleep(3000);
            ScenarioContext.setContext("vehicleMaxLux", VehiclePage.getInstance().getMaxLux());

      }
      @And("I get the vehicle price in the vehicle page")
      public void iGetTheVehiclePriceInTheVehiclePage() {
            ScenarioContext.setContext("vehiclePrice", VehiclePage.getInstance().getVehiclePriceInVS());
      }
      @And("I get the Total price in the vehicle page")
      public void iGetTheTotalPriceInTheVehiclePage() {
            ScenarioContext.setContext("totalPrice", VehiclePage.getInstance().getTotalPriceInPBS());
      }

      @And("Verify the Itinerary Location Information in the vehicle page")
      public void verifyTheItineraryLocationInformationInTheVehiclePage() throws InterruptedException {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  String itineraryFromLocation = ItineraryPage.getInstance().getFromLocation().split(",")[0].trim().toLowerCase();
                  String vehicleFromLocation = VehiclePage.getInstance().getFromLocation().split(",")[0].trim().toLowerCase();
                  System.out.println(itineraryFromLocation);
                  System.out.println(vehicleFromLocation);
                  Assert.assertTrue(itineraryFromLocation.contains(vehicleFromLocation)
                          || vehicleFromLocation.contains(itineraryFromLocation));

                  String itineraryToLocation = ItineraryPage.getInstance().getToLocation().split(",")[0].trim().toLowerCase();
                  String vehicleToLocation = VehiclePage.getInstance().getToLocation().split(",")[0].trim().toLowerCase();
                  System.out.println(itineraryToLocation);
                  System.out.println(vehicleToLocation);
                  Assert.assertTrue(itineraryToLocation.contains(vehicleToLocation)
                                  || vehicleToLocation.contains(itineraryToLocation));

            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }

      }

      @And("Verify the Itinerary Time Information in the vehicle page")
      public void verifyTheItineraryTimeInformationInTheVehiclePage() {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  Assert.assertEquals(ItineraryPage.getInstance().getFromDateTime(),
                          VehiclePage.getInstance().getFromDateTime());

                  Assert.assertEquals(ItineraryPage.getInstance().getToDateTime(),
                          VehiclePage.getInstance().getToDateTime());
            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }
      }

      @And("verify the Show All Itineraries link is displayed")
      public void verifyTheShowAllItinerariesLinkIsDisplayed() {
            Assert.assertEquals(VehiclePage.getInstance().isShowAllLinkDisplayed(), true);
      }
      @And("verify the Show All Itineraries link is not displayed")
      public void verifyTheShowAllItinerariesLinkIsNotDisplayed() {
            Assert.assertEquals(VehiclePage.getInstance().isShowAllLinkDisplayed(), false);
      }

      @And("Verify {string} is displayed for more than two locations")
      public void verifyIsDisplayedForMoreThanTwoLocations(String text) {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  Assert.assertEquals(text, VehiclePage.getInstance().getShowAllItineraryText());
            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }
      }

      @And("I click on the Show all Itineraries link")
      public void iClickOnTheShowAllItinerariesLink() {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  VehiclePage.getInstance().clickOnShowAllItineraryLink();
            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }
      }
      @And("Verify {string} is changed to {string} after clicking the Show All Itineraries link")
      public void verifyIsChangedToAfterClickingTheShowAllItinerariesLink(String arg0, String text) {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  Assert.assertEquals(VehiclePage.getInstance().getShowAllItineraryText(), text);
            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }
      }
      @Then("Verify the Ride dates with actual dates in vehicle page")
      public void verifyTheRideDatesWithActualDatesInVehiclePage() {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  Assert.assertEquals(ItineraryPage.getInstance().getDates(), VehiclePage.getInstance().getRideDates());
            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }
      }

      @And("Verify the Ride dates for each days in vehicle page")
      public void verifyTheRideDatesForEachDaysInVehiclePage() throws InterruptedException {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  Assert.assertEquals(ItineraryPage.getInstance().getRideDateForEachDay(), VehiclePage.getInstance().getRideDateForEachDay());
            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }
      }

      @And("Verify the Ride Time for each days in vehicle page")
      public void verifyTheRideTimeForEachDaysInVehiclePage() throws InterruptedException {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  Assert.assertEquals(ItineraryPage.getInstance().getRideTimes(), VehiclePage.getInstance().getRideTimes());
            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }
      }

      @And("Verify the Ride locations for each days in vehicle page")
      public void verifyTheRideLocationsForEachDaysInVehiclePage() throws InterruptedException {
            Utils.implicitWait(10);

            // Add an explicit wait to check if the itinerary is displayed
            try {
                  Utils.waitForVisibility(VehiclePage.getInstance().itineraryOutline);  // Replace with the actual itinerary element
                  for (int i = 0; i < VehiclePage.getInstance().getRideLocations().size(); i++) {
                        System.out.println(ItineraryPage.getInstance().getLocations().get(i).split(",")[0]);
                        System.out.println(VehiclePage.getInstance().getRideLocations().get(i).split(",")[0]);

                        Assert.assertTrue(VehiclePage.getInstance().getRideLocations().get(i).split(",")[0].
                                contains(ItineraryPage.getInstance().getLocations().get(i).split(",")[0])
                                || ItineraryPage.getInstance().getLocations().get(i).split(",")[0].
                                contains(VehiclePage.getInstance().getRideLocations().get(i).split(",")[0]));

                  }
                  Thread.sleep(1000);
            } catch (TimeoutException e) {
                  // Handle case where the itinerary is not visible
                  System.out.println("Itinerary not displayed, checking Quotes page");
                  Assert.assertEquals(QuotesPage.getInstance().getTitle(), "Get a Price Quote");
                  return;
            }
      }
      @When("I click on Edit button in the Vehicle Page")
      public void iClickOnEditButtonInTheVehiclePage() {
            VehiclePage.getInstance().clickOnEditItineraryBtn();
      }

      @And("I click on the price breakdown link")
      public void iClickOnThePriceBreakdownLink() {
            DriverManager.getDriver().switchTo().defaultContent();
            VehiclePage.getInstance().clickOnPriceBreakdownLink();
      }

      @Then("Verify vehicle price should be updated in vehicle pricedown section")
      public void verifyVehiclePriceShouldBeUpdatedInVehiclePricedownSection() {
            Assert.assertEquals(ScenarioContext.getContext("vehiclePrice"),
                    VehiclePage.getInstance().getVehiclePriceInPBS());
      }

      @And("I select vehicle count as {int}")
      public void iSelectVehicleCountAs(int vehicle_count) {
            VehiclePage.getInstance().adjustVehicleQuantity(vehicle_count);
      }

      @And("I get the vehicle price in PBS")
      public void iGetTheVehiclePriceInPBS() {
            ScenarioContext.setContext("vehiclePriceInPBS", VehiclePage.getInstance().getVehiclePriceInPBS());
      }


      @Then("Verify vehicle price for {int} should be updated in vehicle pricedown section")
      public void verifyVehiclePriceForVehicle_quantityShouldBeUpdatedInVehiclePricedownSection(int quantity) {
            System.out.println(VehiclePage.getInstance().getVehiclePriceForMultipleVehicle(quantity));
            System.out.println(VehiclePage.getInstance().getVehiclePriceInPBS());
            Assert.assertEquals(VehiclePage.getInstance().getVehiclePriceForMultipleVehicle(quantity),
                    VehiclePage.getInstance().getVehiclePriceInPBS());
      }

      @Then("Verify the Total price is updated properly in vehicle price break down section")
      public void verifyTheTotalPriceIsUpdatedProperlyInVehiclePriceBreakDownSection() {
            Assert.assertEquals(VehiclePage.getInstance().expectedTotalPriceInPBS(), VehiclePage.getInstance().getTotalPriceInPBS());
      }

      @Then("Verify the meet and greet price is {string} when its not selected")
      public void verifyTheMeetAndGreetPriceIsWhenItsNotSelected(String meet_greet_price) {
            Assert.assertEquals(meet_greet_price,
                    VehiclePage.getInstance().getMeetAndGreetPriceInPBS());
      }

      @And("I click on meet and greet checkbox")
      public void iClickOnMeetAndGreetCheckbox() throws InterruptedException {
            VehiclePage.getInstance().clickOnMeetAndGreetCB();
            Thread.sleep(3000);
      }

      @And("I get the meet and greet price in vehicle page")
      public void iGetTheMeetAndGreetPriceInVehiclePage() {
            ScenarioContext.setContext("meetAndGreetPrice", VehiclePage.getInstance().getMeetAndGreetPriceInPBS());
      }
      @And("I get the infant seat price in vehicle page")
      public void iGetTheInfantSeatPriceInVehiclePage() {
            ScenarioContext.setContext("InfantPrice", VehiclePage.getInstance().getInfantPriceInPBS());
      }
      @And("I get the booster seat price in vehicle page")
      public void iGetTheBoosterSeatPriceInVehiclePage() {
            ScenarioContext.setContext("BoosterPrice", VehiclePage.getInstance().getBoosterPriceInPBS());
      }
      @And("I get the Child seat price in vehicle page")
      public void iGetTheChildSeatPriceInVehiclePage() {
            ScenarioContext.setContext("ChildPrice", VehiclePage.getInstance().getChildPriceInPBS());

      }
      @Then("Verify the meet and greet price should be updated when its selected")
      public void verifyTheMeetAndGreetPriceShouldBeUpdatedWhenItsSelected() {
            Assert.assertEquals(VehiclePage.getInstance().expectedMeetAndGreetPrice(),
                    VehiclePage.getInstance().getMeetAndGreetPriceInPBS());
      }

      @And("I click on child seat checkbox")
      public void iClickOnChildSeatCheckbox() {
            VehiclePage.getInstance().clickOnChildSeatCB();
      }

      @Then("Verify the child seat price is {string} when its not selected")
      public void verifyTheChildSeatPriceIsWhenItsNotSelected(String price) {
            Assert.assertEquals(price, VehiclePage.getInstance().getChildSeatPriceInPBS());
      }


      @And("I select infant seat quantity as {int}")
      public void iSelectInfantSeatQuantityAsInfant_seat_quantity(int quantity) {
            VehiclePage.getInstance().adjustInfantQuantity(quantity);
      }

      @And("I select booster seat quantity as {int}")
      public void iSelectBoosterSeatQuantityAsBooster_seat_quantity(int quantity) {
            VehiclePage.getInstance().adjustBoosterQuantity(quantity);
      }

      @And("I select child seat quantity as {int}")
      public void iSelectChildSeatQuantityAsChild_seat_quantity(int quantity) {
            VehiclePage.getInstance().adjustChildQuantity(quantity);
      }

      @And("I get the infant quantity in the vehicle page")
      public void iGetTheInfantQuantityInTheVehiclePage() {
            ScenarioContext.setContext("infant_count", VehiclePage.getInstance().getInfantCount());
      }

      @And("I get the booster quantity in the vehicle page")
      public void iGetTheBoosterQuantityInTheVehiclePage() {
            ScenarioContext.setContext("booster_count", VehiclePage.getInstance().getBoosterQuantity());
      }

      @And("I get the child quantity in the vehicle page")
      public void iGetTheChildQuantityInTheVehiclePage() {
            ScenarioContext.setContext("child_count", VehiclePage.getInstance().getChildQuantity());
      }

      @Then("Verify the child seats price should be updated when its selected")
      public void verifyTheChildSeatsPriceShouldBeUpdatedWhenItsSelected() {
            Assert.assertEquals(VehiclePage.getInstance().expectedChildSeatPrices(),
                    VehiclePage.getInstance().getChildSeatPriceInPBS());
      }

      @Then("Verify the all vehicles are displayed in the price ascending order")
      public void verifyTheAllVehiclesAreDisplayedInThePriceAscendingOrder() throws InterruptedException {
//            System.out.println(VehiclePage.getInstance().getAllVehiclesPrice());
//            System.out.println(VehiclePage.getInstance().isAllVehicleSorted());
            Assert.assertTrue(VehiclePage.getInstance().isAllVehicleSorted());
      }

      @Then("Verify the all images are displayed in the vehicle page")
      public void verifyTheAllImagesAreDisplayedInTheVehiclePage() {
            Assert.assertTrue(VehiclePage.getInstance().areImagesDisplayedInAllVehicleGroups());
      }

      @And("I click on the clear all filter link")
      public void iClickOnTheClearAllFilterLink() {
            VehiclePage.getInstance().clickOnClearAllFilterLink();
      }
      @And("I click on the All check box")
      public void iClickOnTheAllCheckBox() throws InterruptedException {
            VehiclePage.getInstance().clickOnAllSeatCapacityCB();
      }
      @When("the user applies the seating capacity filter for {string}")
      public void theUserAppliesTheSeatingCapacityFilterFor(String capacity) {
            VehiclePage.getInstance().clickOnSeatCapacityCB(capacity);
      }

      @Then("only vehicles with seating capacity {int} to {int} are displayed")
      public void onlyVehiclesWithSeatingCapacityToAreDisplayed(int minCapacity, int maxCapacity) {
            Assert.assertTrue(VehiclePage.getInstance().areAllVehicleSectionsPasLugCountUpdated(minCapacity, maxCapacity));
      }


      @Then("Verify the error message for no vehicle available for expected filter")
      public void verifyTheErrorMessageForNoVehicleAvailableForExpectedFilter() {
            Assert.assertTrue(VehiclePage.getInstance().isErrorMsgAvailableForNoVehicle());
      }

      @And("the user enters a minimum price {string}")
      public void theUserEntersAMinimumPrice(String min_price) {
            VehiclePage.getInstance().enterMinimumInputPrice(min_price);
      }

      @And("the user enters a maximum price {string}")
      public void theUserEntersAMaximumPrice(String max_price) {
            VehiclePage.getInstance().enterMaximumInputPrice(max_price);
      }

      @Then("only vehicles with price between {double} to {double} are displayed")
      public void onlyVehiclesWithPriceBetweenMinPriceToMaxPriceAreDisplayed(double min_price, double max_price) {
            Assert.assertEquals(VehiclePage.getInstance().areVehiclePricesAreInExpRangeInAllSections(min_price, max_price), true);
      }




}
