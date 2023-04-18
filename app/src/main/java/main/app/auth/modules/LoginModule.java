package main.app.auth.modules;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import main.app.auth.data.api.login.LoginService;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class LoginModule {
    @Provides
    public static LoginService provideLoginService(Retrofit retrofit){
        return retrofit.create(LoginService.class);
    }
}
