package com.example.azmart_android.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.azmart_android.R;
import com.example.azmart_android.view.auth.AuthActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {

            Intent i = new Intent(SplashActivity.this,
                    AuthActivity.class);
            startActivity(i);
            finishAffinity();

        }, SPLASH_SCREEN_TIME_OUT);
    }
}