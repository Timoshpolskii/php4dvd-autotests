package actions;

import pages.FilmDetailsPage;
import driver.HasWaiter;
import ru.yandex.qatools.allure.annotations.Step;

public class FilmDetailsActions implements HasWaiter {
    private FilmDetailsPage filmDetailsPage = new FilmDetailsPage();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(filmDetailsPage.txtFilmTitle);
    }

    @Step("Get film title from UI")
    public String getFilmTitle() {
        return filmDetailsPage.txtFilmTitle.getText();
    }

    @Step("Get film language from UI")
    public String getFilmLanguage() {
        return filmDetailsPage.txtLanguage.getText();
    }

    @Step("Get film personal notes from UI")
    public String getFilmPersonalNotes() {
        return filmDetailsPage.txtPersonalNotes.getText();
    }
}
