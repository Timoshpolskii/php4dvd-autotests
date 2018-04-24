package tests;

import org.testng.annotations.Test;
import steps.DashBoardSteps;
import steps.LoginSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends BaseTest {
    private LoginSteps loginSteps = new LoginSteps();
    private DashBoardSteps dashBoardSteps = new DashBoardSteps();

    @Test
    public void loginWithValidCredentials() {
        //TODO create userCredentials object
        loginSteps.loginWithValidCredentials("admin", "admin");
        boolean isSettingsButtonDisplayed = dashBoardSteps.isSettingsButtonDisplayed();
        assertThat("Settings button should be displayed", isSettingsButtonDisplayed);
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginSteps.loginWithInvalidCredentials("123", "123");
        String actualAlertText = loginSteps.getTextFromLoginAlert();
        String expectedAlertText = "Incorrect user name or password";
        assertThat("Actual text from alert should match expected", actualAlertText, equalTo(expectedAlertText));
    }
}
