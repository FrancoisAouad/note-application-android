package main.app.auth.register.data.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import main.app.auth.register.data.models.RequestModel;
import main.app.auth.register.data.models.ResponseModel;
import retrofit2.Call;

public class RegisterRepository {

    private final RegisterService registerService;

    @Inject
    public RegisterRepository(RegisterService registerService) {
        this.registerService = registerService;
    }
    public Call<ResponseModel> registerUser(RequestModel requestModel){
        return registerService.register(requestModel);
    }
}

