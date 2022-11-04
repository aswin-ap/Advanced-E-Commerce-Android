package com.example.azmart_android.view.Products;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.azmart_android.adapter.SearchAdapter;
import com.example.azmart_android.contracts.ProductsContract;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.databinding.ActivityProductsBinding;
import com.example.azmart_android.presenter.ProductsPresenter;

public class ProductsActivity extends AppCompatActivity implements ProductsContract.View {

    private ActivityProductsBinding binding;
    private ProductsPresenter productsPresenter;
    private SearchAdapter searchAdapter;
    private SearchResponse searchResponseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        productsPresenter=new ProductsPresenter(this);
        initView();
    }

    private void initView() {
        int categoryId = getIntent().getIntExtra("categoryId",0);
        productsPresenter.getProducts(categoryId);
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
        showToast(this, string);
    }

    @Override
    public void showProductsResponse(SearchResponse searchResponse) {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvSearch.setVisibility(View.VISIBLE);
        binding.tvResults.setText("Results "+searchResponse.getTotalRecordCount());
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