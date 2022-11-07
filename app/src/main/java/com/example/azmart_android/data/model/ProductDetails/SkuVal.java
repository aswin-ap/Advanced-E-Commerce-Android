
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SkuVal {

    @SerializedName("availQuantity")
    private Long mAvailQuantity;
    @SerializedName("inventory")
    private Long mInventory;
    @SerializedName("isActivity")
    private Boolean mIsActivity;
    @SerializedName("optionalWarrantyPrice")
    private List<Object> mOptionalWarrantyPrice;
    @SerializedName("skuAmount")
    private SkuAmount mSkuAmount;
    @SerializedName("skuCalPrice")
    private String mSkuCalPrice;

    public Long getAvailQuantity() {
        return mAvailQuantity;
    }

    public void setAvailQuantity(Long availQuantity) {
        mAvailQuantity = availQuantity;
    }

    public Long getInventory() {
        return mInventory;
    }

    public void setInventory(Long inventory) {
        mInventory = inventory;
    }

    public Boolean getIsActivity() {
        return mIsActivity;
    }

    public void setIsActivity(Boolean isActivity) {
        mIsActivity = isActivity;
    }

    public List<Object> getOptionalWarrantyPrice() {
        return mOptionalWarrantyPrice;
    }

    public void setOptionalWarrantyPrice(List<Object> optionalWarrantyPrice) {
        mOptionalWarrantyPrice = optionalWarrantyPrice;
    }

    public SkuAmount getSkuAmount() {
        return mSkuAmount;
    }

    public void setSkuAmount(SkuAmount skuAmount) {
        mSkuAmount = skuAmount;
    }

    public String getSkuCalPrice() {
        return mSkuCalPrice;
    }

    public void setSkuCalPrice(String skuCalPrice) {
        mSkuCalPrice = skuCalPrice;
    }

}
