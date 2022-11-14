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

    @Override
    public void addProductToWishlist(String productId, String userId) {
        // mView.showLoading();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("user_id", userId);
        dataMap.put("product_id", productId);
        mApiDataManager.addProductToWishlist(this, dataMap);
    }

    @Override
    public void isExistProductInWishlist(String productId, String userId) {
        // mView.showLoading();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("user_id", userId);
        dataMap.put("product_id", productId);
        mApiDataManager.isExistProductInWishlist(this,dataMap);
    }

    @Override
    public void onAddToWishlistResponse(String messge) {
        mView.showAddedToWishlistResponse(messge);
    }

    @Override
    public void isExistWishlistResponse(String messge) {
        mView.showisExistwishlist(messge);
    }

    @Override
    public void deleteProductInWishlist(String productId, String userId) {
        // mView.showLoading();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("user_id", userId);
        dataMap.put("product_id", productId);
        mApiDataManager.deleteProductFromWishlist(this,dataMap);
    }

    @Override
    public void deleteProductInWishlistResponse(String messge) {
        mView.showdeleteProductwishlist(messge);
    }

}
