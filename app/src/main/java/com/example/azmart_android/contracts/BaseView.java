package com.example.azmart_android.contracts;

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showApiErrorWarning(String string);
}
