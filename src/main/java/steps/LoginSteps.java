package steps;

import actions.DashboardActions;
import actions.LoginActions;

public class LoginSteps {
    private LoginActions loginActions = new LoginActions();
    private DashboardActions dashboardActions = new DashboardActions();

    public void loginWithValidCredentials(String userName, String password) {
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(userName);
        loginActions.enterPassword(password);
        loginActions.tapSubmitButton();
        dashboardActions.waitForPageToBeLoaded();
    }

    public void loginWithIncorrectCredentials(String userName, String password) {
        //The difference from loginWithValidCredentials() is that user stays on login page.
        //User is not navigation on dashboard
        loginActions.waitForPageToBeLoaded();
        loginActions.enterUserName(userName);
        loginActions.enterPassword(password);
        loginActions.tapSubmitButton();
    }

    public String getTextFromLoginAlert() {
        return loginActions.getTextFromLoginAlert();
    }
}
