package actions.databaseActions;

import dataBaseObjects.UserDBObject;
import driver.DataBase.DatabaseConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBActions {
    private Connection connection = DatabaseConnectionProvider.getConnection();

    public List<UserDBObject> getListOfUsers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");

        List<UserDBObject> listOfUsers = new ArrayList<>();
        while (resultSet.next()) {
            listOfUsers.add(this.serializeUser(resultSet));
        }
        return listOfUsers;
    }

    public UserDBObject getUserObjectByName(String name) throws SQLException {
        List<UserDBObject> users = getListOfUsers();
        return users.stream().findAny().filter(user -> user.getUserName().equals(name)).get();
    }

    public void deleteUser(UserDBObject userDBObject) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM users WHERE id = " + userDBObject.getId() + ";");
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
