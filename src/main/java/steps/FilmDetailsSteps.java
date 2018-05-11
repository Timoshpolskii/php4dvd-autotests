package steps;

import actions.FilmDetailsActions;

public class FilmDetailsSteps {
    private FilmDetailsActions filmDetailsActions = new FilmDetailsActions();

    public String getFilmTitle() {
        return filmDetailsActions.getFilmTitle();
    }

    public String getFilmLanguage() {
        return filmDetailsActions.getFilmLanguage();
    }

    public String getFilmPersonalNotes() {
        return filmDetailsActions.getFilmPersonalNotes();
    }
}
