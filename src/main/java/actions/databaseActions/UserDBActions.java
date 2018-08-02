package actions.databaseActions;

import dataBaseObjects.UserObject;
import driver.DatabaseConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBActions {
    private Connection connection = DatabaseConnectionProvider.getConnection();

    public List<UserObject> getListOfUsers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");

        List<UserObject> listOfUsers = new ArrayList<>();
        while (resultSet.next()) {
            listOfUsers.add(this.serializeUser(resultSet));
        }
        return listOfUsers;
    }

    public UserObject getUserObjectByName(String name) throws SQLException {
        List<UserObject> users = getListOfUsers();
        return users.stream().findAny().filter(user -> user.getUserName().equals(name)).get();
    }

    public void deleteUser(UserObject userObject) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM users WHERE id = " + userObject.getId() + ";");
    }

    private UserObject serializeUser(ResultSet resultSet) throws SQLException {
        UserObject userObject = new UserObject();
        userObject.setId(resultSet.getInt("id"));
        userObject.setEmail(resultSet.getString("email"));
        userObject.setUserName(resultSet.getString("username"));
        userObject.setPassword(resultSet.getString("password"));
        userObject.setPermission(resultSet.getInt("permission"));
        userObject.setLastLogin(resultSet.getDate("lastlogin"));
        return userObject;
    }
}
