package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import services.PropertyReader;

public enum DriverSingleton {
//will solve the problem  about driver's system path
    DRIVER_INSTANCE;

    private WebDriver driver ;

    public WebDriver getDriver(){
        if (driver == null){
            String driverType = PropertyReader.getProperty("driver.type");
            driver = getDriverType(driverType);
            return driver;
        }else return driver;
    }

    private WebDriver getDriverType (String driverType){
        switch (driverType){
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default: return  new ChromeDriver();
        }
    }

    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
