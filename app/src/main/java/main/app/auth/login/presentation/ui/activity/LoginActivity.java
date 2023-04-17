package main.app.auth.login.presentation.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import main.app.MainActivity;
import main.app.R;
import main.app.auth.login.data.models.RequestModel;
import main.app.auth.login.data.models.ResponseModel;
import main.app.auth.login.data.remote.LoginService;
import main.app.auth.login.presentation.viewmodels.LoginViewModel;
import main.app.auth.register.RegisterActivity;
import main.app.databinding.ActivityLoginBinding;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    @Inject
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel.login(new RequestModel("", ""));
        loginViewModel.loginResponse.observe(this, responseModel -> {
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        binding.loginButton.setOnClickListener(v -> {
            final String user = binding.username.getText().toString();
            final String pass = binding.password.getText().toString();
            RequestModel requestModel = new RequestModel(user, pass);
            loginViewModel.login(requestModel);
        });

        binding.registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
