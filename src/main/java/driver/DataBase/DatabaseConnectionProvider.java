package driver.DataBase;

import helper.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionProvider {
    private static Connection connection = null;
    private static String DATABASE_CREDENTIALS_FILEPATH = "/src/test/resources/database_credentials.properties";
    private static Properties properties = PropertiesReader.readFromFile(DATABASE_CREDENTIALS_FILEPATH);
    private static Logger log = LogManager.getLogger();

    private DatabaseConnectionProvider() {}

    public static synchronized Connection getConnection() {
        if (connection == null) {
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            try {
                connection = DriverManager.getConnection(url, username, password);
                LogManager.getLogger().debug("SUCCESS connect to database");
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
                LogManager.getLogger().info("FAILED to connect to database");
            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            log.debug("Closed connection to database");
        }
    }
}
