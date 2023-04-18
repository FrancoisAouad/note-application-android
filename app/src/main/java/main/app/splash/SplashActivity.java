package main.app.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

import dagger.hilt.android.AndroidEntryPoint;
import main.app.R;
import main.app.auth.screens.ui.activities.LoginActivity;
import main.app.databinding.ActivitySplashBinding;

@AndroidEntryPoint
public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initSplashAnimation();

    }

    private void initSplashAnimation() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding.logo.setAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_animation));

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, 4500);
    }

}
