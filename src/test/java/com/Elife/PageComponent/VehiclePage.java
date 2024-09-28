package com.Elife.PageComponent;

import com.Elife.Utilities.ScenarioContext;
import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.be.I;
import io.cucumber.java.en.And;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.Elife.Utilities.Utils.*;

public class VehiclePage {
      private static VehiclePage VehicleInstance;
      public VehiclePage(){}
      public static VehiclePage getInstance()
      {
            if(VehicleInstance == null)
            {
                  VehicleInstance = new VehiclePage();
            }
            return VehicleInstance;
      }

      // Itinerary Information
      @FindBy(id = "itinary-outline") public WebElement itineraryOutline;
      @FindBy(id = "itinary-from-location") private WebElement textFromLocation;
      public String getFromLocation() { return Utils.getWebElementText(textFromLocation);}
      @FindBy(id = "itinary-from-date") private WebElement textFromDateTime;
      public String getFromDateTime() { return Utils.getWebElementText(textFromDateTime);}

      @FindBy(id = "itinary-to-date") private WebElement textToDateTime;
      public String getToDateTime() { return Utils.getWebElementText(textToDateTime);}
      @FindBy(id = "itinary-to-location") private WebElement textToLocation;
      public String getToLocation() { return Utils.getWebElementText(textToLocation);}

      @FindBy(id = "itinary-link") private WebElement linkShowAllItinerary;
      public String getShowAllItineraryText()
      {
            if (linkShowAllItinerary.isDisplayed()) {
                  return linkShowAllItinerary.getText();
            } else {
                  return "Itinerary link is not displayed.";
            }
      }
      public boolean isShowAllLinkDisplayed()
      {
            if (linkShowAllItinerary.isDisplayed())
            {
                  return true;
            }
            return false;
      }
      public void clickOnShowAllItineraryLink() { Utils.clickOnElement(linkShowAllItinerary);}

      @FindBy(xpath = "//*[@id=\"itinaries-dropdown-tabs\"]/div//div[1]") private List<WebElement> btnRideDate;
      @FindBy(xpath = "//*[@id=\"itinaries-dropdown-tabs\"]/div//div[2]") private List<WebElement> btnRideMonth;
      public List<String> getRideDates()
      {
            List<String> RideDates = new ArrayList<>();

            for (int i = 0; i < btnRideDate.size(); i++) {
                  Utils.waitForVisibility(btnRideDate.get(i));
                  Utils.moveToElement(btnRideDate.get(i));
                  RideDates.add(Utils.getWebElementText(btnRideDate.get(i))
                          .concat(" ")
                          .concat(Utils.getWebElementText(btnRideMonth.get(i))));
            }
            return RideDates;
      }

      @FindBy(id = "itinaries-dropdown-date") private WebElement textRideDate;
      public List<String> getRideDateForEachDay() throws InterruptedException {
            HomePage.getInstance().hideHeader();
            List<String> RideDates = new ArrayList<>();

            // Iterate through each btnRideDate element starting from the second one
            for (int i = 0; i < btnRideDate.size(); i++) {
                  // Check if the current btnRideDate element is displayed
                  if (btnRideDate.get(i).isDisplayed()) {
                        // Click on the current btnRideDate element
                        Utils.moveToElement(btnRideDate.get(i));
                        btnRideDate.get(i).click();

                        // Add the retrieved text of textRideDate to the list
                        RideDates.add(Utils.getWebElementText(textRideDate).trim());
                  }
            }
            return RideDates;
      }

      @FindBy(xpath = "//*[@id=\"itinaries-dropdown-cards\"]//div[@class='itinary-card-time']")
      private List<WebElement> textRideTimes;
      public List<String> getRideTimes() throws InterruptedException {
            HomePage.getInstance().hideHeader();
            List<String> RideTimes = new ArrayList<>();

            // Iterate through each btnRideDate element starting from the second one
            for (int i = 0; i < btnRideDate.size(); i++) {
                  for (int j=0; j< textRideTimes.size(); j++)
                  {
                        // Check if the current btnRideDate element is displayed
                        if (btnRideDate.get(i).isDisplayed()) {
                              // Click on the current btnRideDate element
                              Utils.focusOnElement(btnRideDate.get(i));
                              btnRideDate.get(i).click();
                              // Add the retrieved text of textRideDate to the list
                              RideTimes.add(Utils.getWebElementText(textRideTimes.get(j)).trim().replace(" ",""));
                        }
                  }
            }

            return RideTimes;
      }

