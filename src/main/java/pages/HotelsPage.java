package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsPage extends BasePage {

    private static final String PRICE_ELEMENT = "//div[@class='room_details ']//b";
    private static final String BEGIN_LOCATOR_CHOOSE_CURRENCY_TYPE = "//ul[@class='currency_list']//span[contains(text(),'";
    private static final String END_LOCATOR_PART_CHOOSE_CURRENCY_TYPE = "')]";

    @FindBy(xpath = "//li[@data-id='currency_selector']")
    private WebElement currencyTypeSelector;

    @FindBy(xpath = "//div[@data-block-id='heading']//h2")
    private WebElement foundProperties;

    public HotelsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String findPrice() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, WAIT_TIME);
        webDriverWait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath(PRICE_ELEMENT)));
        return webDriver.findElement(By.xpath(PRICE_ELEMENT)).getText();
    }

    public HotelsPage changeCurrency(String currencyType) {
        By locator = By.xpath(BEGIN_LOCATOR_CHOOSE_CURRENCY_TYPE +
                currencyType + END_LOCATOR_PART_CHOOSE_CURRENCY_TYPE);
        currencyTypeSelector.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, WAIT_TIME);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        webDriver.findElement(locator).click();
        return PageFactory.initElements(webDriver, HotelsPage.class);
    }

    public String findExistProperties() {
        return foundProperties.getText();
    }
}
