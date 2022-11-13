package com.example.azmart_android.presenter;

import com.example.azmart_android.contracts.ProductContract;
import com.example.azmart_android.data.model.ProductDetails.ProductDetailsResponse;
import com.example.azmart_android.network.api_manager.ApiDataManager;

import java.util.HashMap;
import java.util.Map;

public class ProductPresenter implements ProductContract.Presenter {

    ProductContract.View mView;
    ApiDataManager mApiDataManager;

    public ProductPresenter(ProductContract.View mView) {
        this.mView = mView;
        mApiDataManager = new ApiDataManager();
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }

    @Override
    public void getProduct(String productId) {
        mView.showLoading();
        mApiDataManager.getProductByCategory(this, productId);
    }

    @Override
    public void onProductResultResponse(ProductDetailsResponse productDetailsResponse) {
        mView.showProductResponse(productDetailsResponse);
    }

    @Override
    public void addProductToCart(String productId, String userId) {
       // mView.showLoading();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("user_id", userId);
        dataMap.put("product_id", productId);
        mApiDataManager.addProductToCart(this, dataMap);
    }

    @Override
    public void onAddToCartResponse(String messge) {
        mView.showAddedToCartResponse(messge);
    }
}
