package tests;

import actions.DashboardActions;
import actions.LoginActions;
import actions.NavigationActions;
import driver.DataBase.DatabaseConnectionProvider;
import driver.DriverProvider;
import helper.HasLogger;
import helper.PropertiesReader;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.SQLException;

public class BaseTest implements HasLogger {
    private LoginActions loginActions = new LoginActions();
    private DashboardActions dashboardActions = new DashboardActions();
    private NavigationActions navigationActions = new NavigationActions();
    private Logger log = getLogger();

    @BeforeSuite()
    public void loginWithAdminCredentials() {
        String USER_CREDENTIALS_FILEPATH = "/src/test/resources/fixtures/user_credentials.properties";
        String adminUserName = PropertiesReader.readPropertyFromFile(USER_CREDENTIALS_FILEPATH, "admin_username");
        String adminUserPassword = PropertiesReader.readPropertyFromFile(USER_CREDENTIALS_FILEPATH, "admin_password");

        log.info("Login to app with admin user to save current session in browser");
        navigationActions.openHomePage();
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(adminUserName);
        loginActions.enterPassword(adminUserPassword);
        loginActions.tapSubmitButton();
        dashboardActions.waitForPageToBeLoaded();
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        DriverProvider.quitDriver();
        DatabaseConnectionProvider.closeConnection();
    }

    //TODO investigate cucumber
    //TODO investigate jUnit
}
