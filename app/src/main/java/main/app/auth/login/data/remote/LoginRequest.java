package main.app.auth.login.data.remote;

/**
 * @class - Class for sending login request body
 */
public class LoginRequest {
    public String username;
    public String password;

    public LoginRequest(String username, String password) {
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
