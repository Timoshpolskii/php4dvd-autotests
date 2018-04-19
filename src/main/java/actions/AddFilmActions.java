package actions;

import pages.AddFilmPage;
import utils.HasWaiter;

public class AddFilmActions implements HasWaiter {

    private AddFilmPage addFilmPage = new AddFilmPage();

    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(addFilmPage.btnSave);
    }

    public void addTitleOfFilm(String title) {
        addFilmPage.fldTitle.sendKeys(title);
    }

    public void addYearOfFilm(String year) {
        addFilmPage.fldYear.sendKeys(year);
    }

    public void saveFilm() {
        addFilmPage.btnSave.click();
    }
}