      @FindBy(xpath = "//*[@id=\"itinaries-dropdown-cards\"]//div[@class='itinary-card-location']")
      private List<WebElement> textRideLocations;
      public List<String> getRideLocations() throws InterruptedException {
            HomePage.getInstance().hideHeader();
            List<String> allRideLocations = new ArrayList<>();

            // Check if the first element is enabled; if not, click it
            if (!btnRideDate.get(0).isSelected()) {
                  btnRideDate.get(0).click();
            }

            // Retrieve locations for the first ride date
            for (int j = 0; j < textRideLocations.size(); j++) {
                  allRideLocations.add(Utils.getWebElementText(textRideLocations.get(j)));
            }

            // Iterate through each btnRideDate element starting from the second one
            for (int i = 1; i < btnRideDate.size(); i++) {
                  if (btnRideDate.get(i).isDisplayed()) {
                        // Click on the current btnRideDate element
                        Utils.clickOnElement(btnRideDate.get(i));

                        // Retrieve locations for the current ride date
                        for (int j = 0; j < textRideLocations.size(); j++) {
                              allRideLocations.add(Utils.getWebElementText(textRideLocations.get(j)));
                        }
                  }
            }
            // Optionally, you can remove duplicates if needed
            // allRideLocations = new ArrayList<>(new LinkedHashSet<>(allRideLocations));

            return allRideLocations;
      }

      // Edit Itinerary
      @FindBy(id = "itinary-edit-btn") private WebElement btnEditItinerary;
      public void clickOnEditItineraryBtn()
      {
            Utils.clickOnElement(btnEditItinerary);
      }


      // Vehicle Information
      @FindBy(xpath = "//div[@id=\'vehicle-group-lists\']//div[@class=\'vehicle-price\']")
      private List<WebElement> textVehiclePrices;

      public List<Double> getAllVehiclesPrice()
      {
            Utils.waitForVisibilityOfElements(textVehiclePrices);
            List<Double> Prices = new ArrayList<>();
            for (WebElement element : textVehiclePrices)
            {
                  String price = Utils.getWebElementText(element);
                  String[] values = price.split(" ");
                  Prices.add(Double.valueOf(values[1].replace(",","")));
            }
            return Prices;
      }
      @FindBy(xpath = "//div[@id='vehicle-groups']//div[contains(@class, \"vehicle-class-title\")]")
      private List<WebElement> linkVehicleGroups;
      public boolean isAllVehicleSorted() throws InterruptedException {
            Thread.sleep(3000);
            boolean allSorted = true;  // Track sorting status across all vehicle groups

            for (WebElement vehicleGroup : linkVehicleGroups) {
                  String vehicleGroupName = vehicleGroup.getText();  // Get the name or identifier of the vehicle group
                  Utils.clickOnElement(vehicleGroup);  // Click each vehicle group

                  if (!Utils.isListSortedInAscendingOrder(getAllVehiclesPrice())) {
                        System.out.println("The vehicle group '" + vehicleGroupName + "' is not sorted.");
                        allSorted = false;  // If any group is not sorted, mark as false
                  }
            }
            return allSorted;  // Return the overall result after checking all groups
      }

      @FindBy(xpath = "//div[@id='vehicle-group-lists']//div[@class='vehicle-item-img']//img")
      private List<WebElement> imgVehicles;

      public boolean isImgDisplayed()
      {
            for (WebElement image : imgVehicles) {
                  String src = image.getAttribute("src");
                  if (src == null || src.trim().isEmpty()) {
                        return false; // Return false if any src attribute is empty or null
                  }
            }
            return true;
      }
      public boolean areImagesDisplayedInAllVehicleGroups() {
            Utils.waitForVisibilityOfElements(linkVehicleGroups);
            for (WebElement group : linkVehicleGroups) {
                  group.click(); // Click each vehicle group

                  // Wait for vehicle images to load (you can use explicit wait here if needed)
                  if (!isImgDisplayed()) {
                        return false; // If any page has missing/invalid images, return false
                  }
            }
            return true; // Return true if all images are valid across all pages
      }



