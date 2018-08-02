package actions.databaseActions;

import driver.DataBase.DatabaseConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MovieDBActions {
    private Connection connection = DatabaseConnectionProvider.getConnection();

    public void deleteAllMovies() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM movies;");
    }

    public void deleteListOfMoviesByName(List<String> movieNames) throws SQLException {
        Statement statement = connection.createStatement();
        String listOfMoviesQuery = this.getMoviesQueryFromListOfMovies(movieNames);
        statement.execute("DELETE FROM movies WHERE name IN (" + listOfMoviesQuery + ");");
    }

    private String getMoviesQueryFromListOfMovies(List<String> movieNames) {
        String listOfMoviesQuery = "";
        if (movieNames != null) {
            for (String movieName : movieNames) {
                listOfMoviesQuery = listOfMoviesQuery.concat("'" + movieName + "', ");
            }
        }
        //As a result we need to return a string without last comma and space
        return listOfMoviesQuery.substring(0, listOfMoviesQuery.length() - 2);
    }
}
