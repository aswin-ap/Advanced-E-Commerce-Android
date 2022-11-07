
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class CommonModule {

    @SerializedName("activity")
    private Boolean mActivity;
    @SerializedName("categoryId")
    private Long mCategoryId;
    @SerializedName("crawler")
    private Boolean mCrawler;
    @SerializedName("currencyCode")
    private String mCurrencyCode;
    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("gagaDataSite")
    private String mGagaDataSite;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("plaza")
    private Boolean mPlaza;
    @SerializedName("preSale")
    private Boolean mPreSale;
    @SerializedName("productId")
    private Long mProductId;
    @SerializedName("productIdStr")
    private String mProductIdStr;
    @SerializedName("productTags")
    private ProductTags mProductTags;
    @SerializedName("reminds")
    private List<Object> mReminds;
    @SerializedName("sellerAdminSeq")
    private Long mSellerAdminSeq;
    @SerializedName("tradeCurrencyCode")
    private String mTradeCurrencyCode;
    @SerializedName("userCountryCode")
    private String mUserCountryCode;
    @SerializedName("userCountryName")
    private String mUserCountryName;

    public Boolean getActivity() {
        return mActivity;
    }

    public void setActivity(Boolean activity) {
        mActivity = activity;
    }

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long categoryId) {
        mCategoryId = categoryId;
    }

    public Boolean getCrawler() {
        return mCrawler;
    }

    public void setCrawler(Boolean crawler) {
        mCrawler = crawler;
    }

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

    public String getGagaDataSite() {
        return mGagaDataSite;
    }

    public void setGagaDataSite(String gagaDataSite) {
        mGagaDataSite = gagaDataSite;
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

    public Boolean getPlaza() {
        return mPlaza;
    }

    public void setPlaza(Boolean plaza) {
        mPlaza = plaza;
    }

    public Boolean getPreSale() {
        return mPreSale;
    }

    public void setPreSale(Boolean preSale) {
        mPreSale = preSale;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public String getProductIdStr() {
        return mProductIdStr;
    }

    public void setProductIdStr(String productIdStr) {
        mProductIdStr = productIdStr;
    }

    public ProductTags getProductTags() {
        return mProductTags;
    }

    public void setProductTags(ProductTags productTags) {
        mProductTags = productTags;
    }

    public List<Object> getReminds() {
        return mReminds;
    }

    public void setReminds(List<Object> reminds) {
        mReminds = reminds;
    }

    public Long getSellerAdminSeq() {
        return mSellerAdminSeq;
    }

    public void setSellerAdminSeq(Long sellerAdminSeq) {
        mSellerAdminSeq = sellerAdminSeq;
    }

    public String getTradeCurrencyCode() {
        return mTradeCurrencyCode;
    }

    public void setTradeCurrencyCode(String tradeCurrencyCode) {
        mTradeCurrencyCode = tradeCurrencyCode;
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
