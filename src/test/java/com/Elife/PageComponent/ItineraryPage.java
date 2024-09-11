package com.Elife.PageComponent;

import com.Elife.Utilities.ScenarioContext;
import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ItineraryPage {
      private static ItineraryPage ItineraryInstance;

      public ItineraryPage() {
      }

      public static ItineraryPage getInstance() {
            if (ItineraryInstance == null) {
                  ItineraryInstance = new ItineraryPage();
            }
            return ItineraryInstance;
      }

      //
      @FindBy(id = "passengers-input")
      private WebElement inputPassengerCount;
      public void enterPassengerCount(String value) throws InterruptedException {
            Thread.sleep(3000);
            inputPassengerCount.clear();
            Utils.setTextOnElement(inputPassengerCount, value);
      }


      @FindBy(id = "luggages-input")
      private WebElement inputLuggageCount;
      public void enterLuggageCount(String value) throws InterruptedException {
            inputLuggageCount.clear();
            Utils.setTextOnElement(inputLuggageCount, value);
      }


      @FindBy(id = "event-type") private WebElement ddEventType;
      public void clickOnEventTypeDD() {Utils.clickOnElement(ddEventType);}

      @FindBy(id = "//div[@id='event-dropdown']//a[text()='%s']") private WebElement textEventType;
      public void clickOnEventType(String event_type)
      {
            String xpath = String.format("//div[@id='event-dropdown']//a[@id='%s']", event_type);
            WebElement element = DriverManager.getDriver().findElement(By.xpath(xpath));
            element.click();
      }


      // Common xpath - //div[@id='rides']//div[contains(@class,'ride-card')]
      // input location header - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@class='card-title']
      // input location label - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@class='location-title']
      // input location (placeholder) - //div[@id='rides']//div[contains(@class,'ride-card')]//input[contains(@class,'location-input')]
      // input location dropdown first element - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='dropdown']//a[1]

      // input date label - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-time']//div[contains(@class,"form-input")][1]
      // input date - //div[@id='rides']//div[contains(@class,'ride-card')]//input[@id='date']
      // input date calender next btn - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-calendar']//td[@id='next']
      // input date calender previous btn - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-calendar']//td[@id='prev']

      // input time - //div[@id='rides']//div[contains(@class,'ride-card')]//span[@id='time-display']
      // input time hour - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//input[@id='time-hr']
      // input time hour - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//input[@id='time-min']
      // input time hour - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//input[@id='time-hr']
      //input time am - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//div[@id='am']
      //input time pm - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//div[@id='pm']

      // Add stops for all - //div[@id='rides']//div[contains(@class,'ride-card')]//div[@class='add-stop']


      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//input[contains(@class,'location-input')]")
      private List<WebElement> inputLocations;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='dropdown']//a[1]")
      private List<WebElement> dropdownLocationName;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//input[@id='date']")
      private List<WebElement> inputPickupDates;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-calendar']//td[@id='next']")
      private List<WebElement> btnPickupDateNext;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-display']")
      private List<WebElement> inputPickupTimes;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//input[@id='time-hr']")
      private List<WebElement> inputPickupHrs;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//input[@id='time-min']")
      private List<WebElement> inputPickupMins;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//div[@id='am']")
      private List<WebElement> btnPeriodAm;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//div[@id='pm']")
      private List<WebElement> btnPeriodPm;


      public void enterLocation(String location, int index) throws InterruptedException {
            Utils.setTextOnElement(inputLocations.get(index), location);
            Thread.sleep(5000);
            Utils.clickOnElement(dropdownLocationName.get(index));
      }

      public void selectDate(String year, String month, String day, int index) throws InterruptedException {
            // Click the calendar element at the specified index
            inputPickupDates.get(index).click();

            // Construct the expected year-month string
            String expectedYearMonth = year + "-" + month;
            String expectedDay = day;

            while (true) {
                  // Find the month and year elements at the specified index
                  WebElement monthYearElement = DriverManager.getDriver().findElement(
                          By.xpath("(//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-calendar'])[" + (index + 1) + "]//td[@id='cur']")
                  );
//                  System.out.println(monthYearElement.getText());
                  // Check if the desired month and year are present
                  if (monthYearElement.getText().equalsIgnoreCase(expectedYearMonth)) {
                        // Find the day element within the same calendar
                        List<WebElement> dayElements = DriverManager.getDriver().findElements(
                                By.xpath("(//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-calendar'])[" + (index + 1) + "]//td[@name='date']")
                        );
                        for (WebElement dayElement : dayElements)
                        {
                              if (dayElement.getText().equalsIgnoreCase(day))
                              {
                                    dayElement.click();
                                    return;
                              }
                        }

                  }
                  // Click the next button to navigate to the next month
                  btnPickupDateNext.get(index).click();
                  Thread.sleep(3000); // Wait for the calendar to update
            }
      }


      public void enterTime(String hour, String minute, String period, int index) {
            WebElement timeInput = inputPickupTimes.get(index);
            timeInput.click(); // Focus on the time input field

            Utils.setTextOnElement(inputPickupHrs.get(index), hour);
            Utils.setTextOnElement(inputPickupMins.get(index), minute);

            // Handle AM/PM period
            if ("AM".equalsIgnoreCase(period)) {
                  btnPeriodAm.get(index).click();
            } else {
                  btnPeriodPm.get(index).click(); // Ensure you have btnPeriodPm defined similarly
            }
      }
      public void enterTripDetails(String[] locations, String[] years, String[] months, String[] days, String[] hours, String[] minutes, String[] periods) throws InterruptedException {
            for (int i = 0; i < locations.length; i++) {
                  enterLocation(locations[i], i);

                  // Wait for date picker visibility only when necessary
                  if (i < locations.length - 1) {
                        Utils.waitForVisibility(inputPickupDates.get(i)); // Ensure visibility dynamically

                        if (!hours[i].isEmpty() && !minutes[i].isEmpty() && !periods[i].isEmpty()) {
                              enterTime(hours[i], minutes[i], periods[i], i);
                        }
                        if (!days[i].isEmpty() && i < months.length && i < years.length) {
                              selectDate(years[i], months[i], days[i], i);
                        }
                  }
            }
      }

      public List<String> getLocations()
      {
            List<String> locations = new ArrayList<>();
            for (WebElement location : inputLocations)
            {
                  locations.add(location.getAttribute("value"));
            }
            return locations;
      }

      public List<String> getDates() {
            Set<String> uniqueDates = new LinkedHashSet<>();
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d MMM");

            for (WebElement date : inputPickupDates) {
                  String dateValue = date.getAttribute("value");

                  // Check if dateValue is not empty and in the expected format
                  if (dateValue != null && !dateValue.isEmpty()) {
                        try {
                              LocalDate parsedDate = LocalDate.parse(dateValue, inputFormatter);
                              String formattedDate = parsedDate.format(outputFormatter);
                              uniqueDates.add(formattedDate);
                        } catch (DateTimeParseException e) {
                              System.out.println("Could not parse date: " + dateValue);
                        }
                  }
            }
            return new ArrayList<>(uniqueDates);
      }

      public List<String> getRideDateForEachDay() {
            Set<String> uniqueDates = new LinkedHashSet<>();
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy");

            for (WebElement date : inputPickupDates) {
                  String dateValue = date.getAttribute("value").trim();

                  // Check if dateValue is not empty and in the expected format
                  if (dateValue != null && !dateValue.isEmpty()) {
                        try {
                              LocalDate parsedDate = LocalDate.parse(dateValue, inputFormatter);
                              String formattedDate = parsedDate.format(outputFormatter);
                              uniqueDates.add(formattedDate);
                        } catch (DateTimeParseException e) {
                              System.out.println("Could not parse date: " + dateValue);
                        }
                  }
            }
            return new ArrayList<>(uniqueDates);
      }

      public List<String> getTimes() {
            List<String> Times = new ArrayList<>();
//            Utils.waitForVisibilityOfElements(inputPickupTimes);
            for (int i=0; i<inputPickupTimes.size()-1; i++) {
                  String timeValue = Utils.getWebElementText(inputPickupTimes.get(i));

                  // Check if dateValue is not empty and in the expected format
                  if (timeValue != null && !timeValue.isEmpty()) {
                        try {
                              String formattedTime = timeValue.replace(" ", "");
                              Times.add(formattedTime);
                        } catch (DateTimeParseException e) {
                              System.out.println("Could not parse date: " + timeValue);
                        }
                  }

            }

            return Times;
      }


      public Collection<List<String>> getLocationsByDatesWithDate() {
            Map<String, List<String>> dateToLocationsMap = new HashMap<>();

            for (int i=0; i<inputLocations.size(); i++)
            {
                  String date = inputPickupDates.get(i).getAttribute("value").trim();
                  String location = inputLocations.get(i).getAttribute("value").trim();
                  dateToLocationsMap.computeIfAbsent(date, k -> new ArrayList<>()).add(location);
            }
            List<Map.Entry<String, List<String>>> entryList = new ArrayList<>(dateToLocationsMap.entrySet());
            return dateToLocationsMap.values();
      }


      @FindBy(xpath = "//*[@id=\"next-btn\"]") private WebElement btnNext;
      public void clickOnNextBtn()
      {
            HomePage.getInstance().hideHeader();
            Utils.clickOnElement(btnNext);
      }
      @FindBy(xpath = "(//*[@id=\"stops-btn\"])[1]//div[@class='add-stop']")
      private WebElement linkAddStop;
      public void addStops() {
            Utils.clickOnElement(linkAddStop);
      }






