
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;

public class WebEnv {

    @SerializedName("country")
    private String mCountry;
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("env")
    private Env mEnv;
    @SerializedName("host")
    private String mHost;
    @SerializedName("hostname")
    private String mHostname;
    @SerializedName("ip")
    private String mIp;
    @SerializedName("lang")
    private String mLang;
    @SerializedName("language")
    private String mLanguage;
    @SerializedName("locale")
    private String mLocale;
    @SerializedName("reqHost")
    private String mReqHost;
    @SerializedName("site")
    private String mSite;
    @SerializedName("traceId")
    private String mTraceId;

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public Env getEnv() {
        return mEnv;
    }

    public void setEnv(Env env) {
        mEnv = env;
    }

    public String getHost() {
        return mHost;
    }

    public void setHost(String host) {
        mHost = host;
    }

    public String getHostname() {
        return mHostname;
    }

    public void setHostname(String hostname) {
        mHostname = hostname;
    }

    public String getIp() {
        return mIp;
    }

    public void setIp(String ip) {
        mIp = ip;
    }

    public String getLang() {
        return mLang;
    }

    public void setLang(String lang) {
        mLang = lang;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getLocale() {
        return mLocale;
    }

    public void setLocale(String locale) {
        mLocale = locale;
    }

    public String getReqHost() {
        return mReqHost;
    }

    public void setReqHost(String reqHost) {
        mReqHost = reqHost;
    }

    public String getSite() {
        return mSite;
    }

    public void setSite(String site) {
        mSite = site;
    }

    public String getTraceId() {
        return mTraceId;
    }

    public void setTraceId(String traceId) {
        mTraceId = traceId;
    }

}
