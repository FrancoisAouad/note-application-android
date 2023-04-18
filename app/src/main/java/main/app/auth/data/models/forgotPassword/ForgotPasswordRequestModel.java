package main.app.auth.data.models.forgotPassword;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordRequestModel {
    @SerializedName("refreshToken")
    private final String refreshToken;

    public ForgotPasswordRequestModel(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
