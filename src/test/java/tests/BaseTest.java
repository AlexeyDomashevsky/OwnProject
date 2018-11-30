package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import services.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final String BOOKING_URL = "booking.url";
    protected static final String REQUIRED_MONTH_FROM = "necessary.month.from";
    protected static final String REQUIRED_DATE_FROM = "necessary.date.from";
    protected static final String REQUIRED_MONTH_TO = "necessary.month.to";
    protected static final String REQUIRED_DATE_TO = "necessary.date.to";
    protected static final String REQUIRED_CURRENCY_TYPE = "necessary.currency";
    protected static final String NUMBER_ADULTS="number.adults";
    protected static final String NUMBER_ROOMS="number.rooms";

    protected WebDriver webDriver;

    @BeforeClass()
    public void setUp(){
        webDriver = DriverSingleton.DRIVER_INSTANCE.getDriver();
        webDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        webDriver.manage().window().maximize();
    }

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() {
        webDriver.get(PropertyReader.getProperty(BOOKING_URL));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
    }
}
