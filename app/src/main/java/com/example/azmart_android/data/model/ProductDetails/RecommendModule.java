
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class RecommendModule {

    @SerializedName("categoryId")
    private Long mCategoryId;
    @SerializedName("companyId")
    private Long mCompanyId;
    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("platformCount")
    private Long mPlatformCount;
    @SerializedName("productId")
    private Long mProductId;
    @SerializedName("storeNum")
    private Long mStoreNum;

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long categoryId) {
        mCategoryId = categoryId;
    }

    public Long getCompanyId() {
        return mCompanyId;
    }

    public void setCompanyId(Long companyId) {
        mCompanyId = companyId;
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getPlatformCount() {
        return mPlatformCount;
    }

    public void setPlatformCount(Long platformCount) {
        mPlatformCount = platformCount;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public Long getStoreNum() {
        return mStoreNum;
    }

    public void setStoreNum(Long storeNum) {
        mStoreNum = storeNum;
    }

}
