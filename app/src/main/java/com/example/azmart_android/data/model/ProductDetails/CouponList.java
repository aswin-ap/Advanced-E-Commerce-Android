
package com.example.azmart_android.data.model.ProductDetails;

import com.google.gson.annotations.SerializedName;

public class CouponList {

    @SerializedName("bgColor")
    private String mBgColor;
    @SerializedName("color")
    private String mColor;
    @SerializedName("copy")
    private String mCopy;
    @SerializedName("order")
    private Long mOrder;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;

    public String getBgColor() {
        return mBgColor;
    }

    public void setBgColor(String bgColor) {
        mBgColor = bgColor;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public String getCopy() {
        return mCopy;
    }

    public void setCopy(String copy) {
        mCopy = copy;
    }

    public Long getOrder() {
        return mOrder;
    }

    public void setOrder(Long order) {
        mOrder = order;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
