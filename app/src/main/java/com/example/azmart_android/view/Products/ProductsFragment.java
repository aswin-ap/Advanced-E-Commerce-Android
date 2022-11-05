package com.example.azmart_android.view.Products;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.azmart_android.adapter.SearchAdapter;
import com.example.azmart_android.contracts.ProductsContract;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.databinding.FragmentProductsBinding;
import com.example.azmart_android.presenter.ProductsPresenter;
import com.example.azmart_android.view.search.SearchFragmentArgs;


public class ProductsFragment extends Fragment implements ProductsContract.View {

    private FragmentProductsBinding binding;
    private ProductsPresenter productsPresenter;
    private SearchAdapter searchAdapter;
    private SearchResponse searchResponseList;
    private String categoryName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productsPresenter=new ProductsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        categoryName=ProductsFragmentArgs.fromBundle(getArguments()).getCategoryName();
        int categoryId = ProductsFragmentArgs.fromBundle(getArguments()).getCaregoryId();
        productsPresenter.getProducts(categoryId);

        binding.ivBack.setOnClickListener(view -> {
            requireActivity().onBackPressed();
        });
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
    public void showProductsResponse(SearchResponse searchResponse) {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvSearch.setVisibility(View.VISIBLE);
        binding.tvResults.setText(categoryName);
        if (searchResponse.getTotalRecordCount()==0){
            binding.rvSearch.setVisibility(View.GONE);

        }else {
            searchResponseList = searchResponse;
            searchAdapter = new SearchAdapter(searchResponseList);
            binding.rvSearch.setHasFixedSize(true);
            binding.rvSearch.setAdapter(searchAdapter);
        }
    }

    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}