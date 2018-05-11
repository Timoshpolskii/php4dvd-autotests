package steps;

import actions.MyProfileActions;

public class MyProfileSteps {
    private MyProfileActions myProfileActions = new MyProfileActions();

    public String getUserName() {
        return myProfileActions.getUserName();
    }
}