      // Seating capacity Filter section
      @FindBy(xpath = "//*[@id=\"clear-all-filters\"]/a") private WebElement linkClearAllFilter;
      public void clickOnClearAllFilterLink()
      {
            Utils.clickOnElement(linkClearAllFilter);
      }
      @FindBy(id = "all-checkbox-checked-icon") private WebElement checkBoxAllSeatCapacity;
      public void clickOnAllSeatCapacityCB() throws InterruptedException {
            Thread.sleep(3000);
            Utils.clickOnElement(checkBoxAllSeatCapacity);
      }
            public String checkBoxSeatCapacityXpath = "//div[@class='filter-seat-capacity']//div[contains(text(),'%s')]//preceding-sibling::input";
      public void clickOnSeatCapacityCB(String capacity)
      {
            String formattedXpath = String.format(checkBoxSeatCapacityXpath, capacity);
            WebElement exactXpath = DriverManager.getDriver().findElement(By.xpath(formattedXpath));
            Utils.waitForVisibility(exactXpath);
            Utils.clickOnElement(exactXpath);
      }
      @FindBy(id = "apply-filter-btn") private WebElement linkApplyFilter;
      public void clickOnApplyFilterLink()
      {
            Utils.clickOnElement(linkApplyFilter);
      }

      @FindBy(xpath = "//div[@id='vehicle-group-lists']//div[@class='vehicle-pass-lag-capacity']")
      private List<WebElement> textMaxPasLugCount;

      public boolean isVehiclePasLugCountUpdated(int minCapacity, int maxCapacity, String vehicleSection) {
            for (WebElement element : textMaxPasLugCount) {
                  if (element.isDisplayed()) {
                        double price = Double.parseDouble(element.getText().split(" ")[1].replace(",", ""));
                        // Check if the price is within the range
                        if (price < minCapacity || price > maxCapacity) {
                              System.out.println("Out of range price detected in vehicle section: " + vehicleSection + " - Price: " + price);
                              return false; // Return false if the price is out of range
                        }
                  } else {
                        String message = textNoVehicleErrorMsg.getText();
                        Assert.assertEquals(message.trim(), "Oops! No vehicles match your filters.");
                  }
            }
            return true; // Return true if all displayed prices are within range
      }
      @FindBy(xpath = "//*[@id=\"empty-vehicle-group\"]//div[@class='empty-vehicle-group-subtitle']//p")
      private WebElement textNoVehicleErrorMsg;
      public boolean areAllVehicleSectionsPasLugCountUpdated(int minCapacity, int maxCapacity) {
            Utils.waitForVisibilityOfElements(linkVehicleGroups);
            for (WebElement vehicleGroup : linkVehicleGroups) {
                  Utils.clickOnElement(vehicleGroup);
                  String vehicleSection = vehicleGroup.getText();

                  // Perform validation only if no error message is displayed for this group
                  if (!isVehiclePasLugCountUpdated(minCapacity, maxCapacity, vehicleSection)) {
                        System.out.println("Error found in vehicle section: " + " "+ vehicleSection);
                        return false; // Return false if any vehicle in the group has an out-of-range price
                  }
            }
            return true; // Return true if all groups have vehicles within the price range
      }

      public boolean isErrorMsgAvailableForNoVehicle()
      {
            Utils.waitForVisibility(linkClearAllFilter);
            for (WebElement linkVehicleGroup  : linkVehicleGroups)
            {
                  Utils.clickOnElement(linkVehicleGroup);
                  if (!textNoVehicleErrorMsg.isDisplayed())
                  {
                        return false;
                  }
            }
            return true;
      }

      @FindBy(id = "zs-fl-tip") private WebElement btnZohoImage;
      public void hideZohoImage()
      {
            DriverManager.getDriver().switchTo().defaultContent();
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.display='none';", btnZohoImage);
      }
      @FindBy(id = "next-btn") private WebElement btnNext;
      public void clickOnNextBtn() throws InterruptedException {
            hideZohoImage();
            Utils.moveToElementJS(btnNext);
            Utils.clickOnElement(btnNext);
      }


