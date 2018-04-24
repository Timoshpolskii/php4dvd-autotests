package actions;

import pages.AddFilmPage;
import utils.HasWaiter;

public class AddFilmActions implements HasWaiter {

    private AddFilmPage addFilmPage = new AddFilmPage();
    private FilmDetailsActions filmDetailsActions = new FilmDetailsActions();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(addFilmPage.btnSave);
    }

    public void addTitleOfFilm(String title) {
        addFilmPage.fldTitle.sendKeys(title);
    }

    public void addYearOfFilm(String year) {
        addFilmPage.fldYear.sendKeys(year);
    }

    public void addPersonalNotesOfFilm(String text) {
        addFilmPage.fldPersonalNotes.sendKeys(text);
    }

    public void addLanguageOfFilm(String text) {
        addFilmPage.fldLanguage.sendKeys(text);
    }

    public void saveFilm() {
        addFilmPage.btnSave.click();
        filmDetailsActions.waitForPageToBeLoaded();
    }
}