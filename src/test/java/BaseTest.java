import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.BaseStep;

public class BaseTest {
    protected WebDriver driver;
    public static final Logger testLogger = LogManager.getLogger(BaseTest.class);

    public BaseTest() {
        driver = DriverSingleton.DRIVER_INSTANCE.getDriver();
    }

    @BeforeTest
    public void initStep(){
        testLogger.info("webDriver initialized");
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver(){
        driver.close();
        driver.quit();
        testLogger.info("driver closed");
    }


}
