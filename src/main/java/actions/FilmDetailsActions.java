package actions;

import pages.FilmDetailsPage;
import driver.HasWaiter;

public class FilmDetailsActions implements HasWaiter {
    private FilmDetailsPage filmDetailsPage = new FilmDetailsPage();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(filmDetailsPage.txtFilmTitle);
    }

    public String getFilmTitle() {
        return filmDetailsPage.txtFilmTitle.getText();
    }

    public String getFilmLanguage() {
        return filmDetailsPage.txtLanguage.getText();
    }

    public String getFilmPersonalNotes() {
        return filmDetailsPage.txtPersonalNotes.getText();
    }
}
