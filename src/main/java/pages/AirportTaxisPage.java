package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.PropertyReader;

public class AirportTaxisPage extends BasePage {

    private static final String PICK_UP_LOCATION = "taxi.pick.up.location";
    private static final String PICK_UP_LOCATOR_PART = "taxi.pick.up.locator.part";
    private static final String DROP_OFF_LOCATION = "taxi.drop.off.location";
    private static final String DROP_OFF_LOCATOR_PART = "taxi.drop.off.locator.part";
    private static final By SELECT_TAXI = By.xpath("//span[contains(text(), 'select taxi')]");
    private static final By PICK_UP_ITEM_LOCATOR =
            By.xpath("//div[contains(text(), '" + PropertyReader.getProperty(PICK_UP_LOCATOR_PART) + "')]");
    private static final By DROP_OFF_ITEM_LOCATOR =
            By.xpath("//div[contains(text(), '" + PropertyReader.getProperty(DROP_OFF_LOCATOR_PART) + "')]");
    @FindBy(xpath = "//input[@id='pickupLocation']")
    private WebElement pickUpLocation;
    @FindBy(xpath = "//input[@id='dropoffLocation']")
    private WebElement dropOffLocation;
    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    private WebElement searchButton;

    public AirportTaxisPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void bookTaxi() {
        this.pickUpLocation.clear();
        this.pickUpLocation.sendKeys(PropertyReader.getProperty(PICK_UP_LOCATION));
        waiters.waitForElementPresent(PICK_UP_ITEM_LOCATOR).click();
        this.dropOffLocation.clear();
        this.dropOffLocation.sendKeys(PropertyReader.getProperty(DROP_OFF_LOCATION));
        waiters.waitForElementPresent(DROP_OFF_ITEM_LOCATOR).click();
        this.searchButton.click();
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void waitForSearchComplete() {
        waiters.waitForElementPresent(SELECT_TAXI);
    }
}
