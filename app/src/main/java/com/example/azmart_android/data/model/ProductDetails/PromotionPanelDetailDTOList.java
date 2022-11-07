
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;

public class PromotionPanelDetailDTOList {

    @SerializedName("acquirable")
    private Boolean mAcquirable;
    @SerializedName("actionTips")
    private String mActionTips;
    @SerializedName("attributes")
    private Attributes mAttributes;
    @SerializedName("couponAssignParam")
    private CouponAssignParam mCouponAssignParam;
    @SerializedName("displayType")
    private String mDisplayType;
    @SerializedName("endTime")
    private Long mEndTime;
    @SerializedName("promotionDesc")
    private String mPromotionDesc;
    @SerializedName("promotionDetail")
    private String mPromotionDetail;
    @SerializedName("startTime")
    private Long mStartTime;
    @SerializedName("teasingStartTime")
    private Long mTeasingStartTime;
    @SerializedName("toolCode")
    private String mToolCode;

    public Boolean getAcquirable() {
        return mAcquirable;
    }

    public void setAcquirable(Boolean acquirable) {
        mAcquirable = acquirable;
    }

    public String getActionTips() {
        return mActionTips;
    }

    public void setActionTips(String actionTips) {
        mActionTips = actionTips;
    }

    public Attributes getAttributes() {
        return mAttributes;
    }

    public void setAttributes(Attributes attributes) {
        mAttributes = attributes;
    }

    public CouponAssignParam getCouponAssignParam() {
        return mCouponAssignParam;
    }

    public void setCouponAssignParam(CouponAssignParam couponAssignParam) {
        mCouponAssignParam = couponAssignParam;
    }

    public String getDisplayType() {
        return mDisplayType;
    }

    public void setDisplayType(String displayType) {
        mDisplayType = displayType;
    }

    public Long getEndTime() {
        return mEndTime;
    }

    public void setEndTime(Long endTime) {
        mEndTime = endTime;
    }

    public String getPromotionDesc() {
        return mPromotionDesc;
    }

    public void setPromotionDesc(String promotionDesc) {
        mPromotionDesc = promotionDesc;
    }

    public String getPromotionDetail() {
        return mPromotionDetail;
    }

    public void setPromotionDetail(String promotionDetail) {
        mPromotionDetail = promotionDetail;
    }

    public Long getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Long startTime) {
        mStartTime = startTime;
    }

    public Long getTeasingStartTime() {
        return mTeasingStartTime;
    }

    public void setTeasingStartTime(Long teasingStartTime) {
        mTeasingStartTime = teasingStartTime;
    }

    public String getToolCode() {
        return mToolCode;
    }

    public void setToolCode(String toolCode) {
        mToolCode = toolCode;
    }

}
