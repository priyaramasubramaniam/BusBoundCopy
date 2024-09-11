package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.Elife.Utilities.Utils.getNumberFromString;

public class AdditionalInfoPage {
      private static AdditionalInfoPage AdditionalInfoInstance;
      public AdditionalInfoPage(){}
      public static AdditionalInfoPage getInstance()
      {
            if(AdditionalInfoInstance == null)
            {
                  AdditionalInfoInstance = new AdditionalInfoPage();
            }
            return AdditionalInfoInstance;
      }

      // Title and Sub Title X paths
      @FindBy(xpath = "//div[@id='additional-info']//div[@class='title']") private WebElement textTitle;
      public String getTitle()
      {
            return Utils.getWebElementText(textTitle);
      }
      @FindBy(xpath = "//div[@id='additional-info']//div[@class='subtitle']") private WebElement textSubTitle;
      public String getSubTitle() { return Utils.getWebElementText(textSubTitle);}

      // Section Title Xpaths
      @FindBy(xpath = "(//div[@id='additional-info']//p[@class='section-title']//p)[1]") private WebElement textMeetAndGreetTitle;
      public String getMeetAndGreetSecTitle()
      {
            return Utils.getWebElementText(textMeetAndGreetTitle).trim();
      }
      @FindBy(xpath = "//span[@for='meet-greet-no']") private WebElement radioMeetAndGreetNo;
      public boolean isMeetAndGreetNoEnabled()
      {
            return Utils.checkIfElementIsEnabled(radioMeetAndGreetNo);
      }
      @FindBy(xpath = "//span[@for='meet-greet-yes']") private WebElement radioMeetAndGreetYes;
      public boolean isMeetAndGreetYesEnabled()
      {
            return Utils.checkIfElementIsEnabled(radioMeetAndGreetYes);
      }
      public void selectMeetAndGreetOption(String option) throws InterruptedException {
            HomePage.getInstance().hideHeader();
            if (option.equals("Yes")) {
                  Utils.moveToElementJS(radioMeetAndGreetYes);
                  Utils.clickOnElement(radioMeetAndGreetYes);
            } else {
                  Utils.clickOnElement(radioMeetAndGreetNo);
            }
      }
      @FindBy(id = "meet-and-greet-price") private WebElement priceMeetAndGreet;
      public String getMeetAndGreetPrice() {
            if (priceMeetAndGreet.isDisplayed()) {
                  String numericPart = priceMeetAndGreet.getText().replaceAll("[^\\d.]", "").trim();
                  return String.valueOf(Double.parseDouble(numericPart));
            }
            else {
                  throw new IllegalStateException("Meet and greet price is not displayed.");
            }
      }

      @FindBy(xpath = "//textarea[@id='meet-greet-message']") private WebElement inputMeetAndGreet;
      public void enterMeetAndGreetText(String text)
      {
            Utils.setTextOnElement(inputMeetAndGreet, text);
      }
      public boolean isMeetAndGreetInputDisplayed()
      {
            return Utils.checkIfElementIsDisplayed(inputMeetAndGreet);
      }
      @FindBy(xpath = "(//div[@id='additional-info']//p[@class='section-title'])[2]") private WebElement textChildSeatTitle;
      public String getChildSeatSecTitle()
      {
            return Utils.getWebElementText(textChildSeatTitle);
      }
      @FindBy(xpath = "//span[@for='child-seat-no']") private WebElement radioChildSeatNo;
      public boolean isChildSeatNoEnabled()
      {
            return Utils.checkIfElementIsEnabled(radioChildSeatNo);
      }
      @FindBy(xpath = "//span[@for='child-seat-yes']") private WebElement radioChildSeatYes;

