package com.example.azmart_android.view.Products;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.azmart_android.R;
import com.example.azmart_android.adapter.ProductViewPagerAdaptor;
import com.example.azmart_android.contracts.ProductContract;
import com.example.azmart_android.data.model.ProductDetails.ProductDetailsResponse;
import com.example.azmart_android.databinding.FragmentProductBinding;
import com.example.azmart_android.presenter.ProductPresenter;
import com.example.azmart_android.presenter.ProductsPresenter;
import com.example.azmart_android.utils.NetworkManager;

import java.util.ArrayList;

public class ProductFragment extends Fragment implements ProductContract.View {

    private ProductPresenter productPresenter;
    private FragmentProductBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productPresenter=new ProductPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.srfProduct.setColorSchemeColors(getResources().getColor(R.color.green_700));
        binding.srfProduct.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                binding.srfProduct.setRefreshing(false);
            }
        });
        initView();
    }

    private void initView() {
        String productName=ProductFragmentArgs.fromBundle(getArguments()).getProductName();
        binding.tvProductName.setText(productName);
        String productId = ProductFragmentArgs.fromBundle(getArguments()).getProductId();
        Log.e("productid :" ,productId  );

        if (NetworkManager.isNetworkAvailable(requireContext())) {
            binding.llProduct.setVisibility(View.GONE);
            binding.tvNetworkWorning.setVisibility(View.GONE);
            productPresenter.getProduct(productId);
        } else{
            binding.tvNetworkWorning.setVisibility(View.VISIBLE);
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
    public void showProductResponse(ProductDetailsResponse productDetailsResponse) {
        ProductViewPagerAdaptor productViewPagerAdaptor;
        productViewPagerAdaptor= new ProductViewPagerAdaptor(getActivity().getBaseContext(), productDetailsResponse.getProductSmallImageUrls().getString());
        binding.vpProductImage.setAdapter(productViewPagerAdaptor);
        binding.ciIndicator.attachTo(binding.vpProductImage);
        productViewPagerAdaptor.notifyDataSetChanged();
//        binding.rbRating.setRating((float) productDetailsResponse.getEvaluateRate());
        binding.tvPrice.setText(productDetailsResponse.getMetadata().getPriceModule().getFormatedPrice());
        hideLoading();
        binding.llProduct.setVisibility(View.VISIBLE);
    }

    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}