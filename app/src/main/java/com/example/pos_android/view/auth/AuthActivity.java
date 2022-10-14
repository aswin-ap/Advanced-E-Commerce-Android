package com.example.pos_android.view.auth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.pos_android.R;
import com.example.pos_android.databinding.ActivityAuthBinding;
import com.google.android.material.tabs.TabLayout;

public class AuthActivity extends AppCompatActivity {
    Fragment currentFragment;
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

        TabLayout.Tab loginTab = binding.tabLayout.newTab();
        loginTab.setText("Login");
        TabLayout.Tab signupTab = binding.tabLayout.newTab();
        signupTab.setText("Sign Up");
        binding.tabLayout.addTab(loginTab);
        binding.tabLayout.addTab(signupTab);
        openFragment(getCurrentFragment(0));

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                currentFragment = null;
                currentFragment = getCurrentFragment(tab.getPosition());
                openFragment(currentFragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    Fragment getCurrentFragment(int position) {
        switch (position) {
            case 0:
                return new LoginFragment();

            case 1:
                return new SignupFragment();

            default:
                return null;

        }
    }

    private void openFragment(final Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}