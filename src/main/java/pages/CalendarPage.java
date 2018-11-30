package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "//div[@data-calendar2-title='Check-in']//button[@aria-label='Open calendar']")
    private WebElement openCalendarFromButton;
    @FindBy(xpath = "//div[@data-calendar2-title='Check-out']//button[@aria-label='Open calendar']")
    private WebElement openCalendarToButton;
    @FindBy(xpath = "//*[@class = 'bui-calendar__control bui-calendar__control--next']")
    private WebElement buttonNext;

    public CalendarPage(WebDriver webDriver) {
        super(webDriver);
    }

    private CalendarPage clickOpenCalendarFrom() {
        openCalendarFromButton.click();
        return this;
    }

    private CalendarPage clickOpenCalendarTo() {
        openCalendarToButton.click();
        return this;
    }

    private CalendarPage chooseDate(String month, String date) {
        while (!findNecessaryMonth(month)) {
            buttonNext.click();
        }
        webDriver.findElement(By.xpath("//div[contains(text(),'" +
                month + "')]/following-sibling::table//td[contains(text(),'" + date + "')]")).click();
        return this;
    }

    public CalendarPage fillCalendarFrom(String month, String date) {
        clickOpenCalendarFrom();
        chooseDate(month, date);
        clickOpenCalendarFrom();
        return this;
    }

    public CalendarPage fillCalendarTo(String month, String date) {
        clickOpenCalendarTo();
        chooseDate(month, date);
        clickOpenCalendarTo();
        return this;
    }

    private boolean findNecessaryMonth(String month) {
        return !webDriver.findElements(By.xpath("//div[contains(text(),'" + month + "')]")).isEmpty();
    }
}
