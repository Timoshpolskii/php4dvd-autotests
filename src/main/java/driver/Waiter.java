package driver;

import helper.HasLogger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverProvider.getDriver;

public class Waiter implements HasLogger {
    private long duration;
    private WebDriverWait wait = new WebDriverWait(getDriver(), duration);
    private Logger log = getLogger();

    public Waiter(long duration) {
        this.duration = duration;
    }

    public Waiter() {
        this.duration = 0;
    }

    public void sendKeys(WebElement element, String text) {
        //TODO use these methods for all actions
        wait.until(CustomExpectedConditions.elementToBeDisplayed(element));
        element.sendKeys(text);
        log.debug("Send text [" + text + "] to element with locator" + getLocatorFromElement(element));
    }

    public void sendKeys(By by, WebElement parentElement, String text) {
        wait.until(CustomExpectedConditions.elementToBeDisplayed(parentElement));
        parentElement.findElement(by).sendKeys(text);
        log.debug("Send text [" + text + "] to element with locator [" + by.toString()
                + "] and parent element " + getLocatorFromElement(parentElement));
    }

    public void click(WebElement element) {
        wait.until(CustomExpectedConditions.elementToBeDisplayed(element));
        element.click();
        log.debug("Click element with locator " + getLocatorFromElement(element));
    }

    public void click(By by, WebElement parentElement) {
        wait.until(CustomExpectedConditions.elementToBeDisplayed(parentElement));
        parentElement.findElement(by).click();
        log.debug("Click element with locator [" + by.toString()
                + "] and parent element " + getLocatorFromElement(parentElement));
    }

    public boolean waitDisplayed(WebElement element) {
        try {
            log.debug("Wait for element with locator " + getLocatorFromElement(element) + " to be displayed");
            return wait.until(CustomExpectedConditions.elementToBeDisplayed(element));
        }
        catch (TimeoutException ignored) {
            log.info("Failed to wait for element to be displayed" + getLocatorFromElement(element));
            return false;
        }
    }

    public boolean waitAbsent(WebElement element) {
        //TODO investigate driver implicit wait = 0 so tests will be fast
        try {
            log.debug("Wait for element with locator " + getLocatorFromElement(element) + " to be absent");
            return wait.until(CustomExpectedConditions.elementToBeAbsent(element));
        }
        catch (TimeoutException e) {
            log.info("Failed to wait for element to be absent " + getLocatorFromElement(element));
            return false;
        }

    }

    public String getText(WebElement element) {
        try {
            wait.until(CustomExpectedConditions.elementToBeDisplayed(element));
            log.debug("Get text from element with locator:" + getLocatorFromElement(element));
            return element.getText();

        }
        catch (TimeoutException e) {
            log.info("Not able to get text from element with locator:" + getLocatorFromElement(element));
            return null;
        }
    }

    public String getText(By by, WebElement parentElement) {
        try {
            wait.until(CustomExpectedConditions.elementToBeDisplayed(parentElement));
            log.debug("Get text from element with locator [" + by.toString()
                    + "] and parent element " + getLocatorFromElement(parentElement));
            return parentElement.findElement(by).getText();
        }
        catch (TimeoutException e) {
            log.info("Not able to get text from element with locator ["
                    + by.toString() + "] and parent element " + getLocatorFromElement(parentElement));
            return null;
        }
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        log.info("Accept browser alert");
    }

    private String getLocatorFromElement(WebElement element) {
        // There are two types of element.toString() :
        // 1)If element not exists, value starts with : 'Proxy element for'
        // 2)If not: 'ChromeDriver: chrome on MAC'
        String stringValueOfElement = element.toString();
        if (stringValueOfElement.contains("Proxy element for")) {
            return stringValueOfElement.replace("Proxy element for: DefaultElementLocator", "");
        }
        else {
            int indexOfSeparator = stringValueOfElement.indexOf("->");
            return stringValueOfElement.substring(indexOfSeparator, element.toString().length() - 1);
        }
    }
}
