package actions;

import pages.MovieDetailsPage;
import driver.HasWaiter;
import ru.yandex.qatools.allure.annotations.Step;

public class MovieDetailsActions implements HasWaiter {
    private MovieDetailsPage movieDetailsPage = new MovieDetailsPage();

    @Override
    public boolean waitForPageToBeLoaded() {
        return waiter(15).waitDisplayed(movieDetailsPage.txtMovieTitle);
    }

    @Step("Get movie title from UI")
    public String getMovieTitle() {
        return movieDetailsPage.txtMovieTitle.getText();
    }

    @Step("Get movie language from UI")
    public String getMovieLanguage() {
        return movieDetailsPage.txtLanguage.getText();
    }

    @Step("Get movie personal notes from UI")
    public String getMoviePersonalNotes() {
        return movieDetailsPage.txtPersonalNotes.getText();
    }

    @Step("Press 'Remove' button")
    public void pressRemoveButton() {
        movieDetailsPage.btnRemove.click();
    }

    @Step("Accept movie removal alert")
    public void acceptMovieRemoveAlert() {
        waiter(5).acceptAlert();
    }
}
