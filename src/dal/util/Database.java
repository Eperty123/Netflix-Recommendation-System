package dal.util;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    protected String host;

    // Default port is mysql.
    protected int port = 3306;
    protected String database;
    protected String username;
    protected String password;

    protected Connection connection;


    public void connect() {
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", host, port, database), username, password);
        } catch (Exception e) {
            MessageBox.Show(String.format("Connect exception: %s", e.getMessage()), "Connect exception", Alert.AlertType.ERROR);
        }
    }

    public void connect(String host, String database, String username, String password) {
        setHost(host);
        setDatabase(database);
        setUsername(username);
        setPassword(password);
        connect();
    }

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
