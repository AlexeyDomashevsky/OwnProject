package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarFlightPage extends BasePage {

    @FindBy(xpath = "//div[@class='col-day highlighted flex selected startDate']/div")
    private WebElement startDate;

    @FindBy(xpath = "//div[@class='col-day highlighted flex selected endDate']/div")
    private WebElement endDate;

    @FindBy(xpath = "//div[@class='col-day highlighted flex selected endDate']" +
            "//ancestor::div[@class='month']/div[@class='monthDisplay']")
    private WebElement monthForEndDate;

    @FindBy(xpath = "//div[@class='col-day highlighted flex selected startDate']" +
            "//ancestor::div[@class='month']/div[@class='monthDisplay']")
    private WebElement monthForStartDay;

    public CalendarFlightPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getExistingDate() {
        String date = parse(monthForStartDay.getText());
        date += startDate.getText();
        date += SPACE;
        date += parse(monthForEndDate.getText());
        date += endDate.getText();
        return date;

    }

    private String parse(String string) {
        return string.split("\\s")[0] + " ";
    }
}
