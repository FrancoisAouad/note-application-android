package main.app.auth.screens.viewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import main.app.auth.data.api.AuthRepository;
import main.app.auth.data.models.login.LoginRequestModel;
import main.app.auth.data.models.login.LoginResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class LoginViewModel extends ViewModel {
    private final AuthRepository authRepository;
    public MutableLiveData<LoginResponseModel> loginResponse = new MutableLiveData<>();

    @Inject
    public LoginViewModel(AuthRepository repository) {
        this.authRepository = repository;
    }

    public void login(LoginRequestModel loginRequestModel) {
        authRepository.loginUser(loginRequestModel).enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                if (response.isSuccessful()) {
                    Log.e("Login ViewModel", "SUCCESS");
                    loginResponse.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                Log.e("LoginVM", "FAILED /auth/api");
            }
        });
    }
}
