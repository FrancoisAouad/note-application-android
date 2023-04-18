package main.app.auth.screens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import dagger.hilt.android.AndroidEntryPoint;
import main.app.MainActivity;
//import main.app.auth.data.models.login.LoginRequestModel;
//import main.app.auth.data.models.login.RequestModel;
import main.app.auth.data.models.login.LoginRequestModel;
import main.app.auth.screens.viewModels.LoginViewModel;
import main.app.databinding.ActivityLoginBinding;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    LoginViewModel loginViewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
        implementListeners();
        initObservers();

    }

    private void initObservers() {

        loginViewModel.loginResponse.observe(this, responseModel -> {
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void implementListeners() {
        binding.loginButton.setOnClickListener(v -> {
            final String user = binding.username.getText().toString().trim();
            final String pass = binding.password.getText().toString().trim();
            LoginRequestModel loginRequestModel = new LoginRequestModel(user, pass);
            loginViewModel.login(loginRequestModel);
        });

        binding.registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private void initViews() {
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }
}
