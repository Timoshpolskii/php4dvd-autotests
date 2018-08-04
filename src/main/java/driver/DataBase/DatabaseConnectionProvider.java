package driver.DataBase;

import helper.PropertiesReader;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnectionProvider {
    private static Connection connection = null;
    private static String DATABASE_CREDENTIALS_FILEPATH = "/src/main/resources/database_credentials.properties";
    private static Properties properties = PropertiesReader.readFromFile(DATABASE_CREDENTIALS_FILEPATH);

    private DatabaseConnectionProvider() {}

    public static synchronized Connection getConnection() {
        if (connection == null) {
            //TODO add logger
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
