package com.Elife.PageComponent;

import com.Elife.Utilities.Utils;
import io.cucumber.java.be.I;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.Elife.Utilities.Utils.*;

public class VehiclePage {
      private static VehiclePage VehicleInstance;
      public VehiclePage(){}
      public static VehiclePage getInstance()
      {
            if(VehicleInstance == null)
            {
                  VehicleInstance = new VehiclePage();
            }
            return VehicleInstance;
      }

      @FindBy(id = "next-btn") private WebElement btnNext;
      public void clickOnNextBtn() throws InterruptedException {
            Utils.moveToElementJS(btnNext);
            Utils.clickOnElement(btnNext);
      }

      // Functional
      @FindBy(xpath = "//div[@id='vehicle-group-lists']//div[1]") private WebElement linkVehicle;
      public void selectVehicle()
      {
            waitForVisibilitySec(linkVehicle,30);
            Utils.clickOnElement(linkVehicle);
      }
      @FindBy(xpath = "//div[@class='vehicle-item vehicle-item-selected']//div[@class='vehicle-item-qty']//div[1]//div[2]")
      private WebElement textMaxPax;
      public String getMaxPax()
      {
            return Utils.getWebElementText(textMaxPax);
      }
      @FindBy(xpath = "//div[@class='vehicle-item vehicle-item-selected']//div[@class='vehicle-item-qty']//div[2]//div[2]")
      private WebElement textMaxLux;
      public String getMaxLux()
      {
            return Utils.getWebElementText(textMaxLux);
      }
      @FindBy(xpath = "//div[@class='vehicle-item vehicle-item-selected']//div[@class='vehicle-num']//span")
      private WebElement textVehicleNumber;
      public String getVehicleNumber()
      {
            return Utils.getWebElementText(textVehicleNumber);
      }
      @FindBy(xpath = "//div[@class='vehicle-item vehicle-item-selected']//div[@class='vehicle-item-name']//div[1]//div[1]")
      private WebElement textVehicleName;
      public String getVehicleName()
      {
            return textVehicleName.getText().concat(" "+"x"+ " ").concat(getVehicleNumber());
      }
      @FindBy(xpath = "//div[@class='vehicle-item vehicle-item-selected']//div[@class='vehicle-item-name']//div[1]//div[2]")
      private WebElement textVehicleBrand;
      public String getVehicleBrand()
      {
            return Utils.getWebElementText(textVehicleBrand);
      }
      @FindBy(xpath = "//div[@class='vehicle-item vehicle-item-selected']//div[@class='vehicle-item-amt']//div[2]//div[1]")
      private WebElement textVehiclePrice;
      public String getVehiclePrice()
      {
            String price = Utils.getWebElementText(textVehiclePrice);
            String[] values = price.split(" ");
            return values[1].replace(",","").concat(" ").concat(values[0]);

      }
}

