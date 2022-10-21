package com.example.azmart_android.contracts;

public interface BaseView {
    void showProgressBar();
    void hideProgressBar();
    void showApiErrorWarning(String string);
    void showWarningMessage(String message);
}
