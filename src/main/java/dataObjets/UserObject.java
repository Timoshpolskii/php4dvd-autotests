package dataObjets;

//TODO: investigate if expose required
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserObject {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("user_role")
    @Expose
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