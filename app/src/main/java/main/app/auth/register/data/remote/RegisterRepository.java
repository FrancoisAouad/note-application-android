package main.app.auth.register.data.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;

import main.app.auth.register.data.models.RequestModel;
import main.app.auth.register.data.models.ResponseModel;
import main.app.utils.GlobalService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterRepository {
    private MutableLiveData<ResponseModel> userMutableLiveData;
    private GlobalService globalService;

    public RegisterRepository() {
        userMutableLiveData = new MutableLiveData<>();
        globalService = new GlobalService();

    }

    public LiveData<ResponseModel> getUserLiveData() {
        return userMutableLiveData;
    }

    public void register(RequestModel requestModel) {
        Retrofit retrofit = globalService.initializeRetrofit();
        RegisterService registerService = retrofit.create(RegisterService.class);
        Call<ResponseModel> call = registerService.register(requestModel);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (!response.isSuccessful()) {
                    try {
                        String errorMessage = response.errorBody().toString();
                        JSONObject jsonObject = new JSONObject(errorMessage);
                        String message = jsonObject.getString("message");
                        int statusCode = jsonObject.getInt("statusCode");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                ResponseModel user = response.body();
                userMutableLiveData.postValue(user);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}

