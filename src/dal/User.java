package dal;

public class User {
    protected int id;
    protected String name;

    public User() {

    }

    public User(int id, String name) {
        setId(id);
        setName(name);
    }

    public User(int id) {
        setId(id);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
