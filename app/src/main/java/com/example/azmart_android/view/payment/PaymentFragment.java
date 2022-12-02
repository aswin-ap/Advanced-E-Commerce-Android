package com.example.azmart_android.view.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.azmart_android.R;
import com.example.azmart_android.adapter.CardAdapter;
import com.example.azmart_android.contracts.CardContract;
import com.example.azmart_android.data.model.CardsModel;
import com.example.azmart_android.databinding.FragmentPaymentBinding;
import com.example.azmart_android.presenter.CardPresenter;
import com.example.azmart_android.utils.OnItemClickListener;
import com.example.azmart_android.view.BaseFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


public class PaymentFragment extends BaseFragment implements CardContract.View, OnItemClickListener {

    private final int selectedPosition = 0;
    public float totalPrice;
    FirebaseUser currentUser;
    private FragmentPaymentBinding binding;
    private CardPresenter cardPresenter;
    private CardAdapter cardAdapter;

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
        totalPrice = PaymentFragmentArgs.fromBundle(getArguments()).getTotalPrice();
        binding.btnProceedPayment.setText("Pay $" + " " + totalPrice);
//        binding.srfWishlist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                binding.srfWishlist.setRefreshing(false);
//            }
//        });

        binding.ivBack.setOnClickListener(v -> {
            Navigation.findNavController(requireView()).popBackStack();
        });

        binding.shimmerLayout.setVisibility(View.VISIBLE);
        binding.rbCard.setChecked(false);
        binding.rbCash.setChecked(false);

        binding.rbCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.llCardDetails.setVisibility(View.VISIBLE);
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
                cardPresenter.authenticate();
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
        binding.rbCard.setChecked(false);
        binding.rbCash.setChecked(false);
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
    public void showAuthenticationWarning(String message) {
        showSnackBar(requireView(), message);
    }

    @Override
    public void showCardResponse(List<CardsModel> cardModelList) {
        if (cardModelList.size() > 0) {
            cardAdapter = new CardAdapter(cardModelList, requireContext(), selectedPosition, this);
            binding.rvCardList.setAdapter(cardAdapter);
            binding.shimmerLayout.setVisibility(View.GONE);
            binding.llPayament.setVisibility(View.VISIBLE);
            binding.btnProceedPayment.setVisibility(View.VISIBLE);
        } else {
            binding.shimmerLayout.setVisibility(View.GONE);
            binding.llPayament.setVisibility(View.VISIBLE);
            binding.btnProceedPayment.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onItemClick(Integer position) {
        cardAdapter.updatePosition(position);
        cardAdapter.notifyDataSetChanged();
    }
}