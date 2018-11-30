package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.PropertyReader;
import util.CustomLogger;
import util.Waiters;

public class BasePage {

    protected static final int WAIT_TIME = 5000;
    protected static final String DEFAULT_LANGUAGE = "required.language";
    protected static final String NAME_PLACE = "name.place";
    protected static final String FLIGHTS_LINK = "link.flights";
    protected static final String CAR_HIRE_LINK = "link.car.hire";
    protected static final String AIRPORT_TAXI_LINK = "link.airport.taxi";
    protected static final String SPACE = " ";
    protected WebDriver webDriver;
    protected Waiters waiters;

    @FindBy(xpath = "//li[@data-id='language_selector']")
    private WebElement changeLanguageSelector;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waiters = new Waiters(webDriver);
    }

    public void clickLanguageButton() {
        changeLanguageSelector.click();
    }

    public MainPage goToBookingCom() {
        clickLanguageButton();
        changeLanguage();
        waiters.waitForPageLoaded();
        return PageFactory.initElements(this.webDriver, MainPage.class);
    }

    public void changeLanguage() {
        CustomLogger.logIntoConsoleInfo("Choose English (US) language");
        webDriver.findElement(By.xpath("//span[contains(text(), '" + PropertyReader.getProperty(DEFAULT_LANGUAGE) + "')]")).click();
    }

    public boolean isLanguageChanged(String language) {
        CustomLogger.logIntoConsoleInfo("Wait for 'Switch language' button to be present");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, WAIT_TIME);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeLanguageSelector));
        clickLanguageButton();
        return !webDriver.findElements(By.xpath("//span[contains(text(), '" + language + "')]")).isEmpty();
    }

}
