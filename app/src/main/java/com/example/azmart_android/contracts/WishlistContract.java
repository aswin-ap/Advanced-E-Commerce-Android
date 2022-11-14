package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.SearchResponse;

public interface WishlistContract {

    interface View extends BaseView {
        void showWishlistProducts(String message);
    }

    interface Presenter extends BasePresenter {
        void onWishlistProductResultResponse(String message);
        void getProductsFromWishlist(String userId);
    }

}
