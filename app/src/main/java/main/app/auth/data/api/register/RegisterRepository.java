package main.app.auth.data.api.register;

import javax.inject.Inject;

import main.app.auth.data.models.register.RequestModel;
import main.app.auth.data.models.register.ResponseModel;
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

