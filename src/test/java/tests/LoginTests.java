package tests;

import driver.SeleniumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.DashBoardSteps;
import steps.LoginSteps;
import testData.UserCredentialsData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends BaseTest {
    private LoginSteps loginSteps = new LoginSteps();
    private DashBoardSteps dashBoardSteps = new DashBoardSteps();

    @BeforeMethod
    public void clearCookies() {
        SeleniumDriver.getDriver().manage().deleteAllCookies();
        SeleniumDriver.getDriver().get("http://localhost/php4dvd/");
    }

    @Test(dataProvider = "admin_user", dataProviderClass = UserCredentialsData.class)
    public void loginWithValidCredentials(String username, String password) {
        loginSteps.loginWithValidCredentials(username, password);
        boolean isSettingsButtonDisplayed = dashBoardSteps.isSettingsButtonDisplayed();
        assertThat("Settings button should be displayed", isSettingsButtonDisplayed);
    }

    @Test
    public void loginWithInvalidCredentials() {
        //TODO add invalid user creds
        loginSteps.loginWithInvalidCredentials("123", "123");
        String actualAlertText = loginSteps.getTextFromLoginAlert();
        String expectedAlertText = "Incorrect user name or password";
        assertThat("Actual text from alert should match expected", actualAlertText, equalTo(expectedAlertText));
    }

    //TODO: Add login with guest user
}