      // Method to select Child Seat option
      public void selectChildSeatOption(String option) throws InterruptedException {
            HomePage.getInstance().hideHeader();
            if (option.equals("Yes")) {
                  Utils.moveToElement(radioChildSeatYes);
                  Utils.clickOnElement(radioChildSeatYes);
            } else {
                  Utils.moveToElementJS(radioChildSeatNo);
                  Utils.clickOnElement(radioChildSeatNo);
            }
      }
      @FindBy(xpath = "(//div[@class='seat-option'])[1]") private List<WebElement> seatOptions;
      public boolean isSeatOptionsDisplayed() {
            for (WebElement element : seatOptions) {
                  if (element.isDisplayed()) {
                        return true;
                  }
            }
            return false;
      }
      @FindBy(xpath = "//span[@id='infant-seat-count']") private WebElement inputInfantSeat;
      @FindBy(xpath = "//*[@id=\"child-seat-section\"]/div/div[1]/div/button[1]") private WebElement btnInfantSeatMinus;
      @FindBy(xpath = "//*[@id=\"child-seat-section\"]/div/div[1]/div/button[2]") private WebElement btnInfantSeatPlus;

      // Method to set Infant Seat quantity
      public void enterInfantSeatQuantity(String quantity) throws InterruptedException {
            Thread.sleep(3000); // Optional wait time before starting the operation
            Utils.moveToElement(inputInfantSeat);
            if (inputInfantSeat.isDisplayed()) {
                  int desiredQuantity = Integer.parseInt(quantity); // Convert desired quantity from String to int
                  int currentQuantity = Integer.parseInt(inputInfantSeat.getText()); // Get current quantity from input field

                  // Loop to adjust the quantity to the desired value
                  while (Integer.parseInt(inputInfantSeat.getText()) != desiredQuantity) {
                        if (desiredQuantity < currentQuantity) {
                              Utils.clickOnElement(btnInfantSeatMinus); // Click the "-" button to decrease the quantity
                        } else if (desiredQuantity > currentQuantity) {
                              Utils.clickOnElement(btnInfantSeatPlus); // Click the "+" button to increase the quantity
                        }
                        Thread.sleep(500); // Wait to allow UI to update
                        currentQuantity = Integer.parseInt(inputInfantSeat.getText()); // Update the current quantity
                  }

            } else {
                  System.out.println("Input field for Infant Seat is not displayed.");
            }
      }
      @FindBy(xpath = "//span[@id='booster-seat-count']") private WebElement inputBoosterSeat;
      @FindBy(xpath = "//*[@id=\"child-seat-section\"]/div/div[2]/div/button[1]") private WebElement btnBoosterSeatMinus;
      @FindBy(xpath = "//*[@id=\"child-seat-section\"]/div/div[2]/div/button[2]") private WebElement btnBoosterSeatPlus;
      // Method to set Booster Seat quantity
      public void enterBoosterSeatQuantity(String quantity) throws InterruptedException {
            Thread.sleep(3000);
            Utils.moveToElement(inputBoosterSeat);
            if (inputBoosterSeat.isDisplayed()) {
                  int desiredQuantity = Integer.parseInt(quantity); // Convert desired quantity from String to int
                  int currentQuantity = Integer.parseInt(inputBoosterSeat.getText()); // Get current quantity from input field

                        // Loop to adjust the quantity to the desired value
                  while (Integer.parseInt(inputBoosterSeat.getText()) != desiredQuantity) {
                        if (desiredQuantity < currentQuantity) {
                              Utils.clickOnElement(btnBoosterSeatMinus); // Click the "-" button to decrease the quantity
                        } else if (desiredQuantity > currentQuantity) {
                              Utils.clickOnElement(btnBoosterSeatPlus); // Click the "+" button to increase the quantity
                        }
                        Thread.sleep(500); // Wait to allow UI to update
                        currentQuantity = Integer.parseInt(inputBoosterSeat.getText()); // Update the current quantity
                        }

                  } else {
                        System.out.println("Input field for Booster Seat is not displayed.");
                  }
      }

