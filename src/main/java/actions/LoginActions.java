package actions;

import helper.HasWaiter;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginActions implements HasWaiter {
    private LoginPage loginPage = new LoginPage();

    @Step("Enter username [{0}]")
    public void enterUserName(String userName) {
        loginPage.fldUserName.sendKeys(userName);
    }

    @Step("Enter password [{0}]")
    public void enterPassword(String password) {
        loginPage.fldPassword.sendKeys(password);
    }

    @Step("Tap submit button")
    public void tapSubmitButton() {
        loginPage.btnSubmit.click();
    }

    @Step("Get text from login alert")
    public String getTextFromLoginAlert() {
        return waiter(15).getText(loginPage.txtLoginAlert);
    }

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(loginPage.fldUserName);
    }
}
