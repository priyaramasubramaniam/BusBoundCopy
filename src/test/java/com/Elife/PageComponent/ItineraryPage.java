package com.Elife.PageComponent;

import com.Elife.Utilities.ScenarioContext;
import com.Elife.Utilities.Utils;
import com.Elife.Web_Driver_Manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.rmi.CORBA.Util;
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

      @FindBy(id = "return-trip") private WebElement checkBoxReturnTrip;
      public void clickOnReturnTripCB() { Utils.clickOnElement(checkBoxReturnTrip);}
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
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//input[@id='date-time-combo']")
      private List<WebElement> inputPickupDateTimes;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-time-combo-calendar']//td[@id='next']")
      private List<WebElement> btnPickupDateNext;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-time-combo-time']")
      private List<WebElement> inputPickupTimes;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-time-combo-time']//input[@id='time-hr']")
      private List<WebElement> inputPickupHrs;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-time-combo-time']//input[@id='time-min']")
      private List<WebElement> inputPickupMins;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-time-combo-time']//div[@id='am']")
      private List<WebElement> btnPeriodAm;
      @FindBy(xpath = "//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-time-combo-time']//div[@id='pm']")
      private List<WebElement> btnPeriodPm;


      public void enterLocation(String location, int index) throws InterruptedException {
            Utils.setTextOnElement(inputLocations.get(index), location);
            Thread.sleep(5000);
            Utils.clickOnElement(dropdownLocationName.get(index));
      }

      public void selectDate(String year, String month, String day, int index) throws InterruptedException {
            // Click the calendar element at the specified index
            inputPickupDateTimes.get(index).click();

            // Construct the expected year-month string
            String expectedYearMonth = month+" "+year;
            String expectedDay = day;

            while (true) {
                  // Find the month and year elements at the specified index
                  WebElement monthYearElement = DriverManager.getDriver().findElement(
                          By.xpath("(//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-time-combo-calendar'])[" + (index + 1) + "]//td[@id='cur']")
                  );
//                  System.out.println(monthYearElement.getText());
                  // Check if the desired month and year are present
                  if (monthYearElement.getText().equalsIgnoreCase(expectedYearMonth)) {
                        // Find the day element within the same calendar
                        List<WebElement> dayElements = DriverManager.getDriver().findElements(
                                By.xpath("(//div[@id='rides']//div[contains(@class,'ride-card')]//div[@id='date-time-combo-calendar'])[" + (index + 1) + "]//td[@name='date']")
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
                        Utils.waitForVisibility(inputPickupDateTimes.get(i)); // Ensure visibility dynamically

                        if (!days[i].isEmpty() && i < months.length && i < years.length) {
                              selectDate(years[i], months[i], days[i], i);
                        }
                        if (!hours[i].isEmpty() && !minutes[i].isEmpty() && !periods[i].isEmpty()) {
                              enterTime(hours[i], minutes[i], periods[i], i);
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


      public String getFromLocation() { return inputLocations.get(0).getAttribute("value");}
      public String getToLocation()
      {
            boolean isRoundTripNotEnabled = checkBoxReturnTrip.getAttribute("class").contains("unchecked");
            int index =  isRoundTripNotEnabled ? inputLocations.size() - 1 : inputPickupDateTimes.size() - 2;
            return inputLocations.get(index).getAttribute("value");
      }
      public String getFromDateTime() {
            return inputPickupDateTimes.get(0).getAttribute("value").replaceFirst("^0", "");}

      public String getToDateTime() {
            boolean isRoundTripNotEnabled = checkBoxReturnTrip.getAttribute("class").contains("unchecked");
            int index =  isRoundTripNotEnabled ? inputPickupDateTimes.size() - 1 : inputPickupDateTimes.size() - 2;
            return inputPickupDateTimes.get(index).getAttribute("value").replaceFirst("^0", "");
      }



      public List<String> getDates() {
            Set<String> uniqueDates = new LinkedHashSet<>();

            for (WebElement date : inputPickupDateTimes) {
                  String dateValue = date.getAttribute("value");

                  // Check if dateValue is not empty and in the expected format
                  if (dateValue != null && !dateValue.isEmpty()) {
                        try {
                              String DateTime = dateValue.split(",")[0];
                              String[] dateTimeParts = DateTime.split(" ");
                              String day = dateTimeParts[1];  // Get the day ("21")
                              String month = dateTimeParts[0];  // Get the month abbreviation ("Sep")

                              // Format the date as "21 Sep"
                              String formattedDate = day + " " + month;
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

            for (WebElement date : inputPickupDateTimes) {
                  String dateValue = date.getAttribute("value").trim();

                  // Check if dateValue is not empty and in the expected format
                  if (dateValue != null && !dateValue.isEmpty()) {
                        try {
                              // Extract the date part (e.g., "Sep 21, 2024")
                              String[] dateTimeParts = dateValue.split(" ");
                              String formattedDate = dateTimeParts[0] + " " + dateTimeParts[1] +" "+ dateTimeParts[2];

                              uniqueDates.add(formattedDate);
                        } catch (DateTimeParseException e) {
                              System.out.println("Could not parse date: " + dateValue.split(",")[0]);
                        }
                  }
            }
            return new ArrayList<>(uniqueDates);
      }

      public List<String> getRideTimes() {
            List<String> Times = new ArrayList<>();
            for (WebElement time : inputPickupDateTimes) {
                  String timeValue = time.getAttribute("value").trim();

                  // Check if dateValue is not empty and in the expected format
                  if (timeValue != null && !timeValue.isEmpty()) {
                        try {
                              String[] dateTimeParts = timeValue.split(" ");
                              String formattedDate = dateTimeParts[3] + dateTimeParts[4];

                              Times.add(formattedDate);
                        } catch (DateTimeParseException e) {
                              System.out.println("Could not parse date: " + timeValue.split(" "));
                        }
                  }
            }
            return new ArrayList<>(Times);
      }


      public Collection<List<String>> getLocationsByDatesWithDate() {
            Map<String, List<String>> dateToLocationsMap = new HashMap<>();

            for (int i=0; i<inputLocations.size(); i++)
            {
                  String date = inputPickupDateTimes.get(i).getAttribute("value").trim();
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
