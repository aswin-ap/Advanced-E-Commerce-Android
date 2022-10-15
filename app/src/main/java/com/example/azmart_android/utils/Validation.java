package com.example.azmart_android.utils;

import android.text.TextUtils;
import android.util.Patterns;

public class Validation {

    public static boolean isValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public static boolean isNotNullOrEmpty(String text) {
        return (text != null && !TextUtils.isEmpty(text));
    }

    public static boolean isValidPassword(String email) {
        return email.length() >= 6;
    }

    public static boolean isPasswordConfirm(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
