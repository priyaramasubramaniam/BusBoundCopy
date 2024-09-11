package com.Elife.Utilities;

import com.Elife.PageComponent.*;
import com.Elife.Web_Driver_Manager.DriverManager;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
      public static String getGlobalValue(String key) throws IOException {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream("src/test/java/com/Elife/Utilities/Global_Config.properties");
            properties.load(file);
            return properties.getProperty(key);
      }

      public static void moveToElementJS(WebElement element) throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(3000);
      }
      public static void moveToPageBottomJS()
      {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
      }

      public static void focusOnElement(WebElement element) throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

            // Focus on the element to bring it into view without scrolling
            js.executeScript("arguments[0].focus();", element);

            Thread.sleep(1000); // Short wait time to ensure the script executes
      }

      public static void waitForVisibilitySec(WebElement element, int seconds){
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
      }

      public static void waitForVisibility(WebElement element){
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
      }
      public static void waitForVisibilityOfElements(List<WebElement> elements){
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
      }

      public static void implicitWait(int seconds)
      {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
      }
      public static boolean checkIfElementIsDisplayed(WebElement element){
            waitForVisibilitySec(element, 40);
            return element.isDisplayed();
      }

      public static boolean checkIfElementIsNotDisplayed(WebElement element){
            return element.isDisplayed();
      }

      public boolean verifyVisibilityOfElement(WebElement element){
            try{
                  element.getSize();
                  return true;
            }catch (org.openqa.selenium.NoSuchElementException e){
                  return false;
            }
      }
      public static void checkIfElementIsSelected(WebElement element){
            Assert.assertTrue(element.isSelected());
      }

      public static void checkIfElementIsNotSelected(WebElement element){
            Assert.assertFalse(element.isSelected());
      }

      public static void clickOnElement(WebElement element){
            waitForVisibility(element);
            element.click();
      }

      public static void clearTextOnElement(WebElement element){
            waitForVisibility(element);
            element.clear();
      }

      public static void setTextOnElement(WebElement element, String text){
            waitForVisibility(element);
            element.clear();
            element.sendKeys(text);
            Assert.assertEquals(text,element.getAttribute("value"));
      }
      public static void verifyTextOfElement(WebElement element, String text){
            Assert.assertTrue(element.getText().contains(text));
      }

      public static void navigateToElement(WebElement element){
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(element).build().perform();
      }

      public static void verifyDropDownOptions(WebElement element, List<String> expectedValue){
            Select select = new Select(element);
            List<WebElement> actualOptions = select.getOptions();
            List<String> actualValues = new ArrayList<>();
            for (WebElement opt: actualOptions) {
                  actualValues.add(opt.getText());
            }
            Collections.sort(actualValues);
            Collections.sort(expectedValue);
            Assert.assertEquals(expectedValue,actualValues);
      }

      public static void selectByVisibleTextFromDropDown(WebElement element, String text){
            Select select = new Select(element);
            select.selectByVisibleText(text);
      }

      public static void selectByValueFromDropDown(WebElement element, String text){
            Select select = new Select(element);
            select.selectByValue(text);
      }

      public static void pageRefresh(){
            DriverManager.getDriver().navigate().refresh();
      }

      public boolean isElementPresent(String xpath){
            try{
                  DriverManager.getDriver().findElement(By.xpath(xpath));
                  return true;
            }catch (org.openqa.selenium.NoSuchElementException e){
                  return false;
            }
      }

      public boolean isAttributePresent(WebElement element, String attribute) {
            boolean result = false;
            try {
                  String value = element.getAttribute(attribute);
                  if (!value.isEmpty())
                        result = true;
            } catch (Exception e) {
            }
            return result;
      }

      public  static void verifySelectedOptionFromDropDown(WebElement element, String text){
            Select select = new Select(element);
            String selectedOptionInDropDown = select.getFirstSelectedOption().getText();
            Assert.assertEquals(selectedOptionInDropDown,text);
      }

      public static void verifyFieldRestrictionOnMoreThanMaxValue(WebElement element,String text){
            element.clear();
            element.sendKeys(text);
            Assert.assertEquals(text.length()-1,element.getAttribute("value").length());
      }

      public static void setNullValueOnElement(WebElement element){
            element.clear();
      }

      public static void verifyDefaultValueOfDropDown(WebElement element,String expectedValue){
            Select select = new Select(element);
            WebElement option = select.getFirstSelectedOption();
            Assert.assertEquals(option.getText(),expectedValue);
      }

      public static boolean checkIfElementIsEnabled(WebElement element){
            waitForVisibility(element);
            return element.isEnabled();
      }

      public static boolean checkIfElementIsNotEnabled(WebElement element){
            waitForVisibility(element);
            return !element.isEnabled();
      }

      public static void selectByIndexFromDropDown(WebElement element, int index){
            Select select = new Select(element);
            select.selectByIndex(index);
      }

      public static boolean isElementVisible(WebElement element){
            try{
                  return element.isDisplayed();
            }catch (Exception NoSuchElementException){
                  return false;
            }
      }

      public static String getWebElementText(WebElement element)
      {
            waitForVisibility(element);
            return element.getText();
      }
      public static List<String> getWebElementsText(List<WebElement> elements)
      {
            List<String> webElementsText = new ArrayList<>();
            for (WebElement element : elements)
            {
                  webElementsText.add(element.getText().trim());
            }
            return webElementsText;
      }

      public static void moveToElement(WebElement element)
      {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].click();", element);
