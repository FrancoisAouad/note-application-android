package main.app.auth.login.data.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import main.app.auth.login.data.models.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {
    private MutableLiveData<UserModel> userMutableLiveData;

    public UserRepository() {
        userMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<UserModel> getUserLiveData() {
        return userMutableLiveData;
    }

    public void login(LoginRequest loginRequest) {
        System.out.println("username: " + loginRequest.username + " password: " + loginRequest.password);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.59.1:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService userService = retrofit.create(UserService.class);

        Call<UserModel> call = userService.login(loginRequest);
        System.out.println("API RESPONSE" + call);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                System.out.println("RESPONSE ->");
                System.out.println(call);
                System.out.println(response);
                System.out.println(response.message());
                System.out.println(response.body());
                if (response.isSuccessful()) {
                    Gson gson = new GsonBuilder().create();
                    UserModel user = gson.fromJson(response.body().toString(), UserModel.class);
                    System.out.println("SUCCESS");
                    System.out.println("RESPONSE BODY IS " + user.getAccessToken());
                    // UserModel user = response.body();
                    System.out.println("RESPONSE BODY IS" + user.toString());
                    userMutableLiveData.postValue(user);

                } else {
                    System.out.println("FAILLEEEEDDDD");
                    try {
                        String errorMessage = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorMessage);
                        String message = jsonObject.getString("message");
                        int statusCode = jsonObject.getInt("statusCode");
                        // handle error
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                System.out.println("On Failure message caught: " + t + "Call: " + call);
            }
        });
    }

    public void register() {
    }

}
