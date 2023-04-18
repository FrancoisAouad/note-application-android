package main.app.auth.data.models.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponseModel {
    @SerializedName("accessToken")
    private final String accessToken;
    @SerializedName("refreshToken")
    private final String refreshToken;

    public LoginResponseModel(String accessToken, String refreshToken) {
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
