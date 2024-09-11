package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.an.E;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.Elife.Utilities.Utils.getNumberFromString;

public class RideSummaryPage {
      private static RideSummaryPage RideSummaryInstance;
      public RideSummaryPage(){}
      public static RideSummaryPage getInstance()
      {
            if(RideSummaryInstance == null)
            {
                  RideSummaryInstance = new RideSummaryPage();
            }
            return RideSummaryInstance;
      }

      // Common Methods
      // Hide Header
      @FindBy(xpath = "//div[@id='date-selection']//button//p[1]") private List<WebElement> btnRideDate;
      @FindBy(xpath = "//div[@id='date-selection']//button//p[2]") private List<WebElement> btnRideMonth;
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
      @FindBy(id = "ride-date") private WebElement textRideDate;
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
      // Need to check
      @FindBy(xpath = "//div[@class='timeline-content']//p[@class='ride-time']") private List<WebElement> textRideTimes;
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
      @FindBy(xpath = "//div[@class='timeline-content']//p[@class='ride-locations']") private List<WebElement> textRideLocations;
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
      @FindBy(xpath = "//div[@id='vehicle-info-section']//p[1]") private WebElement vehicleName;
      public String getVehicleName()
      {
            return Utils.getWebElementText(vehicleName);
      }
      @FindBy(xpath = "//div[@id='vehicle-info-section']//p[2]") private WebElement vehicleBrand;
      public String getVehicleBrand()
      {
            return Utils.getWebElementText(vehicleBrand);
      }
      @FindBy(xpath = "(//div[@class='vehicle-info-section-capacity']//span[2])[1]") private WebElement vehicleMaxPax;
      public String getVehicleMaxPax()
      {
            return Utils.getWebElementText(vehicleMaxPax);
      }
      @FindBy(xpath = "(//div[@class='vehicle-info-section-capacity']//span[2])[2]") private WebElement vehicleMaxLux;
      public String getVehicleMaxLux()
      {
            return Utils.getWebElementText(vehicleMaxLux);
      }


      // Contact Information
      @FindBy(xpath = "//*[@id=\"name\"]//input[@class='customer-name']") private WebElement inputCustomerName;
      public void enterCustomerName(String name) { Utils.setTextOnElement(inputCustomerName, name);}
      @FindBy(xpath = "//*[@id=\"email\"]//input[@class='customer-email']") private WebElement inputCustomerEmail;
      public void enterCustomerEmail(String email) { Utils.setTextOnElement(inputCustomerEmail, email);}
      @FindBy(xpath = "//*[@id=\"phone-1\"]/div[2]/div[1]/input") private WebElement inputCountryCode1;
      @FindBy(xpath = "//div[@id='phone-1']//a[1]") private WebElement textCountryCode1;
      public void selectCountryCode1()
      {
            Utils.clickOnElement(inputCountryCode1);
            Utils.clickOnElement(textCountryCode1);
      }@FindBy(xpath = "//*[@id=\"phone-1\"]/div[2]/div[2]/input") private WebElement inputCellNumber1;
      public void enterCellNumber1(String cellNumber)
      {
            Utils.setTextOnElement(inputCellNumber1, cellNumber);
      }
      @FindBy(xpath = "//*[@id=\"contact-info-section\"]/p[1]") private WebElement textName;
      public String getName() { return Utils.getWebElementText(textName).split(":")[1].trim(); }
      @FindBy(xpath = "//*[@id=\"contact-info-section\"]/p[2]") private WebElement textEmail;
      public String getEmail() { return Utils.getWebElementText(textEmail).split(":")[1].trim();}
      @FindBy(xpath = "//*[@id=\"contact-info-section\"]/p[3]") private WebElement textPhoneNumber1;
      public String getPhoneNumber1() { return Utils.getWebElementText(textPhoneNumber1).split(":")[1].trim();}
      @FindBy(xpath = "//*[@id=\"contact-info-section\"]/p[4]") private WebElement textPhoneNumber2;
      public String getPhoneNumber2() { return Utils.getWebElementText(textPhoneNumber2).split(":")[1].trim();}
      @FindBy(xpath = "//*[@id=\"contact-info-section\"]/p[5]/span") private WebElement iconSocialMedia;
      public String getSocialMedia()
      {
            return iconSocialMedia.getAttribute("class").split("badge el-icon2")[1].trim();
      }
      @FindBy(xpath = "//*[@id=\"contact-info-section\"]/p[5]") private WebElement textSocialMedia;
      public String getSocialMediaName() { return Utils.getWebElementText(textSocialMedia).split(":")[1].trim();}

