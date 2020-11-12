package bll;

import dal.Movie;
import dal.dao.MovieDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovieModel {
    private ObservableList<Movie> movies = FXCollections.observableArrayList();
    private MovieDAO movieDAO = new MovieDAO();

    public MovieModel(){

    }

    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public ObservableList<Movie> getMovies() {
        movieDAO.loadFile("src/Data/movie_titles.txt");
        var movies = movieDAO.getMovies();
        for (int i = 0; i < movies.size(); i++){
            Movie movie = movies.get(i);
            this.movies.add(movie);
        }
        return this.movies;
    }
}