      // Price Filter Section
      @FindBy(id = "min-price-input") private WebElement inputMinimumPrice;
      public void enterMinimumInputPrice(String min_price)
      {
            Utils.setTextOnElement(inputMinimumPrice, min_price);
      }
      @FindBy(id = "max-price-input") private WebElement inputMaximumPrice;
      public void enterMaximumInputPrice(String max_price)
      {
            Utils.setTextOnElement(inputMaximumPrice, max_price);
      }
      public boolean isVehiclePricesAreInExpRange(double min_price, double max_price, String vehicleSection) {
            for (WebElement vehiclePrice : textVehiclePrices) {
                  if (vehiclePrice.isDisplayed()) {
                        double price = Double.parseDouble(vehiclePrice.getText().split(" ")[1].replace(",", ""));
                        // Check if the price is within the range
                        if (price < min_price || price > max_price) {
                              return false; // Return false if the price is out of range
                        }
                  } else {
                        String message = textNoVehicleErrorMsg.getText();
                        Assert.assertEquals(message.trim(), "Oops! No vehicles match your filters.");
                  }
            }
            return true; // Return true if all displayed prices are within range
      }
      public boolean areVehiclePricesAreInExpRangeInAllSections(double min_price, double max_price) {
            Utils.waitForVisibilityOfElements(linkVehicleGroups);
            for (WebElement vehicleGroup : linkVehicleGroups) {
                  Utils.clickOnElement(vehicleGroup);
                  String vehicleSection = vehicleGroup.getText();
                  // Perform validation only if no error message is displayed for this group
                  if (!isVehiclePricesAreInExpRange(min_price, max_price, vehicleSection)) {
                        System.out.println(vehicleSection);
                        return false; // Return false if any vehicle in the group has an out-of-range price
                  }
            }
            return true; // Return true if all groups have vehicles within the price range
      }


      // Functional

      @FindBy(xpath = "(//div[@id='vehicle-groups']//div[@class='vehicle-class'])[2]") private WebElement linkVehicleSection;
      @FindBy(xpath = "(//div[@id='vehicle-group-lists']//div[@class='vehicle-card'])[1]") private WebElement linkVehicle;
      public void clickOnVehicleLink() { Utils.clickOnElement(linkVehicle);}
      public void selectVehicle()
      {
            Utils.clickOnElement(linkVehicleSection);
            Utils.clickOnElement(linkVehicle);
      }
      public void modifyVehicle()
      {
            Utils.clickOnElement(linkVehicleSection);
            Utils.clickOnElement(linkVehicle);
      }

      // Modify vehicle Information


      @FindBy(xpath = "//div[@class='vehicle-card vehicle-item-selected']//div[@class='vehicle-name']")
      private WebElement textVehicleName;
      public String getVehicleName()
      {
            return getVehicleNameInPBS().concat(" "+"x"+" ").concat(getVehicleCountInPBS());
      }
      @FindBy(id = "vehicle-name") private WebElement textVehicleNameInPBS;
      public String getVehicleNameInPBS()
      {
            DriverManager.getDriver().switchTo().defaultContent();
            return Utils.getWebElementText(textVehicleNameInPBS);
      }
      @FindBy(id = "vehicle-quantity") private WebElement textVehicleCountInPBS;
      public String getVehicleCountInPBS()
      {
            return Utils.getWebElementText(textVehicleCountInPBS);
      }

