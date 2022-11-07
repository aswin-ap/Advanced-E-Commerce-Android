
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class OriginalLayoutResultList {

    @SerializedName("additionLayout")
    private List<AdditionLayout> mAdditionLayout;
    @SerializedName("bizData")
    private BizData mBizData;
    @SerializedName("contentLayout")
    private List<List<ContentLayout>> mContentLayout;
    @SerializedName("deliveryOptionPanelDisplayList")
    private List<String> mDeliveryOptionPanelDisplayList;
    @SerializedName("detailFirstScreenDisplayList")
    private List<String> mDetailFirstScreenDisplayList;
    @SerializedName("dxTemplateInfo")
    private DxTemplateInfo mDxTemplateInfo;
    @SerializedName("finalPatternId")
    private Long mFinalPatternId;
    @SerializedName("skuSwitchDisplayList")
    private List<String> mSkuSwitchDisplayList;
    @SerializedName("titleLayout")
    private List<List<TitleLayout>> mTitleLayout;

    public List<AdditionLayout> getAdditionLayout() {
        return mAdditionLayout;
    }

    public void setAdditionLayout(List<AdditionLayout> additionLayout) {
        mAdditionLayout = additionLayout;
    }

    public BizData getBizData() {
        return mBizData;
    }

    public void setBizData(BizData bizData) {
        mBizData = bizData;
    }

    public List<List<ContentLayout>> getContentLayout() {
        return mContentLayout;
    }

    public void setContentLayout(List<List<ContentLayout>> contentLayout) {
        mContentLayout = contentLayout;
    }

    public List<String> getDeliveryOptionPanelDisplayList() {
        return mDeliveryOptionPanelDisplayList;
    }

    public void setDeliveryOptionPanelDisplayList(List<String> deliveryOptionPanelDisplayList) {
        mDeliveryOptionPanelDisplayList = deliveryOptionPanelDisplayList;
    }

    public List<String> getDetailFirstScreenDisplayList() {
        return mDetailFirstScreenDisplayList;
    }

    public void setDetailFirstScreenDisplayList(List<String> detailFirstScreenDisplayList) {
        mDetailFirstScreenDisplayList = detailFirstScreenDisplayList;
    }

    public DxTemplateInfo getDxTemplateInfo() {
        return mDxTemplateInfo;
    }

    public void setDxTemplateInfo(DxTemplateInfo dxTemplateInfo) {
        mDxTemplateInfo = dxTemplateInfo;
    }

    public Long getFinalPatternId() {
        return mFinalPatternId;
    }

    public void setFinalPatternId(Long finalPatternId) {
        mFinalPatternId = finalPatternId;
    }

    public List<String> getSkuSwitchDisplayList() {
        return mSkuSwitchDisplayList;
    }

    public void setSkuSwitchDisplayList(List<String> skuSwitchDisplayList) {
        mSkuSwitchDisplayList = skuSwitchDisplayList;
    }

    public List<List<TitleLayout>> getTitleLayout() {
        return mTitleLayout;
    }

    public void setTitleLayout(List<List<TitleLayout>> titleLayout) {
        mTitleLayout = titleLayout;
    }

}
