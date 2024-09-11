package com.Elife.StepDefinitions;

import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Common_Step_Definitions {

      private static String scenarioName = null;

      public static String getScenarioName() {
            return scenarioName;
      }

      private static final Logger LOGGER = LogManager.getLogger(Common_Step_Definitions.class);

      @Before
      public void beforeScenario(Scenario scenario) {
            LOGGER.info("Execution started......");
            try {
                  String scenarioName = scenario.getName();
                  String scenarioDescription = "Scenario: " + scenario.getName();
                  DriverManager.launchBrowser();
                  Utils.initWebElements();
            } catch (Exception e) {
                  e.printStackTrace();
            }




            /* If you want to run entire feature in one browser use this
            LOGGER.info("Execution started......");
            try {
                  LOGGER.info("Checking the driver is null or not.........");
                  if(driver == null)
                  {
                        DriverManager.launchBrowser();
                        Utils.initWebElements();
                  }

            }catch (Exception e)
            {
                  e.printStackTrace();
            }
      } */
      }
      @After
      public void afterScenario()
      {
            DriverManager.getDriver().quit();
      }

      @AfterStep
      public void attachScreenshot(Scenario scenario)
      {
            if (scenario.isFailed()) {
                  byte[] screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                  String screenshotDirectory = "E://BusBoundApp - Copy/screenshots/";
                  File directory = new File(screenshotDirectory);

                  if (!directory.exists()) {
                        directory.mkdirs();  // Create directories if they do not exist
                  }

                  String screenshotName = "error-screen-" + System.currentTimeMillis() + ".png";
                  File screenshotFile = new File(screenshotDirectory + screenshotName);

                  try {
                        Files.write(screenshotFile.toPath(), screenshotTaken);
                        scenario.attach(screenshotTaken, "image/png", screenshotName);
                  } catch (IOException e) {
                        e.printStackTrace();
                  }
                  DriverManager.getDriver().quit();
            }
      }

      private static int passedCount = 0;
      private static int failedCount = 0;
      private static int blockedCount = 0;



      // Track test results after each scenario
      @After
      public void trackResult(Scenario scenario) {
            if (scenario.isFailed()) {
                  failedCount++;
            } else if (scenario.getStatus().name().equalsIgnoreCase("SKIPPED")) {
                  blockedCount++;
            } else {
                  passedCount++;
            }
      }

      // Print the test result summary after all scenarios
      @AfterAll
      public static void printSummary() {
            System.out.println("Test overview:");
            System.out.println("Running num: " + (passedCount + failedCount + blockedCount));
            System.out.println("Passed num: " + passedCount);
            System.out.println("Failed num: " + failedCount);
            System.out.println("Blocked num: " + blockedCount);
      }


}
