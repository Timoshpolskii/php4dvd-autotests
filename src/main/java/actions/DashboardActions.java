package actions;

import pages.DashboardPage;
import driver.HasWaiter;

public class DashboardActions implements HasWaiter {
    private DashboardPage dashboardPage = new DashboardPage();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(dashboardPage.btnSettings);
    }

    public void pressAddButton() {
        dashboardPage.btnAdd.click();
    }

    public boolean isSettingsButtonDisplayed() {
        return dashboardPage.btnSettings.isDisplayed();
    }

    public boolean isAddButtonDisplayed() {
        return waiter(5).waitDisplayed(dashboardPage.btnAdd);
    }

    public boolean isAddButtonAbsent() {
        return waiter(5).waitAbsent(dashboardPage.btnAdd);
    }
}
