package main.app.auth.data.models.logout;

import com.google.gson.annotations.SerializedName;

public class LogoutRequestModel {
    @SerializedName("refreshToken")
    private final String refreshToken;


    public LogoutRequestModel(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

}
