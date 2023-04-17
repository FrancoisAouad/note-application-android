package main.app.auth.login.data.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;

import main.app.auth.login.data.models.RequestModel;
import main.app.auth.login.data.models.ResponseModel;
import main.app.utils.GlobalService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginRepository {
    private LoginService service;

    @Inject
    public LoginRepository(LoginService loginService) {
        this.service = loginService;
    }

    public Call<ResponseModel> login(RequestModel requestModel){
        return service.login(requestModel);
    }


}