      @FindBy(xpath = "//div[@class='vehicle-card vehicle-item-selected']//img") private WebElement imgVehicle;
      public String getVehicleImgSrc()
      {
            waitForVisibility(imgVehicle);
            return imgVehicle.getAttribute("src");
      }
      @FindBy(xpath = "//div[@class='vehicle-card vehicle-item-selected']//div[@class='vehicle-description']")
      private WebElement textVehicleBrand;
      public String getVehicleBrand()
      {
            return Utils.getWebElementText(textVehicleBrand);
      }
      @FindBy(xpath = "(//div[@class='vehicle-card vehicle-item-selected']//div[@class='vehicle-pass-lag-capacity'])[1]")
      private WebElement textMaxPax;
      public String getMaxPax()
      {
            return Utils.getWebElementText(textMaxPax);
      }
      @FindBy(xpath = "(//div[@class='vehicle-card vehicle-item-selected']//div[@class='vehicle-pass-lag-capacity'])[2]")
      private WebElement textMaxLux;
      public String getMaxLux()
      {
            return Utils.getWebElementText(textMaxLux);
      }


      @FindBy(xpath = "//div[@class='vehicle-card vehicle-item-selected']//div[@class='vehicle-price']")
      private WebElement textVehiclePriceInVS;
      public String getVehiclePriceInVS()
      {
            String price = Utils.getWebElementText(textVehiclePriceInVS);
            String[] values = price.split(" ");
            return values[1].replace(",","");
      }



      public String getVehiclePriceForMultipleVehicle(int quantity)
      {
            String vehiclePriceStr = (String) ScenarioContext.getContext("vehiclePrice");
            double vehiclePrice = Double.parseDouble(vehiclePriceStr);
            // Calculate the total cost by multiplying vehicle count by vehicle price
            double totalCost = quantity * vehiclePrice;

            // Return the total cost as a formatted string
            return String.format("%.2f", totalCost);
      }

      // Price Breakdown
      @FindBy(id = "price-breakdown-btn") private WebElement linkPriceBreakdown;
      public void clickOnPriceBreakdownLink()
      {
            Utils.clickOnElement(linkPriceBreakdown);
      }

      @FindBy(xpath = "//div[@class='price-breakdown-widget']//button[@id='minus-vehicle']")
      private WebElement btnVehicleCountMinus;
      @FindBy(xpath = "//div[@class='price-breakdown-widget']//button[@id='plus-vehicle']")
      private WebElement btnVehicleCountPlus;
      @FindBy(xpath = "//div[@class='price-breakdown-widget']//span[@id='vehicle-quantity']")
      private WebElement textVehicleQuantity;

      public void adjustVehicleQuantity(int expectedQuantity) {
            // Parse the actual quantity from string to integer
            int actualQuantity = Integer.parseInt(textVehicleQuantity.getText());

            while (expectedQuantity > actualQuantity) {
                  if (btnVehicleCountPlus.isEnabled()) {
                        // Click on plus button
                        btnVehicleCountPlus.click();
                        actualQuantity++;  // Increase the actual quantity after clicking
                  } else {
                        System.out.println("Plus button is not enabled.");
                        break;
                  }
            }

            while (expectedQuantity < actualQuantity) {
                  if (btnVehicleCountMinus.isEnabled()) {
                        // Click on minus button
                        btnVehicleCountMinus.click();
                        actualQuantity--;  // Decrease the actual quantity after clicking
                  } else {
                        System.out.println("Minus button is not enabled.");
                        break;
                  }
            }

            // If quantities are equal, no action is needed
            if (expectedQuantity == actualQuantity) {
                  System.out.println("No adjustment needed.");
            }
      }

      @FindBy(xpath = "//div[@class='price-breakdown-widget']//span[@id='vehicle-price']")
      private WebElement textVehiclePriceInPBS;
      public String getVehiclePriceInPBS()
      {
            String price = Utils.getWebElementText(textVehiclePriceInPBS);
            String[] values = price.split(" ");
            return values[1].replace(",","");
      }

      @FindBy(id = "meet-greet") private WebElement checkBoxMeetAndGreet;
      public void clickOnMeetAndGreetCB()
      {
            Utils.clickOnElement(checkBoxMeetAndGreet);
      }


