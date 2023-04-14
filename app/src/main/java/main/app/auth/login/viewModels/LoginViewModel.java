package main.app.auth.login.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import main.app.auth.login.data.models.ResponseModel;
import main.app.auth.login.data.models.RequestModel;
import main.app.auth.login.data.remote.LoginRepository;

public class LoginViewModel extends ViewModel {
    private LoginRepository loginRepository;
    private LiveData<ResponseModel> userLiveData;

    public LoginViewModel() {
        loginRepository = new LoginRepository();
        userLiveData = loginRepository.getUserLiveData();
    }

    public LiveData<ResponseModel> getUserLiveData() {
        return userLiveData;
    }

    public void login(RequestModel requestModel) {
        loginRepository.login(requestModel);
    }
}
