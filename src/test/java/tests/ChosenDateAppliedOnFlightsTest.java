package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import services.PropertyReader;

public class ChosenDateAppliedOnFlightsTest extends BaseTest {

    @Test(groups = "flight")
    public void verifyChosenDateAppliedOnFlights(){
        MainPage mainPage = new BasePage(super.webDriver).goToBookingCom();
        mainPage.fillPlaceNameField();
        CalendarAccommodationPage calendarAccommodationPage = mainPage.openCalendar();

        calendarAccommodationPage.fillCalendarFrom(PropertyReader.getProperty(REQUIRED_MONTH_FROM),
                PropertyReader.getProperty(REQUIRED_DATE_FROM));

        mainPage = calendarAccommodationPage.fillCalendarTo(PropertyReader.getProperty(REQUIRED_MONTH_TO),
                PropertyReader.getProperty(REQUIRED_DATE_TO));
        mainPage.submit();

        FlightsPage flightsPage = mainPage.clickFlightLink();

        CalendarFlightPage calendarFlightPage = flightsPage.clickCalendar();

        String actual = calendarFlightPage.getExistingDate();
        Assert.assertEquals(actual, expectedDate());
    }

    private String expectedDate(){
        return PropertyReader.getProperty(REQUIRED_MONTH_FROM) + " " +
                PropertyReader.getProperty(REQUIRED_DATE_FROM) + " " +
                PropertyReader.getProperty(REQUIRED_MONTH_TO) + " " +
                PropertyReader.getProperty(REQUIRED_DATE_TO);
    }
}
