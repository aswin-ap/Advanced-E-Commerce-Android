
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class WebCouponInfo {

    @SerializedName("couponAttributes")
    private CouponAttributes mCouponAttributes;
    @SerializedName("couponList")
    private List<CouponList> mCouponList;
    @SerializedName("promotionPanelDTO")
    private PromotionPanelDTO mPromotionPanelDTO;
    @SerializedName("usingNewCouponApi")
    private Boolean mUsingNewCouponApi;

    public CouponAttributes getCouponAttributes() {
        return mCouponAttributes;
    }

    public void setCouponAttributes(CouponAttributes couponAttributes) {
        mCouponAttributes = couponAttributes;
    }

    public List<CouponList> getCouponList() {
        return mCouponList;
    }

    public void setCouponList(List<CouponList> couponList) {
        mCouponList = couponList;
    }

    public PromotionPanelDTO getPromotionPanelDTO() {
        return mPromotionPanelDTO;
    }

    public void setPromotionPanelDTO(PromotionPanelDTO promotionPanelDTO) {
        mPromotionPanelDTO = promotionPanelDTO;
    }

    public Boolean getUsingNewCouponApi() {
        return mUsingNewCouponApi;
    }

    public void setUsingNewCouponApi(Boolean usingNewCouponApi) {
        mUsingNewCouponApi = usingNewCouponApi;
    }

}
