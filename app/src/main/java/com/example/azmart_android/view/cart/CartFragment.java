package com.example.azmart_android.view.cart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.azmart_android.adapter.CartAdapter;
import com.example.azmart_android.contracts.CartContract;
import com.example.azmart_android.data.model.CartModel;
import com.example.azmart_android.databinding.FragmentCartBinding;
import com.example.azmart_android.presenter.CartPresenter;
import com.example.azmart_android.utils.ConfirmDialog;
import com.example.azmart_android.view.BaseFragment;
import com.example.azmart_android.view.Payment.PaymentActivity;
import com.example.azmart_android.view.home.HomeActivity;
import com.example.azmart_android.view.home.HomeFragmentDirections;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends BaseFragment implements CartAdapter.onCartItemClickListener, ConfirmDialog.ConfirmCheckoutListener, CartContract.View {
    FirebaseUser currentUser;
    private FragmentCartBinding binding;
    private CartAdapter cartAdapter;
    private CartPresenter presenter;
    private ArrayList<CartModel> cartModelArrayList = new ArrayList<>();
    private float total = 0;
    private String formattedString;
    private ConfirmDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCartBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }


    private void initView() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        presenter = new CartPresenter(this, requireContext());
        dialog = new ConfirmDialog(requireContext(), this, "Are you sure to proceed to payment ?");
        presenter.getCart(currentUser.getUid());

        setupCartRecyclerView();

        binding.srfCart.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getCart(currentUser.getUid());
                binding.srfCart.setRefreshing(false);
            }
        });

        binding.placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    private void setupCartRecyclerView() {
        cartAdapter = new CartAdapter(requireContext(), cartModelArrayList, this);
        binding.rvCart.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvCart.setHasFixedSize(true);
        binding.rvCart.setAdapter(cartAdapter);
    }

    @Override
    public void onQuantityAdd(int position) {
        CartModel model = cartModelArrayList.get(position);
        model.setQuantity(model.getQuantity() + 1);
        cartAdapter.notifyDataSetChanged();
        setGrandTotal();
    }

    @Override
    public void onQuantitySub(int position) {
        CartModel model = cartModelArrayList.get(position);
        model.setQuantity(model.getQuantity() - 1);
        cartAdapter.notifyDataSetChanged();
        setGrandTotal();
    }

    @Override
    public void onDeleteItem(int position) {
        CartModel model = cartModelArrayList.get(position);
        presenter.deleteProductFromCart(model.getUserId(), model.getId());
    }

    private void setGrandTotal() {
        total = 0;
        for (int i = 0; i < cartModelArrayList.size(); i++) {
            for (int j = 1; j <= cartModelArrayList.get(i).getQuantity(); j++) {
                total += Float.parseFloat(cartModelArrayList.get(i).getPrice());
            }
        }
        formattedString = String.format("%.02f", total);
        binding.textTotal.setText("$" + formattedString);
    }

    @Override
    public void checkOut() {

    }

    @Override
    public void showLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.VISIBLE);
        binding.cartLayout.setVisibility(View.GONE);
        binding.layoutTotal.setVisibility(View.GONE);
        binding.totalMargin.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);

    }

    @Override
    public void showApiErrorWarning(String string) {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        showToast(requireActivity(), string);
    }

    @Override
    public void showCartList(List<CartModel> cartModelList) {
        if (cartModelList.size() > 0) {
            cartModelArrayList.addAll(cartModelList);
            cartAdapter.notifyDataSetChanged();
            setGrandTotal();
            binding.cartLayout.setVisibility(View.VISIBLE);
            binding.layoutTotal.setVisibility(View.VISIBLE);
            binding.totalMargin.setVisibility(View.VISIBLE);
            //  binding.tvNoData.setVisibility(View.GONE);
            //TODO Handle the no data of cart
        } else {
            binding.cartLayout.setVisibility(View.GONE);
            binding.layoutTotal.setVisibility(View.GONE);
            binding.totalMargin.setVisibility(View.GONE);
            showToast(requireContext(), "No items");
            //  binding.tvNoData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showDeleteResponse(String message) {
        showSnackBar(requireView(), message);
        presenter.getCart(currentUser.getUid());
    }

    @Override
    public void showLoadingDialog() {
        showLoadingDialog(requireContext());
    }

    @Override
    public void hideLoadingDialogue() {
        super.hideLoadingDialog();
    }

    public void navigateToPayment() {
        Intent intent = new Intent(requireContext(), PaymentActivity.class);
        intent.putExtra("total",total);
        startActivity(intent);
//        Navigation.findNavController(requireView()).navigate(CartFragmentDirections.actionCartFragmentToPaymentFragment(total));

    }

}