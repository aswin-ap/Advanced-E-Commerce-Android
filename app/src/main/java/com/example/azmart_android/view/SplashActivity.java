package com.example.azmart_android.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.azmart_android.R;
import com.example.azmart_android.data.prefrence.SessionManager;
import com.example.azmart_android.view.auth.AuthActivity;
import com.example.azmart_android.view.home.HomeActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SessionManager sessionManager = new SessionManager(this);
        new Handler().postDelayed(() -> {
            if (sessionManager.isLoggedIn()) {
                Intent i = new Intent(SplashActivity.this,
                        HomeActivity.class);
                startActivity(i);
                finishAffinity();
            } else {
                Intent i = new Intent(SplashActivity.this,
                        HomeActivity.class);
                startActivity(i);
                finishAffinity();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}