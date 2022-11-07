
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class CouponAssignParam {

    @SerializedName("buffettParam")
    private String mBuffettParam;
    @SerializedName("couponMeta")
    private String mCouponMeta;
    @SerializedName("couponSource")
    private String mCouponSource;
    @SerializedName("couponType")
    private String mCouponType;

    public String getBuffettParam() {
        return mBuffettParam;
    }

    public void setBuffettParam(String buffettParam) {
        mBuffettParam = buffettParam;
    }

    public String getCouponMeta() {
        return mCouponMeta;
    }

    public void setCouponMeta(String couponMeta) {
        mCouponMeta = couponMeta;
    }

    public String getCouponSource() {
        return mCouponSource;
    }

    public void setCouponSource(String couponSource) {
        mCouponSource = couponSource;
    }

    public String getCouponType() {
        return mCouponType;
    }

    public void setCouponType(String couponType) {
        mCouponType = couponType;
    }

}
