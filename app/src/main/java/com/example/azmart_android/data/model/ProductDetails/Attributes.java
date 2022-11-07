
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("codeScope")
    private String mCodeScope;
    @SerializedName("collectedTips")
    private String mCollectedTips;
    @SerializedName("couponCampaignStyle")
    private String mCouponCampaignStyle;
    @SerializedName("houyiTrack")
    private String mHouyiTrack;
    @SerializedName("privateText")
    private String mPrivateText;
    @SerializedName("promotionId")
    private String mPromotionId;

    public String getCodeScope() {
        return mCodeScope;
    }

    public void setCodeScope(String codeScope) {
        mCodeScope = codeScope;
    }

    public String getCollectedTips() {
        return mCollectedTips;
    }

    public void setCollectedTips(String collectedTips) {
        mCollectedTips = collectedTips;
    }

    public String getCouponCampaignStyle() {
        return mCouponCampaignStyle;
    }

    public void setCouponCampaignStyle(String couponCampaignStyle) {
        mCouponCampaignStyle = couponCampaignStyle;
    }

    public String getHouyiTrack() {
        return mHouyiTrack;
    }

    public void setHouyiTrack(String houyiTrack) {
        mHouyiTrack = houyiTrack;
    }

    public String getPrivateText() {
        return mPrivateText;
    }

    public void setPrivateText(String privateText) {
        mPrivateText = privateText;
    }

    public String getPromotionId() {
        return mPromotionId;
    }

    public void setPromotionId(String promotionId) {
        mPromotionId = promotionId;
    }

}