      @FindBy(id = "meet-greet-price") private WebElement textExpMeetAndGreetPrice;
      public String expectedMeetAndGreetPrice()
      {
            String price = Utils.getWebElementText(textExpMeetAndGreetPrice);
            String[] values = price.split(" ");
            return values[1];
      }
      @FindBy(xpath = "//div[@class='price-breakdown-widget']//span[@id='meet-greet-price-total']")
      private WebElement textMeetAndGreetPriceInPBS;
      public String getMeetAndGreetPriceInPBS()
      {
            String price = Utils.getWebElementText(textMeetAndGreetPriceInPBS);
            String[] values = price.split(" ");
            return values[1];
      }
      @FindBy(id = "infant-seat-price") private WebElement textInfantPrice;
      public String getInfantPriceInPBS()
      {
            String price = Utils.getWebElementText(textInfantPrice);
            String[] values = price.split(" ");
            Double amount = (Double.parseDouble(values[1])) * (Double.parseDouble(textInfantQuantity.getText()));
            return String.valueOf(amount);
      }
      @FindBy(id = "booster-seat-price") private WebElement textBoosterPrice;
      public String getBoosterPriceInPBS()
      {
            String price = Utils.getWebElementText(textBoosterPrice);
            String[] values = price.split(" ");
            Double amount = (Double.parseDouble(values[1])) * (Double.parseDouble(textBoosterQuantity.getText()));
            return String.valueOf(amount);
      }
      @FindBy(id = "child-seat-price") private WebElement textChildPrice;
      public String getChildPriceInPBS()
      {
            String price = Utils.getWebElementText(textChildPrice);
            String[] values = price.split(" ");
            Double amount = (Double.parseDouble(values[1])) * (Double.parseDouble(textChildQuantity.getText()));
            return String.valueOf(amount);
      }

      @FindBy(id = "need-seats") private WebElement checkboxChildSeat;
      public void clickOnChildSeatCB()
      {
            Utils.waitForVisibility(checkboxChildSeat);
            Utils.clickOnElement(checkboxChildSeat);
      }




      @FindBy(id = "infant-seat-price") private WebElement textInfantSeatPrice;
      @FindBy(id = "booster-seat-price") private WebElement textBoosterSeatPrice;
      @FindBy(id = "child-seat-price") private WebElement textChildSeatPrice;

      @FindBy(id = "infant-quantity") private WebElement textInfantQuantity;
      @FindBy(id = "booster-quantity") private WebElement textBoosterQuantity;
      @FindBy(id = "child-quantity") private WebElement textChildQuantity;
      public String expectedChildSeatPrices()
      {
            String infantPrice = Utils.getWebElementText(textInfantSeatPrice).split(" ")[1];
            String boosterPrice = Utils.getWebElementText(textBoosterSeatPrice).split(" ")[1];
            String childPrice = Utils.getWebElementText(textChildSeatPrice).split(" ")[1];
            Double totalInfantPrice = Double.parseDouble(infantPrice) *
                   Double.parseDouble(Utils.getWebElementText(textInfantQuantity));
            Double totalBoosterPrice = Double.parseDouble(boosterPrice) *
                    Double.parseDouble( Utils.getWebElementText(textBoosterQuantity));
            Double totalChildPrice = Double.parseDouble(childPrice) *
                    Double.parseDouble( Utils.getWebElementText(textChildQuantity));
            double totalCost = totalInfantPrice + totalBoosterPrice + totalChildPrice;
            return String.format("%.2f", totalCost);
      }
      public String getInfantCount()
      {
            String infantQuantity = Utils.getWebElementText(textInfantQuantity);
            return infantQuantity.equals("0") ? "-" : infantQuantity;
      }
      public String getBoosterQuantity()
      {
            String boosterQuantity = Utils.getWebElementText(textBoosterQuantity);
            return boosterQuantity.equals("0") ? "-" : boosterQuantity;
      }
      public String getChildQuantity()
      {
            String childQuantity = Utils.getWebElementText(textChildQuantity);
            return childQuantity.equals("0") ? "-" : childQuantity;
      }

