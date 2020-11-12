package dal.dao;

import dal.Movie;
import dal.util.FileHandler;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends FileHandler {

    protected List<Movie> movies = new ArrayList<>();

    @Override
    public void loadFile(String path) {
        super.loadFile(path);
        parseMovies();
    }

    @Override
    public void saveFile() {

        if (movies.size() > 0) {
            getInputLines().clear();

            for (var movie : movies)
                getOutputLines().add(String.format("%d,%d,%s", movie.getId(), movie.getYear(), movie.getName()));
        }
        super.saveFile();
    }

    public void parseMovies() {
        for (Object str : getInputLines()) {
            var split = str.toString().split(",");

            if (split.length == 3) {
                var result = new Movie();
                var movie_id = Integer.parseInt(split[0]);
                var movie_year = Integer.parseInt(split[1]);
                var movie_name = split[2];

                result.setId(movie_id);
                result.setName(movie_name);
                result.setYear(movie_year);
                movies.add(result);
            }
        }
    }

    public Movie getMove(int id) {
        Movie result = new Movie();
        for (var movie : movies)
            if (id == movie.getId())
                result = movie;
        return result;
    }

    public void addMovie(String name, int year) {
        if (!name.isEmpty() && year > 0) {
            int new_id = movies.size() + 1;
            movies.add(new Movie(new_id, name, year));
        }
    }

    public void removeMovie(String name) {
        for (int i = 0; i < movies.size(); i++) {
            var movie = movies.get(i);
            if (name == movie.getName())
                movies.remove(i);
        }
    }

    public int getAvailableId() {
        int id = 0;
/*
        for (Movie movie : movies) {
            if (movie.getId() > id)
                id = movie.getId();
        }
*/

        id = movies.size();
        return id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        if (movies != null && movies.size() > 0)
            this.movies = new ArrayList<>(movies);
    }
}
