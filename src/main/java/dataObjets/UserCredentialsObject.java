package dataObjets;

import com.google.gson.annotations.SerializedName;

public class UserCredentialsObject {
    //TODO: move to property file

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("user_role")
    private String userRole;

    public String getUsername() {
        return username;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getPassword() {
        return password;
    }

}