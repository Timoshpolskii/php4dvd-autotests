package actions;

import driver.DriverProvider;
import helper.PropertiesReader;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Properties;

public class NavigationActions {
    private String NAVIGATION_URLS_FILEPATH = "/src/main/resources/navigation_URLs.properties";
    private Properties properties = PropertiesReader.readFromFile(NAVIGATION_URLS_FILEPATH);

    private String BASE_URL = properties.getProperty("base_URL");
    private String MY_PROFILE_URL = BASE_URL + properties.getProperty("my_profile_URL");

    @Step("Open 'Home' page")
    public void openHomePage() {
        DriverProvider.getDriver().get(BASE_URL);
    }

    @Step("Open 'My Profile' page")
    public void openMyProfilePage() {
        DriverProvider.getDriver().get(MY_PROFILE_URL);
    }
}
