package actions.databaseActions;

import dataBaseObjects.MovieDBObject;
import driver.DataBase.DatabaseConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public List<MovieDBObject> getListOfMovies() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM movies;");

        List<MovieDBObject> listOfUsers = new ArrayList<>();
        while (resultSet.next()) {
            listOfUsers.add(this.serializeMovie(resultSet));
        }
        return listOfUsers;
    }

    private MovieDBObject serializeMovie(ResultSet resultSet) throws SQLException {
        MovieDBObject movieDBObject = new MovieDBObject();
        movieDBObject.setId(resultSet.getInt("id"));
        movieDBObject.setImdbid(resultSet.getString("imdbid"));
        movieDBObject.setName(resultSet.getString("name"));
        movieDBObject.setNameorder(resultSet.getString("nameorder"));
        movieDBObject.setAka(resultSet.getString("aka"));
        movieDBObject.setYear(resultSet.getInt("year"));
        movieDBObject.setDuration(resultSet.getInt("duration"));
        movieDBObject.setRating(resultSet.getDouble("rating"));
        movieDBObject.setLanguages(resultSet.getString("languages"));
        movieDBObject.setCountry(resultSet.getString("country"));
        movieDBObject.setGenres(resultSet.getString("genres"));
        movieDBObject.setDirector(resultSet.getString("director"));
        movieDBObject.setWriter(resultSet.getString("writer"));
        movieDBObject.setProducer(resultSet.getString("producer"));
        movieDBObject.setMusic(resultSet.getString("music"));
        movieDBObject.setCast(resultSet.getString("cast"));
        movieDBObject.setTaglines(resultSet.getString("taglines"));
        movieDBObject.setPlotoutline(resultSet.getString("plotoutline"));
        movieDBObject.setPlots(resultSet.getString("plots"));
        movieDBObject.setFormat(resultSet.getString("format"));
        movieDBObject.setOwn(resultSet.getInt("own"));
        movieDBObject.setSeen(resultSet.getInt("seen"));
        movieDBObject.setNotes(resultSet.getString("notes"));
        movieDBObject.setLoaned(resultSet.getInt("loaned"));
        movieDBObject.setLoandate(resultSet.getDate("loandate"));
        movieDBObject.setLoanname(resultSet.getString("loanname"));
        movieDBObject.setAdded(resultSet.getDate("added"));
        movieDBObject.setTrailer(resultSet.getString("trailer"));
        movieDBObject.setSubtitles(resultSet.getString("subtitles"));
        movieDBObject.setAudio(resultSet.getString("audio"));
        movieDBObject.setVideo(resultSet.getString("video"));
        movieDBObject.setTv(resultSet.getInt("tv"));
        movieDBObject.setSeasons(resultSet.getInt("seasons"));
        movieDBObject.setFavourite(resultSet.getInt("favourite"));
        movieDBObject.setMpaa(resultSet.getString("mpaa"));
        movieDBObject.setPg(resultSet.getInt("pg"));
        return movieDBObject;
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
