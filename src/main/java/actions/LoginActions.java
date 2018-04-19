package actions;

import pages.DashboardPage;
import pages.LoginPage;
import utils.HasWaiter;

public class LoginActions implements HasWaiter {
    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();

    public void enterUserName(String userName) {
        loginPage.fldUserName.sendKeys(userName);
    }

    public void enterPassword(String password) {
        loginPage.fldPassword.sendKeys(password);
    }

    public void tapSubmitButton() {
        loginPage.btnSubmit.click();
    }

    public String getTextFromLoginAlert() {
        return waiter(15).getText(loginPage.txtLoginAlert);
    }
}
