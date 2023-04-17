package main.app.auth.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import main.app.MainActivity;
import main.app.R;
import main.app.auth.login.data.models.RequestModel;
import main.app.auth.login.viewModels.LoginViewModel;
import main.app.auth.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {
    LoginViewModel loginViewModel;
    EditText username, password;
    Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getUserLiveData().observe(this, userModel -> {
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        loginButton.setOnClickListener(v -> {
            final String user = username.getText().toString();
            final String pass = password.getText().toString();
            RequestModel requestModel = new RequestModel(user, pass);
            loginViewModel.login(requestModel);
        });

        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
