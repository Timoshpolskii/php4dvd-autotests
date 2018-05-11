package testData;

import dataObjets.UserObject;
import helper.TestDataReader;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;

public class UserCredentialsData {

    @DataProvider(name = "admin_user")
    public Object[][] adminData() throws FileNotFoundException {
        String ADMIN_USER_FILEPATH = "/Users/andrewtimoshpolskiy/Documents/workspace/php4dvd-autotests/src/test/resources/fixtures/admin_user_credentials.json";
        TestDataReader<UserObject> userCredentials = new TestDataReader(ADMIN_USER_FILEPATH, UserObject.class);
        UserObject user = userCredentials.read();
        return new Object[][]{{user.getUsername(), user.getPassword()}};
    }

    @DataProvider(name = "guest_user")
    public Object[][]  guestData() throws FileNotFoundException {
        String GUEST_USER_FILEPATH = "/Users/andrewtimoshpolskiy/Documents/workspace/php4dvd-autotests/src/test/resources/fixtures/guest_user_credentials.json";
        TestDataReader userCredentials = new TestDataReader(GUEST_USER_FILEPATH, UserObject.class);
        UserObject user = userCredentials.read();
        return new Object[][]{{user.getUsername(), user.getPassword()}};
    }

}
