package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.rmi.CORBA.Util;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
      private static HomePage HomeInstance;
      public HomePage(){}
      public static HomePage getInstance()
      {
            if(HomeInstance == null)
            {
                  HomeInstance = new HomePage();
            }
            return HomeInstance;
      }
      // Title
      @FindBy(id = "ext-title") private WebElement textTitle;
      public String getTitle() { return Utils.getWebElementText(textTitle);}
      @FindBy(className = "bus") private WebElement textSubTitle;
      public String getSubTitle() { return Utils.getWebElementText(textSubTitle).replaceAll("\\s+", " ").trim();}

      // Header
      @FindBy(xpath = "//div[@class=\"my-rides-dropdown\"]") private WebElement linkMyRides;
      public void clickOnMyRidesBtn()
      {
            Utils.clickOnElement(linkMyRides);
      }
      @FindBy(xpath = "//div[@id='my-rides-dropdown-content']//a[@id='my-ride']") private WebElement DDMyRides;
      public void clickOnDDMyRides()
      {
            Utils.clickOnElement(DDMyRides);
      }
      @FindBy(xpath = "//div[@id='my-rides-dropdown-content']//a") private List<WebElement> linksMyRideDD;
      public List<String> getMyRideListDD() {
            List<String> values = new ArrayList<>();
            for (WebElement element : linksMyRideDD)
            {
                  values.add(element.getText());
            }
            return values;
      }


      @FindBy(xpath = "//*[@id=\"my-rides-dropdown-content\"]/a[@id='my-ride-logout']") private WebElement linkLogout;
      public boolean isLogoutLinkDisplayed() { return Utils.checkIfElementIsDisplayed(linkLogout);}
      public void clickOnLogoutLink() { Utils.clickOnElement(linkLogout);}

      @FindBy(id = "price-quote-btn") private WebElement btnPriceQuote;
      public void clickOnPriceQuoteBtn()
      {
            Utils.clickOnElement(btnPriceQuote);
      }

      public void hideHeader()
      {
            //*[@id="header"]/div/div
            DriverManager.getDriver().switchTo().defaultContent();
            WebElement overlappingElement = DriverManager.getDriver().findElement(By.xpath("//*[@class=\"fixed-header\"]"));
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.display='none';", overlappingElement);
            DriverManager.getDriver().switchTo().frame("front-inc");
      }

      public void displayHeader() {
            DriverManager.getDriver().switchTo().defaultContent();
            WebElement overlappingElement = DriverManager.getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div"));
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.display='block';", overlappingElement);
      }

      // Booking Widget
      @FindBy(id = "add-multiple-stops") private WebElement linkAddMultipleStops;
      public void clickOnAddMultipleStopsLink()
      {
            Utils.clickOnElement(linkAddMultipleStops);
      }

      // One way Pickup location
      @FindBy(xpath = "//div[@id='form-fields-one-way']//input[@class='from-location-input']")
      private WebElement inputOWPickupLoc;
      @FindBy(xpath = "//div[@id='from-dropdown-one-way']//a[1]") private WebElement dropdownOWPickupLocName;
      public void enterOWPickupLoc(String pickup_loc) throws InterruptedException {
            Utils.setTextOnElement(inputOWPickupLoc, pickup_loc);
            Thread.sleep(5000);
            Utils.clickOnElement(dropdownOWPickupLocName);
      }
      public String getOWPickupLoc()
      {
            return inputOWPickupLoc.getAttribute("value");
      }

      // One way Drop off Location
      @FindBy(xpath = "//div[@id='form-fields-one-way']//input[@class='to-location-input']")
      private WebElement inputOWDropoffLoc;
      @FindBy(xpath = "//div[@id='to-dropdown-one-way']//a[1]") private WebElement dropdownOWDropoffLocName;
      public void enterOWDropoffLoc(String dropoff_loc) throws InterruptedException {
            Utils.setTextOnElement(inputOWDropoffLoc, dropoff_loc);
            Thread.sleep(5000);
            Utils.clickOnElement(dropdownOWDropoffLocName);
      }
      public String getOWDropoffLoc()
      {
            return inputOWDropoffLoc.getAttribute("value");
      }

      // One way Pickup Date
      @FindBy(xpath = "//div[@id=\'form-fields-one-way\']//input[@id=\'date-time-combo\']")
      private WebElement inputOWPickupDate;
      @FindBy(xpath = "//div[@id='form-fields-one-way']//div[@id='date-time-combo-calendar']//td[@id='cur']")
      private WebElement textMonthYear;
      @FindBy(xpath = "//div[@id='form-fields-one-way']//div[@id='date-time-combo-calendar']//td[@id='next']")
      private WebElement btnNextMonth;

      public void selectOnewayPickupYearMonth(String MonthYear)
      {
            Utils.clickOnElement(inputOWPickupDate);
            while (!textMonthYear.getText().equals(MonthYear)) {
                  // Click the next button until the correct month-year is displayed
                  Utils.clickOnElement(btnNextMonth); // Update with the correct locator
            }
      }
      @FindBy(xpath = "//div[@id='form-fields-one-way']//div[@id='date-time-combo-calendar']//tr[@name='week']//td")
      private List<WebElement> textDates;
      public void selectOWPickupDate(String date)
      {
            for (WebElement dateElement : textDates) {
                  String dayText = dateElement.getText();
                  // Check if the text matches the expected day
                  if (dayText.equals(date)) {
                        dateElement.click(); // Click on the matching date
                        break;
                  }
            }
      }
      @FindBy(xpath = "//div[@id='form-fields-one-way']//div[@id='date-time-combo-time']//input[@id='time-hr']")
      private WebElement inputPickupHour;
      public void enterOWPickupHour(String hour) throws InterruptedException {
            Utils.setTextOnElement(inputPickupHour, hour);

      }
      @FindBy(xpath = "//div[@id='form-fields-one-way']//div[@id='date-time-combo-time']//input[@id='time-min']")
      private WebElement inputPickupMinute;
      public void enterOWPickupMinute(String minute)
      {
            Utils.setTextOnElement(inputPickupMinute, minute);
      }
      @FindBy(xpath = "(//div[@id='form-fields-one-way']//div[@id='time-ampm'])[1]//div[@id='am']")
      private WebElement btnPickupAM;
      @FindBy(xpath = "(//div[@id='form-fields-one-way']//div[@id='time-ampm'])[1]//div[@id='pm']")
      private WebElement btnPickupPM;
      public void selectOWPickupPeriod(String period)
      {
            // Handle AM/PM period
            if ("AM".equalsIgnoreCase(period)) {
                  Utils.clickOnElement(btnPickupAM);
            } else {
                  Utils.clickOnElement(btnPickupPM);
            }
      }

      public String getPickupDateTime() {
            return inputOWPickupDate.getAttribute("value").replaceFirst("^0", "");}

      // Event Type
      @FindBy(xpath = "//div[@id='event-type-one-way']//input[@id='event-type']") private WebElement inputEventType;
      @FindBy(xpath = "//div[@id='event-type-one-way']//div[@id='event-dropdown-1']//a[1]") private WebElement textEventType;
      public void selectEventType() throws InterruptedException {
            hideHeader();
            Utils.clickOnElement(inputEventType);
            Utils.clickOnElement(textEventType);
      }


}
