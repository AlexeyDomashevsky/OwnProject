package steps;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import services.PropertyReader;

public class BaseStep {

    protected WebDriver driver;
    public static final  Logger stepLogger = LogManager.getLogger(BaseStep.class);

    public static final String PAGE_URL = "page.url";

    public BaseStep(WebDriver driver) {
        this.driver = driver;
    }

    public void initBrowser(){
        driver.get(PropertyReader.getProperty(PAGE_URL));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stepLogger.info("connect to "+PropertyReader.getProperty(PAGE_URL));
    }

    public void closeBrowser(){

    }
}
