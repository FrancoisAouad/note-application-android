package main.app.auth.login.data.models;

/**
 * @class - Class used to verify login response
 */
public class UserModel {
    private String accessToken;
    private String refreshToken;

    public UserModel(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
