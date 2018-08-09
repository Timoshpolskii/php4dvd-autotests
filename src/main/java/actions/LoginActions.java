package actions;

import helper.HasWaiter;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginActions implements HasWaiter {
    private LoginPage loginPage = new LoginPage();

    @Step("Enter username [{0}]")
    public void enterUserName(String userName) {
        waiter().sendKeys(loginPage.fldUserName, userName);
    }

    @Step("Enter password [{0}]")
    public void enterPassword(String password) {
        waiter().sendKeys(loginPage.fldPassword, password);
    }

    @Step("Tap submit button")
    public void tapSubmitButton() {
        waiter().click(loginPage.btnSubmit);
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
