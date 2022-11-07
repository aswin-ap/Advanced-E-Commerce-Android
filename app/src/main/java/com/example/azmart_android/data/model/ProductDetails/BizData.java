
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class BizData {

    @SerializedName("company")
    private String mCompany;
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("deliveryDate")
    private String mDeliveryDate;
    @SerializedName("deliveryDayMax")
    private Long mDeliveryDayMax;
    @SerializedName("deliveryDayMin")
    private Long mDeliveryDayMin;
    @SerializedName("deliveryOptionCode")
    private String mDeliveryOptionCode;
    @SerializedName("deliveryProviderCode")
    private String mDeliveryProviderCode;
    @SerializedName("deliveryProviderName")
    private String mDeliveryProviderName;
    @SerializedName("discount")
    private Long mDiscount;
    @SerializedName("etaTraceId")
    private String mEtaTraceId;
    @SerializedName("freightCommitDay")
    private String mFreightCommitDay;
    @SerializedName("guaranteedDeliveryTime")
    private Long mGuaranteedDeliveryTime;
    @SerializedName("guaranteedDeliveryTimeProviderName")
    private String mGuaranteedDeliveryTimeProviderName;
    @SerializedName("itemId")
    private Long mItemId;
    @SerializedName("itemScene")
    private String mItemScene;
    @SerializedName("itemShipFromType")
    private String mItemShipFromType;
    @SerializedName("leadTimeSort")
    private List<Long> mLeadTimeSort;
    @SerializedName("patternId")
    private Long mPatternId;
    @SerializedName("provider")
    private String mProvider;
    @SerializedName("shipFrom")
    private String mShipFrom;
    @SerializedName("shipFromCode")
    private String mShipFromCode;
    @SerializedName("shipTo")
    private String mShipTo;
    @SerializedName("shipToCode")
    private String mShipToCode;
    @SerializedName("shippingFee")
    private String mShippingFee;
    @SerializedName("solutionBusinessType")
    private String mSolutionBusinessType;
    @SerializedName("solutionId")
    private Long mSolutionId;
    @SerializedName("tracking")
    private String mTracking;
    @SerializedName("utParams")
    private String mUtParams;

    public String getCompany() {
        return mCompany;
    }

    public void setCompany(String company) {
        mCompany = company;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getDeliveryDate() {
        return mDeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        mDeliveryDate = deliveryDate;
    }

    public Long getDeliveryDayMax() {
        return mDeliveryDayMax;
    }

    public void setDeliveryDayMax(Long deliveryDayMax) {
        mDeliveryDayMax = deliveryDayMax;
    }

    public Long getDeliveryDayMin() {
        return mDeliveryDayMin;
    }

    public void setDeliveryDayMin(Long deliveryDayMin) {
        mDeliveryDayMin = deliveryDayMin;
    }

    public String getDeliveryOptionCode() {
        return mDeliveryOptionCode;
    }

    public void setDeliveryOptionCode(String deliveryOptionCode) {
        mDeliveryOptionCode = deliveryOptionCode;
    }

    public String getDeliveryProviderCode() {
        return mDeliveryProviderCode;
    }

    public void setDeliveryProviderCode(String deliveryProviderCode) {
        mDeliveryProviderCode = deliveryProviderCode;
    }

    public String getDeliveryProviderName() {
        return mDeliveryProviderName;
    }

    public void setDeliveryProviderName(String deliveryProviderName) {
        mDeliveryProviderName = deliveryProviderName;
    }

    public Long getDiscount() {
        return mDiscount;
    }

    public void setDiscount(Long discount) {
        mDiscount = discount;
    }

    public String getEtaTraceId() {
        return mEtaTraceId;
    }

    public void setEtaTraceId(String etaTraceId) {
        mEtaTraceId = etaTraceId;
    }

    public String getFreightCommitDay() {
        return mFreightCommitDay;
    }

    public void setFreightCommitDay(String freightCommitDay) {
        mFreightCommitDay = freightCommitDay;
    }

    public Long getGuaranteedDeliveryTime() {
        return mGuaranteedDeliveryTime;
    }

    public void setGuaranteedDeliveryTime(Long guaranteedDeliveryTime) {
        mGuaranteedDeliveryTime = guaranteedDeliveryTime;
    }

    public String getGuaranteedDeliveryTimeProviderName() {
        return mGuaranteedDeliveryTimeProviderName;
    }

    public void setGuaranteedDeliveryTimeProviderName(String guaranteedDeliveryTimeProviderName) {
        mGuaranteedDeliveryTimeProviderName = guaranteedDeliveryTimeProviderName;
    }

    public Long getItemId() {
        return mItemId;
    }

    public void setItemId(Long itemId) {
        mItemId = itemId;
    }

    public String getItemScene() {
        return mItemScene;
    }

    public void setItemScene(String itemScene) {
        mItemScene = itemScene;
    }

    public String getItemShipFromType() {
        return mItemShipFromType;
    }

    public void setItemShipFromType(String itemShipFromType) {
        mItemShipFromType = itemShipFromType;
    }

    public List<Long> getLeadTimeSort() {
        return mLeadTimeSort;
    }

    public void setLeadTimeSort(List<Long> leadTimeSort) {
        mLeadTimeSort = leadTimeSort;
    }

    public Long getPatternId() {
        return mPatternId;
    }

    public void setPatternId(Long patternId) {
        mPatternId = patternId;
    }

    public String getProvider() {
        return mProvider;
    }

    public void setProvider(String provider) {
        mProvider = provider;
    }

    public String getShipFrom() {
        return mShipFrom;
    }

    public void setShipFrom(String shipFrom) {
        mShipFrom = shipFrom;
    }

    public String getShipFromCode() {
        return mShipFromCode;
    }

    public void setShipFromCode(String shipFromCode) {
        mShipFromCode = shipFromCode;
    }

    public String getShipTo() {
        return mShipTo;
    }

    public void setShipTo(String shipTo) {
        mShipTo = shipTo;
    }

    public String getShipToCode() {
        return mShipToCode;
    }

    public void setShipToCode(String shipToCode) {
        mShipToCode = shipToCode;
    }

    public String getShippingFee() {
        return mShippingFee;
    }

    public void setShippingFee(String shippingFee) {
        mShippingFee = shippingFee;
    }

    public String getSolutionBusinessType() {
        return mSolutionBusinessType;
    }

    public void setSolutionBusinessType(String solutionBusinessType) {
        mSolutionBusinessType = solutionBusinessType;
    }

    public Long getSolutionId() {
        return mSolutionId;
    }

    public void setSolutionId(Long solutionId) {
        mSolutionId = solutionId;
    }

    public String getTracking() {
        return mTracking;
    }

    public void setTracking(String tracking) {
        mTracking = tracking;
    }

    public String getUtParams() {
        return mUtParams;
    }

    public void setUtParams(String utParams) {
        mUtParams = utParams;
    }

}
