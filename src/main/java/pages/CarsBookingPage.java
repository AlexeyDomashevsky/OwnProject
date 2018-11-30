package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarsBookingPage extends BasePage {

    public CarsBookingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isCarTypeButtonAvailable(String carType) {
        return !webDriver.findElements(By.xpath("//span[contains(text(),'" + carType + "')]")).isEmpty();
    }

    public void waitForRequiredTitle() {
        waiters.waitForTitle("Car hire");
    }
}
