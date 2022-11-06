package com.example.azmart_android.presenter;

import com.example.azmart_android.contracts.ProductContract;
import com.example.azmart_android.data.model.ProductDetails.ProductDetailsResponse;
import com.example.azmart_android.network.api_manager.ApiDataManager;

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
        mApiDataManager.getProductByCategory(this,productId);
    }

    @Override
    public void onProductResultResponse(ProductDetailsResponse productDetailsResponse) {
        mView.showProductResponse(productDetailsResponse);
    }
}
