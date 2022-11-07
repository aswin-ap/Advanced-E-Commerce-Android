
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;

public class ShippingModule {

    @SerializedName("currencyCode")
    private String mCurrencyCode;
    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("freightCalculateInfo")
    private FreightCalculateInfo mFreightCalculateInfo;
    @SerializedName("generalFreightInfo")
    private GeneralFreightInfo mGeneralFreightInfo;
    @SerializedName("hbaFreeShipping")
    private Boolean mHbaFreeShipping;
    @SerializedName("hbaFreight")
    private Boolean mHbaFreight;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("productId")
    private Long mProductId;
    @SerializedName("regionCountryName")
    private String mRegionCountryName;
    @SerializedName("suppressFreightInvoke")
    private Boolean mSuppressFreightInvoke;
    @SerializedName("userCountryCode")
    private String mUserCountryCode;
    @SerializedName("userCountryName")
    private String mUserCountryName;

    public String getCurrencyCode() {
        return mCurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        mCurrencyCode = currencyCode;
    }

    public Features getFeatures() {
        return mFeatures;
    }

    public void setFeatures(Features features) {
        mFeatures = features;
    }

    public FreightCalculateInfo getFreightCalculateInfo() {
        return mFreightCalculateInfo;
    }

    public void setFreightCalculateInfo(FreightCalculateInfo freightCalculateInfo) {
        mFreightCalculateInfo = freightCalculateInfo;
    }

    public GeneralFreightInfo getGeneralFreightInfo() {
        return mGeneralFreightInfo;
    }

    public void setGeneralFreightInfo(GeneralFreightInfo generalFreightInfo) {
        mGeneralFreightInfo = generalFreightInfo;
    }

    public Boolean getHbaFreeShipping() {
        return mHbaFreeShipping;
    }

    public void setHbaFreeShipping(Boolean hbaFreeShipping) {
        mHbaFreeShipping = hbaFreeShipping;
    }

    public Boolean getHbaFreight() {
        return mHbaFreight;
    }

    public void setHbaFreight(Boolean hbaFreight) {
        mHbaFreight = hbaFreight;
    }

    public I18nMap getI18nMap() {
        return mI18nMap;
    }

    public void setI18nMap(I18nMap i18nMap) {
        mI18nMap = i18nMap;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public String getRegionCountryName() {
        return mRegionCountryName;
    }

    public void setRegionCountryName(String regionCountryName) {
        mRegionCountryName = regionCountryName;
    }

    public Boolean getSuppressFreightInvoke() {
        return mSuppressFreightInvoke;
    }

    public void setSuppressFreightInvoke(Boolean suppressFreightInvoke) {
        mSuppressFreightInvoke = suppressFreightInvoke;
    }

    public String getUserCountryCode() {
        return mUserCountryCode;
    }

    public void setUserCountryCode(String userCountryCode) {
        mUserCountryCode = userCountryCode;
    }

    public String getUserCountryName() {
        return mUserCountryName;
    }

    public void setUserCountryName(String userCountryName) {
        mUserCountryName = userCountryName;
    }

}
