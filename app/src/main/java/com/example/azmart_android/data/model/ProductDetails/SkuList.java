
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class SkuList {

    @SerializedName("freightExt")
    private String mFreightExt;
    @SerializedName("skuAttr")
    private String mSkuAttr;
    @SerializedName("skuId")
    private Long mSkuId;
    @SerializedName("skuIdStr")
    private String mSkuIdStr;
    @SerializedName("skuPropIds")
    private String mSkuPropIds;
    @SerializedName("skuVal")
    private SkuVal mSkuVal;

    public String getFreightExt() {
        return mFreightExt;
    }

    public void setFreightExt(String freightExt) {
        mFreightExt = freightExt;
    }

    public String getSkuAttr() {
        return mSkuAttr;
    }

    public void setSkuAttr(String skuAttr) {
        mSkuAttr = skuAttr;
    }

    public Long getSkuId() {
        return mSkuId;
    }

    public void setSkuId(Long skuId) {
        mSkuId = skuId;
    }

    public String getSkuIdStr() {
        return mSkuIdStr;
    }

    public void setSkuIdStr(String skuIdStr) {
        mSkuIdStr = skuIdStr;
    }

    public String getSkuPropIds() {
        return mSkuPropIds;
    }

    public void setSkuPropIds(String skuPropIds) {
        mSkuPropIds = skuPropIds;
    }

    public SkuVal getSkuVal() {
        return mSkuVal;
    }

    public void setSkuVal(SkuVal skuVal) {
        mSkuVal = skuVal;
    }

}
