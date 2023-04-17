package main.app.di;

import android.content.Context;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import main.app.utils.GlobalService;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    public static Retrofit provideRetrofit(@ApplicationContext Context context){
        return new GlobalService().initializeRetrofit(context);
    }
}