      @FindBy(id = "plus-infant") private WebElement btnInfantPlus;
      @FindBy(id = "minus-infant") private WebElement btnInfantMinus;
      public void adjustInfantQuantity(int expectedQuantity) {
            // Parse the actual quantity from string to integer
            Utils.waitForVisibility(textInfantQuantity);
            int actualQuantity = Integer.parseInt(textInfantQuantity.getText());

            while (expectedQuantity > actualQuantity) {
                  if (btnInfantPlus.isEnabled()) {
                        // Click on plus button
                        btnInfantPlus.click();
                        actualQuantity++;  // Increase the actual quantity after clicking
                  } else {
                        System.out.println("Plus button is not enabled.");
                        break;
                  }
            }
            while (expectedQuantity < actualQuantity) {
                  if (btnInfantMinus.isEnabled()) {
                        // Click on minus button
                        btnInfantPlus.click();
                        actualQuantity--;  // Decrease the actual quantity after clicking
                  } else {
                        System.out.println("Minus button is not enabled.");
                        break;
                  }
            }
            // If quantities are equal, no action is needed
            if (expectedQuantity == actualQuantity) {
                  System.out.println("No adjustment needed.");
            }
      }

      @FindBy(id = "plus-booster") private WebElement btnBoosterPlus;
      @FindBy(id = "minus-booster") private WebElement btnBoosterMinus;
      public void adjustBoosterQuantity(int expectedQuantity) {
            Utils.waitForVisibility(textBoosterQuantity);
            // Parse the actual quantity from string to integer
            int actualQuantity = Integer.parseInt(textBoosterQuantity.getText());

            while (expectedQuantity > actualQuantity) {
                  if (btnBoosterPlus.isEnabled()) {
                        // Click on plus button
                        btnBoosterPlus.click();
                        actualQuantity++;  // Increase the actual quantity after clicking
                  } else {
                        System.out.println("Plus button is not enabled.");
                        break;
                  }
            }
            while (expectedQuantity < actualQuantity) {
                  if (btnBoosterMinus.isEnabled()) {
                        // Click on minus button
                        btnBoosterMinus.click();
                        actualQuantity--;  // Decrease the actual quantity after clicking
                  } else {
                        System.out.println("Minus button is not enabled.");
                        break;
                  }
            }
            // If quantities are equal, no action is needed
            if (expectedQuantity == actualQuantity) {
                  System.out.println("No adjustment needed.");
            }
      }

      @FindBy(id = "plus-child") private WebElement btnChildPlus;
      @FindBy(id = "minus-child") private WebElement btnChildMinus;
      public void adjustChildQuantity(int expectedQuantity) {
            // Parse the actual quantity from string to integer
            Utils.waitForVisibility(textChildQuantity);
            int actualQuantity = Integer.parseInt(textChildQuantity.getText());

            while (expectedQuantity > actualQuantity) {
                  if (btnChildPlus.isEnabled()) {
                        // Click on plus button
                        btnChildPlus.click();
                        actualQuantity++;  // Increase the actual quantity after clicking
                  } else {
                        System.out.println("Plus button is not enabled.");
                        break;
                  }
            }
            while (expectedQuantity < actualQuantity) {
                  if (btnChildMinus.isEnabled()) {
                        // Click on minus button
                        btnChildMinus.click();
                        actualQuantity--;  // Decrease the actual quantity after clicking
                  } else {
                        System.out.println("Minus button is not enabled.");
                        break;
                  }
            }
            // If quantities are equal, no action is needed
            if (expectedQuantity == actualQuantity) {
                  System.out.println("No adjustment needed.");
            }
      }

      @FindBy(xpath = "//div[@class='price-breakdown-widget']//span[@id='need-seats-total']")
      private WebElement textChildSeatPriceInPBS;
      public String getChildSeatPriceInPBS()
      {
            String price = Utils.getWebElementText(textChildSeatPriceInPBS);
            String[] values = price.split(" ");
            return values[1];
      }
      @FindBy(id = "total-price") private WebElement textTotalPrice;
      public String getTotalPriceInPBS()
      {
            String totalPrice = Utils.getWebElementText(textTotalPrice);
            String[] parts = totalPrice.split(" ");
            double amount = Double.parseDouble(parts[1]); // Get the numeric part
            return String.valueOf(amount);
      }

      public String expectedTotalPriceInPBS()
      {
            double totalCost = Double.parseDouble(getVehiclePriceInPBS()) + Double.parseDouble(getMeetAndGreetPriceInPBS()) + Double.parseDouble(getChildSeatPriceInPBS());
            return String.format("%.2f", totalCost);
      }

}

