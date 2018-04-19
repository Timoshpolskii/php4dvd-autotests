package tests;

import actions.AddFilmActions;
import actions.DashboardActions;
import actions.LoginActions;
import driver.SeleniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashBoardTests extends BaseTest {

    private DashboardActions dashboardActions = new DashboardActions();
    private AddFilmActions addFilmActions = new AddFilmActions();
    private LoginActions loginActions = new LoginActions();

    @BeforeClass
    public void loginWithValidCredentials() {
        //TODO refactor this part
        SeleniumDriver.getDriver().get("http://localhost/php4dvd/");
        loginActions.enterUserName("admin");
        loginActions.enterPassword("admin");
        loginActions.tapSubmitButton();
        dashboardActions.waitForPageToBeLoaded();
    }

    @Test
    public void checkNameOfNewAddedFilm() {
        //TODO save film info in FILM object
        String filmTitle = "New Film Title";
        String filmYear = "1990";

        dashboardActions.pressAddButton();
        addFilmActions.waitForPageToBeLoaded();
        addFilmActions.addTitleOfFilm(filmTitle);
        addFilmActions.addYearOfFilm(filmYear);
        addFilmActions.saveFilm();
    }

    @AfterClass
    public void deleteTestData() {
        //TODO implement this logic
    }
}
