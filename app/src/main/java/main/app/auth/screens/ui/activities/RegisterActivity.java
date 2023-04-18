package main.app.auth.screens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import dagger.hilt.android.AndroidEntryPoint;
import main.app.MainActivity;

import main.app.auth.data.models.register.RegisterRequestModel;
import main.app.auth.screens.viewModels.RegisterViewModel;
import main.app.databinding.ActivityRegisterBinding;

@AndroidEntryPoint
public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
        implementListeners();
        initObservers();

    }

    private void initObservers() {
        registerViewModel.registerResponse.observe(this, userModel -> {
            Toast.makeText(RegisterActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void implementListeners() {
        binding.registerButton.setOnClickListener(v -> {

            final String firstName = binding.firstName.getText().toString();
            final String lastName = binding.lastName.getText().toString();
            final String username = binding.username.getText().toString();
            final String email = binding.email.getText().toString();
            final String password = binding.password.getText().toString();
            final String confirmPassword = binding.confirmPassword.getText().toString();
            RegisterRequestModel registerRequestModel = new RegisterRequestModel(firstName, lastName, username, email, password, confirmPassword);
            registerViewModel.register(registerRequestModel);
        });


        binding.login.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void initViews() {
        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
    }
}