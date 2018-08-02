package testData;

import dataObjets.UserCredentialsObject;
import helper.TestDataReader;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;

public class UserCredentialsData {
    private String currentPath = System.getProperty("user.dir");

    @DataProvider(name = "admin_user")
    public Object[][] adminData() throws FileNotFoundException {

        String ADMIN_USER_FILEPATH = currentPath + "/src/test/resources/fixtures/admin_user_credentials.json";
        TestDataReader<UserCredentialsObject> userCredentials = new TestDataReader(ADMIN_USER_FILEPATH, UserCredentialsObject.class);
        UserCredentialsObject user = userCredentials.read();
        return new Object[][]{{user.getUsername(), user.getPassword()}};
    }

    @DataProvider(name = "guest_user")
    public Object[][]  guestData() throws FileNotFoundException {
        String GUEST_USER_FILEPATH = currentPath +"/src/test/resources/fixtures/guest_user_credentials.json";
        TestDataReader<UserCredentialsObject> userCredentials = new TestDataReader(GUEST_USER_FILEPATH, UserCredentialsObject.class);
        UserCredentialsObject user = userCredentials.read();
        return new Object[][]{{user.getUsername(), user.getPassword()}};
    }

    @DataProvider(name = "incorrect_user")
    public Object[][]  incorrectUserData() throws FileNotFoundException {
        String INCORRECT_USER_FILEPATH = currentPath + "/src/test/resources/fixtures/incorrect_user_credentials.json";
        TestDataReader<UserCredentialsObject> userCredentials = new TestDataReader(INCORRECT_USER_FILEPATH, UserCredentialsObject.class);
        UserCredentialsObject user = userCredentials.read();
        return new Object[][]{{user.getUsername(), user.getPassword()}};
    }

}
