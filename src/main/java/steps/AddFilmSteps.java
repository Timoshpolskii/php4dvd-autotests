package steps;

import actions.AddFilmActions;
import actions.FilmDetailsActions;

public class AddFilmSteps {
    private AddFilmActions addFilmActions = new AddFilmActions();
    private FilmDetailsActions filmDetailsActions = new FilmDetailsActions();

    public void addNameOfFilm(String title) {
        addFilmActions.addNameOfFilm(title);
    }

    public void addYearOfFilm(int year) {
        addFilmActions.addYearOfFilm(year);
    }

    public void addPersonalNotesOfFilm(String text) {
        addFilmActions.addPersonalNotesOfFilm(text);
    }

    public void addLanguageOfFilm(String text){
        addFilmActions.addLanguageOfFilm(text);
    }

    public void saveFilm() {
        addFilmActions.saveFilm();
        filmDetailsActions.waitForPageToBeLoaded();
    }
}
