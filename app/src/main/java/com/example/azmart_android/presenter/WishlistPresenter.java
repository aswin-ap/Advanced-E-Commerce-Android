package com.example.azmart_android.presenter;

import com.example.azmart_android.contracts.WishlistContract;
import com.example.azmart_android.data.model.WishListModel;
import com.example.azmart_android.network.api_manager.ApiDataManager;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

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
        mView.showLoading();
        mApiDataManager.getProductsFromWishlist(this, userId);
    }

    @Override
    public void onWishlistProductResultResponse(QuerySnapshot documentSnapshots) {
        mView.hideLoading();
        List<WishListModel> listModels = new ArrayList<>();
        for (QueryDocumentSnapshot document : documentSnapshots) {
            listModels.add(new WishListModel(
                    document.getString("product_id"),
                    document.getString("title"),
                    document.getString("rating"),
                    document.getString("price"),
                    document.getString("imageUrl"),
                    ""
            ));
        }
        mView.showWishlistProducts(listModels);
    }

}
