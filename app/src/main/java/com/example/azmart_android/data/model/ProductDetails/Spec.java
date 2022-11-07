
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class Spec {

    @SerializedName("attrName")
    private String mAttrName;
    @SerializedName("attrValue")
    private String mAttrValue;

    public String getAttrName() {
        return mAttrName;
    }

    public void setAttrName(String attrName) {
        mAttrName = attrName;
    }

    public String getAttrValue() {
        return mAttrValue;
    }

    public void setAttrValue(String attrValue) {
        mAttrValue = attrValue;
    }

}
