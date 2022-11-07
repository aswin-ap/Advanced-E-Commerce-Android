
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class Features {

    @SerializedName("recommendGpsScenarioOtherSellerProducts")
    private String mRecommendGpsScenarioOtherSellerProducts;
    @SerializedName("recommendGpsScenarioSellerOtherProducts")
    private String mRecommendGpsScenarioSellerOtherProducts;
    @SerializedName("recommendGpsScenarioTopSelling")
    private String mRecommendGpsScenarioTopSelling;
    @SerializedName("showSubTitle")
    private String mShowSubTitle;

    public String getRecommendGpsScenarioOtherSellerProducts() {
        return mRecommendGpsScenarioOtherSellerProducts;
    }

    public void setRecommendGpsScenarioOtherSellerProducts(String recommendGpsScenarioOtherSellerProducts) {
        mRecommendGpsScenarioOtherSellerProducts = recommendGpsScenarioOtherSellerProducts;
    }

    public String getRecommendGpsScenarioSellerOtherProducts() {
        return mRecommendGpsScenarioSellerOtherProducts;
    }

    public void setRecommendGpsScenarioSellerOtherProducts(String recommendGpsScenarioSellerOtherProducts) {
        mRecommendGpsScenarioSellerOtherProducts = recommendGpsScenarioSellerOtherProducts;
    }

    public String getRecommendGpsScenarioTopSelling() {
        return mRecommendGpsScenarioTopSelling;
    }

    public void setRecommendGpsScenarioTopSelling(String recommendGpsScenarioTopSelling) {
        mRecommendGpsScenarioTopSelling = recommendGpsScenarioTopSelling;
    }

    public String getShowSubTitle() {
        return mShowSubTitle;
    }

    public void setShowSubTitle(String showSubTitle) {
        mShowSubTitle = showSubTitle;
    }

}
