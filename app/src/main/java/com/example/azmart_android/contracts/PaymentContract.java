package com.example.azmart_android.contracts;

public interface PaymentContract {

    interface View extends BaseView {

        void showLoadingDialog();
        void hideLoadingDialogue();
    }

    interface Presenter extends BasePresenter {

    }

}
