package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import com.google.common.base.Utf8;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.Elife.Utilities.Utils.waitForVisibilitySec;

public class QuotesPage {
      private static QuotesPage QuotesInstance;
      public QuotesPage(){}
      public static QuotesPage getInstance()
      {
            if(QuotesInstance == null)
            {
                  QuotesInstance = new QuotesPage();
            }
            return QuotesInstance;
      }
      @FindBy(xpath = "//section[@id='contact-info-2']//div[@class='top']//div[@class='title']")
      private WebElement textTitle;
      public String getTitle() { waitForVisibilitySec(textTitle,30);
            return Utils.getWebElementText(textTitle);}
      @FindBy(xpath = "//section[@id='contact-info-2']//div[@class='top']//div[@class='subtitle']")
      private WebElement textSubTitle;
      public String getSubTitle() { return Utils.getWebElementText(textSubTitle);}
}
