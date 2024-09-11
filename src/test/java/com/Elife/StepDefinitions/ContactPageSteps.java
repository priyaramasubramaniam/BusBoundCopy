package com.Elife.StepDefinitions;

import com.Elife.PageComponent.ContactPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

public class ContactPageSteps {

      @When("I enter the following details into the form")
      public void iEnterTheFollowingDetailsIntoTheForm(DataTable dataTable) throws InterruptedException {
            List<Map<String, String>> formData = dataTable.asMaps(String.class, String.class);

            for (Map<String, String> extractList : formData) {
                  String field = extractList.get("Field");
                  String value = extractList.get("Values");


                  if (value == null || value.trim().isEmpty()) {
                        continue; // Skip processing if the value is null or empty
                  }

                  switch (field) {
                        case "Name":
                              ContactPage.getInstance().enterName(value);
                              break;
                        case "Salutation":
                              ContactPage.getInstance().clickOnSalutation();
                              ContactPage.getInstance().selectSalutation(value);
                              break;
                        case "Email":
                              ContactPage.getInstance().enterEmail(value);
                              break;
                        case "Phone Number 1 Code":
                              ContactPage.getInstance().selectCountryCode1();
                              break;
                        case "Phone Number 1":
                              ContactPage.getInstance().enterCellNumber1(value);
                              break;
                        case "Phone Number 2 Code":
                              ContactPage.getInstance().selectCountryCode2();
                              break;
                        case "Phone Number 2":
                              ContactPage.getInstance().enterCellNumber2(value);
                              break;
                        case "Social Media":
                              ContactPage.getInstance().selectSocialMedia();
                              break;
                        case "Social Media Name":
                              ContactPage.getInstance().enterSocialMedia(value);
                              break;
                        default:
                              // Handle unknown fields if necessary
                              break;
                  }
            }
      }


      @Then("I click on next button in contact page")
      public void iClickOnNextButtonInContactPage() {
            ContactPage.getInstance().clickOnNextBtn();
      }



}
