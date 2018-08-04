package tests;

import actions.AddMovieActions;
import actions.DashboardActions;
import actions.MovieDetailsActions;
import actions.NavigationActions;
import actions.databaseActions.MovieDBActions;
import helper.AssertHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.MovieInfoDataProvider;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.empty;

public class DashBoardTests extends BaseTest {

    private DashboardActions dashboardActions = new DashboardActions();
    private AddMovieActions addMovieActions = new AddMovieActions();
    private MovieDetailsActions movieDetailsActions = new MovieDetailsActions();
    private NavigationActions navigationActions = new NavigationActions();
    private MovieDBActions movieDBActions = new MovieDBActions();

    private List<String> testMovieNames = new ArrayList<>();

    @BeforeMethod
    public void openHomeScreen() {
        navigationActions.openHomePage();
    }

    @Test(dataProvider = "correct_movie", dataProviderClass = MovieInfoDataProvider.class)
    public void checkInfoOfNewAddedMovie(Properties properties) {
        String expectedMovieName = getUniqueNameOfMovie();
        int expectedMovieYear = Integer.valueOf(properties.getProperty("year"));
        String expectedMovieLanguage = properties.getProperty("language");
        String expectedMoviePersonalNotes = properties.getProperty("personal_notes");

        dashboardActions.pressAddButton();
        addMovieActions.waitForPageToBeLoaded();
        addMovieActions.addNameOfMovie(expectedMovieName);
        addMovieActions.addYearOfMovie(expectedMovieYear);
        addMovieActions.addPersonalNotesOfMovie(expectedMoviePersonalNotes);
        addMovieActions.addLanguageOfMovie(expectedMovieLanguage);
        addMovieActions.saveMovie();

        Map<String, String> expectedMovieInfo = new HashMap<>();
        expectedMovieInfo.put("title", expectedMovieName + " (" + expectedMovieYear + ")");
        expectedMovieInfo.put("language", "Languages: " + expectedMovieLanguage);
        expectedMovieInfo.put("personal notes", expectedMoviePersonalNotes);

        Map<String, String> actualMovieInfo = new HashMap<>();
        actualMovieInfo.put("title", movieDetailsActions.getMovieTitle());
        actualMovieInfo.put("language", movieDetailsActions.getMovieLanguage());
        actualMovieInfo.put("personal notes", movieDetailsActions.getMoviePersonalNotes());
        
        List<String> diff = AssertHelper.getDifference(actualMovieInfo, expectedMovieInfo);
        assertThat("List of differences should be empty", diff, is(empty()));
    }

    @AfterTest
    public void deleteTestData() throws SQLException {
        movieDBActions.deleteListOfMoviesByName(testMovieNames);
    }

    private String getUniqueNameOfMovie() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String uniqueName = "New Movie " + dtf.format(now);
        testMovieNames.add(uniqueName);
        return uniqueName;
    }
}
