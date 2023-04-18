package main.app.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    public static Retrofit provideRetrofit(@ApplicationContext Context context){
        return new Retrofit.Builder()
                .baseUrl("http://192.168.59.1:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
