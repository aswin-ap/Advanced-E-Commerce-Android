package com.example.azmart_android.view.checkout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.azmart_android.R;
import com.example.azmart_android.adapter.AddressAdapter;
import com.example.azmart_android.contracts.AddressContract;
import com.example.azmart_android.data.model.AddressModel;
import com.example.azmart_android.databinding.FragmentAddressBinding;
import com.example.azmart_android.presenter.AddressPresenter;
import com.example.azmart_android.utils.ConfirmDialog;
import com.example.azmart_android.utils.OnItemClickListener;
import com.example.azmart_android.view.BaseFragment;
import com.example.azmart_android.view.cart.CartFragment;
import com.example.azmart_android.view.product.ProductsFragmentArgs;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class AddressFragment extends BaseFragment implements AddressContract.View, ConfirmDialog.ConfirmCheckoutListener, OnItemClickListener {
    private FragmentAddressBinding binding;
    AddressPresenter addressPresenter;
    AddressAdapter addressAdapter;
    FirebaseUser currentUser;
    ConfirmDialog dialog;
    private int selectedPosition = 0;
    private float totalPrice;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        addressPresenter = new AddressPresenter(this, requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddressBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        totalPrice= AddressFragmentArgs.fromBundle(getArguments()).getTotalPrice();
        initView();
    }

    private void initView() {
        dialog = new ConfirmDialog(requireContext(), this, "Are you sure to proceed to payment ?");
        binding.srfWishlist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.srfWishlist.setRefreshing(false);
            }
        });

        binding.ivBack.setOnClickListener(v -> {
            Navigation.findNavController(requireView()).popBackStack();
        });

        binding.btnAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.action_addressFragment_to_addAddressFragment);
            }
        });
        binding.btnProceedPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        addressPresenter.getAddress(currentUser.getUid());

    }

    @Override
    public void showSuccessResponse(String message) {
        showSnackBar(requireView(), message);
    }

    @Override
    public void showAddressResponse(List<AddressModel> addressModelList) {
        if (addressModelList.size() > 0) {
            addressAdapter = new AddressAdapter(addressModelList, requireContext(), selectedPosition, (OnItemClickListener) this);
            binding.rvAddress.setAdapter(addressAdapter);
            binding.shimmerLayout.setVisibility(View.GONE);
            binding.addressLayout.setVisibility(View.VISIBLE);
            binding.btnProceedPayment.setVisibility(View.VISIBLE);
        } else {
            binding.shimmerLayout.setVisibility(View.GONE);
            binding.addressLayout.setVisibility(View.GONE);
            binding.btnProceedPayment.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLoading() {
        binding.shimmerLayout.setVisibility(View.VISIBLE);
        binding.addressLayout.setVisibility(View.GONE);
        binding.btnProceedPayment.setVisibility(View.GONE);
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
    public void checkOut() {

    }

    @Override
    public void onItemClick(Integer position) {
        Log.d("Click", "onItemClick: ");
        selectedPosition = position;
        addressAdapter.notifyDataSetChanged();
    }

    @Override
    public void navigateToPayment() {
        Navigation.findNavController(requireView()).navigate(AddressFragmentDirections.actionAddressFragmentToPaymentFragment(totalPrice));

    }
}