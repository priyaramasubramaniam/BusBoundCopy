package com.Elife.StepDefinitions;

import com.Elife.PageComponent.ItineraryPage;
import com.Elife.PageComponent.VehiclePage;
import com.Elife.Utilities.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehiclePageSteps {

      @When("I select the vehicle in the vehicle page")
      public void iSelectTheVehicleInTheVehiclePage() {
            VehiclePage.getInstance().selectVehicle();
      }

      @And("I click on the next button in the vehicle page")
      public void iClickOnTheNextButtonInTheVehiclePage() throws InterruptedException {
            VehiclePage.getInstance().clickOnNextBtn();
            Thread.sleep(3000);
      }

      @And("I get the vehicle info in the vehicle page")
      public void iGetTheVehicleInfoInTheVehiclePage() {
            ScenarioContext.setContext("vehicleName", VehiclePage.getInstance().getVehicleName());
            ScenarioContext.setContext("vehicleBrand", VehiclePage.getInstance().getVehicleBrand());
            ScenarioContext.setContext("vehicleMaxPax", VehiclePage.getInstance().getMaxPax());
            ScenarioContext.setContext("vehicleMaxLux", VehiclePage.getInstance().getMaxLux());
      }
      @And("I get the vehicle price in the vehicle page")
      public void iGetTheVehiclePriceInTheVehiclePage() {
            ScenarioContext.setContext("vehiclePrice", VehiclePage.getInstance().getVehiclePrice());
      }




}
