package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarAccommodationPage extends BasePage {

    @FindBy(xpath = "//div[@data-calendar2-title='Check-in']//button[@aria-label='Open calendar']")
    private WebElement openCalendarFromButton;
    @FindBy(xpath = "//div[@data-calendar2-title='Check-out']//button[@aria-label='Open calendar']")
    private WebElement openCalendarToButton;
    @FindBy(xpath = "//*[@class = 'bui-calendar__control bui-calendar__control--next']")
    private WebElement buttonNext;

    public CalendarAccommodationPage(WebDriver webDriver) {
        super(webDriver);
    }

    private CalendarAccommodationPage clickOpenCalendarFrom() {
        openCalendarFromButton.click();
        return this;
    }

    private CalendarAccommodationPage clickOpenCalendarTo() {
        openCalendarToButton.click();
        return this;
    }

    private CalendarAccommodationPage chooseDate(String month, String date) {
        while (!findNecessaryMonth(month)) {
            buttonNext.click();
        }
        webDriver.findElement(By.xpath("//div[contains(text(),'" +
                month + "')]/following-sibling::table//td[contains(text(),'" + date + "')]")).click();
        return this;
    }

    public CalendarAccommodationPage fillCalendarFrom(String month, String date) {
        clickOpenCalendarFrom();
        chooseDate(month, date);
        clickOpenCalendarFrom();
        return this;
    }

    public MainPage fillCalendarTo(String month, String date) {
        clickOpenCalendarTo();
        chooseDate(month, date);
        clickOpenCalendarTo();
        return PageFactory.initElements(webDriver, MainPage.class);
    }

    private boolean findNecessaryMonth(String month) {
        return !webDriver.findElements(By.xpath("//div[contains(text(),'" + month + "')]")).isEmpty();
    }


}
