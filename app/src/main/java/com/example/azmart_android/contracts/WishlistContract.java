package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.data.model.WishListModel;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public interface WishlistContract {

    interface View extends BaseView {
        void showWishlistProducts(List<WishListModel> modelList);
    }

    interface Presenter extends BasePresenter {
        void onWishlistProductResultResponse(QuerySnapshot documentSnapshots);
        void getProductsFromWishlist(String userId);
    }

}
