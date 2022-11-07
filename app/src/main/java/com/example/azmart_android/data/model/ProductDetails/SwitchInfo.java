
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;

public class SwitchInfo {

    @SerializedName("skuUnavailableRevision")
    private Boolean mSkuUnavailableRevision;

    public Boolean getSkuUnavailableRevision() {
        return mSkuUnavailableRevision;
    }

    public void setSkuUnavailableRevision(Boolean skuUnavailableRevision) {
        mSkuUnavailableRevision = skuUnavailableRevision;
    }

}
