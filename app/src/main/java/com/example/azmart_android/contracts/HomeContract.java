package com.example.azmart_android.contracts;

public interface HomeContract {
    interface View extends BaseView {
        void showSuccess(String message);
        void showInputWarning();

    }

    interface Presenter extends BasePresenter {
        void CallLOGIN(String user, String password);
    }
}
