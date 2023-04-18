package main.app.auth.screens.viewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import main.app.auth.data.models.login.ResponseModel;
import main.app.auth.data.models.login.RequestModel;
import main.app.auth.data.api.login.LoginRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class LoginViewModel extends ViewModel {
    private final LoginRepository loginRepository;
    public MutableLiveData<ResponseModel> loginResponse = new MutableLiveData<>();

    @Inject
    public LoginViewModel(LoginRepository repository) {
        this.loginRepository = repository;
    }

    public void login(RequestModel requestModel) {
        loginRepository.login(requestModel).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful()) {
                    Log.e("TEST", "" + response.body());
                    System.out.println("SUCCESS");
                    loginResponse.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}
