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
      @FindBy(xpath = "//div[@id='date-selection']//button//p[1]") private List<WebElement> btnRideDate;
      @FindBy(xpath = "//div[@id='date-selection']//button//p[2]") private List<WebElement> btnRideMonth;
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
      @FindBy(id = "vehicle-image") private WebElement vehicleImageSrc;
      public String getVehicleImageSrc() { return vehicleImageSrc.getAttribute("src");}
      @FindBy(xpath = "//div[@class='vehicle']//p[1]") private WebElement vehicleName;
      public String getVehicleName() {return Utils.getWebElementText(vehicleName);}
      @FindBy(xpath = "//div[@class='vehicle']//p[2]") private WebElement vehicleBrand;
      public String getVehicleBrand()
      {
            return Utils.getWebElementText(vehicleBrand);
      }
      @FindBy(xpath = "(//div[@class='vehicle']//span[2])[1]") private WebElement vehicleMaxPax;
      public String getVehicleMaxPax()
      {
            return Utils.getWebElementText(vehicleMaxPax);
      }
      @FindBy(xpath = "(//div[@class='vehicle']//span[2])[2]") private WebElement vehicleMaxLux;
      public String getVehicleMaxLux()
      {
            return Utils.getWebElementText(vehicleMaxLux);
      }

      @FindBy(id = "modify-vehicle-info") private WebElement linkModifyVehicleInfo;
      public void clickOnModifyVehicleInfoLink(){ Utils.clickOnElement(linkModifyVehicleInfo);}

      // Infant, Booster and Child Seat count
      @FindBy(xpath = "(//div[@class='vehicle-info-section-capacity'])[2]//span[2]") private WebElement textInfantCount;
      public String getInfantCount() {
            String[] count = Utils.getWebElementText(textInfantCount).split(":");
            return count[1].trim();
      }
      @FindBy(xpath = "(//div[@class='vehicle-info-section-capacity'])[2]//span[3]") private WebElement textBoosterCount;
      public String getBoosterCount() {
            String[] count = Utils.getWebElementText(textBoosterCount).split(":");
            return count[1].trim();
      }
      @FindBy(xpath = "(//div[@class='vehicle-info-section-capacity'])[2]//span[4]") private WebElement textChildCount;
      public String getChildCount() {
            String[] count = Utils.getWebElementText(textChildCount).split(":");
            return count[1].trim();
      }


      // Pricing Details
      @FindBy(xpath = "//div[@id='price-section']//span[text()='Vehicle Service']//following::span[2]") private WebElement textVehiclePrice;
      public String getVehiclePrice()
      {
            String amount = Utils.getWebElementText(textVehiclePrice).split(" ")[0];
            return amount.trim();
      }
      @FindBy(xpath = "//div[@id='total-section']//p[2]") private WebElement textTotalPrice;
      public String getTotalPrice()
      {
            String amount = Utils.getWebElementText(textTotalPrice).split(" ")[0];
            return amount.trim();
      }
      @FindBy(xpath = "//div[@id='price-section']//span[text()='Infant Seat']//following::span[2]") private WebElement textInfantPrice;
      public String getInfantPrice()
      {
            String amount = Utils.getWebElementText(textInfantPrice).split(" ")[0];
            return amount.trim();
      }
      @FindBy(xpath = "//div[@id='price-section']//span[text()='Booster Seat']//following::span[2]") private WebElement textBoosterPrice;
      public String getBoosterPrice()
      {
            String amount = Utils.getWebElementText(textBoosterPrice).split(" ")[0];
            return amount.trim();
      }
      @FindBy(xpath = "//div[@id='price-section']//span[text()='Child Seat']//following::span[2]") private WebElement textChildPrice;
      public String getChildPrice()
      {
            String amount = Utils.getWebElementText(textChildPrice).split(" ")[0];
            return amount.trim();
      }
      @FindBy(xpath = "//div[@id='price-section']//span[text()='Meet and Greet']//following::span[2]") private WebElement textMeetGreetPrice;
      public String getMeetGreetPrice()
      {
            String amount = Utils.getWebElementText(textMeetGreetPrice).split(" ")[0];
            return amount.trim();
      }

      public boolean isMeetAndGreetPriceDisplayed() {
            if (!Utils.checkIfElementIsDisplayed(textMeetGreetPrice)) {
                  return false;
            }
            return true;
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
      }
      @FindBy(xpath = "//*[@id=\"phone-1\"]/div[2]/div[2]/input") private WebElement inputCellNumber1;
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

      // Special Instruction
      @FindBy(id = "special-instructions") private WebElement inputSpecialInstructions;
      public void enterSpecialInstruction(String SI)
      {
            Utils.setTextOnElement(inputSpecialInstructions, SI);
      }

      // Error Message for Contact Form
      @FindBy(xpath = "//*[@id=\"name\"]/div[3]") private WebElement textNameErrorMsg;
      public String getNameErrorMsg() { return Utils.getWebElementText(textNameErrorMsg);}
      @FindBy(xpath = "//*[@id=\"email\"]/div[3]") private WebElement textEmailErrorMsg;
      public String getEmailErrorMsg() { return Utils.getWebElementText(textEmailErrorMsg);}
      @FindBy(xpath = "//*[@id=\"phone-1\"]/div[4]") private WebElement textCountryCodeErrorMsg;
      public String getCountryCodeErrorMsg() { return Utils.getWebElementText(textCountryCodeErrorMsg);}
      @FindBy(xpath = "//*[@id=\"phone-1\"]/div[3]")  private WebElement textCellNumberErrorMsg;
      public String getCellNumberErrorMsg() { return Utils.getWebElementText(textCellNumberErrorMsg);}

      // Meet and Greet Information Section
      @FindBy(id = "meet_and_greet_section") private WebElement sectionMeetGreet;
      public boolean isMeetAndGreetSectionDisplayed()
      {
            if (sectionMeetGreet.isDisplayed())
            {
                  return true;
            }
            else {
                  return false;
            }
      }


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
      @FindBy(xpath = "//*[@id=\"payment-element\"]/button") private WebElement btnPay;
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


      // Infant, Booster and Child Seat count





}
