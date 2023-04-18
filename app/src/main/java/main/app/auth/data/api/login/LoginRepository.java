package main.app.auth.data.api.login;

import javax.inject.Inject;

import main.app.auth.data.models.login.RequestModel;
import main.app.auth.data.models.login.ResponseModel;
import retrofit2.Call;

public class LoginRepository {
    private final LoginService service;

    @Inject
    public LoginRepository(LoginService loginService) {
        this.service = loginService;
    }

    public Call<ResponseModel> login(RequestModel requestModel) {
        return service.login(requestModel);
    }
}
