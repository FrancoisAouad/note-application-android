package main.app.auth.data.api.register;

import main.app.auth.data.models.register.RequestModel;
import main.app.auth.data.models.register.ResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterService {
    @POST("api/auth/register")
    Call<ResponseModel> register(
            @Body RequestModel requestModel
    );
}
