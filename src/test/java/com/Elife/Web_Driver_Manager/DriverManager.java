package com.Elife.Web_Driver_Manager;
import com.Elife.Utilities.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverManager {
      private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

      public static WebDriver driver = null;

      public static WebDriver getDriver() {
            return driver;
      }

      public static String downloadFilepath;


      //launchBrowser
      public static void launchBrowser()
      {

            try {
                  switch (Utils.getGlobalValue("BROWSER"))
                  {
                        case "chrome":
                              WebDriverManager.chromedriver().setup();
                              LOGGER.info("Launching "+Utils.getGlobalValue("BROWSER")+ "...........");
                              ChromeOptions chromeOptions = new ChromeOptions();
                              chromeOptions.addArguments("--remote-allow-origins=*");
                              driver = new ChromeDriver(chromeOptions);
                              driver.manage().window().maximize();
                              break;
                        case "firefox":
                              WebDriverManager.firefoxdriver().setup();
                              LOGGER.info("Launching "+Utils.getGlobalValue("BROWSER")+ "...........");
                              FirefoxOptions firefoxOptions = new FirefoxOptions();
                              firefoxOptions.setAcceptInsecureCerts(true);
                              DesiredCapabilities capabilities = new DesiredCapabilities();
                              capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                              driver = new FirefoxDriver();
                              driver.manage().window().maximize();
                              break;
                        case "ie":
                              WebDriverManager.iedriver().setup();
                              LOGGER.info("Launching "+Utils.getGlobalValue("BROWSER")+ "...........");
                              driver = new InternetExplorerDriver();
                              driver.manage().window().maximize();
                              break;
                        default:
                              WebDriverManager.chromedriver().setup();
                              LOGGER.info("Launching "+Utils.getGlobalValue("BROWSER")+ "...........");
                              driver = new ChromeDriver();
                              break;
                  }
            }
            catch (Exception e)
            {
                  e.printStackTrace();
            }

      }
}
