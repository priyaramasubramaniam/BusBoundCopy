package com.Elife.StepDefinitions;

import com.Elife.PageComponent.HomePage;
import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
}
