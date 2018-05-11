package tests;

import actions.AddFilmActions;
import actions.DashboardActions;
import actions.FilmDetailsActions;
import driver.SeleniumDriver;
import helper.AssertHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DashBoardTests extends BaseTest {

    private DashboardActions dashboardActions = new DashboardActions();
    private AddFilmActions addFilmActions = new AddFilmActions();
    private FilmDetailsActions filmDetailsActions = new FilmDetailsActions();

    @BeforeMethod
    public void openPage() {
        SeleniumDriver.getDriver().get("http://localhost/php4dvd/");
    }

    @Test
    public void checkInfoOfNewAddedFilm() {
        //TODO save film info in FILM object
        String expectedFilmName = "New Film Title1";
        int expectedFilmYear = 1991;
        String expectedFilmLanguage = "English1";
        String expectedFilmPersonalNotes = "Film personal notes1";

        dashBoardSteps.pressAddButton();
        addFilmSteps.addNameOfFilm(expectedFilmName);
        addFilmSteps.addYearOfFilm(expectedFilmYear);
        addFilmSteps.addPersonalNotesOfFilm(expectedFilmPersonalNotes);
        addFilmSteps.addLanguageOfFilm(expectedFilmLanguage);
        addFilmSteps.saveFilm();

        String expectedFilmTitle = expectedFilmName + " (" + expectedFilmYear + ")";
        String actualFilmTitle = filmDetailsSteps.getFilmTitle();
        assertThat("Actual name of film should be matched with expected",
                actualFilmTitle, equalTo(expectedFilmTitle));

        String actualFilmLanguage = filmDetailsSteps.getFilmLanguage();
        assertThat("Actual language of film should be matched with expected",
                actualFilmLanguage, equalTo("Languages: " + expectedFilmLanguage));

        String actualFilmPersonalNotes = filmDetailsSteps.getFilmPersonalNotes();
        assertThat("Actual personal notes of film should be matched with expected",
                actualFilmPersonalNotes, equalTo(expectedFilmPersonalNotes));
    }

    @AfterClass
    public void deleteTestData() {
        //TODO implement this logic
    }
}
