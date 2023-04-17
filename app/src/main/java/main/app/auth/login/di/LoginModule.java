package main.app.auth.login.di;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import main.app.auth.login.data.remote.LoginService;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class LoginModule {
    public static LoginService provideLoginService(Retrofit retrofit){
        return retrofit.create(LoginService.class);
    }

}
