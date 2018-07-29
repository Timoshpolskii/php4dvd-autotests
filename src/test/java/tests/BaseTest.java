package tests;

import actions.DashboardActions;
import actions.LoginActions;
import actions.NavigationActions;
import driver.DriverProvider;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private LoginActions loginActions = new LoginActions();
    private DashboardActions dashboardActions = new DashboardActions();
    private NavigationActions navigationActions = new NavigationActions();
    private static Cookie currentSession;

    @BeforeSuite()
    public void setUp() {
        navigationActions.openHomePage();
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName("admin");
        loginActions.enterPassword("admin");
        loginActions.tapSubmitButton();
        dashboardActions.waitForPageToBeLoaded();

        currentSession = DriverProvider.getDriver().manage().getCookieNamed("PHPSESSID");
    }

    @BeforeMethod()
    public void setSession() {
        DriverProvider.getDriver().manage().addCookie(currentSession);
    }

    @AfterMethod
    public void deleteCookies() {
        DriverProvider.getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public void tearDown() {
        DriverProvider.getDriver().quit();
    }

    //TODO how to pass login/password in @before method???
    //TODO create screens on test fail
    //TODO add logger
    //TODO investigate cucumber
    //TODO investigate jUnit
    //TODO move usercredentials in one file
}
