package dal.dao;

import dal.User;
import dal.util.FileHandler;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends FileHandler {

    protected List<User> users = new ArrayList<>();

    @Override
    public void loadFile(String path) {
        super.loadFile(path);
        parseUsers();
    }

    @Override
    public void saveFile() {
        for (var user : users)
            getOutputLines().add(String.format("%d,%s", user.getId(), user.getName()));

        super.saveFile();
    }

    public void parseUsers() {
        for (Object str : getInputLines()) {
            var split = str.toString().split(",");

            if (split.length == 3) {
                var result = new User();
                var user_id = Integer.parseInt(split[0]);
                var user_name = split[2];

                result.setId(user_id);
                result.setName(user_name);
            }
        }
    }

    public User getUser(int id) {
        User result = new User();
        for (var user : users)
            if (id == user.getId())
                result = user;
        return result;
    }

    public void adduser(String name, int year) {
        if (!name.isEmpty() && year > 0) {
            int new_id = users.size() + 1;
            users.add(new User(new_id, name));
        }
    }

    public void removeUser(String name) {
        for (int i = 0; i < users.size(); i++) {
            var user = users.get(i);
            if (name == user.getName())
                users.remove(i);
        }
    }
}
