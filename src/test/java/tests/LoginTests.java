package tests;

import actions.DashboardActions;
import actions.LoginActions;
import actions.NavigationActions;
import driver.DriverProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.UserCredentialsDataProvider;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends BaseTest {

    private LoginActions loginActions = new LoginActions();
    private DashboardActions dashboardActions = new DashboardActions();
    private NavigationActions navigationActions = new NavigationActions();

    @BeforeMethod
    public void logoutAndOpenHomePage() {
        //App is logged in with admin user from BeforeSuite method. We need to logout to run this test class
        DriverProvider.getDriver().manage().deleteAllCookies();
        navigationActions.openHomePage();
    }

    @Test(dataProvider = "admin_user", dataProviderClass = UserCredentialsDataProvider.class)
    public void loginWithAdminCredentials(String username, String password) {
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(username);
        loginActions.enterPassword(password);
        loginActions.tapSubmitButton();
        dashboardActions.waitForPageToBeLoaded();
        boolean isAddButtonDisplayed = dashboardActions.isAddButtonDisplayed();
        assertThat("Add button should be displayed", isAddButtonDisplayed);
    }

    @Test(dataProvider = "incorrect_user", dataProviderClass = UserCredentialsDataProvider.class)
    public void loginWithIncorrectCredentials(String username, String password) {
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(username);
        loginActions.enterPassword(password);
        loginActions.tapSubmitButton();
        String actualAlertText = loginActions.getTextFromLoginAlert();
        String expectedAlertText = "Incorrect user name or password";
        assertThat("Actual text from alert should match expected", actualAlertText, equalTo(expectedAlertText));
    }

    @Test(dataProvider = "guest_user", dataProviderClass = UserCredentialsDataProvider.class)
    public void loginWithGuestCredentials(String username, String password) {
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(username);
        loginActions.enterPassword(password);
        loginActions.tapSubmitButton();
        dashboardActions.waitForPageToBeLoaded();
        boolean isAddButtonAbsent = dashboardActions.isAddButtonAbsent();
        assertThat("Add button should NOT be displayed", isAddButtonAbsent);
    }

    @AfterClass
    public void loginAsAdminCredentials() {
        //After all tests complete running, we need to login to app from BeforeSuite method
        DriverProvider.getDriver().manage().deleteAllCookies();
        super.loginWithAdminCredentials();
    }
}
