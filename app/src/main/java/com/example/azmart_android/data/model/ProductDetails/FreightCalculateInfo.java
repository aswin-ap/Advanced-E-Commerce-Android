
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class FreightCalculateInfo {

    @SerializedName("displayMultipleFreight")
    private Boolean mDisplayMultipleFreight;
    @SerializedName("hideFreight")
    private Boolean mHideFreight;

    public Boolean getDisplayMultipleFreight() {
        return mDisplayMultipleFreight;
    }

    public void setDisplayMultipleFreight(Boolean displayMultipleFreight) {
        mDisplayMultipleFreight = displayMultipleFreight;
    }

    public Boolean getHideFreight() {
        return mHideFreight;
    }

    public void setHideFreight(Boolean hideFreight) {
        mHideFreight = hideFreight;
    }

}
