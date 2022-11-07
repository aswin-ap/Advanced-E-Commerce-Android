
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class PlatformCoupon {

    @SerializedName("displayType")
    private String mDisplayType;
    @SerializedName("promotionGroupTitle")
    private String mPromotionGroupTitle;
    @SerializedName("promotionPanelDetailDTOList")
    private List<PromotionPanelDetailDTOList> mPromotionPanelDetailDTOList;

    public String getDisplayType() {
        return mDisplayType;
    }

    public void setDisplayType(String displayType) {
        mDisplayType = displayType;
    }

    public String getPromotionGroupTitle() {
        return mPromotionGroupTitle;
    }

    public void setPromotionGroupTitle(String promotionGroupTitle) {
        mPromotionGroupTitle = promotionGroupTitle;
    }

    public List<PromotionPanelDetailDTOList> getPromotionPanelDetailDTOList() {
        return mPromotionPanelDetailDTOList;
    }

    public void setPromotionPanelDetailDTOList(List<PromotionPanelDetailDTOList> promotionPanelDetailDTOList) {
        mPromotionPanelDetailDTOList = promotionPanelDetailDTOList;
    }

}
