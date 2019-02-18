package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import services.PropertyReader;

public class MainPage extends BasePage{

    private static final String DESTINATION = "destination.place.name";
    private static final String CHECK_IN_MONTH = "check.in..month";
    private static final String CHECK_IN_DAY = "check.in.day";
    private static final String CHECK_OUT_MONTH = "check.out.month";
    private static final String CHECK_OUT_DAY = "check.out.day";

    @FindBy(xpath = "//input[@id='ss']" )
    private WebElement fieldInputDestination;

    @FindBy(xpath = "//div[@class='xp__dates xp__group']")
    private WebElement fieldInputDate;

    @FindBy(xpath = "//div[@class='bui-calendar__month']")
    private WebElement monthName;

    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    private WebElement nextMonthButton;

    @FindBy(xpath = "//div[contains(text(),'March')]/following-sibling::*//td[contains(text(),'15')]")
    private WebElement dayOfMonth;

    @FindBy(xpath = "//label[@id='xp__guests__toggle']")
    private WebElement guestsInputField;

    @FindBy(xpath = "//button[@class='sb-searchbox__button  ']")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage fillFieldDestination(){
        fieldInputDestination.click();
        fieldInputDestination.sendKeys(PropertyReader.getProperty(DESTINATION));
        pageLogger.info("fieldInputDestination.sendKeys("+PropertyReader.getProperty(DESTINATION)+")");
        return this;
    }

    public MainPage fillFieldRequiredDate(){
        fieldInputDate.click();
        findRequiredMonth(PropertyReader.getProperty(CHECK_IN_MONTH));
        setRequiredDay(PropertyReader.getProperty(CHECK_IN_MONTH),PropertyReader.getProperty(CHECK_IN_DAY));
        waiters.sleep(3000);
        findRequiredMonth(PropertyReader.getProperty(CHECK_OUT_MONTH));
        setRequiredDay(PropertyReader.getProperty(CHECK_OUT_MONTH),PropertyReader.getProperty(CHECK_OUT_DAY));
        waiters.sleep(3000);
        return this;
    }

    public HotelsPage clickSearchButton(){
        searchButton.click();
        return PageFactory.initElements(driver,HotelsPage.class);
    }

    private void findRequiredMonth(String month){
        while (!findMonth(month)){
            nextMonthButton.click();
        }
    }

    private boolean findMonth(String month){
        pageLogger.info(month);
        pageLogger.info(month.contains(monthName.getText()));
        return monthName.getText().contains(month);
    }
    private void setRequiredDay(String month, String day){
        driver.findElement(By.xpath("//div[contains(text(),'"+month+
                "')]/following-sibling::*//td[contains(text(),'"+day+"')]")).click();
    }


    public ChooseNumberOfRoomsAndGuestsPage clickOnGuestInputField (){
        guestsInputField.click();
        pageLogger.info(" guestsInputField.click()");
        return new ChooseNumberOfRoomsAndGuestsPage(driver);
    }

}
