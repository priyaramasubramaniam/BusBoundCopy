package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

      // Header
      @FindBy(xpath = "//div[@class=\"my-rides-dropdown\"]") private WebElement linkMyRides;
      public void clickOnMyRidesBtn()
      {
            Utils.clickOnElement(linkMyRides);
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
            WebElement overlappingElement = DriverManager.getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div"));
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.display='none';", overlappingElement);
            DriverManager.getDriver().switchTo().frame("front-inc");
      }

      public void displayHeader() {
            DriverManager.getDriver().switchTo().defaultContent();
            WebElement overlappingElement = DriverManager.getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div"));
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.display='block';", overlappingElement);
      }

}
