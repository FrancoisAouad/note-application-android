package main.app.auth.data.models.forgotPassword;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordResponseModel {
    @SerializedName("success")
    private final boolean success;

    public ForgotPasswordResponseModel(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return this.success;
    }
}
