
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class MinAmount {

    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("formatedAmount")
    private String mFormatedAmount;
    @SerializedName("value")
    private Double mValue;

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getFormatedAmount() {
        return mFormatedAmount;
    }

    public void setFormatedAmount(String formatedAmount) {
        mFormatedAmount = formatedAmount;
    }

    public Double getValue() {
        return mValue;
    }

    public void setValue(Double value) {
        mValue = value;
    }

}
