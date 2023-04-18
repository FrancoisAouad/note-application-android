package main.app.auth.register.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import main.app.auth.register.data.models.ResponseModel;
import main.app.auth.register.data.models.RequestModel;
import main.app.auth.register.data.remote.RegisterRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class RegisterViewModel extends ViewModel {
    private final RegisterRepository registerRepository;

    @Inject
    public RegisterViewModel(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public MutableLiveData<ResponseModel> result = new MutableLiveData<>();

    public void register(RequestModel requestModel){
        registerRepository.registerUser(requestModel).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful())
                    result.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }


}
