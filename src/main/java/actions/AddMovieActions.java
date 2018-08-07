package actions;

import helper.HasWaiter;
import pages.AddMoviePage;
import ru.yandex.qatools.allure.annotations.Step;

public class AddMovieActions implements HasWaiter {

    private AddMoviePage addMoviePage = new AddMoviePage();
    private MovieDetailsActions movieDetailsActions = new MovieDetailsActions();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(addMoviePage.btnSave);
    }

    @Step("Add name [{0}]of movie")
    public void addNameOfMovie(String title) {
        waiter().sendKeys(addMoviePage.fldTitle, title);
    }

    @Step("Add year [{0}] of movie")
    public void addYearOfMovie(int year) {
        waiter().sendKeys(addMoviePage.fldYear, String.valueOf(year));
    }

    @Step("Add personal notes [{0}] of movie")
    public void addPersonalNotesOfMovie(String text) {
        waiter().sendKeys(addMoviePage.fldPersonalNotes, text);
    }

    @Step("Add language [{0}] of movie")
    public void addLanguageOfMovie(String text) {
        waiter().sendKeys(addMoviePage.fldLanguage, text);
    }

    @Step("Save movie")
    public void saveMovie() {
        waiter().click(addMoviePage.btnSave);
        movieDetailsActions.waitForPageToBeLoaded();
    }
}