//            Actions actions = new Actions(DriverManager.getDriver());
//            actions.moveToElement(element);
      }

      public static void moveToElementByOffsetAndClick(WebElement element, int x, int y)
      {
            Actions actions = new Actions(DriverManager.getDriver());
            actions.moveToElement(element, x, y).click().build().perform();
      }



      public static void attachScreenshot(Scenario scenario) throws IOException {
            if(scenario.isFailed())
            {
                  File screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
                  FileUtils.copyFile(screenshotTaken, new File("//Screenshot"));
                  scenario.attach(String.valueOf(screenshotTaken), "image/png", scenario.getName());
            }
      }

      public static void scrollToElement(WebElement element)
      {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", element);
      }

      public static String getNumberFromString(String text) {
            // Adjust the regex to handle currency symbols, commas, and periods
            Pattern pattern = Pattern.compile("\\d{1,3}(,\\d{3})*(\\.\\d{2})?");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                  return matcher.group();
            }
            return "";
      }

      public static boolean isListSortedInAscendingOrder(List<Double> list) {
            for (int i = 0; i < list.size() - 1; i++) {
                  if (list.get(i) > list.get(i + 1)) {
                        return false;
                  }
            }
            return true;
      }
      public static void switchToWindow() {
            String originalWindow = DriverManager.getDriver().getWindowHandle();

            // Loop through all open windows
            for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
                  // Switch to the new window if it's not the original window
                  if (!originalWindow.contentEquals(windowHandle)) {
                        DriverManager.getDriver().switchTo().window(windowHandle);
                        break;
                  }
            }
      }

      public static void switchToMainWindow() {
            String originalWindow = DriverManager.getDriver().getWindowHandle();

            // Get all window handles
            Set<String> allWindowHandles = DriverManager.getDriver().getWindowHandles();

            // Close all windows except the original one
            for (String windowHandle : allWindowHandles) {
                  if (!windowHandle.equals(originalWindow)) {
                        DriverManager.getDriver().switchTo().window(windowHandle);
                        DriverManager.getDriver().close(); // Close the new window
                        break;
                  }
            }

            // Switch back to the original window
            DriverManager.getDriver().switchTo().window(originalWindow);
      }
      public static void initWebElements()
      {
            PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
            PageFactory.initElements(DriverManager.getDriver(), ItineraryPage.getInstance());
            PageFactory.initElements(DriverManager.getDriver(), ContactPage.getInstance());
            PageFactory.initElements(DriverManager.getDriver(), VehiclePage.getInstance());
            PageFactory.initElements(DriverManager.getDriver(), AdditionalInfoPage.getInstance());
            PageFactory.initElements(DriverManager.getDriver(), RideSummaryPage.getInstance());
            PageFactory.initElements(DriverManager.getDriver(), RideConfirmationPage.getInstance());
            PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
            PageFactory.initElements(DriverManager.getDriver(), RideListPage.getInstance());
      }
}
