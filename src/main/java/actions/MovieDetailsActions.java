package actions;

import pages.MovieDetailsPage;
import helper.HasWaiter;
import ru.yandex.qatools.allure.annotations.Step;

public class MovieDetailsActions implements HasWaiter {
    private MovieDetailsPage movieDetailsPage = new MovieDetailsPage();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(movieDetailsPage.txtMovieTitle);
    }

    @Step("Get movie title from UI")
    public String getMovieTitle() {
        return waiter().getText(movieDetailsPage.txtMovieTitle);
    }

    @Step("Get movie language from UI")
    public String getMovieLanguage() {
        return waiter().getText(movieDetailsPage.txtLanguage);
    }

    @Step("Get movie personal notes from UI")
    public String getMoviePersonalNotes() {
        return waiter().getText(movieDetailsPage.txtPersonalNotes);
    }

    @Step("Press 'Remove' button")
    public void pressRemoveButton() {
        waiter().click(movieDetailsPage.btnRemove);
    }

    @Step("Accept movie removal alert")
    public void acceptMovieRemoveAlert() {
        waiter(5).acceptAlert();
    }
}
