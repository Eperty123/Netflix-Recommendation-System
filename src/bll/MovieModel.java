package bll;

import dal.MovieDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovieModel {
    private ObservableList<Movie> movies = FXCollections.observableArrayList();
    private MovieDAO movieDAO = new MovieDAO();

    public MovieModel(){

    }

    public ObservableList<Movie> getMovies() {
        movieDAO.loadFile("src/Data/movie_titles.txt");
        for (int i = 0; i < movieDAO.getInputLines().size()-1; i++){
            String[] data = movieDAO.getInputLines().get(i).split(",");
            Movie movie = new Movie(Integer.parseInt(data[0]), data[2], Integer.parseInt(data[1]));
            movies.add(movie);
        }
        return movies;
    }
}
