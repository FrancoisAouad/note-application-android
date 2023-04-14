package main.app.auth.login.data.models;

public class ResponseModel {
    private String accessToken;
    private String refreshToken;

    public ResponseModel(String accessToken, String refreshToken) {
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
