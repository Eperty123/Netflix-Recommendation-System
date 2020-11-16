package dal.dao;

import dal.Movie;
import dal.Rating;
import dal.util.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class RatingDAO extends FileHandler {

    protected List<Rating> ratings = new ArrayList<>();

    @Override
    public void loadFile(String path) {
        super.loadFile(path);
        parseRatings();
    }

    @Override
    public void saveFile() {
        for (var rating : ratings)
            getInputLines().add(String.format("%d,%d,%d", rating.getMovieId(), rating.getUserId(), rating.getRating()));

        super.saveFile();
    }

    public void parseRatings() {
        for (Object str : getInputLines()) {
            var split = str.toString().split(",");

            if (split.length == 3) {
                var result = new Rating();
                var movie_id = Integer.parseInt(split[0]);
                var rating = Integer.parseInt(split[1]);
                var user_id = Integer.parseInt(split[2]);

                result.setRatingId(getAvailableId());
                result.setMovieId(movie_id);
                result.setUserId(user_id);
                result.setRating(rating);

                ratings.add(result);
            }
        }
    }

    public Rating getRating(int id) {
        Rating result = new Rating();
        for (var rating : ratings)
            if (id == rating.getRating())
                result = rating;
        return result;
    }

    public void addRating(int movieId, int userId, int rating) {
        if (movieId != -1 && userId != -1) {
            int new_id = getAvailableId();
            ratings.add(new Rating(movieId, userId, rating));
        }
    }

    public int getAvailableId() {
        int id = 0;
        for (Rating rating : ratings) {
            if (rating.getRatingId() > id)
                id = rating.getRatingId();
        }
        id++;
        return id;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void removeRating(int movieId) {
        for (int i = 0; i < ratings.size(); i++) {
            var rating = ratings.get(i);
            if (movieId == rating.getMovieId())
                ratings.remove(i);
        }
    }

    public void removeRating(int userId, int movieId) {
        for (int i = 0; i < ratings.size(); i++) {
            var rating = ratings.get(i);
            if (movieId == rating.getMovieId() && rating.getUserId() == userId)
                ratings.remove(i);
        }
    }
}
