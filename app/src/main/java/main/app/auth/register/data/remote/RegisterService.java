package main.app.auth.register.data.remote;

import main.app.auth.register.data.models.RequestModel;
import main.app.auth.register.data.models.ResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RegisterService {
    @POST("api/auth/register")
    Call<ResponseModel> register(
            @Body RequestModel requestModel
    );
}
