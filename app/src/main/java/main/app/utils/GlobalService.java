package main.app.utils;


import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GlobalService {
    public Retrofit initializeRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://192.168.59.1:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static <T> void makeApiCall(Call<T> call, MutableLiveData<T> liveData) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    T data = response.body();
                    liveData.postValue(data);
                } else {
                    try {
                        String errorMessage = response.errorBody().toString();
                        JSONObject jsonObject = new JSONObject(errorMessage);
                        String message = jsonObject.getString("message");
                        int statusCode = jsonObject.getInt("statusCode");
                        // handle error
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
};

