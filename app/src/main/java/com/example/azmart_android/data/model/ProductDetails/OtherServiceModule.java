
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class OtherServiceModule {

    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("hasWarrantyInfo")
    private Boolean mHasWarrantyInfo;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;

    public Features getFeatures() {
        return mFeatures;
    }

    public void setFeatures(Features features) {
        mFeatures = features;
    }

    public Boolean getHasWarrantyInfo() {
        return mHasWarrantyInfo;
    }

    public void setHasWarrantyInfo(Boolean hasWarrantyInfo) {
        mHasWarrantyInfo = hasWarrantyInfo;
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

}
