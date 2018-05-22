package driver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

class CustomExpectedConditions {

    static ExpectedCondition<Boolean> elementToBeAbsent(WebElement element) {
        return driver -> {
            boolean result;
            try {
                result = !(element.isDisplayed());
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                result = true;
            }
            return result;
        };
    }

    static ExpectedCondition<Boolean> elementToBeDisplayed(WebElement element) {
        return driver -> {
            boolean result;
            try {
                result = (element.isDisplayed());
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                result = false;
            }
            return result;
        };
    }
}
