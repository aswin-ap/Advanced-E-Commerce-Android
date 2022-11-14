package com.example.azmart_android.presenter;

import android.util.Log;

import com.example.azmart_android.contracts.WishlistContract;
import com.example.azmart_android.network.api_manager.ApiDataManager;

public class WishlistPresenter implements WishlistContract.Presenter {

    WishlistContract.View mView;
    ApiDataManager mApiDataManager;

    public WishlistPresenter(WishlistContract.View mView) {
        this.mView = mView;
        mApiDataManager = new ApiDataManager();
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }

    @Override
    public void getProductsFromWishlist(String userId) {
        mApiDataManager.getProductsFromWishlist(this, userId);
    }

    @Override
    public void onWishlistProductResultResponse(String messge) {
        mView.showWishlistProducts(messge);
    }

}
