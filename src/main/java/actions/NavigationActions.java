package actions;

import driver.DriverProvider;
import pages.NavigationURLs;
import ru.yandex.qatools.allure.annotations.Step;

public class NavigationActions {
    private NavigationURLs navigationURLs = new NavigationURLs();

    @Step("Open 'Home' page")
    public void openHomePage() {
        DriverProvider.getDriver().get(navigationURLs.baseURL);
    }

    @Step("Open 'My Profile' page")
    public void openMyProfilePage() {
        DriverProvider.getDriver().get(navigationURLs.myProfileURL);
    }
}
