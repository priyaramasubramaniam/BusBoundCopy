package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideConfirmationPage {
      private static RideConfirmationPage RideConfirmationInstance;
      public RideConfirmationPage(){}
      public static RideConfirmationPage getInstance()
      {
            if(RideConfirmationInstance == null)
            {
                  RideConfirmationInstance = new RideConfirmationPage();
            }
            return RideConfirmationInstance;
      }
      // Title
      @FindBy(xpath = "//*[@id=\"ride-conf-title\"]//div[@class='title']") private WebElement textTitle;
      public String getTitle()
      {
            Utils.waitForVisibility(textTitle);
            return Utils.getWebElementText(textTitle);
      }
      @FindBy(xpath = "//div[@id='more']") private WebElement linkMore;
      public boolean isMoreLinkDisplayed()
      {
            return Utils.isElementVisible(linkMore);
      }

      public void clickOnMoreLink()
      {
            Utils.clickOnElement(linkMore);
      }
      @FindBy(id = "cancel-btn") private WebElement btnCancelRide;
      public boolean isCancelRideBtnDisplayed()
      {
            return Utils.isElementVisible(btnCancelRide);
      }
      public void clickOnCancelBtn()
      {
            Utils.clickOnElement(btnCancelRide);
      }

      @FindBy(id = "cell-number-input") private WebElement inputCellNumber;
      @FindBy(xpath = "//div[@id='cell-number-drop-down']//a[1]") private WebElement textCellNumber;
      public void selectCellNumber() throws InterruptedException {
            DriverManager.getDriver().switchTo().defaultContent();
            Utils.moveToElementJS(inputCellNumber);
            Utils.clickOnElement(inputCellNumber);
            Utils.clickOnElement(textCellNumber);
      }
      @FindBy(id = "get-verication-link") private WebElement linkGetVerificationCode;
      public void clickOnVerificationCodeLink()
      {
            Utils.clickOnElement(linkGetVerificationCode);
      }
      @FindBy(id = "confirm-btn") private WebElement btnConfirm;
      public void clickOnConfirmBtn()
      {
            Utils.clickOnElement(btnConfirm);
      }
      @FindBy(id = "cancellation-policy-btn") private WebElement linkServicePolicy;
      public boolean isServicePolicyDisplayed()
      {
            return Utils.isElementVisible(linkServicePolicy);
      }
      public void clickOnServicePolicyLink()
      {
            Utils.clickOnElement(linkServicePolicy);
      }
      @FindBy(xpath = "//*[@id=\"cancellation-policy-container\"]//button[contains(text(), \"Modification\")]")
      private WebElement linkModification;
      public void clickOnModificationLink()
      {
            Utils.clickOnElement(linkModification);
      }
      @FindBy(xpath = "//*[@id=\"modify\"]") private WebElement textModification;
      public String getModificationText()
      {
            return Utils.getWebElementText(textModification);
      }
      @FindBy(xpath = "//*[@id=\"cancellation-policy-container\"]//button[contains(text(), \"Additional Charge\")]")
      private WebElement linkAdditionalCharge;
      public void clickOnAdditionalChargeLink()
      {
            Utils.clickOnElement(linkAdditionalCharge);
      }
      @FindBy(xpath = "//*[@id=\"overtime\"]") private WebElement textAdditionalChargeText;
      public String getAdditionalChargeText()
      {
            return Utils.getWebElementText(textAdditionalChargeText);
      }

      // Table
      @FindBy(xpath = "//*[@id=\"cancellation-policy-container\"]/div") private WebElement tableElement;
      @FindBy(xpath = "//*[@id=\"cancellation-policy-container\"]/div/div[2]/div[2]/table/tbody/tr") private List<WebElement> rows;
      @FindBy(xpath = "//*[@id=\"cancellation-policy-container\"]/div/div[2]/div[2]/table/tbody/tr//td") private List<WebElement> cells;
      @FindBy(xpath = "//*[@id=\"cancellation-policy-container\"]/div/div[2]/div[2]/table/thead/tr//th") private List<WebElement> header;
      public List<List<String>> getAllTableData() {
            DriverManager.getDriver().switchTo().defaultContent();
            List<List<String>> tableData = new ArrayList<>();

            // Get all rows in the table
            List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

            for (WebElement row : rows) {
                  List<String> rowData = new ArrayList<>();

                  // Get all columns/cells in the current row
                  List<WebElement> cells = row.findElements(By.tagName("td"));

                  // If there are no <td> elements, it could be a header row, so we try <th>
                  if (cells.isEmpty()) {
                        cells = row.findElements(By.tagName("th"));
                  }

                  for (WebElement cell : cells) {
                        rowData.add(cell.getText().trim());
                  }

                  tableData.add(rowData);
            }
            return tableData;
      }


      // Ride Information for Ride List Page
      @FindBy(xpath = "//*[@id=\"ride-conf-ride-id\"]/span") private WebElement textRideId;
      public String getRideId()
      {
            Utils.moveToElement(textRideId);
            return Utils.getWebElementText(textRideId);
      }
      @FindBy(id = "ride-conf-ride-date") private WebElement textStartDate;
      public String getStartDate()
      {
            return Utils.getWebElementText(textStartDate);
      }
      @FindBy(xpath = "//div[@id='ride-conf-timeline']//p[@class='ride-time']") private WebElement textStartTime;
      public String getStartTime()
      {
            return Utils.getWebElementText(textStartTime).replaceFirst("^0", "");
      }


      @FindBy(xpath = "//div[@id='ride-conf-date-selection']//button//p[1]") private List<WebElement> btnRideDate;
      @FindBy(xpath = "//div[@id='ride-conf-date-selection']//button//p[2]") private List<WebElement> btnRideMonth;
      public List<String> getRideDates()
      {
            List<String> RideDates = new ArrayList<>();

            for (int i = 0; i < btnRideDate.size(); i++) {
                  Utils.moveToElement(btnRideDate.get(i));
                  RideDates.add(Utils.getWebElementText(btnRideDate.get(i))
                          .concat(" ")
                          .concat(Utils.getWebElementText(btnRideMonth.get(i))));
            }
            return RideDates;
      }

      @FindBy(id = "ride-conf-ride-date") private WebElement textRideDate;
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

      @FindBy(xpath = "//div[@id='ride-conf-timeline']//p[@class='ride-time']") private List<WebElement> textRideTimes;
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

      @FindBy(xpath = "//div[@id='ride-conf-timeline']//p[@class='ride-locations']") private List<WebElement> textRideLocations;
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

      // Vehicle Information
      @FindBy(id = "ride-conf-vehicle-image") private WebElement vehicleImageSrc;
      public String getVehicleImageSrc() { return vehicleImageSrc.getAttribute("src");}

      @FindBy(xpath = "//div[@id='ride-conf-vehicle-info-section']//p[1]") private WebElement vehicleName;
      public String getVehicleName()
      {
            return Utils.getWebElementText(vehicleName);
      }
      @FindBy(xpath = "//div[@id='ride-conf-vehicle-info-section']//p[2]") private WebElement vehicleBrand;
      public String getVehicleBrand()
      {
            return Utils.getWebElementText(vehicleBrand);
      }
      @FindBy(xpath = "(//div[@id='ride-conf-vehicle-info-section']//span[2])[1]") private WebElement vehicleMaxPax;
      public String getVehicleMaxPax()
      {
            return Utils.getWebElementText(vehicleMaxPax);
      }
      @FindBy(xpath = "(//div[@id='ride-conf-vehicle-info-section']//span[2])[2]") private WebElement vehicleMaxLux;
      public String getVehicleMaxLux()
      {
            return Utils.getWebElementText(vehicleMaxLux);
      }

      // Additional Information
      @FindBy(xpath = "//div[@id='ride-conf-additional-info-section']//p[strong[contains(text(), 'Infant Seat:')]]")
      private WebElement textInfantSeatCount;
      public String getInfantSeatCount()
      {
            String text = textInfantSeatCount.getText().trim();
            String infantSeatValue = text.replace("Infant Seat:", "").trim();
            return infantSeatValue;
      }
      @FindBy(xpath = "//div[@id='ride-conf-additional-info-section']//p[strong[contains(text(), 'Child Seat:')]]")
      private WebElement textChildSeatCount;
      public String getChildSeatCount()
      {
            String text = textChildSeatCount.getText().trim();
            String childSeatValue = text.replace("Child Seat:", "").trim();
            return childSeatValue;
      }
      @FindBy(xpath = "//div[@id='ride-conf-additional-info-section']//p[strong[contains(text(), 'Booster Seat:')]]")
      private WebElement textBoosterSeatCount;
      public String getBoosterSeatCount()
      {
            String text = textBoosterSeatCount.getText().trim();
            String boosterSeatValue = text.replace("Booster Seat:", "").trim();
            return boosterSeatValue;
      }
      @FindBy(xpath = "//div[@id='ride-conf-additional-info-section']//p[strong[contains(text(), 'Meet & Greet Sign:')]]")
      private WebElement textMeetAndGreet;
      public String getMeetAndGreetText()
      {
            String text = textMeetAndGreet.getText().trim();
            String meetAndGreetValue = text.replace("Meet & Greet Sign:", "").trim();
            return meetAndGreetValue;
      }
      @FindBy(xpath = "//div[@id='ride-conf-additional-info-section']//p[strong[contains(text(), 'Notes to driver:')]]")
      private WebElement textNotesToDriver;
      public String getNotesToDriverText()
      {
            String text = textNotesToDriver.getText().trim();
            String NotesToDriverValue = text.replace("Notes to driver:", "").trim();
            return NotesToDriverValue;
      }



      @FindBy(xpath = "//*[@id=\"ride-conf-date-selection\"]/button") private List<WebElement> btnRideDates;

      public List<String> getFirstAndLastLocation()
      {
            HomePage.getInstance().hideHeader();
            List<String> firstAndLastLocations = new ArrayList<>();

            // Retrieve the first location from the first ride date
            firstAndLastLocations.add(Utils.getWebElementText(textRideLocations.get(0))); // First location
            if (btnRideDates.size() == 1) {
                  // If there's only one ride date, retrieve the last location from the same date
                  firstAndLastLocations.add(Utils.getWebElementText(textRideLocations.get(textRideLocations.size() - 1))); // Last location
            }
            else if (btnRideDates.size() > 1) {
                  // If there are multiple ride dates, navigate to the last ride date
                  for (int i = 1; i < btnRideDates.size(); i++) {
                        if (btnRideDates.get(i).isDisplayed()) {
                              Utils.clickOnElement(btnRideDates.get(i));
                        }
                  }
                  // Retrieve the last location from the last ride date
                  firstAndLastLocations.add(Utils.getWebElementText(textRideLocations.get(textRideLocations.size() - 1))); // Last location

            }
            return firstAndLastLocations;
      }

      // Get Url
      public String getUrl()
      {
            return DriverManager.getDriver().getCurrentUrl();
      }


}