      @FindBy(xpath = "//span[@id='child-seat-count']") private WebElement inputChildSeat;
      @FindBy(xpath = "//*[@id=\"child-seat-section\"]/div/div[3]/div/button[1]") private WebElement btnChildSeatMinus;
      @FindBy(xpath = "//*[@id=\"child-seat-section\"]/div/div[3]/div/button[2]") private WebElement btnChildSeatPlus;
      // Method to set Child Seat quantity
      public void enterChildSeatQuantity(String quantity) throws InterruptedException {
            Thread.sleep(3000);
            Utils.moveToElement(inputChildSeat);
            if (inputChildSeat.isDisplayed()) {
                  int desiredQuantity = Integer.parseInt(quantity); // Convert desired quantity from String to int
                  int currentQuantity = Integer.parseInt(inputChildSeat.getText()); // Get current quantity from input field

                  // Loop to adjust the quantity to the desired value
                  while (Integer.parseInt(inputChildSeat.getText()) != desiredQuantity) {
                        if (desiredQuantity < currentQuantity) {
                              Utils.clickOnElement(btnChildSeatMinus); // Click the "-" button to decrease the quantity
                        } else if (desiredQuantity > currentQuantity) {
                              Utils.clickOnElement(btnChildSeatPlus); // Click the "+" button to increase the quantity
                        }
                        Thread.sleep(500); // Wait to allow UI to update
                        currentQuantity = Integer.parseInt(inputChildSeat.getText()); // Update the current quantity
                  }

            } else {
                  System.out.println("Input field for Child Seat is not displayed.");
            }
      }

      @FindBy(xpath = "//span[@id='infant-seat-price']") private WebElement priceInfantSeat;
      public String getInfantSeatPrice() {
            if (inputInfantSeat.isDisplayed()) {

                  String numericPart = priceInfantSeat.getText().replace("$", "");
                  String count = inputInfantSeat.getText();
                  System.out.println(numericPart);
                  System.out.println(count);
                  return String.valueOf(Double.parseDouble(numericPart) * Double.parseDouble(count));
            }
             else {
                  throw new IllegalStateException("Input field for Infant Seat is not displayed.");
            }
      }
      @FindBy(xpath = "//span[@id='booster-seat-price']") private WebElement priceBoosterSeat;
      public String getBoosterSeatPrice() {
            if (inputBoosterSeat.isDisplayed()) {
                  String numericPart = priceBoosterSeat.getText().replace("$", "");
                  String count = inputBoosterSeat.getText();
                  return String.valueOf(Double.parseDouble(numericPart) * Double.parseDouble(count));
            }
            else {
                  throw new IllegalStateException("Input field for Booster Seat is not displayed.");
            }
      }
      @FindBy(xpath = "//span[@id='child-seat-price']") private WebElement priceChildSeat;
      public String getChildSeatPrice()
      {
            if (inputChildSeat.isDisplayed()) {
                  String numericPart = priceChildSeat.getText().replace("$", "");
                  String count = inputChildSeat.getText();
                  return String.valueOf(Double.parseDouble(numericPart) * Double.parseDouble(count));
            }
            else {
                  throw new IllegalStateException("Input field for Child Seat is not displayed.");
            }
      }

      // Special Instructions
      @FindBy(xpath = "(//div[@id='additional-info']//p[@class='section-title'])[3]") private WebElement textSpecialInstructionTitle;
      public String getSpecialInstructionSecTitle()
      {
            return Utils.getWebElementText(textSpecialInstructionTitle);
      }
      @FindBy(xpath = "//textarea[@id='special-instructions']") private WebElement inputSpecialInstructions;
      public void enterSpecialInstructions(String text)
      {
            Utils.setTextOnElement(inputSpecialInstructions, text);
      }
      public boolean isSpecialInstDisplayed()
      {
            return Utils.checkIfElementIsEnabled(inputSpecialInstructions);
      }


      // Check all the inputs are displayed when i click on yes
      public boolean checkIfAdditionalInfoDisplayed(String text)
      {
            boolean isDisplayed = false; // Default value assuming additional info is not displayed

            if (text.equals("Meet and Greet")) {
                  isDisplayed = isSeatOptionsDisplayed();
            } else if (text.equals("Child seat")) {
                  isDisplayed = isChildSeatNoEnabled();
            } else if (text.equals("Special Instruction Text Area"))
            {
                  isDisplayed = isSpecialInstDisplayed();
            }
            return isDisplayed;
      }
      @FindBy(id = "next-btn") private WebElement btnNext;
      public void clickOnNextBtn()
      {
            Utils.clickOnElement(btnNext);
      }

}
