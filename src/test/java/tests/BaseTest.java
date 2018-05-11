package tests;

import driver.SeleniumDriver;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import steps.LoginSteps;

public class BaseTest {
    private LoginSteps loginSteps = new LoginSteps();
    private static Cookie currentSession;

    @BeforeSuite()
    public void setUp() {
        SeleniumDriver.getDriver().get("http://localhost/php4dvd/");
        loginSteps.loginWithValidCredentials("admin", "admin");
        currentSession = SeleniumDriver.getDriver().manage().getCookieNamed("PHPSESSID");
    }

    @BeforeMethod()
    public void setSession() {
        SeleniumDriver.getDriver().manage().addCookie(currentSession);
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
