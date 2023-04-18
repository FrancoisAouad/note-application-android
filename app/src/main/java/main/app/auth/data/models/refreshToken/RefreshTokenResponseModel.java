package main.app.auth.data.models.refreshToken;

import com.google.gson.annotations.SerializedName;

public class RefreshTokenResponseModel {
    @SerializedName("success")
    private final boolean success;

    public RefreshTokenResponseModel(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return this.success;
    }
}
