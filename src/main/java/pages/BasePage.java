package pages;

import org.openqa.selenium.support.PageFactory;

import static driver.DriverProvider.getDriver;

class BasePage {
    BasePage() {
        PageFactory.initElements(getDriver(), this);
    }
}
