package main.app.auth.login.presentation.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
            RequestModel requestModel = new RequestModel(user, pass);
            loginViewModel.login(requestModel);
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
