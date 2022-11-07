
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class CrossLinkModule {

    @SerializedName("breadCrumbPathList")
    private List<BreadCrumbPathList> mBreadCrumbPathList;
    @SerializedName("crossLinkGroupList")
    private List<CrossLinkGroupList> mCrossLinkGroupList;
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

    public List<BreadCrumbPathList> getBreadCrumbPathList() {
        return mBreadCrumbPathList;
    }

    public void setBreadCrumbPathList(List<BreadCrumbPathList> breadCrumbPathList) {
        mBreadCrumbPathList = breadCrumbPathList;
    }

    public List<CrossLinkGroupList> getCrossLinkGroupList() {
        return mCrossLinkGroupList;
    }

    public void setCrossLinkGroupList(List<CrossLinkGroupList> crossLinkGroupList) {
        mCrossLinkGroupList = crossLinkGroupList;
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

}
