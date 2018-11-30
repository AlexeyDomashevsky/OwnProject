package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import services.PropertyReader;
import util.CustomLogger;

import java.util.ArrayList;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@id='ss']")
    private WebElement fieldInputNamePlace;

    @FindBy(xpath = "//div[@data-component='search/group/group-with-modal']")
    private WebElement chooseNumberOfGuests;

    @FindBy(xpath = "//div[@class ='xp__button']//button[@data-sb-id='main']")
    private WebElement submitButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage fillPlaceNameField() {
        this.fieldInputNamePlace.clear();
        this.fieldInputNamePlace.sendKeys(PropertyReader.getProperty(NAME_PLACE));
        return this;
    }

    public HotelsPage submit() {
        CustomLogger.logIntoConsoleInfo("Click 'Search' button");
        submitButton.click();
        waiters.waitForPageLoaded();
        CustomLogger.logIntoConsoleInfo("Check if language switched and not dropped");
        if (isLanguageChanged(PropertyReader.getProperty(DEFAULT_LANGUAGE))) {
            changeLanguage();
        } else {
            clickLanguageButton();
        }
        return PageFactory.initElements(webDriver, HotelsPage.class);
    }

    public NumberOfGuestsPage clickFieldChooseGuest() {
        chooseNumberOfGuests.click();
        return PageFactory.initElements(webDriver, NumberOfGuestsPage.class);
    }

    public CalendarAccommodationPage openCalendar() {
        return PageFactory.initElements(webDriver, CalendarAccommodationPage.class);
    }

    /**
     * Page sometimes doesn't load at all, and waiters can't handle this behaviour
     */
    public FlightsPage clickFlightLink() {
        CustomLogger.logIntoConsoleInfo("Wait for ' " + PropertyReader.getProperty(FLIGHTS_LINK) + " ' link to be present");
        waiters.waitForElementPresent(By.xpath("//span[contains(text(), '" + PropertyReader.getProperty(FLIGHTS_LINK) + "')]"));
        webDriver.findElement(By.xpath("//span[contains(text(), '" + PropertyReader.getProperty(FLIGHTS_LINK) + "')]")).click();
        CustomLogger.logIntoConsoleError("Switch to next tab");
        ArrayList<String> tabs = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(tabs.size() - 1));
        waiters.sleep();
//        if(!((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equals("complete")){
        CustomLogger.logIntoConsoleInfo("Refresh page");
        webDriver.navigate().refresh();
//        }
        return PageFactory.initElements(webDriver, FlightsPage.class);
    }

    public CarsBookingPage clickCarHireLink() {
        CustomLogger.logIntoConsoleInfo("Wait for ' " + PropertyReader.getProperty(CAR_HIRE_LINK) + " ' link to be present");
        waiters.waitForElementPresent(By.xpath("//span[contains(text(), '" + PropertyReader.getProperty(CAR_HIRE_LINK) + "')]"));
        webDriver.findElement(By.xpath("//span[contains(text(), '" + PropertyReader.getProperty(CAR_HIRE_LINK) + "')]")).click();
        CustomLogger.logIntoConsoleError("Switch to next tab");
        ArrayList<String> tabs = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(tabs.size() - 1));
        waiters.waitForPageLoaded();
        return PageFactory.initElements(webDriver, CarsBookingPage.class);
    }

    public AirportTaxisPage clickAirportTaxisLink() {
        CustomLogger.logIntoConsoleInfo("Wait for ' " + PropertyReader.getProperty(AIRPORT_TAXI_LINK) + " ' link to be present");
        waiters.waitForElementPresent(By.xpath("//span[contains(text(), '" + PropertyReader.getProperty(AIRPORT_TAXI_LINK) + "')]"));
        webDriver.findElement(By.xpath("//span[contains(text(), '" + PropertyReader.getProperty(AIRPORT_TAXI_LINK) + "')]")).click();
        CustomLogger.logIntoConsoleError("Switch to next tab");
        ArrayList<String> tabs = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(tabs.size() - 1));
        waiters.waitForPageLoaded();
        return PageFactory.initElements(webDriver, AirportTaxisPage.class);
    }
}
