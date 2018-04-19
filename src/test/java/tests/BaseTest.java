package tests;

import driver.SeleniumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        SeleniumDriver.getDriver().get("http://localhost/php4dvd/");
    }

    @AfterMethod
    public void deleteCookies() {
        SeleniumDriver.getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public void tearDown() {
        SeleniumDriver.getDriver().quit();
    }
}
