package com.Elife.StepDefinitions;

import com.Elife.PageComponent.ContactPage;
import com.Elife.PageComponent.HomePage;
import com.Elife.PageComponent.ItineraryPage;
import com.Elife.PageComponent.RideConfirmationPage;
import com.Elife.Utilities.ExcelUtils;
import com.Elife.Utilities.ScenarioContext;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.be.I;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.Assert;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItineraryPageSteps {


      @Given("I click on Round trip Radio button")
      public void iClickOnRoundTripRadioButton() {
            ItineraryPage.getInstance().clickOnReturnTripCB();
      }
      @Given("I set passenger count as {string}")
      public void iSetPassengerCountAs(String passenger_count) throws InterruptedException {
            ItineraryPage.getInstance().enterPassengerCount(passenger_count);
      }
      @Then("I set luggage count as {string}")
      public void iSetLuggageCountAs(String string) throws InterruptedException {
            ItineraryPage.getInstance().enterLuggageCount(string);
      }

      @And("I click on event type")
      public void iClickOnEventType() {
            ItineraryPage.getInstance().clickOnEventTypeDD();
      }

      @And("User selects the event type as {string}")
      public void userSelectsTheEventTypeAs(String event_type) {
            ItineraryPage.getInstance().clickOnEventType(event_type);
      }

      @When("the user enters the trip details into the input fields")
      public void theUserEntersTheTripDetailsIntoTheInputFields(DataTable dataTable) throws InterruptedException, IOException {
            // Convert DataTable to a List of Maps
            // To get data from Data Table
            List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

            // To get data from Excel file
//            String excelFilePath = "src/test/java/com/Elife/TestData/rideTestData.xlsx";
//            String sheetName = "Sheet1";
//            List<Map<String, String>> rows = ExcelUtils.getTripDetailsFromExcel(excelFilePath, sheetName);

            // Maps to store details for each field type
            Map<String, List<String>> fieldValues = new HashMap<>();

            // Initialize the map with empty lists for each field type
            for (String field : Arrays.asList("Location", "Year", "Month", "Day", "Hour", "Minute", "Period")) {
                  fieldValues.put(field, new ArrayList<>());
            }

            // Populate the map with values from the rows
            for (Map<String, String> row : rows) {
                  String field = row.get("Field");
                  if (field != null && fieldValues.containsKey(field)) {
                        // Loop through the keys to find all "Value" columns
                        for (Map.Entry<String, String> entry : row.entrySet()) {
                              String key = entry.getKey();
                              if (key.startsWith("Value") && entry.getValue() != null && !entry.getValue().isEmpty()) {
                                    fieldValues.get(field).add(entry.getValue());
                              }
                        }
                  }
            }

            // Convert lists to arrays and handle empty lists gracefully
            String[] locations = fieldValues.getOrDefault("Location", Collections.emptyList()).toArray(new String[0]);
            String[] years = fieldValues.getOrDefault("Year", Collections.emptyList()).toArray(new String[0]);
            String[] months = fieldValues.getOrDefault("Month", Collections.emptyList()).toArray(new String[0]);
            String[] days = fieldValues.getOrDefault("Day", Collections.emptyList()).toArray(new String[0]);
            String[] hours = fieldValues.getOrDefault("Hour", Collections.emptyList()).toArray(new String[0]);
            String[] minutes = fieldValues.getOrDefault("Minute", Collections.emptyList()).toArray(new String[0]);
            String[] periods = fieldValues.getOrDefault("Period", Collections.emptyList()).toArray(new String[0]);

            // Enter trip details using the Page Object Model
            ItineraryPage.getInstance().enterTripDetails(locations, years, months, days, hours, minutes, periods);
      }


      @And("I click on next button in itinerary page")
      public void iClickOnNextButtonInItineraryPage() throws InterruptedException {
            Thread.sleep(3000);
            ItineraryPage.getInstance().clickOnNextBtn();
            Thread.sleep(3000);
//            ItineraryPage.getInstance().clickOnNextBtn();
      }


      @And("the user adds {int} stops")
      public void theUserAddsStops(int StopsCount) {
            for (int i = 0; i < StopsCount; i++) {
                  ItineraryPage.getInstance().addStops();
            }
      }



}
