package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverProvider.getDriver;

public class Waiter {
    private long duration;
    private WebDriverWait wait = new WebDriverWait(getDriver(), duration);

    Waiter(long duration) {
        this.duration = duration;
    }

    Waiter() {
        this.duration = 0;
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(CustomExpectedConditions.elementToBeDisplayed(element));
        element.sendKeys(text);
    }

    public void sendKeys(By by, WebElement parentElement, String text) {
        wait.until(CustomExpectedConditions.elementToBeDisplayed(parentElement));
        parentElement.findElement(by).sendKeys(text);
    }

    public void click(WebElement element) {
        wait.until(CustomExpectedConditions.elementToBeDisplayed(element));
        element.click();
    }

    public void click(By by, WebElement parentElement) {
        wait.until(CustomExpectedConditions.elementToBeDisplayed(parentElement));
        parentElement.findElement(by).click();
    }

    public boolean waitDisplayed(WebElement element) {
        try {
            return wait.until(CustomExpectedConditions.elementToBeDisplayed(element));
        }
        catch (TimeoutException ignored) {
            return false;
        }
    }

    public boolean waitAbsent(WebElement element) {
        //TODO investigate driver implicit wait = 0 so tests will be fast
        try {
            return wait.until(CustomExpectedConditions.elementToBeAbsent(element));
        }
        catch (TimeoutException e) {
            return false;
        }

    }

    public String getText(WebElement element) {
        try {
            wait.until(CustomExpectedConditions.elementToBeDisplayed(element));
            return element.getText();
        }
        catch (TimeoutException e) {
            return null;
        }
    }

    public String getText(By by, WebElement parentElement) {
        try {
            wait.until(CustomExpectedConditions.elementToBeDisplayed(parentElement));
            return parentElement.findElement(by).getText();
        }
        catch (TimeoutException e) {
            return null;
        }
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
}
