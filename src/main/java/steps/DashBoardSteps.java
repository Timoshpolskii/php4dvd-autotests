package steps;

import actions.AddFilmActions;
import actions.DashboardActions;

public class DashBoardSteps {
    private DashboardActions dashboardActions = new DashboardActions();
    private AddFilmActions addFilmActions = new AddFilmActions();

    public boolean isSettingsButtonDisplayed() {
        return dashboardActions.isSettingsButtonDisplayed();
    }

    public void pressAddButton() {
        dashboardActions.pressAddButton();
        addFilmActions.waitForPageToBeLoaded();
    }
}