      // Error Message for Contact Form
      @FindBy(xpath = "//*[@id=\"name\"]/div[3]") private WebElement textNameErrorMsg;
      public String getNameErrorMsg() { return Utils.getWebElementText(textNameErrorMsg);}
      @FindBy(xpath = "//*[@id=\"email\"]/div[3]") private WebElement textEmailErrorMsg;
      public String getEmailErrorMsg() { return Utils.getWebElementText(textEmailErrorMsg);}
      @FindBy(xpath = "//*[@id=\"phone-1\"]/div[4]") private WebElement textCountryCodeErrorMsg;
      public String getCountryCodeErrorMsg() { return Utils.getWebElementText(textCountryCodeErrorMsg);}
      @FindBy(xpath = "//*[@id=\"phone-1\"]/div[3]")  private WebElement textCellNumberErrorMsg;
      public String getCellNumberErrorMsg() { return Utils.getWebElementText(textCellNumberErrorMsg);}

      // Payment Information
      @FindBy(id = "continue-to-payment-btn") private WebElement btnContinueToPayment;
      public void clickOnPaymentBtn() throws InterruptedException {
            try {
                  HomePage.getInstance().hideHeader();
                  ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", btnContinueToPayment);
                  ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", btnContinueToPayment);
            } catch (ElementClickInterceptedException e)
            {
                  System.out.println(e.getMessage());
            }

      }

      // Payment Model
      @FindBy(xpath = "//input[contains(@id, \"adyen-checkout-encryptedCardNumber\")]")
      private WebElement inputCardNumber;
      @FindBy(xpath = "/html/body/div/input") private WebElement inputExpiryDate;
      @FindBy(xpath = "/html/body/div/input") private WebElement inputSecurityCode;
      @FindBy(xpath = "//input[contains(@id, 'adyen-checkout-holderName')]") private WebElement inputName;
      @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/section[5]/div[2]/div[1]/div[2]/button") private WebElement btnPay;
      @FindBy(xpath = "//iframe[@title='Iframe for card number']") private WebElement iframeCardNumber;
      public void enterPaymentDetails() throws InterruptedException {
            Utils.waitForVisibility(iframeCardNumber);
            Utils.moveToElement(iframeCardNumber);
            DriverManager.getDriver().switchTo().frame(iframeCardNumber);
            Thread.sleep(3000);
            Utils.setTextOnElement(inputCardNumber, "5577 0000 5577 0004");
            DriverManager.getDriver().switchTo().parentFrame();
            DriverManager.getDriver().switchTo().frame(1);
            Utils.waitForVisibilitySec(inputExpiryDate, 10);
            Utils.setTextOnElement(inputExpiryDate, "03/30");
            Thread.sleep(5000);
            DriverManager.getDriver().switchTo().parentFrame();
            DriverManager.getDriver().switchTo().frame(2);
            Utils.waitForVisibilitySec(inputSecurityCode, 10);
            Utils.setTextOnElement(inputSecurityCode, "737");
            DriverManager.getDriver().switchTo().parentFrame();
            Utils.setTextOnElement(inputName, "TEST");
            Utils.clickOnElement(btnPay);
      }

      // Amount
      @FindBy(xpath = "//div[contains(@class,'price-section')]//span[text()='Infant Seat']/following-sibling::span[2]")
      private WebElement textInfantSeatPrice;
      public String getInfantSeatPrice()
      {
            Utils.moveToElement(textInfantSeatPrice);
            if (textInfantSeatPrice.isDisplayed()) {
                  String numericPart = textInfantSeatPrice.getText().replaceAll("[^\\d.]", "");
                  if (!numericPart.isEmpty()) {
                        return String.valueOf(Double.parseDouble(numericPart));
                  } else {
                        throw new NumberFormatException("No valid number found in: " + textInfantSeatPrice.getText());
                  }
            } else {
                  throw new IllegalStateException("Input field for Infant Seat is not displayed.");
            }
      }

