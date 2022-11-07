
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class PriceModule {

    @SerializedName("activity")
    private Boolean mActivity;
    @SerializedName("discountPromotion")
    private Boolean mDiscountPromotion;
    @SerializedName("extraTags")
    private ExtraTags mExtraTags;
    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("formatedPrice")
    private String mFormatedPrice;
    @SerializedName("hiddenBigSalePrice")
    private Boolean mHiddenBigSalePrice;
    @SerializedName("i18nMap")
    private I18nMap mI18nMap;
    @SerializedName("id")
    private Long mId;
    @SerializedName("installment")
    private Boolean mInstallment;
    @SerializedName("lot")
    private Boolean mLot;
    @SerializedName("maxAmount")
    private MaxAmount mMaxAmount;
    @SerializedName("minAmount")
    private MinAmount mMinAmount;
    @SerializedName("multiUnitName")
    private String mMultiUnitName;
    @SerializedName("name")
    private String mName;
    @SerializedName("numberPerLot")
    private Long mNumberPerLot;
    @SerializedName("oddUnitName")
    private String mOddUnitName;
    @SerializedName("preSale")
    private Boolean mPreSale;
    @SerializedName("priceRuleInfo")
    private PriceRuleInfo mPriceRuleInfo;
    @SerializedName("promotionSellingPointTags")
    private List<PromotionSellingPointTag> mPromotionSellingPointTags;
    @SerializedName("regularPriceActivity")
    private Boolean mRegularPriceActivity;
    @SerializedName("showActivityMessage")
    private Boolean mShowActivityMessage;
    @SerializedName("vatDesc")
    private String mVatDesc;

    public Boolean getActivity() {
        return mActivity;
    }

    public void setActivity(Boolean activity) {
        mActivity = activity;
    }

    public Boolean getDiscountPromotion() {
        return mDiscountPromotion;
    }

    public void setDiscountPromotion(Boolean discountPromotion) {
        mDiscountPromotion = discountPromotion;
    }

    public ExtraTags getExtraTags() {
        return mExtraTags;
    }

    public void setExtraTags(ExtraTags extraTags) {
        mExtraTags = extraTags;
    }

    public Features getFeatures() {
        return mFeatures;
    }

    public void setFeatures(Features features) {
        mFeatures = features;
    }

    public String getFormatedPrice() {
        return mFormatedPrice;
    }

    public void setFormatedPrice(String formatedPrice) {
        mFormatedPrice = formatedPrice;
    }

    public Boolean getHiddenBigSalePrice() {
        return mHiddenBigSalePrice;
    }

    public void setHiddenBigSalePrice(Boolean hiddenBigSalePrice) {
        mHiddenBigSalePrice = hiddenBigSalePrice;
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

    public Boolean getInstallment() {
        return mInstallment;
    }

    public void setInstallment(Boolean installment) {
        mInstallment = installment;
    }

    public Boolean getLot() {
        return mLot;
    }

    public void setLot(Boolean lot) {
        mLot = lot;
    }

    public MaxAmount getMaxAmount() {
        return mMaxAmount;
    }

    public void setMaxAmount(MaxAmount maxAmount) {
        mMaxAmount = maxAmount;
    }

    public MinAmount getMinAmount() {
        return mMinAmount;
    }

    public void setMinAmount(MinAmount minAmount) {
        mMinAmount = minAmount;
    }

    public String getMultiUnitName() {
        return mMultiUnitName;
    }

    public void setMultiUnitName(String multiUnitName) {
        mMultiUnitName = multiUnitName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getNumberPerLot() {
        return mNumberPerLot;
    }

    public void setNumberPerLot(Long numberPerLot) {
        mNumberPerLot = numberPerLot;
    }

    public String getOddUnitName() {
        return mOddUnitName;
    }

    public void setOddUnitName(String oddUnitName) {
        mOddUnitName = oddUnitName;
    }

    public Boolean getPreSale() {
        return mPreSale;
    }

    public void setPreSale(Boolean preSale) {
        mPreSale = preSale;
    }

    public PriceRuleInfo getPriceRuleInfo() {
        return mPriceRuleInfo;
    }

    public void setPriceRuleInfo(PriceRuleInfo priceRuleInfo) {
        mPriceRuleInfo = priceRuleInfo;
    }

    public List<PromotionSellingPointTag> getPromotionSellingPointTags() {
        return mPromotionSellingPointTags;
    }

    public void setPromotionSellingPointTags(List<PromotionSellingPointTag> promotionSellingPointTags) {
        mPromotionSellingPointTags = promotionSellingPointTags;
    }

    public Boolean getRegularPriceActivity() {
        return mRegularPriceActivity;
    }

    public void setRegularPriceActivity(Boolean regularPriceActivity) {
        mRegularPriceActivity = regularPriceActivity;
    }

    public Boolean getShowActivityMessage() {
        return mShowActivityMessage;
    }

    public void setShowActivityMessage(Boolean showActivityMessage) {
        mShowActivityMessage = showActivityMessage;
    }

    public String getVatDesc() {
        return mVatDesc;
    }

    public void setVatDesc(String vatDesc) {
        mVatDesc = vatDesc;
    }

}
