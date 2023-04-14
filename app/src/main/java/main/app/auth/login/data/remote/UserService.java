package main.app.auth.login.data.remote;

import main.app.auth.login.data.models.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserService {
    @Headers("Content-Type: application/json")
    @POST("api/auth/login")
    Call<UserModel> login(@Body LoginRequest loginRequest);
}
