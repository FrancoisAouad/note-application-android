package main.app.auth.login.data.models;


public class RequestModel {
    public String username;
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



