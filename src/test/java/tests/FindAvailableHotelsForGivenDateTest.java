package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import services.PropertyReader;

public class FindAvailableHotelsForGivenDateTest extends BaseTest {

    private static final String EXPECTED = "properties found";

    @Test(groups = "hotel")
    public void verifyAvailableHotelsForGivenDatePresence(){
        BasePage basePage = new BasePage(super.webDriver);
        MainPage mainPage = basePage.goToBookingCom();
        mainPage.fillPlaceNameField();
        CalendarAccommodationPage calendarAccommodationPage = mainPage.openCalendar();

        calendarAccommodationPage.fillCalendarFrom(PropertyReader.getProperty(REQUIRED_MONTH_FROM),
                PropertyReader.getProperty(REQUIRED_DATE_FROM));

        mainPage =
        calendarAccommodationPage.fillCalendarTo(PropertyReader.getProperty(REQUIRED_MONTH_TO),
                PropertyReader.getProperty(REQUIRED_DATE_TO));
        NumberOfGuestsPage numberOfGuestsPage = mainPage.clickFieldChooseGuest();

        mainPage = numberOfGuestsPage.fillFormNumberOfGuest(PropertyReader.getProperty(NUMBER_ADULTS),
                PropertyReader.getProperty(NUMBER_ROOMS));

        HotelsPage hotelsPage = mainPage.submit();
        String actual = hotelsPage.findExistProperties();
        Assert.assertTrue(actual.contains(EXPECTED));

    }
    
}
