package tests;

import driver.SeleniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.AddFilmSteps;
import steps.DashBoardSteps;
import steps.FilmDetailsSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DashBoardTests extends BaseTest {

    private DashBoardSteps dashBoardSteps = new DashBoardSteps();
    private AddFilmSteps addFilmSteps = new AddFilmSteps();
    private FilmDetailsSteps filmDetailsSteps = new FilmDetailsSteps();

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
