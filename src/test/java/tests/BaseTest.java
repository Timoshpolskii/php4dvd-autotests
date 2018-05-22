package tests;

import actions.DashboardActions;
import actions.LoginActions;
import driver.SeleniumDriver;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private LoginActions loginActions = new LoginActions();
    private DashboardActions dashboardActions = new DashboardActions();
    private static Cookie currentSession;

    @BeforeSuite()
    public void setUp() {
        SeleniumDriver.getDriver().get("http://localhost/php4dvd/");

        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName("admin");
        loginActions.enterPassword("admin");
        loginActions.tapSubmitButton();
        dashboardActions.waitForPageToBeLoaded();

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

    //TODO how to pass login/password in @before method???
    //TODO add allure
    //TODO create screens on test fail
    //TODO add logger
    //TODO investigate cucumber
    //TODO investigate jUnit
    //TODO move usercredentials in one file
}
