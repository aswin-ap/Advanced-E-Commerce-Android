package com.example.azmart_android.view.Order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.azmart_android.R;
import com.example.azmart_android.adapter.OrderHistoryAdapter;
import com.example.azmart_android.adapter.ProductsAdapter;
import com.example.azmart_android.contracts.OrderHistoryContract;
import com.example.azmart_android.data.model.OrderHistoryModel;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.databinding.FragmentAddPaymentBinding;
import com.example.azmart_android.databinding.FragmentOrderHistoryBinding;
import com.example.azmart_android.presenter.CardPresenter;
import com.example.azmart_android.presenter.OrderHistoryPresenter;
import com.example.azmart_android.utils.NetworkManager;
import com.example.azmart_android.view.BaseFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class OrderHistoryFragment extends BaseFragment implements OrderHistoryContract.View {

    private FragmentOrderHistoryBinding binding;
    private OrderHistoryPresenter orderHistoryPresenter;
    private OrderHistoryAdapter orderHistoryAdapter;
    FirebaseUser currentUser;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        orderHistoryPresenter=new OrderHistoryPresenter(this,requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentOrderHistoryBinding.inflate(inflater,container,false);
        initView();
        binding.ivBack.setOnClickListener(view -> {
            requireActivity().onBackPressed();
        });
        binding.srfProduct.setColorSchemeColors(getResources().getColor(R.color.green_700));
        binding.srfProduct.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                binding.srfProduct.setRefreshing(false);
            }
        });
        return binding.getRoot();

    }

    private void initView() {
        if (NetworkManager.isNetworkAvailable(requireContext())) {
            binding.tvNetworkWorning.setVisibility(View.GONE);
            orderHistoryPresenter.getOrdersHistory(currentUser.getUid());
        } else{
            binding.tvNetworkWorning.setVisibility(View.VISIBLE);
            binding.rvSearch.setVisibility(View.GONE);
        }

    }

    @Override
    public void showLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.VISIBLE);
        binding.rvSearch.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvSearch.setVisibility(View.GONE);
    }

    @Override
    public void showApiErrorWarning(String string) {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvSearch.setVisibility(View.GONE);
        showToast(requireActivity(), string);
    }

    @Override
    public void showOrderHistoryResponse(List<OrderHistoryModel> orderHistoryModels) {
        orderHistoryAdapter=new OrderHistoryAdapter(this,orderHistoryModels);
        binding.rvSearch.setHasFixedSize(true);
        binding.rvSearch.setAdapter(orderHistoryAdapter);
        showToast(requireActivity(), "string");

    }
}