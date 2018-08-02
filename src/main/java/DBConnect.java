import actions.databaseActions.UserDBActions;

import java.sql.SQLException;

public class DBConnect {

    public static void main(String[] args) throws SQLException {
        UserDBActions userDBActions = new UserDBActions();
        userDBActions.getListOfUsers();

    }
}
