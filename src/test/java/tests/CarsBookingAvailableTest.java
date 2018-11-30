package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import services.PropertyReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarsBookingAvailableTest extends BaseTest {

    @Test(groups = "car", dataProvider = "Car types")
    public void verifyCarsBookingAvailable(String carType){
        MainPage mainPage = new BasePage(super.webDriver).goToBookingCom();
        mainPage.fillPlaceNameField();
        CalendarAccommodationPage calendarAccommodationPage = mainPage.openCalendar();

        calendarAccommodationPage.fillCalendarFrom(PropertyReader.getProperty(REQUIRED_MONTH_FROM),
                PropertyReader.getProperty(REQUIRED_DATE_FROM));
        mainPage = calendarAccommodationPage.fillCalendarTo(PropertyReader.getProperty(REQUIRED_MONTH_TO),
                PropertyReader.getProperty(REQUIRED_DATE_TO));
        mainPage.submit();

        CarsBookingPage carsBookingPage = mainPage.clickCarHireLink();
        carsBookingPage.waitForRequiredTitle();
        Assert.assertTrue(carsBookingPage.isCarTypeButtonAvailable(carType));
    }

    @DataProvider(name = "Car types")
    private Iterator<Object[]> carTypes(){
        List<Object[]> data = new ArrayList();
        data.add(new Object[]{"Small cars"});
        data.add(new Object[]{"Medium cars"});
        data.add(new Object[]{"Large cars"});
        data.add(new Object[]{"Estate cars"});
        data.add(new Object[]{"Premium cars"});
        data.add(new Object[]{"People carriers"});
        data.add(new Object[]{"SUVs"});
        return data.iterator();
    }
}
