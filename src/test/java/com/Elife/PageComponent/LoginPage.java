package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
      private static LoginPage LoginInstance;
      public LoginPage(){}
      public static LoginPage getInstance()
      {
            if(LoginInstance == null)
            {
                  LoginInstance = new LoginPage();
            }
            return LoginInstance;
      }

      // Login Page
      @FindBy(xpath = "//*[@id=\"page-content\"]//div[@class='modal-title']") private WebElement textTitle;
      public String getTitle() { return Utils.getWebElementText(textTitle);}
      @FindBy(xpath = "country-codes-input") private WebElement inputCountryCode;
      @FindBy(xpath = "//div[@id='country-codes-dropdown']//a[1]") private WebElement textCountryCode;
      public void selectCountryCode(String country_code) throws InterruptedException {
            Thread.sleep(5000);
            Utils.clickOnElement(inputCountryCode);
            Utils.setTextOnElement(inputCountryCode, country_code);
            Utils.clickOnElement(textCountryCode);
      }
      @FindBy(id = "cell-phone") private WebElement inputCellNumber;
      public void enterCellNumber(String cell_number)
      {
            Utils.setTextOnElement(inputCellNumber, cell_number);
      }
      @FindBy(id = "get-verification-code") private WebElement linkGetCode;
      public void clickOnGetCodeLink()
      {
            Utils.clickOnElement(linkGetCode);
      }
      @FindBy(id = "verification-code-no") private WebElement inputVerificationCode;
      public void enterVerificationCode(String code)
      {
            Utils.setTextOnElement(inputVerificationCode, code);
      }
      @FindBy(id = "verify-checkbox") private WebElement checkboxServiceAgree;
      public void clickOnServiceCheckbox()
      {
            Utils.clickOnElement(checkboxServiceAgree);
      }
      @FindBy(id = "sms-login") private WebElement btnLogin;
      public void clickOnLoginBtn()
      {
            Utils.clickOnElement(btnLogin);
      }
      @FindBy(id = "error-msg") private WebElement textErrorMsg;
      public String getErrorMsg()
      {
            System.out.println(Utils.getWebElementText(textErrorMsg));
            Utils.waitForVisibilitySec(textErrorMsg,5);
            return Utils.getWebElementText(textErrorMsg);
      }

      @FindBy(xpath = "//label[@for='verify-checkbox']//a[1]") private WebElement linkPrivacyPolicy;
      public void clickOnPrivacyPolicy()
      {
            Utils.clickOnElement(linkPrivacyPolicy);
      }
      @FindBy(xpath = "//label[@for='verify-checkbox']//a[2]") private WebElement linkServiceAgreement;
      public void clickOnServiceAgreement()
      {
            Utils.clickOnElement(linkServiceAgreement);
      }

      // Pop up window
      @FindBy(xpath = "//div[@class=\"modal-content no-ride-found-modal\"]") private WebElement popupNoRideFound;
      public boolean isPopupDisplayed()
      {
            return Utils.checkIfElementIsDisplayed(popupNoRideFound);
      }

      @FindBy(xpath = "//div[@class=\"modal-content no-ride-found-modal\"]//div[@class=\"section modal-section-title\"]")
      private WebElement textPopupTitle;
      public String getPopupTitle()
      {
            return Utils.getWebElementText(textPopupTitle);
      }
      @FindBy(xpath = "//div[@class=\"modal-content no-ride-found-modal\"]//div[@class=\"section modal-section-description\"]")
      private WebElement textPopupDescription;
      public String getPopupDescription()
      {
            return Utils.getWebElementText(textPopupDescription);
      }
      @FindBy(xpath = "//div[@class=\"modal-content no-ride-found-modal\"]//a[@class=\"price-quote\"]")
      private WebElement btnGetAQuote;
      public void clickOnGetAQuoteBtn()
      {
            Utils.clickOnElement(btnGetAQuote);
      }
      @FindBy(xpath = "//div[@class=\"modal-content no-ride-found-modal\"]//span[@id=\"modal-close\"]")
      private WebElement btnPopupClose;
      public void clickOnPopUpCloseBtn() { Utils.clickOnElement(btnPopupClose);}





}
