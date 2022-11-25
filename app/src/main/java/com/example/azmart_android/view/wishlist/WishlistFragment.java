package com.example.azmart_android.view.wishlist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.azmart_android.adapter.WishlistAdapter;
import com.example.azmart_android.contracts.WishlistContract;
import com.example.azmart_android.data.model.WishListModel;
import com.example.azmart_android.databinding.FragmentWishlistBinding;
import com.example.azmart_android.presenter.WishlistPresenter;
import com.example.azmart_android.utils.NetworkManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


public class WishlistFragment extends Fragment implements WishlistContract.View {
    FirebaseUser currentUser;
    private WishlistPresenter presenter;
    private FragmentWishlistBinding binding;
    private WishlistAdapter wishlistAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new WishlistPresenter(this);
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
        binding.rvWishlist.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvWishlist.setHasFixedSize(true);

        if (NetworkManager.isNetworkAvailable(requireContext())) {
            binding.tvNetworkWorning.setVisibility(View.GONE);
            presenter.getProductsFromWishlist(currentUser.getUid());
        } else {
            binding.tvNetworkWorning.setVisibility(View.VISIBLE);
            binding.rvWishlist.setVisibility(View.GONE);
        }

    }

    @Override
    public void showLoading() {
        binding.shimmerLayout.setVisibility(View.VISIBLE);
        binding.rvWishlist.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        binding.shimmerLayout.setVisibility(View.GONE);
    }

    @Override
    public void showApiErrorWarning(String string) {
        binding.shimmerLayout.setVisibility(View.GONE);
        showToast(requireActivity(), string);
    }

    @Override
    public void showWishlistProducts(List<WishListModel> modelList) {
        if (modelList.size() > 0) {
            wishlistAdapter = new WishlistAdapter(modelList, position -> {
                Navigation.findNavController(requireView()).navigate(WishlistFragmentDirections.actionWishlistFragmentToProductFragment(
                        modelList.get(position).getId(), modelList.get(position).getTitle()
                ));
            });
            binding.rvWishlist.setAdapter(wishlistAdapter);
            binding.rvWishlist.setVisibility(View.VISIBLE);
            binding.shimmerLayout.setVisibility(View.GONE);
            binding.tvNoData.setVisibility(View.GONE);

        } else {
            binding.shimmerLayout.setVisibility(View.GONE);
            binding.rvWishlist.setVisibility(View.GONE);
            binding.tvNoData.setVisibility(View.VISIBLE);
        }

    }

    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}