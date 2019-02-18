package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import services.PropertyReader;
import utils.Waiters;

public class BasePage {

    private static final String DEFAULT_LANGUAGE = "required.language";
    protected Waiters waiters;
    protected WebDriver driver;
    protected Logger pageLogger = LogManager.getLogger(this);

    @FindBy(xpath = "//li[@data-id='language_selector']")
    private WebElement changeLanguageSelector;

    @FindBy(xpath = "//a[@aria-selected='true']//span[@class='seldescription']")
    private WebElement selectedLanguage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waiters = new Waiters();
    }

    public void clickLanguageButton() {
        waiters.sleep(0);
        pageLogger.info("after wait");
        changeLanguageSelector.click();
        pageLogger.info("changeLanguageSelector.click()");
    }

    public void changeLanguage() {
        driver.findElement(By.xpath("//span[contains(text(), '" + PropertyReader.getProperty(DEFAULT_LANGUAGE) + "')]")).click();
    }

    public String getUsedLanguage() {
        changeLanguageSelector.click();
        return selectedLanguage.getText();
    }
}
