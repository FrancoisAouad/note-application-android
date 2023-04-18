package main.app.auth.data.api;

import main.app.auth.data.models.login.LoginRequestModel;
import main.app.auth.data.models.login.LoginResponseModel;
import main.app.auth.data.models.register.RegisterRequestModel;
import main.app.auth.data.models.register.RegisterResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthService {
    @Headers("Content-Type: application/json")
    @POST("api/auth/register")
    Call<RegisterResponseModel> register(
            @Body RegisterRequestModel registerRequestModel
    );

    @Headers("Content-Type: application/json")
    @POST("api/auth/login")
    Call<LoginResponseModel> login(
            @Body LoginRequestModel loginRequestModel
    );
}
