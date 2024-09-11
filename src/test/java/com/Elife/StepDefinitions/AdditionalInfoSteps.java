package com.Elife.StepDefinitions;

import com.Elife.PageComponent.AdditionalInfoPage;
import com.Elife.PageComponent.ContactPage;
import com.Elife.PageComponent.ItineraryPage;
import com.Elife.Utilities.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AdditionalInfoSteps {
      @Given("Verify {string} title should be present in the Additional Info Page")
      public void verifyTitleShouldBePresentInTheAdditionalInfoPage(String string) {
            Assert.assertEquals(string, AdditionalInfoPage.getInstance().getTitle());
      }

      @Then("Verify {string} sub title present in the additional info page")
      public void verifySubTitlePresentInTheAdditionalInfoPage(String string) {
            Assert.assertEquals(string, AdditionalInfoPage.getInstance().getSubTitle());
      }



      @And("Verify {string} Child Seat title present in the additional info page")
      public void verifyChildSeatTitlePresentInTheAdditionalInfoPage(String string) {
            Assert.assertEquals(string, AdditionalInfoPage.getInstance().getChildSeatSecTitle());
      }

      @And("Verify {string} Special Instructions title present in the additional info page")
      public void verifySpecialInstructionsTitlePresentInTheAdditionalInfoPage(String string) {
            Assert.assertEquals(string, AdditionalInfoPage.getInstance().getSpecialInstructionSecTitle());
      }


      @Then("Verify {string} is displayed")
      public void verifyIsDisplayed(String text) {
            AdditionalInfoPage.getInstance().checkIfAdditionalInfoDisplayed(text);
      }


      @Then("I click on the next button in the additional info page")
      public void iClickOnTheNextButtonInTheAdditionalInfoPage() throws InterruptedException {
            AdditionalInfoPage.getInstance().clickOnNextBtn();
            Thread.sleep(5000);
      }

      @Given("I select {string} for the Meet & Greet sign")
      public void iSelectForTheMeetGreetSign(String option) throws InterruptedException {
            AdditionalInfoPage.getInstance().selectMeetAndGreetOption(option);
      }

      @And("I select {string} for the child seat")
      public void iSelectForTheChildSeat(String option) throws InterruptedException {
            AdditionalInfoPage.getInstance().selectChildSeatOption(option);
      }

      @And("I set the quantity {string} for the Infant Seat")
      public void iSetTheQuantityForTheInfantSeat(String quantity) throws InterruptedException {
            AdditionalInfoPage.getInstance().enterInfantSeatQuantity(quantity);
      }

      @And("I set the quantity {string} for the Booster Seat")
      public void iSetTheQuantityForTheBoosterSeat(String quantity) throws InterruptedException {
            AdditionalInfoPage.getInstance().enterBoosterSeatQuantity(quantity);
      }

      @And("I set the quantity {string} for the Child Seat")
      public void iSetTheQuantityForTheChildSeat(String quantity) throws InterruptedException {
            AdditionalInfoPage.getInstance().enterChildSeatQuantity(quantity);
      }


      @Then("I get the price of the infant seat")
      public void iGetThePriceOfTheInfantSeat() {
            ScenarioContext.setContext("infant_seat_price", AdditionalInfoPage.getInstance().getInfantSeatPrice());
      }


      @Then("I get the price of the booster seat")
      public void iGetThePriceOfTheBoosterSeat() {
            ScenarioContext.setContext("booster_seat_price", AdditionalInfoPage.getInstance().getBoosterSeatPrice());
      }

      @Then("I get the price of the child seat seat")
      public void iGetThePriceOfTheChildSeatSeat() {
            ScenarioContext.setContext("child_seat_price", AdditionalInfoPage.getInstance().getChildSeatPrice());
      }

      @Then("I get the price of the meet and greet")
      public void iGetThePriceOfTheMeetAndGreet() {
            ScenarioContext.setContext("meet_greet_price", AdditionalInfoPage.getInstance().getMeetAndGreetPrice());
      }
}
