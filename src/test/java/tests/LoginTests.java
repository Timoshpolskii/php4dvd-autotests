package tests;

import actions.DashboardActions;
import actions.LoginActions;
import driver.SeleniumDriver;
import driver.DriverProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.UserCredentialsData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends BaseTest {

    private LoginActions loginActions = new LoginActions();
    private DashboardActions dashboardActions = new DashboardActions();

    @BeforeMethod
    public void clearCookies() {
        SeleniumDriver.getDriver().get("http://localhost/php4dvd/");
        DriverProvider.getDriver().manage().deleteAllCookies();
    }

    @Test(dataProvider = "admin_user", dataProviderClass = UserCredentialsData.class)
    public void loginWithAdminCredentials(String username, String password) {
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(username);
        loginActions.enterPassword(password);
        loginActions.tapSubmitButton();
        dashboardActions.waitForPageToBeLoaded();
        boolean isAddButtonDisplayed = dashboardActions.isAddButtonDisplayed();
        assertThat("Add button should be displayed", isAddButtonDisplayed);
    }

    @Test(dataProvider = "incorrect_user", dataProviderClass = UserCredentialsData.class)
    public void loginWithIncorrectCredentials(String username, String password) {
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(username);
        loginActions.enterPassword(password);
        loginActions.tapSubmitButton();
        String actualAlertText = loginActions.getTextFromLoginAlert();
        String expectedAlertText = "Incorrect user name or password";
        assertThat("Actual text from alert should match expected", actualAlertText, equalTo(expectedAlertText));
    }

    @Test(dataProvider = "guest_user", dataProviderClass = UserCredentialsData.class)
    public void loginWithGuestCredentials(String username, String password) {
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(username);
        loginActions.enterPassword(password);
        loginActions.tapSubmitButton();
        dashboardActions.waitForPageToBeLoaded();
        boolean isAddButtonAbsent = dashboardActions.isAddButtonAbsent();
        assertThat("Add button should NOT be displayed", isAddButtonAbsent);
    }

}
