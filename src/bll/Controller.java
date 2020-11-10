package bll;

import bll.Movie;
import dal.MovieDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
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

    private MovieDAO movieDAO = new MovieDAO();
    private MovieModel movieModel = new MovieModel();


    public Controller(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lstMovies.setItems(movieModel.getMovies());
    }


    public void handleUserRateMovie(ActionEvent actionEvent) {
    }

    public void handleAddMovie(ActionEvent actionEvent) {
    }

    public void handleUpdateMovie(ActionEvent actionEvent) {

    }

    public void handleDeleteMovie(ActionEvent actionEvent) {
    }

    public void handleSearchUser(KeyEvent keyEvent) {
    }

    public void handleSearchMovie(KeyEvent keyEvent) {
    }

    public void getSelection(MouseEvent mouseEvent) {
        System.out.println(lstMovies.getSelectionModel().getSelectedItem());
        if (lstMovies.getSelectionModel().getSelectedItem() != null){
            txtSelectedMovieTitle.setText(lstMovies.getSelectionModel().getSelectedItem().getName());
            txtSelectedMovieYear.setText(String.valueOf(lstMovies.getSelectionModel().getSelectedItem().getYear()));
        }
    }
}
