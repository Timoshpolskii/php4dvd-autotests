package tests;

import driver.SeleniumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.MyProfileSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MyProfileTests extends BaseTest {

    private MyProfileSteps myProfileSteps = new MyProfileSteps();

    @BeforeMethod
    public void openPage() {
        //TODO move url to params
        SeleniumDriver.getDriver().get("http://localhost/php4dvd/?go=profile");
    }

    @Test
    public void checkProfileInfo() {
        String expectedUserName = "admin";
        String actualUserName = myProfileSteps.getUserName();
        assertThat("Actual user name should be matched with expected",
                actualUserName, equalTo(expectedUserName));
    }
}
