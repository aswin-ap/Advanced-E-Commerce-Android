
package com.example.azmart_android.data.model.ProductDetails;

import com.google.gson.annotations.SerializedName;

public class DescriptionModule {

    @SerializedName("descriptionUrl")
    private String mDescriptionUrl;
    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("productId")
    private Long mProductId;
    @SerializedName("sellerAdminSeq")
    private Long mSellerAdminSeq;

    public String getDescriptionUrl() {
        return mDescriptionUrl;
    }

    public void setDescriptionUrl(String descriptionUrl) {
        mDescriptionUrl = descriptionUrl;
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

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public Long getSellerAdminSeq() {
        return mSellerAdminSeq;
    }

    public void setSellerAdminSeq(Long sellerAdminSeq) {
        mSellerAdminSeq = sellerAdminSeq;
    }

}
