package actions;

import driver.HasWaiter;
import pages.AddFilmPage;
import ru.yandex.qatools.allure.annotations.Step;

public class AddFilmActions implements HasWaiter {

    private AddFilmPage addFilmPage = new AddFilmPage();
    private FilmDetailsActions filmDetailsActions = new FilmDetailsActions();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(addFilmPage.btnSave);
    }

    @Step("Add name [{0}]of film")
    public void addNameOfFilm(String title) {
        addFilmPage.fldTitle.sendKeys(title);
    }

    @Step("Add year [{0}] of film")
    public void addYearOfFilm(int year) {
        addFilmPage.fldYear.sendKeys(String.valueOf(year));
    }

    @Step("Add personal notes [{0}] of film")
    public void addPersonalNotesOfFilm(String text) {
        addFilmPage.fldPersonalNotes.sendKeys(text);
    }

    @Step("Add language [{0}] of film")
    public void addLanguageOfFilm(String text) {
        addFilmPage.fldLanguage.sendKeys(text);
    }

    @Step("Save film")
    public void saveFilm() {
        addFilmPage.btnSave.click();
        filmDetailsActions.waitForPageToBeLoaded();
    }
}
