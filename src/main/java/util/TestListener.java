package util;


import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    Logger logger = LogManager.getLogger(TestListener.class);

    private long time = System.currentTimeMillis();
    private static final String FILE_PATH = ".//test-output/screenshots/screenshot";
    private static final String FILE_VIEW_PATH = "screenshots/screenshot";
    private static final String FILE_EXT = ".png";

    public void onTestStart(ITestResult result) {
        result.getName();
    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getTestName() + " failure" + takeScreenShot());
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

    private String takeScreenShot(){
        WebDriver driver = DriverSingleton.DRIVER_INSTANCE.getDriver();
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot,new File(FILE_PATH+time+FILE_EXT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FILE_VIEW_PATH+time+FILE_EXT;
    }
}
