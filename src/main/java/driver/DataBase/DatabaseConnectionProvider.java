package driver.DataBase;

import java.sql.*;

public class DatabaseConnectionProvider {
    private static Connection connection = null;

    private DatabaseConnectionProvider() {}

    public static synchronized Connection getConnection() {
        if (connection == null) {
            //TODO move to property file
            //TODO add logger
            String url = "jdbc:mysql://localhost:3306/php4dvd?serverTimezone=UTC";
            String username = "root";
            String password = "";

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
