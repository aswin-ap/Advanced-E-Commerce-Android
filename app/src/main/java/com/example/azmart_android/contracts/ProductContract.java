package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.ProductDetails.ProductDetailsResponse;

public interface ProductContract {

    interface View extends BaseView {
        void showProductResponse(ProductDetailsResponse productDetailsResponse);
        void showAddedToCartResponse(String message);
    }

    interface Presenter extends BasePresenter {
        void getProduct(String categoryId);

        void onProductResultResponse(ProductDetailsResponse productDetailsResponse);
        void addProductToCart(String productId, String userId);
        void onAddToCartResponse(String messge);
    }

}
