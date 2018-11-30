package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CalendarAccommodationPage;
import pages.HotelsPage;
import pages.MainPage;
import services.PropertyReader;

public class ChangeTheTypeOfCurrencyTest extends BaseTest {

    private static final String EXPECTED = "US$";

    @Test(groups = "hotel")
    public void verifyTypeOfCurrencyIsChanged(){
        MainPage mainPage = new BasePage(super.webDriver).goToBookingCom();
        mainPage.fillPlaceNameField();
        CalendarAccommodationPage calendarAccommodationPage = mainPage.openCalendar();

        calendarAccommodationPage.fillCalendarFrom(PropertyReader.getProperty(REQUIRED_MONTH_FROM),
                PropertyReader.getProperty(REQUIRED_DATE_FROM));
        mainPage = calendarAccommodationPage.fillCalendarTo(PropertyReader.getProperty(REQUIRED_MONTH_TO),
                        PropertyReader.getProperty(REQUIRED_DATE_TO));
        HotelsPage hotelsPage = mainPage.submit();
        hotelsPage.changeCurrency(PropertyReader.getProperty(REQUIRED_CURRENCY_TYPE));

        String actual = hotelsPage.findPrice();
        Assert.assertTrue(actual.contains(EXPECTED));
    }
}
