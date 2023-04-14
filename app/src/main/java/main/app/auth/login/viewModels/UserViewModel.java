package main.app.auth.login.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import main.app.auth.login.data.models.UserModel;
import main.app.auth.login.data.remote.LoginRequest;
import main.app.auth.login.data.remote.UserRepository;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    private LiveData<UserModel> userLiveData;

    public UserViewModel() {
        userRepository = new UserRepository();
        userLiveData = userRepository.getUserLiveData();
    }

    public LiveData<UserModel> getUserLiveData() {
        return userLiveData;
    }

    public void login(LoginRequest loginRequest) {
        userRepository.login(loginRequest);
    }
}
