package main.app.auth.login.data.remote;

import main.app.auth.login.data.models.RequestModel;
import main.app.auth.login.data.models.ResponseModel;
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

