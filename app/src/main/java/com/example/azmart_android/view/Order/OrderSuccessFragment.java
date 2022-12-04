package com.example.azmart_android.view.Order;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.azmart_android.R;
import com.example.azmart_android.contracts.OrderContract;
import com.example.azmart_android.contracts.OrderHistoryContract;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.databinding.FragmentOrderSuccessBinding;
import com.example.azmart_android.presenter.OrderHistoryPresenter;
import com.example.azmart_android.presenter.OrderPresenter;
import com.example.azmart_android.utils.NetworkManager;
import com.example.azmart_android.view.BaseFragment;
import com.example.azmart_android.view.SplashActivity;
import com.example.azmart_android.view.auth.AuthActivity;
import com.example.azmart_android.view.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OrderSuccessFragment extends BaseFragment implements OrderContract.View {

    private FragmentOrderSuccessBinding binding;
    private OrderPresenter orderPresenter;
    FirebaseUser currentUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentOrderSuccessBinding.inflate(inflater,container,false);
        initView();

        return binding.getRoot();
    }

    private void initView() {
//        FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        currentUser = mAuth.getCurrentUser();
//        orderPresenter=new OrderPresenter(this,requireContext());
//        if (NetworkManager.isNetworkAvailable(requireContext())) {
//            orderPresenter.saveOrder(currentUser.getUid());
//        } else{
//            Toast.makeText(requireContext(), "Your in offline", Toast.LENGTH_SHORT).show();
//        }
        showLoading();
        new Handler().postDelayed(() -> {
            hideLoading();

        }, 4000);
        binding.tvGotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Home", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.VISIBLE);
        binding.llOrderPlaced.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.llOrderPlaced.setVisibility(View.VISIBLE);
        binding.ltOrderPacedMessage.playAnimation();
    }

    @Override
    public void showApiErrorWarning(String string) {

    }


    @Override
    public void showSaveOrdeeResponse(String message) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void hideLoadingDialogue() {

    }
}