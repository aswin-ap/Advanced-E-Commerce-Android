package com.example.azmart_android.presenter;

import android.content.Context;

import com.example.azmart_android.contracts.CartContract;
import com.example.azmart_android.data.model.CartModel;
import com.example.azmart_android.network.api_manager.ApiDataManager;
import com.example.azmart_android.utils.NetworkManager;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPresenter implements CartContract.Presenter {
    CartContract.View mView;
    ApiDataManager mApiDataManager;
    Context context;

    public CartPresenter(CartContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        mApiDataManager = new ApiDataManager();
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.hideLoadingDialogue();
        mView.showApiErrorWarning(data);

    }

    @Override
    public void getCart(String userId) {
        if (NetworkManager.isNetworkAvailable(context)) {
            mView.showLoading();
            mApiDataManager.getProductsFromCart(this, userId);
        } else
            mView.showApiErrorWarning("Oops! No internet available");
    }

    @Override
    public void deleteProductFromCart(String userId, String productId) {
        if (NetworkManager.isNetworkAvailable(context)) {
            mView.showLoadingDialog();
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("user_id", userId);
            dataMap.put("product_id", productId);
            mApiDataManager.deleteProductFromCart(this, dataMap);
        } else
            mView.showApiErrorWarning("Oops! No internet available");
    }

    @Override
    public void onDeleteProductFromCartResponse(String message) {
        mView.hideLoadingDialogue();
        mView.showDeleteResponse(message);
    }

    @Override
    public void onCartResultResponse(QuerySnapshot documentSnapshots) {
        mView.hideLoading();
        List<CartModel> cartModelList = new ArrayList<>();
        for (QueryDocumentSnapshot document : documentSnapshots) {
            cartModelList.add(new CartModel(
                    document.getString("product_id"),
                    document.getString("title"),
                    document.getString("rating"),
                    document.getString("price"),
                    1,
                    document.getString("imageUrl"),
                    document.getString("user_id")
            ));
        }
        mView.showCartList(cartModelList);
    }
}
