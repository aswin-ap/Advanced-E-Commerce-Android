
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class SkuModule {

    @SerializedName("categoryId")
    private Long mCategoryId;
    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("forcePromiseWarrantyJson")
    private String mForcePromiseWarrantyJson;
    @SerializedName("hasSizeInfo")
    private Boolean mHasSizeInfo;
    @SerializedName("hasSkuProperty")
    private Boolean mHasSkuProperty;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("productSKUPropertyList")
    private List<ProductSKUPropertyList> mProductSKUPropertyList;
    @SerializedName("skuPriceList")
    private List<SkuPriceList> mSkuPriceList;
    @SerializedName("warrantyDetailJson")
    private String mWarrantyDetailJson;

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long categoryId) {
        mCategoryId = categoryId;
    }

    public Features getFeatures() {
        return mFeatures;
    }

    public void setFeatures(Features features) {
        mFeatures = features;
    }

    public String getForcePromiseWarrantyJson() {
        return mForcePromiseWarrantyJson;
    }

    public void setForcePromiseWarrantyJson(String forcePromiseWarrantyJson) {
        mForcePromiseWarrantyJson = forcePromiseWarrantyJson;
    }

    public Boolean getHasSizeInfo() {
        return mHasSizeInfo;
    }

    public void setHasSizeInfo(Boolean hasSizeInfo) {
        mHasSizeInfo = hasSizeInfo;
    }

    public Boolean getHasSkuProperty() {
        return mHasSkuProperty;
    }

    public void setHasSkuProperty(Boolean hasSkuProperty) {
        mHasSkuProperty = hasSkuProperty;
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<ProductSKUPropertyList> getProductSKUPropertyList() {
        return mProductSKUPropertyList;
    }

    public void setProductSKUPropertyList(List<ProductSKUPropertyList> productSKUPropertyList) {
        mProductSKUPropertyList = productSKUPropertyList;
    }

    public List<SkuPriceList> getSkuPriceList() {
        return mSkuPriceList;
    }

    public void setSkuPriceList(List<SkuPriceList> skuPriceList) {
        mSkuPriceList = skuPriceList;
    }

    public String getWarrantyDetailJson() {
        return mWarrantyDetailJson;
    }

    public void setWarrantyDetailJson(String warrantyDetailJson) {
        mWarrantyDetailJson = warrantyDetailJson;
    }

}
