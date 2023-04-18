package main.app.auth.data.models.logout;

import com.google.gson.annotations.SerializedName;

public class LogoutResponseModel {
    @SerializedName("success")
    private final boolean success;


    public LogoutResponseModel(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return this.success;
    }

}
