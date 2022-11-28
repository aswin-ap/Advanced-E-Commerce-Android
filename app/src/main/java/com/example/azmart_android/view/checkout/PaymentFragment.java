package com.example.azmart_android.view.checkout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.azmart_android.R;
import com.example.azmart_android.adapter.AddressAdapter;
import com.example.azmart_android.adapter.CardAdapter;
import com.example.azmart_android.contracts.CardContract;
import com.example.azmart_android.contracts.PaymentContract;
import com.example.azmart_android.data.model.CardsModel;
import com.example.azmart_android.databinding.FragmentCartBinding;
import com.example.azmart_android.databinding.FragmentPaymentBinding;
import com.example.azmart_android.presenter.AddressPresenter;
import com.example.azmart_android.presenter.CardPresenter;
import com.example.azmart_android.utils.ConfirmDialog;
import com.example.azmart_android.utils.OnItemClickListener;
import com.example.azmart_android.view.BaseFragment;
import com.example.azmart_android.view.SplashActivity;
import com.example.azmart_android.view.auth.AuthActivity;
import com.example.azmart_android.view.home.HomeActivity;
import com.example.azmart_android.view.product.ProductDetailFragmentArgs;
import com.example.azmart_android.view.product.ProductsFragmentArgs;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


public class PaymentFragment extends BaseFragment implements CardContract.View ,  ConfirmDialog.ConfirmCheckoutListener, OnItemClickListener{

    private FragmentPaymentBinding binding;
    private String formattedString;
    public float totalPrice;
    FirebaseUser currentUser;
    ConfirmDialog dialog;
    private CardPresenter cardPresenter;
    private CardAdapter cardAdapter;
    private int selectedPosition = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        cardPresenter = new CardPresenter(this, requireContext());

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
        dialog = new ConfirmDialog(requireContext(), this, "Are you sure to proceed to payment ?");
//        binding.srfWishlist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                binding.srfWishlist.setRefreshing(false);
//            }
//        });

        binding.ivBack.setOnClickListener(v -> {
            Navigation.findNavController(requireView()).popBackStack();
        });

//        binding.shimmerLayout.setVisibility(View.VISIBLE);
//        binding.llPayament.setVisibility(View.GONE);
//        binding.llAddNewCard.setVisibility(View.GONE);
//        binding.llPayLayout.setVisibility(View.GONE);

//            float total = getActivity().getIntent().getFloatExtra("total",0.0F);
//            formattedString = String.format("%.02f", total);
//            binding.btnProceedPayment.setText(formattedString+"-"+"Proceed to Payment");
//            binding.shimmerLayout.setVisibility(View.GONE);


        binding.rbCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.llCardDetails.setVisibility(View.VISIBLE);
                binding.btnAddCard.setVisibility(View.VISIBLE);
                binding.llExistNewCard.setVisibility(View.VISIBLE);
                binding.llAddNewCard.setVisibility(View.VISIBLE);
                binding.rbCash.setChecked(false);
            }
        });

        binding.btnAddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.action_paymentFragment_to_addPaymentFragment);

            }
        });

        binding.btnProceedPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        binding.rbCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.llCardDetails.setVisibility(View.GONE);
                binding.rbCard.setChecked(false);
            }
        });

        cardPresenter.getCard(currentUser.getUid());

    }

    @Override
    public void showLoading() {
        binding.shimmerLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.shimmerLayout.setVisibility(View.GONE);
    }

    @Override
    public void showApiErrorWarning(String string) {
        binding.shimmerLayout.setVisibility(View.GONE);
        showToast(requireContext(), string);
    }


    @Override
    public void showSuccessResponse(String message) {
        showSnackBar(requireView(), message);
    }

    @Override
    public void showCardResponse(List<CardsModel> cardModelList) {
        if (cardModelList.size() > 0) {
            for (CardsModel cardsModel:cardModelList) {
                Log.e("name11100000",cardsModel.getCardHolderName()+"999999");
                Log.e("name11100000",cardsModel.getCardNumber()+"8888");
                Log.e("name11100000",cardsModel.getCardType()+"7777");
                Log.e("name11100000",cardsModel.getCvv()+"66666");
            }
            Log.e("length", String.valueOf(cardModelList.size()));
            cardAdapter = new CardAdapter(cardModelList, requireContext(), selectedPosition, this);
            binding.rvCardList.setAdapter(cardAdapter);
            binding.shimmerLayout.setVisibility(View.GONE);
            binding.llCardDetails.setVisibility(View.VISIBLE);
            binding.btnAddCard.setVisibility(View.VISIBLE);
            binding.llExistNewCard.setVisibility(View.VISIBLE);
            binding.llAddNewCard.setVisibility(View.VISIBLE);
            binding.llPayament.setVisibility(View.VISIBLE);
            binding.llPayLayout.setVisibility(View.VISIBLE);
        } else {
            binding.shimmerLayout.setVisibility(View.GONE);
            binding.llCardDetails.setVisibility(View.VISIBLE);
            binding.btnAddCard.setVisibility(View.VISIBLE);
            binding.llExistNewCard.setVisibility(View.VISIBLE);
            binding.llAddNewCard.setVisibility(View.VISIBLE);
            binding.llPayament.setVisibility(View.VISIBLE);
            binding.llPayLayout.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void checkOut() {

    }

    @Override
    public void navigateToPayment() {

    }

    @Override
    public void onItemClick(Integer position) {

    }
}