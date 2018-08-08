package actions.databaseActions;

import dataBaseObjects.UserDBObject;
import driver.DataBase.DatabaseConnectionProvider;
import helper.HasLogger;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBActions implements HasLogger {
    private Connection connection = DatabaseConnectionProvider.getConnection();
    private Logger log = getLogger();

    public List<UserDBObject> getListOfUsers() throws SQLException {
        List<UserDBObject> listOfUsers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
            log.debug("Select list of users from database");

            while (resultSet.next()) {
                listOfUsers.add(this.serializeUser(resultSet));
            }
        }
        catch (NullPointerException e) {
            log.info("FAILED to get list of users from database");
            e.printStackTrace();
        }
        return listOfUsers;
    }

    public UserDBObject getUserObjectByName(String name) throws SQLException {
        List<UserDBObject> users = getListOfUsers();
        return users.stream().findAny().filter(user -> user.getUserName().equals(name)).get();
    }

    public void deleteUser(UserDBObject userDBObject) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM users WHERE id = " + userDBObject.getId() + ";");
            log.debug("Delete user with name [" + userDBObject.getUserName() +
                    "] and ID [" + userDBObject.getId() + "] from database");
        }
        catch (NullPointerException e) {
            log.info("FAILED to delete user [" + userDBObject.getUserName() + "] from database");
            e.printStackTrace();
        }
    }

    private UserDBObject serializeUser(ResultSet resultSet) throws SQLException {
        UserDBObject userDBObject = new UserDBObject();
        userDBObject.setId(resultSet.getInt("id"));
        userDBObject.setEmail(resultSet.getString("email"));
        userDBObject.setUserName(resultSet.getString("username"));
        userDBObject.setPassword(resultSet.getString("password"));
        userDBObject.setPermission(resultSet.getInt("permission"));
        userDBObject.setLastLogin(resultSet.getDate("lastlogin"));
        return userDBObject;
    }
}
