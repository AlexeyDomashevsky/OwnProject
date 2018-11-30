package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Waiters {

    private static final int WAIT_TIME = 10;
    private WebDriver driver;

    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void waitForDisplayed(final WebElement element) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return element.isDisplayed();
                    }
                };
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for element to be Displayed.");
        }
    }

    public WebElement waitForElementPresent(final By locator) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return !driver.findElements(locator).isEmpty();
                    }
                };
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for element to be Present.");
        }
        return driver.findElement(locator);
    }

    public void waitForTitle(final String expectedTitle) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return driver.getTitle().startsWith(expectedTitle);
                    }
                };
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for title contains " + expectedTitle);
        }
    }

    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void sleep() {
        sleep(3000);
    }
}
