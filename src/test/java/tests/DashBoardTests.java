package tests;

import actions.AddFilmActions;
import actions.DashboardActions;
import actions.FilmDetailsActions;
import actions.NavigationActions;
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
    private NavigationActions navigationActions = new NavigationActions();

    @BeforeMethod
    public void openHomeScreen() {
        navigationActions.openHomePage();
    }

    @Test
    public void checkInfoOfNewAddedFilm() {
        //TODO save film info in FILM object
        String expectedFilmName = "New Film Title1";
        int expectedFilmYear = 1991;
        String expectedFilmLanguage = "English1";
        String expectedFilmPersonalNotes = "Film personal notes1";

        dashboardActions.pressAddButton();
        addFilmActions.waitForPageToBeLoaded();
        addFilmActions.addNameOfFilm(expectedFilmName);
        addFilmActions.addYearOfFilm(expectedFilmYear);
        addFilmActions.addPersonalNotesOfFilm(expectedFilmPersonalNotes);
        addFilmActions.addLanguageOfFilm(expectedFilmLanguage);
        addFilmActions.saveFilm();

        Map<String, String> expectedFilmInfo = new HashMap<>();
        expectedFilmInfo.put("title", expectedFilmName + " (" + expectedFilmYear + ")");
        expectedFilmInfo.put("language", "Languages: " + expectedFilmLanguage);
        expectedFilmInfo.put("personal notes", expectedFilmPersonalNotes);

        Map<String, String> actualFilmInfo = new HashMap<>();
        actualFilmInfo.put("title", filmDetailsActions.getFilmTitle());
        actualFilmInfo.put("language", filmDetailsActions.getFilmLanguage());
        actualFilmInfo.put("personal notes", filmDetailsActions.getFilmPersonalNotes());
        
        AssertHelper.getDifference(actualFilmInfo, expectedFilmInfo);
    }

    @AfterClass
    public void deleteTestData() {
        //TODO implement this logic
    }
}
