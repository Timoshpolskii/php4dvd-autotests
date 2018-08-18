package actions;

import helper.HasWaiter;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class DashboardActions implements HasWaiter {
    private DashboardPage dashboardPage = new DashboardPage();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(dashboardPage.btnSettings);
    }

    @Step("Press add button")
    public void pressAddButton() {
        waiter().click(dashboardPage.btnAdd);
    }

    public boolean isSettingsButtonDisplayed() {
        return waiter().waitDisplayed(dashboardPage.btnSettings);
    }

    public boolean isAddButtonDisplayed() {
        return waiter(5).waitDisplayed(dashboardPage.btnAdd);
    }

    public boolean isAddButtonAbsent() {
        return waiter(2).waitAbsent(dashboardPage.btnAdd);
    }

    public WebElement getMovieContainerByMovieName(String name) {
        for (WebElement movieContainer : dashboardPage.movieContainers) {
            if (getMovieNameFromMovieContainer(movieContainer).equals(name)) {
                return movieContainer;
            }
        }
        return null;
    }

    public String getMovieNameFromMovieContainer(WebElement movieContainer) {
        return waiter().getText(dashboardPage.txtMovieName, movieContainer);
    }

    public void openMovieDetailsByMovieName(String name) {
        WebElement movieContainer = getMovieContainerByMovieName(name);
        assertThat("Movie with name [" + name + "] should be found to proceed", movieContainer, notNullValue());
        waiter().click(dashboardPage.movieImage, movieContainer);
    }
}
