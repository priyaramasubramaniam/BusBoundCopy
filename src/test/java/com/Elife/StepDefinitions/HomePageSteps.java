package com.Elife.StepDefinitions;

import com.Elife.PageComponent.HomePage;
import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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



}
