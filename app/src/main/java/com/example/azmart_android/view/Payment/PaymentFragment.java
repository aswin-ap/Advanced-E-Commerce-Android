package com.example.azmart_android.view.Payment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.azmart_android.R;
import com.example.azmart_android.contracts.PaymentContract;
import com.example.azmart_android.databinding.FragmentCartBinding;
import com.example.azmart_android.databinding.FragmentPaymentBinding;
import com.example.azmart_android.view.SplashActivity;
import com.example.azmart_android.view.auth.AuthActivity;
import com.example.azmart_android.view.home.HomeActivity;
import com.example.azmart_android.view.product.ProductDetailFragmentArgs;
import com.example.azmart_android.view.product.ProductsFragmentArgs;


public class PaymentFragment extends Fragment implements PaymentContract.View {

    private FragmentPaymentBinding binding;
    private String formattedString;
    public float totalPrice;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPaymentBinding.inflate(inflater, container, false);
        showLoading();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        new Handler().postDelayed(() -> {
            float total = getActivity().getIntent().getFloatExtra("total",0.0F);
            formattedString = String.format("%.02f", total);

            hideLoading();
        }, 4000);


        binding.rbCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.llCardDetailPage.setVisibility(View.GONE);
                binding.llCardDetails.setVisibility(View.VISIBLE);
                binding.llAddNewCard.setVisibility(View.VISIBLE);
                binding.llExistNewCard.setVisibility(View.VISIBLE);
                binding.rbCash.setChecked(false);
            }
        });

        binding.llAddNewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.llExistNewCard.setVisibility(View.GONE);
                binding.llCardDetailPage.setVisibility(View.VISIBLE);
            }
        });

        binding.ivCardDtailsClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.llExistNewCard.setVisibility(View.VISIBLE);
                binding.llCardDetailPage.setVisibility(View.GONE);
            }
        });

        binding.rbCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.llCardDetails.setVisibility(View.GONE);
                binding.rbCard.setChecked(false);
            }
        });

    }

    @Override
    public void showLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.tvResults.setVisibility(View.VISIBLE);
    }

    @Override
    public void showApiErrorWarning(String string) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void hideLoadingDialogue() {

    }
}