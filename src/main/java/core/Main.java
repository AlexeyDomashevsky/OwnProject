package core;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Main {
    public static final Logger log =  LogManager.getLogger(Main.class);
    public static void main(String[] args) {
//        WebDriver driver = DriverSingleton.DRIVER_INSTANCE.getDriver();
//        driver.get("https://www.google.com/");
        log.debug("go to https://www.google.com/");
        log.warn("go to https://www.google.com/");
        log.error("Error Message Logged !!!", new NullPointerException("NullError"));

//        driver.close();
//        driver.quit();
    }
}
