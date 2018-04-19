package pages;

import org.openqa.selenium.support.PageFactory;

import static driver.SeleniumDriver.getDriver;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }
}
