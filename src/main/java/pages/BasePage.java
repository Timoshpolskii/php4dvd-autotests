package pages;

import org.openqa.selenium.support.PageFactory;

import static driver.SeleniumDriver.getDriver;

class BasePage {
    BasePage() {
        PageFactory.initElements(getDriver(), this);
    }
}
