
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class ProductDetailsResponse {

    @SerializedName("app_sale_price")
    private Double mAppSalePrice;
    @SerializedName("app_sale_price_currency")
    private String mAppSalePriceCurrency;
    @SerializedName("discount_rate")
    private Double mDiscountRate;
    @SerializedName("evaluate_rate")
    private String mEvaluateRate;
    @SerializedName("feedBackRating")
    private FeedBackRating mFeedBackRating;
    @SerializedName("first_level_category_id")
    private Long mFirstLevelCategoryId;
    @SerializedName("lastest_volume")
    private Long mLastestVolume;
    @SerializedName("metadata")
    private Metadata mMetadata;
    @SerializedName("productCategoriesBreadcrumb")
    private List<ProductCategoriesBreadcrumb> mProductCategoriesBreadcrumb;
    @SerializedName("product_detail_url")
    private String mProductDetailUrl;
    @SerializedName("product_id")
    private String mProductId;
    @SerializedName("product_small_image_urls")
    private ProductSmallImageUrls mProductSmallImageUrls;
    @SerializedName("quantityObject")
    private QuantityObject mQuantityObject;
    @SerializedName("second_level_category_id")
    private Long mSecondLevelCategoryId;
    @SerializedName("shop_id")
    private Long mShopId;
    @SerializedName("shop_name")
    private String mShopName;
    @SerializedName("shop_url")
    private String mShopUrl;
    @SerializedName("skuList")
    private List<SkuList> mSkuList;
    @SerializedName("skuProperties")
    private List<SkuProperty> mSkuProperties;
    @SerializedName("specs")
    private List<Spec> mSpecs;
    @SerializedName("wishedCount")
    private Long mWishedCount;

    public Double getAppSalePrice() {
        return mAppSalePrice;
    }

    public void setAppSalePrice(Double appSalePrice) {
        mAppSalePrice = appSalePrice;
    }

    public String getAppSalePriceCurrency() {
        return mAppSalePriceCurrency;
    }

    public void setAppSalePriceCurrency(String appSalePriceCurrency) {
        mAppSalePriceCurrency = appSalePriceCurrency;
    }

    public Double getDiscountRate() {
        return mDiscountRate;
    }

    public void setDiscountRate(Double discountRate) {
        mDiscountRate = discountRate;
    }

    public String getEvaluateRate() {
        return mEvaluateRate;
    }

    public void setEvaluateRate(String evaluateRate) {
        mEvaluateRate = evaluateRate;
    }

    public FeedBackRating getFeedBackRating() {
        return mFeedBackRating;
    }

    public void setFeedBackRating(FeedBackRating feedBackRating) {
        mFeedBackRating = feedBackRating;
    }

    public Long getFirstLevelCategoryId() {
        return mFirstLevelCategoryId;
    }

    public void setFirstLevelCategoryId(Long firstLevelCategoryId) {
        mFirstLevelCategoryId = firstLevelCategoryId;
    }

    public Long getLastestVolume() {
        return mLastestVolume;
    }

    public void setLastestVolume(Long lastestVolume) {
        mLastestVolume = lastestVolume;
    }

    public Metadata getMetadata() {
        return mMetadata;
    }

    public void setMetadata(Metadata metadata) {
        mMetadata = metadata;
    }

    public List<ProductCategoriesBreadcrumb> getProductCategoriesBreadcrumb() {
        return mProductCategoriesBreadcrumb;
    }

    public void setProductCategoriesBreadcrumb(List<ProductCategoriesBreadcrumb> productCategoriesBreadcrumb) {
        mProductCategoriesBreadcrumb = productCategoriesBreadcrumb;
    }

    public String getProductDetailUrl() {
        return mProductDetailUrl;
    }

    public void setProductDetailUrl(String productDetailUrl) {
        mProductDetailUrl = productDetailUrl;
    }

    public String getProductId() {
        return mProductId;
    }

    public void setProductId(String productId) {
        mProductId = productId;
    }

    public ProductSmallImageUrls getProductSmallImageUrls() {
        return mProductSmallImageUrls;
    }

    public void setProductSmallImageUrls(ProductSmallImageUrls productSmallImageUrls) {
        mProductSmallImageUrls = productSmallImageUrls;
    }

    public QuantityObject getQuantityObject() {
        return mQuantityObject;
    }

    public void setQuantityObject(QuantityObject quantityObject) {
        mQuantityObject = quantityObject;
    }

    public Long getSecondLevelCategoryId() {
        return mSecondLevelCategoryId;
    }

    public void setSecondLevelCategoryId(Long secondLevelCategoryId) {
        mSecondLevelCategoryId = secondLevelCategoryId;
    }

    public Long getShopId() {
        return mShopId;
    }

    public void setShopId(Long shopId) {
        mShopId = shopId;
    }

    public String getShopName() {
        return mShopName;
    }

    public void setShopName(String shopName) {
        mShopName = shopName;
    }

    public String getShopUrl() {
        return mShopUrl;
    }

    public void setShopUrl(String shopUrl) {
        mShopUrl = shopUrl;
    }

    public List<SkuList> getSkuList() {
        return mSkuList;
    }

    public void setSkuList(List<SkuList> skuList) {
        mSkuList = skuList;
    }

    public List<SkuProperty> getSkuProperties() {
        return mSkuProperties;
    }

    public void setSkuProperties(List<SkuProperty> skuProperties) {
        mSkuProperties = skuProperties;
    }

    public List<Spec> getSpecs() {
        return mSpecs;
    }

    public void setSpecs(List<Spec> specs) {
        mSpecs = specs;
    }

    public Long getWishedCount() {
        return mWishedCount;
    }

    public void setWishedCount(Long wishedCount) {
        mWishedCount = wishedCount;
    }

}
