
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class TitleModule {

    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("feedbackRatings")
    private FeedbackRatings mFeedbackRatings;
    @SerializedName("formatTradeCount")
    private String mFormatTradeCount;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("orig")
    private Boolean mOrig;
    @SerializedName("origTitle")
    private Boolean mOrigTitle;
    @SerializedName("product_description")
    private String mProductDescription;
    @SerializedName("product_title")
    private String mProductTitle;
    @SerializedName("subject")
    private String mSubject;
    @SerializedName("titleTags")
    private List<Object> mTitleTags;
    @SerializedName("tradeCount")
    private Long mTradeCount;
    @SerializedName("tradeCountUnit")
    private String mTradeCountUnit;
    @SerializedName("trans")
    private Boolean mTrans;
    @SerializedName("transTitle")
    private Boolean mTransTitle;

    public Features getFeatures() {
        return mFeatures;
    }

    public void setFeatures(Features features) {
        mFeatures = features;
    }

    public FeedbackRatings getFeedbackRatings() {
        return mFeedbackRatings;
    }

    public void setFeedbackRatings(FeedbackRatings feedbackRatings) {
        mFeedbackRatings = feedbackRatings;
    }

    public String getFormatTradeCount() {
        return mFormatTradeCount;
    }

    public void setFormatTradeCount(String formatTradeCount) {
        mFormatTradeCount = formatTradeCount;
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

    public Boolean getOrig() {
        return mOrig;
    }

    public void setOrig(Boolean orig) {
        mOrig = orig;
    }

    public Boolean getOrigTitle() {
        return mOrigTitle;
    }

    public void setOrigTitle(Boolean origTitle) {
        mOrigTitle = origTitle;
    }

    public String getProductDescription() {
        return mProductDescription;
    }

    public void setProductDescription(String productDescription) {
        mProductDescription = productDescription;
    }

    public String getProductTitle() {
        return mProductTitle;
    }

    public void setProductTitle(String productTitle) {
        mProductTitle = productTitle;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

    public List<Object> getTitleTags() {
        return mTitleTags;
    }

    public void setTitleTags(List<Object> titleTags) {
        mTitleTags = titleTags;
    }

    public Long getTradeCount() {
        return mTradeCount;
    }

    public void setTradeCount(Long tradeCount) {
        mTradeCount = tradeCount;
    }

    public String getTradeCountUnit() {
        return mTradeCountUnit;
    }

    public void setTradeCountUnit(String tradeCountUnit) {
        mTradeCountUnit = tradeCountUnit;
    }

    public Boolean getTrans() {
        return mTrans;
    }

    public void setTrans(Boolean trans) {
        mTrans = trans;
    }

    public Boolean getTransTitle() {
        return mTransTitle;
    }

    public void setTransTitle(Boolean transTitle) {
        mTransTitle = transTitle;
    }

}
