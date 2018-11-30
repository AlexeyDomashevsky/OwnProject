package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AirportTaxisPage;
import pages.BasePage;
import pages.MainPage;

public class TaxiBookingComAvailableTest extends BaseTest {

    @Test(groups = "taxi")
    public void verifyAirportTaxisRedirectsToBookingTaxiService(){
        MainPage mainPage = new BasePage(super.webDriver).goToBookingCom();
        AirportTaxisPage airportTaxisPage = mainPage.clickAirportTaxisLink();
        airportTaxisPage.bookTaxi();
        airportTaxisPage.waitForSearchComplete();
        Assert.assertEquals(airportTaxisPage.getPageTitle(), "Search Results | Booking.com");
    }
}
