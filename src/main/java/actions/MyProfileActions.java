package actions;

import pages.MyProfilePage;
import driver.HasWaiter;

public class MyProfileActions implements HasWaiter {
    private MyProfilePage myProfilePage = new MyProfilePage();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(myProfilePage.btnSave);
    }

    public String getUserName() {
        return myProfilePage.txtUserName.getAttribute("value");
    }
}
