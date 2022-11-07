
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class QuantityModule {

    @SerializedName("activity")
    private Boolean mActivity;
    @SerializedName("displayBulkInfo")
    private Boolean mDisplayBulkInfo;
    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("lot")
    private Boolean mLot;
    @SerializedName("multiUnitName")
    private String mMultiUnitName;
    @SerializedName("name")
    private String mName;
    @SerializedName("oddUnitName")
    private String mOddUnitName;
    @SerializedName("purchaseLimitNumMax")
    private Long mPurchaseLimitNumMax;
    @SerializedName("totalAvailQuantity")
    private Long mTotalAvailQuantity;

    public Boolean getActivity() {
        return mActivity;
    }

    public void setActivity(Boolean activity) {
        mActivity = activity;
    }

    public Boolean getDisplayBulkInfo() {
        return mDisplayBulkInfo;
    }

    public void setDisplayBulkInfo(Boolean displayBulkInfo) {
        mDisplayBulkInfo = displayBulkInfo;
    }

    public Features getFeatures() {
        return mFeatures;
    }

    public void setFeatures(Features features) {
        mFeatures = features;
    }

    public I18nMap getI18nMap() {
        return mI18nMap;
    }

    public void setI18nMap(I18nMap i18nMap) {
        mI18nMap = i18nMap;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Boolean getLot() {
        return mLot;
    }

    public void setLot(Boolean lot) {
        mLot = lot;
    }

    public String getMultiUnitName() {
        return mMultiUnitName;
    }

    public void setMultiUnitName(String multiUnitName) {
        mMultiUnitName = multiUnitName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOddUnitName() {
        return mOddUnitName;
    }

    public void setOddUnitName(String oddUnitName) {
        mOddUnitName = oddUnitName;
    }

    public Long getPurchaseLimitNumMax() {
        return mPurchaseLimitNumMax;
    }

    public void setPurchaseLimitNumMax(Long purchaseLimitNumMax) {
        mPurchaseLimitNumMax = purchaseLimitNumMax;
    }

    public Long getTotalAvailQuantity() {
        return mTotalAvailQuantity;
    }

    public void setTotalAvailQuantity(Long totalAvailQuantity) {
        mTotalAvailQuantity = totalAvailQuantity;
    }

}
