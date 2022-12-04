package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.CartModel;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public interface OrderContract {

    interface View extends BaseView {
        void showSaveOrdeeResponse(String message);
        void showLoadingDialog();
        void hideLoadingDialogue();
    }

    interface Presenter extends BasePresenter {
        void saveOrder(String userId);
        void onSaveOrderResponse(String message);
    }

}
