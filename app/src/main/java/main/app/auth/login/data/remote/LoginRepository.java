package main.app.auth.login.data.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import main.app.auth.login.data.models.RequestModel;
import main.app.auth.login.data.models.ResponseModel;
import main.app.utils.GlobalService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginRepository {
    private MutableLiveData<ResponseModel> userMutableLiveData;
    private GlobalService globalService;

    public LoginRepository() {
        userMutableLiveData = new MutableLiveData<>();
        globalService = new GlobalService();
    }

    public LiveData<ResponseModel> getUserLiveData() {
        return userMutableLiveData;
    }

    public void login(RequestModel requestModel) {
        Retrofit retrofit = globalService.initializeRetrofit();
        LoginService loginService = retrofit.create(LoginService.class);
        Call<ResponseModel> call = loginService.login(requestModel);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (!response.isSuccessful()) {
                    try {
                        String errorMessage = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorMessage);
                        String message = jsonObject.getString("message");
                        int statusCode = jsonObject.getInt("statusCode");
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }
                Gson gson = new GsonBuilder().create();
                ResponseModel user = gson.fromJson(response.body().toString(), ResponseModel.class);
                userMutableLiveData.postValue(user);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
            }
        });
    }
}
