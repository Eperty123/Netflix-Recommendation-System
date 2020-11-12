package dal;

public class Rating {
    protected int rating;
    protected int movieId;
    protected int userId;

    public Rating() {
    }

    public Rating(int rating) {
        setRating(rating);
    }

    public Rating(int userId, int rating) {
        setRating(rating);
        setUserId(userId);
    }

    public Rating(int movieId, int userId, int rating) {
        setRating(rating);
        setMovieId(movieId);
        setUserId(userId);
    }

    public int getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getUserId() {
        return userId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setMovieId(int id) {
        this.movieId = id;
    }

    public void setUserId(int id) {
        this.userId = id;
    }
}
