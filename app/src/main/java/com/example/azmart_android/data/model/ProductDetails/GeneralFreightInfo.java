
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class GeneralFreightInfo {

    @SerializedName("freightExt")
    private String mFreightExt;
    @SerializedName("hideShipFrom")
    private Boolean mHideShipFrom;
    @SerializedName("originalLayoutResultList")
    private List<OriginalLayoutResultList> mOriginalLayoutResultList;
    @SerializedName("usingNewFreight")
    private Boolean mUsingNewFreight;

    public String getFreightExt() {
        return mFreightExt;
    }

    public void setFreightExt(String freightExt) {
        mFreightExt = freightExt;
    }

    public Boolean getHideShipFrom() {
        return mHideShipFrom;
    }

    public void setHideShipFrom(Boolean hideShipFrom) {
        mHideShipFrom = hideShipFrom;
    }

    public List<OriginalLayoutResultList> getOriginalLayoutResultList() {
        return mOriginalLayoutResultList;
    }

    public void setOriginalLayoutResultList(List<OriginalLayoutResultList> originalLayoutResultList) {
        mOriginalLayoutResultList = originalLayoutResultList;
    }

    public Boolean getUsingNewFreight() {
        return mUsingNewFreight;
    }

    public void setUsingNewFreight(Boolean usingNewFreight) {
        mUsingNewFreight = usingNewFreight;
    }

}
