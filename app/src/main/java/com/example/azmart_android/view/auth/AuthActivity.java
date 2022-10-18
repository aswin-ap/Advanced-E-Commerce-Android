package com.example.azmart_android.view.auth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.azmart_android.adapter.MyViewPagerAdapter;
import com.example.azmart_android.databinding.ActivityAuthBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class AuthActivity extends AppCompatActivity {
    private ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        getSupportActionBar().hide();

        FragmentStateAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        binding.viewPager.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, true, (tab, position) -> {
            if (position == 0)
                tab.setText("Login");
            else
                tab.setText("Sign Up");
        }).attach();
    }
}