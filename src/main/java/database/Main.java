package database;

import com.sun.jndi.toolkit.url.Uri;

import java.sql.*;

public class Main {

    private static Statement statement;
    private  static   ResultSet resultSet;

    public static void main(String[] args) {
        DbWorker dbWorker = new DbWorker();
        String query = "SELECT * FROM clients";
        String enter = "INSERT INTO clients (id, username, password) VALUES (3, 'Dima','154')";
        try {
            statement = dbWorker.getConnection().createStatement();
            statement.executeUpdate(enter);
            resultSet = statement.executeQuery(query);
// sdsdsdsdssdd
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                
                System.out.println(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                dbWorker.getConnection().close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