      public boolean isInfantSeatPriceDisplayed()
      {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)); // Adjust timeout as needed
            try {
                  // Wait for the element to be invisible or not present
                  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'price-section')]//span[text()='Infant Seat']/following-sibling::span[2]")));
                  return true; // Element is not present or invisible
            } catch (TimeoutException e) {
                  System.out.println("Element is still visible or present: " + e.getMessage());
                  return false; // Element is still present when it should not be
            }
      }
      @FindBy(xpath = "//div[contains(@class,'price-section')]//span[text()='Booster Seat']/following-sibling::span[2]")
      private WebElement textBoosterSeatPrice;
      public String getBoosterSeatPrice()
      {
            Utils.moveToElement(textBoosterSeatPrice);
            if (textBoosterSeatPrice.isDisplayed()) {
                  String numericPart = getNumberFromString(textBoosterSeatPrice.getText());
                  if (!numericPart.isEmpty()) {
                        return String.valueOf(Double.parseDouble(numericPart));
                  } else {
                        throw new NumberFormatException("No valid number found in: " + textBoosterSeatPrice.getText());
                  }
            } else {
                  throw new IllegalStateException("Input field for Booster Seat is not displayed.");
            }
      }
      public boolean isBoosterSeatPriceDisplayed()
      {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)); // Adjust timeout as needed
            try {
                  // Wait for the element to be invisible or not present
                  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.
                          xpath("//div[contains(@class,'price-section')]//span[text()='Booster Seat']/following-sibling::span[2]")));
                  return true; // Element is not present or invisible
            } catch (TimeoutException e) {
                  System.out.println("Element is still visible or present: " + e.getMessage());
                  return false; // Element is still present when it should not be
            }
      }
      @FindBy(xpath = "//div[contains(@class,'price-section')]//span[text()='Child Seat']/following-sibling::span[2]")
      private WebElement textChildSeatPrice;
      public String getChildSeatPrice()
      {
            Utils.moveToElement(textChildSeatPrice);
            if (textChildSeatPrice.isDisplayed()) {
                  String numericPart = getNumberFromString(textChildSeatPrice.getText());
                  if (!numericPart.isEmpty()) {
                        return String.valueOf(Double.parseDouble(numericPart));
                  } else {
                        throw new NumberFormatException("No valid number found in: " + textChildSeatPrice.getText());
                  }
            } else {
                  throw new IllegalStateException("Input field for Child Seat is not displayed.");
            }
      }
      public boolean isChildSeatPriceDisplayed()
      {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)); // Adjust timeout as needed
            try {
                  // Wait for the element to be invisible or not present
                  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.
                          xpath("//div[contains(@class,'price-section')]//span[text()='Child Seat']/following-sibling::span[2]")));
                  return true; // Element is not present or invisible
            } catch (TimeoutException e) {
                  System.out.println("Element is still visible or present: " + e.getMessage());
                  return false; // Element is still present when it should not be
            }
      }
      @FindBy(xpath = "//div[contains(@class,'price-section')]//span[text()='Meet and Greet']/following-sibling::span[2]")
      private WebElement textMeetAndGreetPrice;
      public String getMeetAndGreetPrice()
      {
            Utils.moveToElement(textMeetAndGreetPrice);
            if (textMeetAndGreetPrice.isDisplayed()) {
                  String numericPart = getNumberFromString(textMeetAndGreetPrice.getText());
                  if (!numericPart.isEmpty()) {
                        return String.valueOf(Double.parseDouble(numericPart));
                  } else {
                        throw new NumberFormatException("No valid number found in: " + textMeetAndGreetPrice.getText());
                  }
            } else {
                  throw new IllegalStateException("Input field for Meet and Greet is not displayed.");
            }
      }
      public boolean isMeetAndGreetPriceDisplayed()
      {WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)); // Adjust timeout as needed

            try {
                  // Wait for the element to be invisible or not present
                  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.
                          xpath("//div[contains(@class,'price-section')]//span[text()='Meet and Greet']/following-sibling::span[2]")));
                  return true; // Element is not present or invisible
            } catch (TimeoutException e) {
                  System.out.println("Element is still visible or present: " + e.getMessage());
                  return false; // Element is still present when it should not be
            }
      }



}
