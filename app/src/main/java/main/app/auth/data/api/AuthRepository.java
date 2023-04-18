package main.app.auth.data.api;

import javax.inject.Inject;

import main.app.auth.data.models.login.LoginRequestModel;
import main.app.auth.data.models.login.LoginResponseModel;
import main.app.auth.data.models.register.RegisterRequestModel;
import main.app.auth.data.models.register.RegisterResponseModel;
import retrofit2.Call;

public class AuthRepository {
    private final AuthService authService;

    @Inject
    public AuthRepository(AuthService authService) {
        this.authService = authService;
    }

    public Call<LoginResponseModel> loginUser(LoginRequestModel loginRequestModel) {
        return authService.login(loginRequestModel);
    }

    public Call<RegisterResponseModel> registerUser(RegisterRequestModel registerRequestModel) {
        return authService.register(registerRequestModel);
    }


}
