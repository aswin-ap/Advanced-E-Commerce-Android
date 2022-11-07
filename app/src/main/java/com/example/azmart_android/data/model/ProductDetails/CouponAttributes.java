
package com.example.azmart_android.data.model.ProductDetails;

import com.google.gson.annotations.SerializedName;

public class CouponAttributes {

    @SerializedName("couponPackageText")
    private String mCouponPackageText;
    @SerializedName("hasPlatformShippingFeeCoupon")
    private String mHasPlatformShippingFeeCoupon;

    public String getCouponPackageText() {
        return mCouponPackageText;
    }

    public void setCouponPackageText(String couponPackageText) {
        mCouponPackageText = couponPackageText;
    }

    public String getHasPlatformShippingFeeCoupon() {
        return mHasPlatformShippingFeeCoupon;
    }

    public void setHasPlatformShippingFeeCoupon(String hasPlatformShippingFeeCoupon) {
        mHasPlatformShippingFeeCoupon = hasPlatformShippingFeeCoupon;
    }

}
