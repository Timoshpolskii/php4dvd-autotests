package tests;

import driver.SeleniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.AddFilmSteps;
import steps.DashBoardSteps;
import steps.FilmDetailsSteps;
import steps.LoginSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DashBoardTests extends BaseTest {

    private LoginSteps loginSteps = new LoginSteps();
    private DashBoardSteps dashBoardSteps = new DashBoardSteps();
    private AddFilmSteps addFilmSteps = new AddFilmSteps();
    private FilmDetailsSteps filmDetailsSteps = new FilmDetailsSteps();

    @BeforeClass
    public void loginWithValidCredentials() {
        //TODO refactor this part
        SeleniumDriver.getDriver().get("http://localhost/php4dvd/");
        loginSteps.loginWithValidCredentials("admin", "admin");
    }

    @Test
    public void checkInfoOfNewAddedFilm() {
        //TODO save film info in FILM object
        String expectedFilmName = "New Film Title";
        String expectedFilmYear = "1990";
        String expectedFilmLanguage = "English";
        String expectedFilmPersonalNotes = "Film personal notes";

        dashBoardSteps.pressAddButton();
        addFilmSteps.addTitleOfFilm(expectedFilmName);
        addFilmSteps.addYearOfFilm(expectedFilmYear);
        addFilmSteps.addPersonalNotesOfFilm(expectedFilmPersonalNotes);
        addFilmSteps.addLanguageOfFilm(expectedFilmLanguage);
        addFilmSteps.saveFilm();

        //TODO create assertion for multiple values
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
