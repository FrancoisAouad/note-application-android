package main.app.auth.register.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import main.app.auth.register.data.models.ResponseModel;
import main.app.auth.register.data.models.RequestModel;
import main.app.auth.register.data.remote.RegisterRepository;

public class RegisterViewModel extends ViewModel {
    private RegisterRepository registerRepository;
    private LiveData<ResponseModel> userLiveData;

    public RegisterViewModel() {
        registerRepository = new RegisterRepository();
        userLiveData = registerRepository.getUserLiveData();
    }

    public LiveData<ResponseModel> getUserLiveData() {
        return userLiveData;
    }

    public void register(RequestModel requestModel) {
        registerRepository.register(requestModel);
    }
}
