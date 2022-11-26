package com.example.azmart_android.view.Payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.azmart_android.R;
import com.example.azmart_android.databinding.ActivityPaymentBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PaymentActivity extends AppCompatActivity {

    private ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }


    private void initView() {
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(getResources().getColor(R.color.green_500));

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerViewPayment);
        NavController navController = navHostFragment.getNavController();




    }
}