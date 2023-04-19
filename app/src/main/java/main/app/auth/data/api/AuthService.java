package main.app.auth.data.api;

import main.app.auth.data.models.forgotPassword.ForgotPasswordRequestModel;
import main.app.auth.data.models.forgotPassword.ForgotPasswordResponseModel;
import main.app.auth.data.models.refreshToken.RefreshTokenRequestModel;
import main.app.auth.data.models.login.LoginRequestModel;
import main.app.auth.data.models.login.LoginResponseModel;
import main.app.auth.data.models.logout.LogoutRequestModel;
import main.app.auth.data.models.logout.LogoutResponseModel;
import main.app.auth.data.models.refreshToken.RefreshTokenResponseModel;
import main.app.auth.data.models.register.RegisterRequestModel;
import main.app.auth.data.models.register.RegisterResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthService {
        @POST("api/auth/register")
        Call<RegisterResponseModel> register(
                        @Body RegisterRequestModel registerRequestModel);

        @POST("api/auth/login")
        Call<LoginResponseModel> login(
                        @Body LoginRequestModel loginRequestModel);

        @DELETE("api/auth/logout")
        Call<LogoutResponseModel> logout(
                        @Body LogoutRequestModel logoutRequestModel);

        @POST("api/auth/refresh-token")
        Call<RefreshTokenResponseModel> refreshToken(
                        @Body RefreshTokenRequestModel refreshTokenRequestModel);

        @POST("api/auth/forgot-password")
        Call<ForgotPasswordResponseModel> forgotPassword(
                        @Body ForgotPasswordRequestModel forgotPasswordRequestModel);

}
