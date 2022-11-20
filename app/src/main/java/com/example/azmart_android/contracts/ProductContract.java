package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.ProductDetails.ProductDetailsResponse;

import java.util.Map;

public interface ProductContract {

    interface View extends BaseView {
        void showProductResponse(ProductDetailsResponse productDetailsResponse);
        void showAddedToCartResponse(String message);
        void showAddedToWishlistResponse(String message);
        void showIsExistWishlist(String message);
        void showDeleteProductWishlist(String message);
        void showLoadingDialog();
        void hideLoadingDialogue();
    }

    interface Presenter extends BasePresenter {
        void getProduct(String categoryId);
        void onProductResultResponse(ProductDetailsResponse productDetailsResponse);
        void addProductToCart(String productId, String userId, String title, String rating, String price,
                              String imageUrl);
        void onCheckProductExistInCartResponse(Boolean isExist, Map<String, Object> objectMap);
        void onAddToCartResponse(String messge);
        void addProductToWishlist(String productId, String userId, String title, String rating, String price,
                                 String imageUrl );
        void onAddToWishlistResponse(String messge);
        void isExistProductInWishlist(String productId, String userId);
        void isExistWishlistResponse(String messge);
        void deleteProductInWishlist(String productId, String userId);
        void deleteProductInWishlistResponse(String messge);

    }

}
