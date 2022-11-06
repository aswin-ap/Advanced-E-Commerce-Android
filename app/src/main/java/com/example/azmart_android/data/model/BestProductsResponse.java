package com.example.azmart_android.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BestProductsResponse {

    @SerializedName("modificationDate")
    @Expose
    private String modificationDate;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("commission_rate")
    @Expose
    private Integer commissionRate;
    @SerializedName("first_level_category_id")
    @Expose
    private String firstLevelCategoryId;
    @SerializedName("first_level_category_name")
    @Expose
    private String firstLevelCategoryName;
    @SerializedName("hot_product_commission_rate")
    @Expose
    private Double hotProductCommissionRate;
    @SerializedName("product_detail_url")
    @Expose
    private String productDetailUrl;
    @SerializedName("product_id")
    @Expose
    private Long productId;
    @SerializedName("product_main_image_url")
    @Expose
    private String productMainImageUrl;
    @SerializedName("product_small_image_urls")
    @Expose
    private ProductSmallImageUrls productSmallImageUrls;
    @SerializedName("product_title")
    @Expose
    private String productTitle;
    @SerializedName("promotion_link")
    @Expose
    private String promotionLink;
    @SerializedName("relevant_market_commission_rate")
    @Expose
    private String relevantMarketCommissionRate;
    @SerializedName("second_level_category_id")
    @Expose
    private Integer secondLevelCategoryId;
    @SerializedName("second_level_category_name")
    @Expose
    private String secondLevelCategoryName;
    @SerializedName("shop")
    @Expose
    private Shop shop;
    @SerializedName("app_sale_price")
    @Expose
    private Double appSalePrice;
    @SerializedName("app_sale_price_currency")
    @Expose
    private String appSalePriceCurrency;
    @SerializedName("original_price")
    @Expose
    private Double originalPrice;
    @SerializedName("sale_price")
    @Expose
    private Double salePrice;
    @SerializedName("sale_price_currency")
    @Expose
    private String salePriceCurrency;
    @SerializedName("prices")
    @Expose
    private List<Price> prices = null;
    @SerializedName("available_quantity")
    @Expose
    private Integer availableQuantity;
    @SerializedName("available_quantities")
    @Expose
    private List<AvailableQuantity> availableQuantities = null;
    @SerializedName("evaluate_rate")
    @Expose
    private Double evaluateRate;
    @SerializedName("reviews_number")
    @Expose
    private Integer reviewsNumber;
    @SerializedName("rade_count")
    @Expose
    private Integer radeCount;
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews = null;
    @SerializedName("discount_rate")
    @Expose
    private Integer discountRate;
    @SerializedName("lastest_volume")
    @Expose
    private Integer lastestVolume;
    @SerializedName("sales")
    @Expose
    private List<Sale> sales = null;
    @SerializedName("targets")
    @Expose
    private List<Object> targets = null;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Integer commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getFirstLevelCategoryId() {
        return firstLevelCategoryId;
    }

    public void setFirstLevelCategoryId(String firstLevelCategoryId) {
        this.firstLevelCategoryId = firstLevelCategoryId;
    }

    public String getFirstLevelCategoryName() {
        return firstLevelCategoryName;
    }

    public void setFirstLevelCategoryName(String firstLevelCategoryName) {
        this.firstLevelCategoryName = firstLevelCategoryName;
    }

    public Double getHotProductCommissionRate() {
        return hotProductCommissionRate;
    }

    public void setHotProductCommissionRate(Double hotProductCommissionRate) {
        this.hotProductCommissionRate = hotProductCommissionRate;
    }

    public String getProductDetailUrl() {
        return productDetailUrl;
    }

    public void setProductDetailUrl(String productDetailUrl) {
        this.productDetailUrl = productDetailUrl;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductMainImageUrl() {
        return productMainImageUrl;
    }

    public void setProductMainImageUrl(String productMainImageUrl) {
        this.productMainImageUrl = productMainImageUrl;
    }

    public ProductSmallImageUrls getProductSmallImageUrls() {
        return productSmallImageUrls;
    }

    public void setProductSmallImageUrls(ProductSmallImageUrls productSmallImageUrls) {
        this.productSmallImageUrls = productSmallImageUrls;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getPromotionLink() {
        return promotionLink;
    }

    public void setPromotionLink(String promotionLink) {
        this.promotionLink = promotionLink;
    }

    public String getRelevantMarketCommissionRate() {
        return relevantMarketCommissionRate;
    }

    public void setRelevantMarketCommissionRate(String relevantMarketCommissionRate) {
        this.relevantMarketCommissionRate = relevantMarketCommissionRate;
    }

    public Integer getSecondLevelCategoryId() {
        return secondLevelCategoryId;
    }

    public void setSecondLevelCategoryId(Integer secondLevelCategoryId) {
        this.secondLevelCategoryId = secondLevelCategoryId;
    }

    public String getSecondLevelCategoryName() {
        return secondLevelCategoryName;
    }

    public void setSecondLevelCategoryName(String secondLevelCategoryName) {
        this.secondLevelCategoryName = secondLevelCategoryName;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Double getAppSalePrice() {
        return appSalePrice;
    }

    public void setAppSalePrice(Double appSalePrice) {
        this.appSalePrice = appSalePrice;
    }

    public String getAppSalePriceCurrency() {
        return appSalePriceCurrency;
    }

    public void setAppSalePriceCurrency(String appSalePriceCurrency) {
        this.appSalePriceCurrency = appSalePriceCurrency;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getSalePriceCurrency() {
        return salePriceCurrency;
    }

    public void setSalePriceCurrency(String salePriceCurrency) {
        this.salePriceCurrency = salePriceCurrency;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public List<AvailableQuantity> getAvailableQuantities() {
        return availableQuantities;
    }

    public void setAvailableQuantities(List<AvailableQuantity> availableQuantities) {
        this.availableQuantities = availableQuantities;
    }

    public Double getEvaluateRate() {
        return evaluateRate;
    }

    public void setEvaluateRate(Double evaluateRate) {
        this.evaluateRate = evaluateRate;
    }

    public Integer getReviewsNumber() {
        return reviewsNumber;
    }

    public void setReviewsNumber(Integer reviewsNumber) {
        this.reviewsNumber = reviewsNumber;
    }

    public Integer getRadeCount() {
        return radeCount;
    }

    public void setRadeCount(Integer radeCount) {
        this.radeCount = radeCount;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getLastestVolume() {
        return lastestVolume;
    }

    public void setLastestVolume(Integer lastestVolume) {
        this.lastestVolume = lastestVolume;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Object> getTargets() {
        return targets;
    }

    public void setTargets(List<Object> targets) {
        this.targets = targets;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public class ProductSmallImageUrls {

        @SerializedName("string")
        @Expose
        private List<String> string = null;

        public List<String> getString() {
            return string;
        }

        public void setString(List<String> string) {
            this.string = string;
        }

    }
}

class AvailableQuantity {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("available_quantity")
    @Expose
    private Integer availableQuantity;
    @SerializedName("modificationDate")
    @Expose
    private String modificationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

}

class Price {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("app_sale_price")
    @Expose
    private Double appSalePrice;
    @SerializedName("app_sale_price_currency")
    @Expose
    private String appSalePriceCurrency;
    @SerializedName("original_price")
    @Expose
    private Double originalPrice;
    @SerializedName("sale_price")
    @Expose
    private Double salePrice;
    @SerializedName("sale_price_currency")
    @Expose
    private String salePriceCurrency;
    @SerializedName("modificationDate")
    @Expose
    private String modificationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAppSalePrice() {
        return appSalePrice;
    }

    public void setAppSalePrice(Double appSalePrice) {
        this.appSalePrice = appSalePrice;
    }

    public String getAppSalePriceCurrency() {
        return appSalePriceCurrency;
    }

    public void setAppSalePriceCurrency(String appSalePriceCurrency) {
        this.appSalePriceCurrency = appSalePriceCurrency;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getSalePriceCurrency() {
        return salePriceCurrency;
    }

    public void setSalePriceCurrency(String salePriceCurrency) {
        this.salePriceCurrency = salePriceCurrency;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

}


class Review {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("evaluate_rate")
    @Expose
    private Double evaluateRate;
    @SerializedName("reviews_number")
    @Expose
    private Integer reviewsNumber;
    @SerializedName("rade_count")
    @Expose
    private Integer radeCount;
    @SerializedName("modificationDate")
    @Expose
    private String modificationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getEvaluateRate() {
        return evaluateRate;
    }

    public void setEvaluateRate(Double evaluateRate) {
        this.evaluateRate = evaluateRate;
    }

    public Integer getReviewsNumber() {
        return reviewsNumber;
    }

    public void setReviewsNumber(Integer reviewsNumber) {
        this.reviewsNumber = reviewsNumber;
    }

    public Integer getRadeCount() {
        return radeCount;
    }

    public void setRadeCount(Integer radeCount) {
        this.radeCount = radeCount;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

}

class Sale {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("lastest_volume")
    @Expose
    private Integer lastestVolume;
    @SerializedName("modificationDate")
    @Expose
    private String modificationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLastestVolume() {
        return lastestVolume;
    }

    public void setLastestVolume(Integer lastestVolume) {
        this.lastestVolume = lastestVolume;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

}

class Shop {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("shop_id")
    @Expose
    private Integer shopId;
    @SerializedName("shop_url")
    @Expose
    private String shopUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

}