package com.example.azmart_android.view.home;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.azmart_android.R;
import com.example.azmart_android.contracts.WishlistContract;
import com.example.azmart_android.databinding.FragmentCategoryBinding;
import com.example.azmart_android.databinding.FragmentWishlistBinding;
import com.example.azmart_android.presenter.WishlistPresenter;
import com.example.azmart_android.utils.NetworkManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class WishlistFragment extends Fragment implements WishlistContract.View {

    FirebaseUser currentUser;
    private WishlistPresenter presenter;
    private FragmentWishlistBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new WishlistPresenter(this);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWishlistBinding.inflate(inflater, container, false);
        binding.srfWishlist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                binding.srfWishlist.setRefreshing(false);
            }
        });
        initView();
        return binding.getRoot();
    }

    private void initView() {
        if (NetworkManager.isNetworkAvailable(requireContext())) {
            binding.tvNetworkWorning.setVisibility(View.GONE);
            presenter.getProductsFromWishlist(currentUser.getUid());
        } else{
            binding.tvNetworkWorning.setVisibility(View.VISIBLE);
            binding.rvWishlist.setVisibility(View.GONE);
        }

    }

    @Override
    public void showLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.VISIBLE);
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
    public void showWishlistProducts(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}