package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RideListPage {
      private static RideListPage RideListInstance;
      public RideListPage(){}
      public static RideListPage getInstance()
      {
            if(RideListInstance == null)
            {
                  RideListInstance = new RideListPage();
            }
            return RideListInstance;
      }

      // Title
      @FindBy(className = "title") private WebElement textTitle;
      public String getTitle() { return Utils.getWebElementText(textTitle);}



      // Past and Future Switch Buttons
      @FindBy(id = "futureBtn") private WebElement btnFuture;
      public boolean isFutureBtnDisplayed() { return Utils.checkIfElementIsDisplayed(btnFuture);}
      public void clickOnFutureBtn()
      {
            Utils.clickOnElement(btnFuture);
      }
      @FindBy(id = "pastBtn") private WebElement btnPast;
      public boolean isBtnPastDisplayed() { return Utils.checkIfElementIsDisplayed(btnPast);}
      public void clickOnPastBtn()
      {
            Utils.clickOnElement(btnPast);
      }


      // Ride Data
      @FindBy(xpath = "//*[@id=\"rightArrow\"]") private WebElement btnNextPage;
      private String rideIdXPath = "//div[@class='ride-list-ride-info']//div[contains(text(), '%s')]";

      public String getRidePartnerName(String dynamicRideId) {
            String formattedXPath = String.format(rideIdXPath, dynamicRideId);
            String rideText = Utils.getWebElementText(DriverManager.getDriver().findElement(By.xpath(formattedXPath)));
            String partnerName = rideText.split(" ")[0];
            return partnerName;
      }

      public String getRideId(String dynamicRideId) {
            while (true) {
                  try {
                        // Step 1: Format the XPath with the dynamic ride ID
                        String formattedXPath = String.format(rideIdXPath, dynamicRideId);
                        WebElement rideId = DriverManager.getDriver().findElement(By.xpath(formattedXPath));

                        // Step 2: Check if the element is displayed and return the ride ID
                        if (rideId.isDisplayed()) {
                              return Utils.getWebElementText(rideId).split(" ")[2];
                        }
                  } catch (NoSuchElementException e) {
                        // Element not found on the current page, proceed to the next page
                        e.getMessage();
                  }

                  // Step 3: Click the next page button if it's displayed and enabled
                  if (btnNextPage.isDisplayed() && btnNextPage.isEnabled()) {
                        Utils.clickOnElement(btnNextPage);
                  } else {
                        // Exit the loop if there are no more pages to navigate
                        break;
                  }
            }
            // Return a default value or throw an exception if the ride ID is not found
            throw new NoSuchElementException("Ride ID " + dynamicRideId + " not found after searching all available pages.");
      }

      private String rideStatusXpath = "//div[@class='ride-list-ride-info']//div[contains(text(), '%s')]//ancestor::a[@class='ride-card']//div[contains(@class, 'payment-status')]";
      public String getRideStatus(String dynamicRideId) {
            String formattedXPath = String.format(rideStatusXpath, dynamicRideId);
            return Utils.getWebElementText(DriverManager.getDriver().findElement(By.xpath(formattedXPath)));
      }
      private String vehicleNameXpath = "//div[@class='ride-list-ride-info']//div[contains(text(), '%s')]//ancestor::a[@class='ride-card']//span[contains(@class, 'vehicle-name')]";
      public String getRideVehicleName(String dynamicRideId) {
            String formattedXPath = String.format(vehicleNameXpath, dynamicRideId);
            return Utils.getWebElementText(DriverManager.getDriver().findElement(By.xpath(formattedXPath)));
      }
      private String vehicleBrandXpath = "//div[@class='ride-list-ride-info']//div[contains(text(), '%s')]//ancestor::a[@class='ride-card']//span[contains(@class, 'vehicle-model')]";
      public String getRideVehicleBrand(String dynamicRideId) {
            String formattedXPath = String.format(vehicleBrandXpath, dynamicRideId);
            return Utils.getWebElementText(DriverManager.getDriver().findElement(By.xpath(formattedXPath)));
      }
      private String rideDateTimeXpath = "//div[@class='ride-list-ride-info']//div[contains(text(), '%s')]//ancestor::a[@class='ride-card']//div[@class='location-desktop']//div[@class='local-time']";
      public String getRideDateTime(String dynamicRideId)
      {
            String formattedXPath = String.format(rideDateTimeXpath, dynamicRideId);
            String DateTime = Utils.getWebElementText(DriverManager.getDriver().findElement(By.xpath(formattedXPath)));
            // Split the string based on comma and "·"
            String[] parts = DateTime.split(" · ");
            // Extract and trim the date and time parts
            return parts[0].trim();
      }
      private String rideLocationXpath = "//div[@class='ride-list-ride-info']//div[contains(text(), '%s')]//ancestor::a[@class='ride-card']//div[@class='timeline-content']//p[contains(@class, 'ride-locations')]";
      public List<String> getRideLocation(String dynamicRideId) {
            String formattedXPath = String.format(rideLocationXpath, dynamicRideId);
            List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath(formattedXPath));

            List<String> locations = new ArrayList<>();
            for (WebElement element : elements) {
                  locations.add(Utils.getWebElementText(element));
            }
            return locations;
      }
      private String rideAmountXpath = "//div[@class='ride-list-ride-info']//div[contains(text(), '%s')]//ancestor::a[@class='ride-card']//div[@class='price-section-desktop']//div[@class='ride-price']";
      public String getRideAmount(String dynamicRideId) {
            String formattedXPath = String.format(rideAmountXpath, dynamicRideId);
            return Utils.getWebElementText(DriverManager.getDriver().findElement(By.xpath(formattedXPath)));
      }


      @FindBy(xpath = "//*[@id='rideCardsContainer']//div[@class='location-desktop']//div[@class='local-time']")
      private List<WebElement> textDateTime;

      // Verify the rides are in ascending order
      public boolean isDateInAscendingOrder1() throws InterruptedException {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy, h:mm a");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy, h:mm a"); // 12-hour output format
            LocalDateTime previousDate = null;  // Variable to store the previous date for comparison

            while (true) {
                  // Loop through all the dates on the current page
                  for (int i = 0; i < textDateTime.size() - 1; i++) {
                        // Get the first date
                        String firstDateString = textDateTime.get(i).getText().split("-")[0].trim();
                        LocalDateTime firstDate = LocalDateTime.parse(firstDateString, formatter);

                        // Get the second date
                        String secondDateString = textDateTime.get(i + 1).getText().split("-")[0].trim();
                        LocalDateTime secondDate = LocalDateTime.parse(secondDateString, formatter);

                        // Compare first and second date for ascending order
                        if (firstDate.isAfter(secondDate)) {
                              System.out.println("Error: " + firstDate.format(outputFormatter) + " should be after " +
                                      secondDate.format(outputFormatter));
                              return false;  // Return false if dates are not in ascending order
                        }

                        // If we're checking dates across multiple pages, compare with the last date from the previous page
                        if (previousDate != null && previousDate.isAfter(firstDate)) {
                              System.out.println("Error: " + firstDate + " should be after " + previousDate);
                              return false;  // Return false if dates across pages are not in ascending order
                        }

                        // Update previous date to be the last date on the current page
                        previousDate = secondDate;
                  }
                  // Check if the next page button is available and clickable
                  if (!btnNextPage.isDisplayed() || !btnNextPage.isEnabled()) {
                        break;  // No more pages to check
                  }

                  Utils.clickOnElement(btnNextPage);
                  Thread.sleep(5000);  // Optional: Adjust sleep time based on page loading speed
            }
            return true;  // Return true if all dates on all pages are in ascending order
      }




      public boolean isDateInDescendingOrder1() throws InterruptedException {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy, h:mm a");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy, h:mm a"); // 12-hour output format
            LocalDateTime previousDate = null;  // Variable to store the previous date for comparison

            while (true) {
                  // Loop through all the dates on the current page
                  for (int i = 0; i < textDateTime.size() - 1; i++) {
                        // Get the first date
                        String firstDateString = textDateTime.get(i).getText().split("-")[0].trim();
                        LocalDateTime firstDate = LocalDateTime.parse(firstDateString, formatter);

                        // Get the second date
                        String secondDateString = textDateTime.get(i + 1).getText().split("-")[0].trim();
                        LocalDateTime secondDate = LocalDateTime.parse(secondDateString, formatter);

                        // Compare first and second date for descending order
                        if (firstDate.isBefore(secondDate)) {
                              System.out.println("Error: " + firstDate.format(outputFormatter) + " should be before " +
                                      secondDate.format(outputFormatter));
                              return false;  // Return false if dates are not in descending order
                        }

                        // If we're checking dates across multiple pages, compare with the last date from the previous page
                        if (previousDate != null && previousDate.isBefore(firstDate)) {
                              System.out.println("Error: " + firstDate.format(outputFormatter) + " should be before " + previousDate);
                              return false;  // Return false if dates across pages are not in descending order
                        }

                        // Update previous date to be the last date on the current page
                        previousDate = secondDate;
                  }

                  // Check if the next page button is available and clickable
                  if (!btnNextPage.isDisplayed() || !btnNextPage.isEnabled()) {
                        break;  // No more pages to check
                  }

                  Utils.clickOnElement(btnNextPage);
                  Thread.sleep(5000);  // Optional: Adjust sleep time based on page loading speed
            }

            return true;  // Return true if all dates on all pages are in descending order
      }

      public boolean isDateGreaterThanNow() throws InterruptedException {
            List<LocalDateTime> dateList = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy, h:mm a");

            while (true) {
                  for (WebElement element : textDateTime) {
                        // Extract only the date and time part before '·'
                        String dateString = element.getText().split("-")[0].trim();
                        // Parse the extracted date string
                        LocalDateTime parsedDateTime = LocalDateTime.parse(dateString, formatter);

                        // Check if parsed date-time is after the current time
                        if (!parsedDateTime.isAfter(LocalDateTime.now())) {
                              return false;  // Return false if any date-time is not greater than now
                        }
                        dateList.add(parsedDateTime);  // Collect date-times for debugging/logging
                  }

                  // Exit if no next page button or it is not enabled
                  if (!btnNextPage.isDisplayed() || !btnNextPage.isEnabled()) {
                        break;
                  }
                  // Navigate to the next page
                  btnNextPage.click();
                  Thread.sleep(3000);  // Add a wait to ensure the page loads properly
            }
            return true;  // Return true if all date-times are greater than now
      }

      public boolean isDateLesserThanNow() throws InterruptedException {
            List<LocalDateTime> dateList = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy, h:mm a");

            while (true) {
                  for (WebElement element : textDateTime) {
                        String dateString = element.getText().split("-")[0].trim();
                        LocalDateTime parsedDateTime = LocalDateTime.parse(dateString, formatter);

                        // Check if parsed date-time is before the current time
                        if (!parsedDateTime.isBefore(LocalDateTime.now())) {
                              return false;  // Return false if any date-time is not less than now
                        }

                        dateList.add(parsedDateTime);  // Optionally collect the date-times for logging
                  }

                  // Exit if no next page button or it is not enabled
                  if (!btnNextPage.isDisplayed() || !btnNextPage.isEnabled()) {
                        break;
                  }

                  // Navigate to the next page
                  btnNextPage.click();
                  Thread.sleep(3000);  // Add a wait to ensure the page loads properly
            }
            return true;  // Return true if all date-times are less than now
      }

      @FindBy(xpath = "//*[@class=\"ride-card\"]") private List<WebElement> rideCards;
      public boolean getRideCardCount(int count) throws InterruptedException {
            int totalRideCardsCount = 0;
            boolean hasNextPage = true;
            while (hasNextPage) {
                  if (rideCards.size() > count) {
                        return false; // Return false if the current page does not contain exactly 5 records
                  }
                  if (btnNextPage.isDisplayed() && btnNextPage.isEnabled())
                  {
                        Utils.clickOnElement(btnNextPage);
                        Thread.sleep(3000);
                  }else {
                        hasNextPage=false;
                  }
            }
            return true;
      }


      // Verify the Ride Confirmation page
      @FindBy(xpath = "(//*[@id=\"rideCardsContainer\"]//div[contains(@class, 'ride-id')])[1]") private WebElement linkRideIdDetails;
      public void clickOnRideIdLink()
      {
            Utils.clickOnElement(linkRideIdDetails);
      }
      public String getRideIdLinkText()
      {
            return Utils.getWebElementText(linkRideIdDetails);
      }

      @FindBy(xpath = "(//*[@id=\"rideCardsContainer\"]//div[contains(@class, 'payment-status')])[1]") private WebElement textRideStatus;
      public String getRideStatusText()
      {
            return Utils.getWebElementText(textRideStatus);
      }


}
