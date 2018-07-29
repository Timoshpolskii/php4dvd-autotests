package actions;

import pages.MyProfilePage;
import driver.HasWaiter;
import ru.yandex.qatools.allure.annotations.Step;

public class MyProfileActions implements HasWaiter {
    private MyProfilePage myProfilePage = new MyProfilePage();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(myProfilePage.btnSave);
    }

    @Step("Get userName from UI")
    public String getUserName() {
        return myProfilePage.txtUserName.getAttribute("value");
    }
}
