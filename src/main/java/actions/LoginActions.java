package actions;

import pages.LoginPage;
import driver.HasWaiter;

public class LoginActions implements HasWaiter {
    private LoginPage loginPage = new LoginPage();

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

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(loginPage.fldUserName);
    }
}
