package bll;

import dal.Movie;
import dal.Rating;
import dal.dao.MovieDAO;
import dal.dao.RatingDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovieModel {
    private ObservableList<Movie> movies = FXCollections.observableArrayList();
    private ObservableList<Rating> ratings = FXCollections.observableArrayList();
    private MovieDAO movieDAO = new MovieDAO();
    private RatingDAO ratingDAO = new RatingDAO();

    public MovieModel() {

    }

    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public RatingDAO getRatingDAO() { return ratingDAO; }

    public ObservableList<Movie> getMovies() {
        movieDAO.loadFile("src/Data/movie_titles.txt");
        var movies = movieDAO.getMovies();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            this.movies.add(movie);
        }
        return this.movies;
    }

    public ObservableList<Rating> getRatings() {
        ratingDAO.loadFile("src/Data/ratings.txt");
        var ratings = ratingDAO.getRatings();
        for (int i = 0; i < ratings.size(); i++) {
            Rating rating = ratings.get(i);
            this.ratings.add(rating);
        }
        return this.ratings;
    }
}
