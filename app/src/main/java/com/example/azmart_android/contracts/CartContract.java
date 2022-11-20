package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.CartModel;
import com.example.azmart_android.data.model.WishListModel;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public interface CartContract {

    interface View extends BaseView {
        void showCartList(List<CartModel> cartModelList);
        void showDeleteResponse(String message);
        void showLoadingDialog();
        void hideLoadingDialogue();
    }

    interface Presenter extends BasePresenter {
        void getCart(String userId);
        void deleteProductFromCart(String userId, String productId);
        void onDeleteProductFromCartResponse(String message);
        void onCartResultResponse(QuerySnapshot documentSnapshots);
    }

}
