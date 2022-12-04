package com.example.azmart_android.presenter;

import android.content.Context;

import com.example.azmart_android.contracts.OrderContract;
import com.example.azmart_android.network.api_manager.ApiDataManager;

import java.util.HashMap;
import java.util.Map;

public class OrderPresenter implements OrderContract.Presenter {

    OrderContract.View mView;
    ApiDataManager mApiDataManager;

    public OrderPresenter(OrderContract.View mView, Context context) {
        this.mView = mView;
        mApiDataManager = new ApiDataManager();
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }


    @Override
    public void saveOrder(String productId) {
        mView.showLoadingDialog();
        Map<String, Object> dataMap = new HashMap<>();
//        dataMap.put("user_id", userId);
//        dataMap.put("product_id", productId);

//        mApiDataManager.isProductExistInCart(this, dataMap);
    }


    @Override
    public void onSaveOrderResponse(String messge) {
        mView.hideLoadingDialogue();
//        mView.showAddedToCartResponse(messge);
    }



}
