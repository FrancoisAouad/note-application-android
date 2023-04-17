package main.app.auth.login.data.models;

import com.google.gson.annotations.SerializedName;

public class RequestModel {
    @SerializedName("username")
    public String username;
    @SerializedName("password")
    public String password;


    public RequestModel(String username, String password) {
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



