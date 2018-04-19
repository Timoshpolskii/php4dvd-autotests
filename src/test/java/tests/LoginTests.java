package tests;

import actions.DashboardActions;
import actions.LoginActions;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends BaseTest {
    private LoginActions loginActions = new LoginActions();
    private DashboardActions dashboardActions = new DashboardActions();

    @Test
    public void loginWithValidCredentials() {
        loginActions.enterUserName("admin");
        loginActions.enterPassword("admin");
        loginActions.tapSubmitButton();
        boolean isDashBoardPageLoaded = dashboardActions.waitForPageToBeLoaded();
        assertThat("Settings button should be displayed", isDashBoardPageLoaded);
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginActions.enterUserName("123");
        loginActions.enterPassword("123");
        loginActions.tapSubmitButton();
        String actualAlertText = loginActions.getTextFromLoginAlert();
        String expectedAlertText = "Incorrect user name or password";
        assertThat("Actual text from alert should match expected", actualAlertText, equalTo(expectedAlertText));
    }
}
