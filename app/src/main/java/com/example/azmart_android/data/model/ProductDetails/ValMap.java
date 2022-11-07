
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;

public class ValMap {

    @SerializedName("g11n:country")
    private String mG11nCountry;
    @SerializedName("g11n:currency")
    private String mG11nCurrency;
    @SerializedName("g11n:locale")
    private String mG11nLocale;
    @SerializedName("g11n:site")
    private String mG11nSite;
    @SerializedName("g11n:timezone")
    private String mG11nTimezone;
    @SerializedName("page:app")
    private String mPageApp;
    @SerializedName("page:id")
    private String mPageId;
    @SerializedName("page:name")
    private String mPageName;
    @SerializedName("ua:browser")
    private String mUaBrowser;
    @SerializedName("ua:device")
    private String mUaDevice;
    @SerializedName("ua:platform")
    private String mUaPlatform;
    @SerializedName("user:id")
    private String mUserId;
    @SerializedName("user:member")
    private String mUserMember;
    @SerializedName("user:type")
    private String mUserType;

    public String getG11nCountry() {
        return mG11nCountry;
    }

    public void setG11nCountry(String g11nCountry) {
        mG11nCountry = g11nCountry;
    }

    public String getG11nCurrency() {
        return mG11nCurrency;
    }

    public void setG11nCurrency(String g11nCurrency) {
        mG11nCurrency = g11nCurrency;
    }

    public String getG11nLocale() {
        return mG11nLocale;
    }

    public void setG11nLocale(String g11nLocale) {
        mG11nLocale = g11nLocale;
    }

    public String getG11nSite() {
        return mG11nSite;
    }

    public void setG11nSite(String g11nSite) {
        mG11nSite = g11nSite;
    }

    public String getG11nTimezone() {
        return mG11nTimezone;
    }

    public void setG11nTimezone(String g11nTimezone) {
        mG11nTimezone = g11nTimezone;
    }

    public String getPageApp() {
        return mPageApp;
    }

    public void setPageApp(String pageApp) {
        mPageApp = pageApp;
    }

    public String getPageId() {
        return mPageId;
    }

    public void setPageId(String pageId) {
        mPageId = pageId;
    }

    public String getPageName() {
        return mPageName;
    }

    public void setPageName(String pageName) {
        mPageName = pageName;
    }

    public String getUaBrowser() {
        return mUaBrowser;
    }

    public void setUaBrowser(String uaBrowser) {
        mUaBrowser = uaBrowser;
    }

    public String getUaDevice() {
        return mUaDevice;
    }

    public void setUaDevice(String uaDevice) {
        mUaDevice = uaDevice;
    }

    public String getUaPlatform() {
        return mUaPlatform;
    }

    public void setUaPlatform(String uaPlatform) {
        mUaPlatform = uaPlatform;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getUserMember() {
        return mUserMember;
    }

    public void setUserMember(String userMember) {
        mUserMember = userMember;
    }

    public String getUserType() {
        return mUserType;
    }

    public void setUserType(String userType) {
        mUserType = userType;
    }

}
