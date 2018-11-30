package pages;

import entity.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CustomLogger;

public class FlightsPage extends BasePage {

    private static final By FLIGHT_TICKET_LOC = By.xpath("//div[@class='best-flights-list-results']");
    private static final By SHIPPING_COMPANY_LOC = By.xpath(".//div[@class=col-field carrier]/div[@class='bottom']");
    private static final By DEPARTURE_TIME_LOC = By.xpath(".//div[@class='col-field time depart']//div[@class='top']");
    private static final By DEPARTURE_AIRPORT_LOC = By.xpath(".//div[@class='col-field time depart']//div[@class='bottom']");
    private static final By ARRIVAL_TIME_LOC = By.xpath(".//div[@class='col-field time return']//div[@class='top']");
    private static final By ARRIVAL_AIRPORT_LOC = By.xpath(".//div[@class='col-field time return']//div[@class='bottom']");
    private static final By DURATION_TIME_LOC = By.xpath("//div[@class='col-field duration']//div[@class='top']");
    @FindBy(xpath = "//div[@class='keel-grid dateRangeGrid']")
    private WebElement dateField;
    @FindBy(xpath = "//input[@name='origin']")
    private WebElement from;
    @FindBy(xpath = "//input[@name='destination']")
    private WebElement to;
    @FindBy(xpath = "//span[@class='label-text' and contains(text(),'One-way')]")
    private WebElement oneWayOption;
    @FindBy(xpath = "//button[@id='AmTa-submit']")
    private WebElement searchButton;

    public FlightsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public FlightsPage chooseOneWayTicket() {
        from.click();
        CustomLogger.logIntoConsoleInfo("after arrow click");
        waiters.waitForDisplayed(oneWayOption);
        oneWayOption.click();
        return this;
    }


    public void getTicket() {
        waitElem(FLIGHT_TICKET_LOC);

        Ticket ticket = new Ticket();

        waitElem(SHIPPING_COMPANY_LOC);

        ticket.setShippingCompany(getText(SHIPPING_COMPANY_LOC));
        ticket.setDepartureTime(getText(DEPARTURE_TIME_LOC));
        ticket.setDepartureAirport(getText(DEPARTURE_AIRPORT_LOC));
        ticket.setArrivalTime(getText(ARRIVAL_TIME_LOC));
        ticket.setArrivalAirport(getText(ARRIVAL_AIRPORT_LOC));
        ticket.setFlightTimeDuration(getText(DURATION_TIME_LOC));
        System.out.println(ticket.getShippingCompany());
    }

    private String getText(By locator) {
        WebElement ticketBody = webDriver.findElement(FLIGHT_TICKET_LOC);
        return ticketBody.findElement(locator).getText();
    }

    private void waitElem(By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, WAIT_TIME);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public CalendarFlightPage clickCalendar() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, WAIT_TIME);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col-1-4 col-rtow col-travel-dates']")));
        dateField.click();
        return PageFactory.initElements(webDriver, CalendarFlightPage.class);
    }
}
