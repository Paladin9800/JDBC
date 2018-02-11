package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbWorker {
    private final String URL = "jdbc:mysql://localhost:3306/test";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private Connection connection;


    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public DbWorker() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
