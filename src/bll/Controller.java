package bll;

import dal.Movie;
import dal.dao.MovieDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField txtMovieSearch;
    @FXML
    private ListView<Movie> lstMovies;
    @FXML
    private TextField txtUserSearch;
    @FXML
    private ListView lstUsers;
    @FXML
    private RadioButton radioRatingMinus5;
    @FXML
    private RadioButton radioRatingMinus3;
    @FXML
    private RadioButton radioRating1;
    @FXML
    private RadioButton radioRating3;
    @FXML
    private RadioButton radioRating5;
    @FXML
    private ListView<Movie> lstRecommendedMovies;
    @FXML
    private TextField txtMovieTitle;
    @FXML
    private TextField txtMovieYear;
    @FXML
    private TextField txtSelectedMovieTitle;
    @FXML
    private TextField txtSelectedMovieYear;

    private MovieModel movieModel = new MovieModel();

    private Movie selectedMovie;
    private int currentRating;


    public Controller() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lstMovies.setItems(movieModel.getMovies());
    }


    public void handleUserRateMovie(ActionEvent actionEvent) {
    }

    public void handleAddMovie(ActionEvent actionEvent) {
        int id = movieModel.getMovieDAO().getAvailableId();
        var newMovie = new Movie();
        newMovie.setId(id);
        newMovie.setName(txtMovieTitle.getText());
        newMovie.setYear(Integer.parseInt(txtMovieYear.getText()));
        lstMovies.getItems().add(newMovie);

        applyChanges();

    }

    public void handleUpdateMovie(ActionEvent actionEvent) {
        if (selectedMovie != null) {
            selectedMovie.setName(txtSelectedMovieTitle.getText());
            selectedMovie.setYear(Integer.parseInt(txtSelectedMovieYear.getText()));
            selectedMovie.setRating(currentRating);
        }

        applyChanges();
    }

    public void handleDeleteMovie(ActionEvent actionEvent) {
        if (selectedMovie != null && !lstMovies.getSelectionModel().isEmpty()) {
            lstMovies.getItems().remove(selectedMovie);
        }
        applyChanges();
    }

    public void handleSearchUser(KeyEvent keyEvent) {
    }

    public void handleSearchMovie(KeyEvent keyEvent) {
    }

    public void getSelection(MouseEvent mouseEvent) {
        System.out.println(lstMovies.getSelectionModel().getSelectedItem());
        if (lstMovies.getSelectionModel().getSelectedItem() != null) {

            selectedMovie = lstMovies.getSelectionModel().getSelectedItem();
            txtSelectedMovieTitle.setText(selectedMovie.getName());
            txtSelectedMovieYear.setText(String.valueOf(selectedMovie.getYear()));
        }
    }

    public int getRating() {
        // TODO: Tilføje det sidste.
        if (radioRating1.isSelected()) currentRating = 1;
        else if (radioRating3.isSelected()) currentRating = 2;
        else if (radioRating5.isSelected()) currentRating = 3;

        return currentRating;
    }

    public void applyChanges() {
        if (movieModel != null && movieModel.getMovieDAO() != null) {
            movieModel.getMovieDAO().setMovies(lstMovies.getItems());
            movieModel.getMovieDAO().saveFile();
        }
    }
}
