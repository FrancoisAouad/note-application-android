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
import main.app.auth.login.data.remote.LoginRequest;
import main.app.auth.login.viewModels.UserViewModel;

public class LoginActivity extends AppCompatActivity {
    UserViewModel userViewModel;
    EditText username, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUserLiveData().observe(this, userModel -> {
            // Handle success scenario - save the user data and navigate to the next screen
            // for example, you could save the tokens to SharedPreferences and navigate to the HomeActivity
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        loginButton.setOnClickListener(v -> {
            final String user = username.getText().toString();
            final String pass = password.getText().toString();
            LoginRequest loginRequest = new LoginRequest(user, pass);
            userViewModel.login(loginRequest);
        });
    }
}
