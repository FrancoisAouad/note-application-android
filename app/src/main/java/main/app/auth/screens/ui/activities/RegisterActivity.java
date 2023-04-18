package main.app.auth.screens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dagger.hilt.android.AndroidEntryPoint;
import main.app.MainActivity;
import main.app.R;
import main.app.auth.data.models.register.RequestModel;
import main.app.auth.screens.viewModels.RegisterViewModel;
import main.app.utils.Prefs;

@AndroidEntryPoint
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterViewModel registerViewModel;
        EditText firstName, lastName, username, email, password, confirmPassword;
        TextView login;
        Button registerButton;

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        registerButton = findViewById(R.id.registerButton);
        login = findViewById(R.id.login);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        registerViewModel.result.observe(this, userModel -> {
            Prefs.loadPrefs(this).saveString(Prefs.PREF_ACCESS_TOKEN,userModel.getAccessToken());
            Toast.makeText(RegisterActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        registerButton.setOnClickListener(v -> {
            final String first = firstName.getText().toString();
            final String last = lastName.getText().toString();
            final String user = username.getText().toString();
            final String emai = email.getText().toString();
            final String pass = password.getText().toString();
            final String confirm = confirmPassword.getText().toString();
            RequestModel requestModel = new RequestModel(first, last, user, emai, pass, confirm);
            registerViewModel.register(requestModel);
//            registerViewModel.register(requestModel);
        });

        login.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });

    }
}