
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SkuProperty {

    @SerializedName("isShowTypeColor")
    private Boolean mIsShowTypeColor;
    @SerializedName("order")
    private Long mOrder;
    @SerializedName("showType")
    private String mShowType;
    @SerializedName("showTypeColor")
    private Boolean mShowTypeColor;
    @SerializedName("skuPropertyId")
    private Long mSkuPropertyId;
    @SerializedName("skuPropertyName")
    private String mSkuPropertyName;
    @SerializedName("skuPropertyValues")
    private List<SkuPropertyValue> mSkuPropertyValues;

    public Boolean getIsShowTypeColor() {
        return mIsShowTypeColor;
    }

    public void setIsShowTypeColor(Boolean isShowTypeColor) {
        mIsShowTypeColor = isShowTypeColor;
    }

    public Long getOrder() {
        return mOrder;
    }

    public void setOrder(Long order) {
        mOrder = order;
    }

    public String getShowType() {
        return mShowType;
    }

    public void setShowType(String showType) {
        mShowType = showType;
    }

    public Boolean getShowTypeColor() {
        return mShowTypeColor;
    }

    public void setShowTypeColor(Boolean showTypeColor) {
        mShowTypeColor = showTypeColor;
    }

    public Long getSkuPropertyId() {
        return mSkuPropertyId;
    }

    public void setSkuPropertyId(Long skuPropertyId) {
        mSkuPropertyId = skuPropertyId;
    }

    public String getSkuPropertyName() {
        return mSkuPropertyName;
    }

    public void setSkuPropertyName(String skuPropertyName) {
        mSkuPropertyName = skuPropertyName;
    }

    public List<SkuPropertyValue> getSkuPropertyValues() {
        return mSkuPropertyValues;
    }

    public void setSkuPropertyValues(List<SkuPropertyValue> skuPropertyValues) {
        mSkuPropertyValues = skuPropertyValues;
    }

}
