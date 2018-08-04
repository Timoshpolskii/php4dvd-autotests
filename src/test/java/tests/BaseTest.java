package tests;

import actions.DashboardActions;
import actions.LoginActions;
import actions.NavigationActions;
import driver.DataBase.DatabaseConnectionProvider;
import driver.DriverProvider;
import helper.PropertiesReader;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.sql.SQLException;

public class BaseTest {
    private LoginActions loginActions = new LoginActions();
    private DashboardActions dashboardActions = new DashboardActions();
    private NavigationActions navigationActions = new NavigationActions();
    private static Cookie currentSession;

    @BeforeSuite()
    public void setUp() {
        String USER_CREDENTIALS_FILEPATH = "/src/test/resources/fixtures/user_credentials.properties";
        String adminUserName = PropertiesReader.readPropertyFromFile(USER_CREDENTIALS_FILEPATH, "admin_username");
        String adminUserPassword = PropertiesReader.readPropertyFromFile(USER_CREDENTIALS_FILEPATH, "admin_password");

        navigationActions.openHomePage();
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(adminUserName);
        loginActions.enterPassword(adminUserPassword);
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
    public void tearDown() throws SQLException {
        DriverProvider.getDriver().quit();
        DatabaseConnectionProvider.getConnection().close();
    }

    //TODO add logger
    //TODO investigate cucumber
    //TODO investigate jUnit
}
