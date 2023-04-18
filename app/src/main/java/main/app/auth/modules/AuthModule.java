package main.app.auth.modules;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import main.app.auth.data.api.AuthService;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class AuthModule {
    @Provides
    public static AuthService provideLoginService(Retrofit retrofit) {
        return retrofit.create(AuthService.class);
    }
}
