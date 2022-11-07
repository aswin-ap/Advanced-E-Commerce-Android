
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;

public class SkuPropertyValue {

    @SerializedName("propertyValueDefinitionName")
    private String mPropertyValueDefinitionName;
    @SerializedName("propertyValueDisplayName")
    private String mPropertyValueDisplayName;
    @SerializedName("propertyValueId")
    private Long mPropertyValueId;
    @SerializedName("propertyValueIdLong")
    private Long mPropertyValueIdLong;
    @SerializedName("propertyValueName")
    private String mPropertyValueName;
    @SerializedName("skuColorValue")
    private String mSkuColorValue;
    @SerializedName("skuPropertyImagePath")
    private String mSkuPropertyImagePath;
    @SerializedName("skuPropertyImageSummPath")
    private String mSkuPropertyImageSummPath;
    @SerializedName("skuPropertyTips")
    private String mSkuPropertyTips;
    @SerializedName("skuPropertyValueShowOrder")
    private Long mSkuPropertyValueShowOrder;
    @SerializedName("skuPropertyValueTips")
    private String mSkuPropertyValueTips;

    public String getPropertyValueDefinitionName() {
        return mPropertyValueDefinitionName;
    }

    public void setPropertyValueDefinitionName(String propertyValueDefinitionName) {
        mPropertyValueDefinitionName = propertyValueDefinitionName;
    }

    public String getPropertyValueDisplayName() {
        return mPropertyValueDisplayName;
    }

    public void setPropertyValueDisplayName(String propertyValueDisplayName) {
        mPropertyValueDisplayName = propertyValueDisplayName;
    }

    public Long getPropertyValueId() {
        return mPropertyValueId;
    }

    public void setPropertyValueId(Long propertyValueId) {
        mPropertyValueId = propertyValueId;
    }

    public Long getPropertyValueIdLong() {
        return mPropertyValueIdLong;
    }

    public void setPropertyValueIdLong(Long propertyValueIdLong) {
        mPropertyValueIdLong = propertyValueIdLong;
    }

    public String getPropertyValueName() {
        return mPropertyValueName;
    }

    public void setPropertyValueName(String propertyValueName) {
        mPropertyValueName = propertyValueName;
    }

    public String getSkuColorValue() {
        return mSkuColorValue;
    }

    public void setSkuColorValue(String skuColorValue) {
        mSkuColorValue = skuColorValue;
    }

    public String getSkuPropertyImagePath() {
        return mSkuPropertyImagePath;
    }

    public void setSkuPropertyImagePath(String skuPropertyImagePath) {
        mSkuPropertyImagePath = skuPropertyImagePath;
    }

    public String getSkuPropertyImageSummPath() {
        return mSkuPropertyImageSummPath;
    }

    public void setSkuPropertyImageSummPath(String skuPropertyImageSummPath) {
        mSkuPropertyImageSummPath = skuPropertyImageSummPath;
    }

    public String getSkuPropertyTips() {
        return mSkuPropertyTips;
    }

    public void setSkuPropertyTips(String skuPropertyTips) {
        mSkuPropertyTips = skuPropertyTips;
    }

    public Long getSkuPropertyValueShowOrder() {
        return mSkuPropertyValueShowOrder;
    }

    public void setSkuPropertyValueShowOrder(Long skuPropertyValueShowOrder) {
        mSkuPropertyValueShowOrder = skuPropertyValueShowOrder;
    }

    public String getSkuPropertyValueTips() {
        return mSkuPropertyValueTips;
    }

    public void setSkuPropertyValueTips(String skuPropertyValueTips) {
        mSkuPropertyValueTips = skuPropertyValueTips;
    }

}
