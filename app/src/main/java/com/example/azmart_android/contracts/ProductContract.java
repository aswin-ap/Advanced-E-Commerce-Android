package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.ProductDetails.ProductDetailsResponse;

public interface ProductContract {

    interface View extends BaseView {
        void showProductResponse(ProductDetailsResponse productDetailsResponse);
        void showAddedToCartResponse(String message);
        void showAddedToWishlistResponse(String message);
        void showisExistwishlist(String message);
        void showdeleteProductwishlist(String message);
    }

    interface Presenter extends BasePresenter {
        void getProduct(String categoryId);
        void onProductResultResponse(ProductDetailsResponse productDetailsResponse);
        void addProductToCart(String productId, String userId);
        void onAddToCartResponse(String messge);
        void addProductToWishlist(String productId, String userId);
        void onAddToWishlistResponse(String messge);
        void isExistProductInWishlist(String productId, String userId);
        void isExistWishlistResponse(String messge);
        void deleteProductInWishlist(String productId, String userId);
        void deleteProductInWishlistResponse(String messge);

    }

}
