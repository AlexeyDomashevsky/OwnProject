package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import services.PropertyReader;

public enum DriverSingleton {

    DRIVER_INSTANCE;

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            String driverType = PropertyReader.getProperty("driver.type");
            driver = getDriverType(driverType);
            return driver;
        }
        return driver;
    }

    private WebDriver getDriverType(String driverType) {
        switch (driverType){
            case "chrome" :
                return new ChromeDriver();
            default: return new ChromeDriver();
        }
    }
}