//      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-display']")
//      private List<WebElement> inputPickupTime;
//      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//input[@id='time-hr']")
//      private List<WebElement> inputPickupHr;
//      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//input[@id='time-min']")
//      private List<WebElement> inputPickupMin;
//      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//div[@id='am']")
//      private List<WebElement> btnPeriodAm;
//      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='time-dropdown']//div[@id='pm']")
//      private List<WebElement> btnPeriodPm;
//
//
////      public void clickOnPickupTime()
////      {
////            for (WebElement element : inputPickupTime)
////            {
////                  Utils.clickOnElement(element);
////            }
////      }
//      public void enterPickupHour(String hour)
//      {
//            for (WebElement element : inputPickupHr)
//            {
//                  Utils.setTextOnElement(element, hour);
//            }
//      }
//      public void enterPickupMin(String min)
//      {
//            for (WebElement element : inputPickupMin)
//            {
//                  Utils.setTextOnElement(element, min);
//            }
//      }
//      public void selectPeriod(String period) {
//            WebElement buttonToClick = null;
//
//            if (period.equalsIgnoreCase("AM")) {
//                  if (!btnPeriodAm.isEmpty()) {
//                        buttonToClick = btnPeriodAm.get(0); // Get the first AM button
//                  }
//            } else if (period.equalsIgnoreCase("PM")) {
//                  if (!btnPeriodPm.isEmpty()) {
//                        buttonToClick = btnPeriodPm.get(0); // Get the first PM button
//                  }
//            } else {
//                  throw new IllegalArgumentException("Invalid period specified: " + period);
//            }
//
//            if (buttonToClick != null) {
//                  Utils.clickOnElement(buttonToClick);
//            } else {
//                  throw new NoSuchElementException("No button found for period: " + period);
//            }
//      }

//}
}
