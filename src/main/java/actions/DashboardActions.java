package actions;

import pages.AddFilmPage;
import pages.DashboardPage;
import utils.HasWaiter;

public class DashboardActions implements HasWaiter {
    private DashboardPage dashboardPage = new DashboardPage();
    private AddFilmPage addFilmPage = new AddFilmPage();

    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(dashboardPage.btnSettings);
    }

    public void pressAddButton() {
        dashboardPage.btnAdd.click();
    }
}
