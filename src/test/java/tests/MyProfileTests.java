package tests;

import actions.MyProfileActions;
import actions.NavigationActions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MyProfileTests extends BaseTest {

    private MyProfileActions myProfileActions = new MyProfileActions();
    private NavigationActions navigationActions = new NavigationActions();

    @BeforeMethod
    public void openPage() {
        navigationActions.openMyProfilePage();
    }

    @Test
    public void checkProfileInfo() {
        String expectedUserName = "admin";
        String actualUserName = myProfileActions.getUserName();
        assertThat("Actual user name should be matched with expected",
                actualUserName, equalTo(expectedUserName));
    }
}
