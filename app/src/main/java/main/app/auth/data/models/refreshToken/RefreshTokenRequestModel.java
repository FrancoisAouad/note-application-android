package main.app.auth.data.models.refreshToken;

import com.google.gson.annotations.SerializedName;

public class RefreshTokenRequestModel {
    @SerializedName("refreshToken")
    private final String refreshToken;

    public RefreshTokenRequestModel(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
