package main.app.auth.data.api.login;

import main.app.auth.data.models.login.RequestModel;
import main.app.auth.data.models.login.ResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {
    @Headers("Content-Type: application/json")
    @POST("api/auth/login")
    Call<ResponseModel> login(
            @Body RequestModel requestModel
    );
}

