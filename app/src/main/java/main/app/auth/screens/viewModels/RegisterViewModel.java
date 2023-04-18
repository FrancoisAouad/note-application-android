package main.app.auth.screens.viewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import main.app.auth.data.api.AuthRepository;
import main.app.auth.data.models.register.RegisterRequestModel;
import main.app.auth.data.models.register.RegisterResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class RegisterViewModel extends ViewModel {
    private final AuthRepository authRepository;

    @Inject
    public RegisterViewModel(AuthRepository repository) {
        this.authRepository = repository;
    }

    public MutableLiveData<RegisterResponseModel> registerResponse = new MutableLiveData<>();

    public void register(RegisterRequestModel registerRequestModel) {

        authRepository.registerUser(registerRequestModel).enqueue(new Callback<RegisterResponseModel>() {
            @Override
            public void onResponse(Call<RegisterResponseModel> call, Response<RegisterResponseModel> response) {
                if (response.isSuccessful())
                    Log.e("Register ViewModel", "SUCCESS: " + response.body());
                registerResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RegisterResponseModel> call, Throwable t) {

            }
        });
    }


}
