
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ImageModule {

    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("imagePathList")
    private List<String> mImagePathList;
    @SerializedName("name")
    private String mName;
    @SerializedName("summImagePathList")
    private List<String> mSummImagePathList;

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

    public List<String> getImagePathList() {
        return mImagePathList;
    }

    public void setImagePathList(List<String> imagePathList) {
        mImagePathList = imagePathList;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<String> getSummImagePathList() {
        return mSummImagePathList;
    }

    public void setSummImagePathList(List<String> summImagePathList) {
        mSummImagePathList = summImagePathList;
    }

}
