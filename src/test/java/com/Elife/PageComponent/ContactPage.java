package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import com.google.common.base.Utf8;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ContactPage {
      private static ContactPage ContactInstance;
      public ContactPage(){}
      public static ContactPage getInstance()
      {
            if(ContactInstance == null)
            {
                  ContactInstance = new ContactPage();
            }
            return ContactInstance;
      }

      // Name
      @FindBy(xpath = "//input[@placeholder='Name of the customer']") private WebElement inputName;
      public void enterName(String name) {Utils.setTextOnElement(inputName, name);}
      public String getName() {return inputName.getAttribute("value");}


      // Salutation
      @FindBy(xpath = "//input[@class='salutation-input']") private WebElement inputSalutation;
      public void clickOnSalutation()
      {
            Utils.clickOnElement(inputSalutation);
      }
      @FindBy(xpath = "//a[@id='%s']") private WebElement textSalutation;
      public void selectSalutation(String salutation) throws InterruptedException {
            String xpath = String.format("//a[@id='%s']", salutation);
            WebElement element = DriverManager.getDriver().findElement(By.xpath(xpath));
            element.click();
      }
      public String getSalutation()
      {
            // Get the value attribute from the input element
            String value = inputSalutation.getAttribute("value").trim();

            // Return "-" if the value is empty, otherwise return the actual value
            return value.isEmpty() ? "" : value;
      }


      // Email
      @FindBy(xpath = "//*[@id=\"email\"]/div[1]") private WebElement textEmailLabel;
      public String getEmailLabelText()
      {
            return Utils.getWebElementText(textEmailLabel);
      }
      @FindBy(xpath = "//input[@placeholder='Email address to receive ride info']") private WebElement inputEmail;
      public String getEmailPlaceholderText()
      {
            return inputEmail.getAttribute("placeholder");
      }
      public void enterEmail(String email)
      {
            Utils.setTextOnElement(inputEmail, email);
      }
      public String getEmail() { return inputEmail.getAttribute("value");}

      // Country Code 1
      @FindBy(xpath = "//*[@id=\"phone-1\"]/div[2]/div[1]/input") private WebElement inputCountryCode1;
      @FindBy(xpath = "//div[@id='phone-1']//a[1]") private WebElement textCountryCode1;
      public void selectCountryCode1()
      {
            Utils.clickOnElement(inputCountryCode1);
            Utils.clickOnElement(textCountryCode1);
      }
      public String getCountryCode1() { return inputCountryCode1.getAttribute("value");}

      // Cell Number 1
      @FindBy(xpath = "//*[@id=\"phone-1\"]/div[2]/div[2]/input") private WebElement inputCellNumber1;
      public void enterCellNumber1(String cellNumber)
      {
            Utils.setTextOnElement(inputCellNumber1, cellNumber);
      }
      public String getCellNumber1()
      {
            return inputCellNumber1.getAttribute("value");
      }

      // Country Code 2
      @FindBy(xpath = "(//*[@id=\"phone-2\"]/div[2]/div[1]/input)[1]") private WebElement inputCountryCode2;
      @FindBy(xpath = "(//div[@id='phone-2']//a[1])[1]") private WebElement textCountryCode2;
      public void selectCountryCode2()
      {
            Utils.clickOnElement(inputCountryCode2);
            Utils.clickOnElement(textCountryCode2);
      }
      public String getCountryCode2() {
            // Get the value attribute from the input element
            String value = inputCountryCode2.getAttribute("value").trim();

            // Return "-" if the value is empty, otherwise return the actual value
            return value.isEmpty() ? "" : value;
      }

      // Cell Number 2
      @FindBy(xpath = "//input[@class='customer-phone-2']") private WebElement inputCellNumber2;
      public void enterCellNumber2(String cellNumber)
      {
            Utils.setTextOnElement(inputCellNumber2, cellNumber);
      }
      public String getCellNumber2() {
            // Get the value attribute from the input element
            String value = inputCellNumber2.getAttribute("value").trim();

            // Return "-" if the value is empty, otherwise return the actual value
            return value.isEmpty() ? "-" : value;}

      // Social Media
      @FindBy(xpath = "//input[@class='social-input']") private WebElement inputSocialMedia;
      @FindBy(xpath = "//a[@id='facebook']") private WebElement textSocialMedia;
      public void selectSocialMedia()
      {
            Utils.clickOnElement(inputSocialMedia);
            Utils.clickOnElement(textSocialMedia);
      }
      public String getSocialMedia()
      {
            // Get the value attribute from the input element
            String value = inputSocialMedia.getAttribute("value").trim();

            // Return "-" if the value is empty, otherwise return the actual value
            return value.isEmpty() ? "-" : value;
      }
      @FindBy(xpath = "(//*[@id=\"phone-2\"]/div[2]/div[2]/input)[2]") private WebElement inputSocialMediaName;
      public void enterSocialMedia(String social_media)
      {
            Utils.setTextOnElement(inputSocialMediaName, social_media);
      }
      public String getSocialMediaName()
      {
            // Get the value attribute from the input element
            String value = inputSocialMediaName.getAttribute("value").trim();

            // Return "-" if the value is empty, otherwise return the actual value
            return value.isEmpty() ? "-" : value;
      }
      @FindBy(xpath = "//div[@id='social-drop-down']//a") private List<WebElement> textSocialMediaDDValues;
      public List<String> getSocialMediaDDValuesText()
      {
            List<String> socialMediaListValues = new ArrayList<>();
            for (WebElement value : textSocialMediaDDValues)
            {
                  socialMediaListValues.add(value.getAttribute("id"));
            }
            return socialMediaListValues;
      }

      // Back Button
      @FindBy(xpath = "//button[@id='prev-btn']") private WebElement btnBack;
      public String getBackBtnText()
      {
            return Utils.getWebElementText(btnBack);
      }
      public void clickOnBackBtn()
      {
            Utils.clickOnElement(btnBack);
      }
      public boolean isBackBtnEnabled()
      {
            return Utils.checkIfElementIsEnabled(btnBack);
      }


      // Next Button
      @FindBy(xpath = "//button[@id='next-btn']") private WebElement btnNext;
      public String getNextBtnText()
      {
            return Utils.getWebElementText(btnNext);
      }
      public void clickOnNextBtn()
      {
            Utils.clickOnElement(btnNext);
      }
      public boolean isNextBtnEnabled()
      {
            return Utils.checkIfElementIsEnabled(btnNext);
      }

      // Error Messages
      @FindBy(xpath = "//*[@id=\"name\"]/div[3]") private WebElement textNameErrorMsg;
      public String getNameErrorMsgText()
      {
            return Utils.getWebElementText(textNameErrorMsg);
      }
      public String getNameErrorMsgColor()
      {
            return textNameErrorMsg.getCssValue("color");
      }
      @FindBy(xpath = "//*[@id=\"email\"]/div[3]") private WebElement textEmailErrorMsg;
      public String getEmailErrorMsgText()
      {
            return Utils.getWebElementText(textEmailErrorMsg);
      }
      public String getEmailErrorMsgColor()
      {
            return textEmailErrorMsg.getCssValue("color");
      }
      @FindBy(xpath = "//*[@id=\"email\"]/div[4]") private WebElement textInvalidEmailErrorMsg;
      public String getInvalidEmailErrorMsg()
      {
            return Utils.getWebElementText(textInvalidEmailErrorMsg);
      }
      @FindBy(xpath = "//*[@id=\"phone-1\"]/div[3]") private WebElement textCellNumberErrorMsg;
      public String getCellNumberErrorMsgText()
      {
            return Utils.getWebElementText(textCellNumberErrorMsg);
      }
      public String getCellNumberErrorMsgColor()
      {
            return textCellNumberErrorMsg.getCssValue("color");
      }

}
