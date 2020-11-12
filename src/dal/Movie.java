package dal;

public class Movie {
    private int id;
    private String name;
    private int year;
    private int rating = 0;

    public Movie() {
    }

    public Movie(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return getId() + " : " + "(" + getYear() + ")" + " " + getName();
    }
}
