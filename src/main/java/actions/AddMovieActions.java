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
        addMoviePage.fldTitle.sendKeys(title);
    }

    @Step("Add year [{0}] of movie")
    public void addYearOfMovie(int year) {
        addMoviePage.fldYear.sendKeys(String.valueOf(year));
    }

    @Step("Add personal notes [{0}] of movie")
    public void addPersonalNotesOfMovie(String text) {
        addMoviePage.fldPersonalNotes.sendKeys(text);
    }

    @Step("Add language [{0}] of movie")
    public void addLanguageOfMovie(String text) {
        addMoviePage.fldLanguage.sendKeys(text);
    }

    @Step("Save movie")
    public void saveMovie() {
        addMoviePage.btnSave.click();
        movieDetailsActions.waitForPageToBeLoaded();
    }
}
