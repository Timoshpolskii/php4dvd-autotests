package testData;

import helper.PropertiesReader;
import org.testng.annotations.DataProvider;

import java.util.Properties;

public class UserCredentialsDataProvider {
    private String USER_CREDENTIALS_FILEPATH = "/src/test/resources/fixtures/user_credentials.properties";
    private Properties properties = PropertiesReader.readFromFile(USER_CREDENTIALS_FILEPATH);

    @DataProvider(name = "admin_user")
    public Object[][] adminData() {
        return new Object[][]{{properties.getProperty("admin_username"), properties.getProperty("admin_password")}};
    }

    @DataProvider(name = "guest_user")
    public Object[][]  guestData() {
        return new Object[][]{{properties.getProperty("guest_username"), properties.getProperty("guest_password")}};
    }

    @DataProvider(name = "incorrect_user")
    public Object[][]  incorrectUserData() {
        return new Object[][]{{properties.getProperty("incorrect_username"), properties.getProperty("incorrect_password")}};
    }
}
