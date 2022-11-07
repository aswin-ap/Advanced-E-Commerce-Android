
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class PromotionPanelDTO {

    @SerializedName("platformCoupon")
    private List<PlatformCoupon> mPlatformCoupon;

    public List<PlatformCoupon> getPlatformCoupon() {
        return mPlatformCoupon;
    }

    public void setPlatformCoupon(List<PlatformCoupon> platformCoupon) {
        mPlatformCoupon = platformCoupon;
    }

}
