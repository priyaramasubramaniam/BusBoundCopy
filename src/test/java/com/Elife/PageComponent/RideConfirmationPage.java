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
            return Utils.getWebElementText(textStartTime);
      }
      @FindBy(xpath = "//*[@id=\"ride-conf-vehicle-info-section\"]/p[1]") private WebElement textVehicleName;
      public String getVehicleName() {return Utils.getWebElementText(textVehicleName).replace("x ", "x");}

      @FindBy(xpath = "//div[@id='vehicle-info-section']//p[2]") private WebElement textVehicleBrand;
      public String getVehicleBrand()
      {
            return Utils.getWebElementText(textVehicleBrand);
      }
      @FindBy(xpath = "//*[@id=\"ride-conf-date-selection\"]/button") private List<WebElement> btnRideDates;
      @FindBy(xpath = "//div[@id='ride-conf-timeline']//p[@class='ride-locations']") private List<WebElement> textRideLocations;

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
