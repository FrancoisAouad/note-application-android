package main.app.auth.modules;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import main.app.auth.data.api.register.RegisterService;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class RegisterModule {
    @Provides
    public static RegisterService provideRegistrationService(Retrofit retrofit){
        return retrofit.create(RegisterService.class);
    }
}
