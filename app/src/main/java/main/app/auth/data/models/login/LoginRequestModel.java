package main.app.auth.data.models.login;

import com.google.gson.annotations.SerializedName;

public class LoginRequestModel {
    @SerializedName("username")
    public String username;
    @SerializedName("password")
    public String password;


    public LoginRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    };

    public String getPassword() {
        return this.password;
    };

}



