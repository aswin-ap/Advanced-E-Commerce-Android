package com.example.azmart_android.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {
    @SerializedName("docs")
    List<Docs> docs;

    @SerializedName("searchEngine")
    SearchEngine searchEngine;

    @SerializedName("limit")
    int limit;

    @SerializedName("page")
    int page;

    @SerializedName("hasPrevPage")
    boolean hasPrevPage;

    @SerializedName("hasNextPage")
    boolean hasNextPage;

    @SerializedName("nextPage")
    int nextPage;

    @SerializedName("prvPage")
    String prvPage;

    @SerializedName("totalPages")
    int totalPages;

    @SerializedName("total_record_count")
    int totalRecordCount;


    public void setDocs(List<Docs> docs) {
        this.docs = docs;
    }
    public List<Docs> getDocs() {
        return docs;
    }

    public void setSearchEngine(SearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }
    public SearchEngine getSearchEngine() {
        return searchEngine;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getLimit() {
        return limit;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public int getPage() {
        return page;
    }

    public void setHasPrevPage(boolean hasPrevPage) {
        this.hasPrevPage = hasPrevPage;
    }
    public boolean getHasPrevPage() {
        return hasPrevPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
    public boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getNextPage() {
        return nextPage;
    }

    public void setPrvPage(String prvPage) {
        this.prvPage = prvPage;
    }
    public String getPrvPage() {
        return prvPage;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }
    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public class Docs {

        @SerializedName("app_sale_price")
        double appSalePrice;

        @SerializedName("app_sale_price_currency")
        String appSalePriceCurrency;

        @SerializedName("discount_rate")
        int discountRate;

        @SerializedName("evaluate_rate")
        double evaluateRate;

        @SerializedName("product_id")
        String productId;

        @SerializedName("product_main_image_url")
        String productMainImageUrl;

        @SerializedName("product_title")
        String productTitle;

        @SerializedName("lastest_volume")
        String lastestVolume;

        @SerializedName("metadata")
        Metadata metadata;

        @SerializedName("product_detail_url")
        String productDetailUrl;

        @SerializedName("keywords")
        String keywords;


        public void setAppSalePrice(double appSalePrice) {
            this.appSalePrice = appSalePrice;
        }
        public double getAppSalePrice() {
            return appSalePrice;
        }

        public void setAppSalePriceCurrency(String appSalePriceCurrency) {
            this.appSalePriceCurrency = appSalePriceCurrency;
        }
        public String getAppSalePriceCurrency() {
            return appSalePriceCurrency;
        }

        public void setDiscountRate(int discountRate) {
            this.discountRate = discountRate;
        }
        public int getDiscountRate() {
            return discountRate;
        }

        public void setEvaluateRate(double evaluateRate) {
            this.evaluateRate = evaluateRate;
        }
        public double getEvaluateRate() {
            return evaluateRate;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }
        public String getProductId() {
            return productId;
        }

        public void setProductMainImageUrl(String productMainImageUrl) {
            this.productMainImageUrl = productMainImageUrl;
        }
        public String getProductMainImageUrl() {
            return productMainImageUrl;
        }

        public void setProductTitle(String productTitle) {
            this.productTitle = productTitle;
        }
        public String getProductTitle() {
            return productTitle;
        }

        public void setLastestVolume(String lastestVolume) {
            this.lastestVolume = lastestVolume;
        }
        public String getLastestVolume() {
            return lastestVolume;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }
        public Metadata getMetadata() {
            return metadata;
        }

        public void setProductDetailUrl(String productDetailUrl) {
            this.productDetailUrl = productDetailUrl;
        }
        public String getProductDetailUrl() {
            return productDetailUrl;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }
        public String getKeywords() {
            return keywords;
        }

    }

    public class Evaluation {

        @SerializedName("starWidth")
        int starWidth;

        @SerializedName("starUrl")
        String starUrl;

        @SerializedName("starRating")
        double starRating;

        @SerializedName("starHeight")
        int starHeight;


        public void setStarWidth(int starWidth) {
            this.starWidth = starWidth;
        }
        public int getStarWidth() {
            return starWidth;
        }

        public void setStarUrl(String starUrl) {
            this.starUrl = starUrl;
        }
        public String getStarUrl() {
            return starUrl;
        }

        public void setStarRating(double starRating) {
            this.starRating = starRating;
        }
        public double getStarRating() {
            return starRating;
        }

        public void setStarHeight(int starHeight) {
            this.starHeight = starHeight;
        }
        public int getStarHeight() {
            return starHeight;
        }

    }

    public class Image {

        @SerializedName("imgUrl")
        String imgUrl;

        @SerializedName("imgWidth")
        int imgWidth;

        @SerializedName("imgHeight")
        int imgHeight;

        @SerializedName("imgType")
        String imgType;


        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgWidth(int imgWidth) {
            this.imgWidth = imgWidth;
        }
        public int getImgWidth() {
            return imgWidth;
        }

        public void setImgHeight(int imgHeight) {
            this.imgHeight = imgHeight;
        }
        public int getImgHeight() {
            return imgHeight;
        }

        public void setImgType(String imgType) {
            this.imgType = imgType;
        }
        public String getImgType() {
            return imgType;
        }

    }

    public class Exposure {

        @SerializedName("selling_point")
        String sellingPoint;


        public void setSellingPoint(String sellingPoint) {
            this.sellingPoint = sellingPoint;
        }
        public String getSellingPoint() {
            return sellingPoint;
        }

    }

    public class PdpParams {

        @SerializedName("pdp_cdi")
        String pdpCdi;

        @SerializedName("pdp_npi")
        String pdpNpi;


        public void setPdpCdi(String pdpCdi) {
            this.pdpCdi = pdpCdi;
        }
        public String getPdpCdi() {
            return pdpCdi;
        }

        public void setPdpNpi(String pdpNpi) {
            this.pdpNpi = pdpNpi;
        }
        public String getPdpNpi() {
            return pdpNpi;
        }

    }

    public class Click {

        @SerializedName("haveSellingPoint")
        String haveSellingPoint;


        public void setHaveSellingPoint(String haveSellingPoint) {
            this.haveSellingPoint = haveSellingPoint;
        }
        public String getHaveSellingPoint() {
            return haveSellingPoint;
        }

    }

    public class UtLogMap {

        @SerializedName("original_price_type")
        String originalPriceType;

        @SerializedName("formatted_price")
        String formattedPrice;

        @SerializedName("csp")
        String csp;

        @SerializedName("x_object_type")
        String xObjectType;

        @SerializedName("hit_19_forbidden")
        boolean hit19Forbidden;

        @SerializedName("is_detail_next")
        String isDetailNext;

        @SerializedName("sku_id")
        String skuId;

        @SerializedName("mixrank_success")
        String mixrankSuccess;

        @SerializedName("sku_ic_tags")
        String skuIcTags;

        @SerializedName("is_adult_certified")
        boolean isAdultCertified;

        @SerializedName("mixrank_enable")
        String mixrankEnable;

        @SerializedName("ump_atmospheres")
        String umpAtmospheres;

        @SerializedName("oip")
        String oip;

        @SerializedName("selling_point")
        String sellingPoint;

        @SerializedName("original_price_strategy")
        String originalPriceStrategy;

        @SerializedName("x_object_id")
        String xObjectId;


        public void setOriginalPriceType(String originalPriceType) {
            this.originalPriceType = originalPriceType;
        }
        public String getOriginalPriceType() {
            return originalPriceType;
        }

        public void setFormattedPrice(String formattedPrice) {
            this.formattedPrice = formattedPrice;
        }
        public String getFormattedPrice() {
            return formattedPrice;
        }

        public void setCsp(String csp) {
            this.csp = csp;
        }
        public String getCsp() {
            return csp;
        }

        public void setXObjectType(String xObjectType) {
            this.xObjectType = xObjectType;
        }
        public String getXObjectType() {
            return xObjectType;
        }

        public void setHit19Forbidden(boolean hit19Forbidden) {
            this.hit19Forbidden = hit19Forbidden;
        }
        public boolean getHit19Forbidden() {
            return hit19Forbidden;
        }

        public void setIsDetailNext(String isDetailNext) {
            this.isDetailNext = isDetailNext;
        }
        public String getIsDetailNext() {
            return isDetailNext;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }
        public String getSkuId() {
            return skuId;
        }

        public void setMixrankSuccess(String mixrankSuccess) {
            this.mixrankSuccess = mixrankSuccess;
        }
        public String getMixrankSuccess() {
            return mixrankSuccess;
        }

        public void setSkuIcTags(String skuIcTags) {
            this.skuIcTags = skuIcTags;
        }
        public String getSkuIcTags() {
            return skuIcTags;
        }

        public void setIsAdultCertified(boolean isAdultCertified) {
            this.isAdultCertified = isAdultCertified;
        }
        public boolean getIsAdultCertified() {
            return isAdultCertified;
        }

        public void setMixrankEnable(String mixrankEnable) {
            this.mixrankEnable = mixrankEnable;
        }
        public String getMixrankEnable() {
            return mixrankEnable;
        }

        public void setUmpAtmospheres(String umpAtmospheres) {
            this.umpAtmospheres = umpAtmospheres;
        }
        public String getUmpAtmospheres() {
            return umpAtmospheres;
        }

        public void setOip(String oip) {
            this.oip = oip;
        }
        public String getOip() {
            return oip;
        }

        public void setSellingPoint(String sellingPoint) {
            this.sellingPoint = sellingPoint;
        }
        public String getSellingPoint() {
            return sellingPoint;
        }

        public void setOriginalPriceStrategy(String originalPriceStrategy) {
            this.originalPriceStrategy = originalPriceStrategy;
        }
        public String getOriginalPriceStrategy() {
            return originalPriceStrategy;
        }

        public void setXObjectId(String xObjectId) {
            this.xObjectId = xObjectId;
        }
        public String getXObjectId() {
            return xObjectId;
        }

    }

    public class Trace {

        @SerializedName("exposure")
        Exposure exposure;

        @SerializedName("custom")
        Custom custom;

        @SerializedName("detailPage")
        DetailPage detailPage;

        @SerializedName("pdpParams")
        PdpParams pdpParams;

        @SerializedName("click")
        Click click;

        @SerializedName("utLogMap")
        UtLogMap utLogMap;


        public void setExposure(Exposure exposure) {
            this.exposure = exposure;
        }
        public Exposure getExposure() {
            return exposure;
        }

        public void setCustom(Custom custom) {
            this.custom = custom;
        }
        public Custom getCustom() {
            return custom;
        }

        public void setDetailPage(DetailPage detailPage) {
            this.detailPage = detailPage;
        }
        public DetailPage getDetailPage() {
            return detailPage;
        }

        public void setPdpParams(PdpParams pdpParams) {
            this.pdpParams = pdpParams;
        }
        public PdpParams getPdpParams() {
            return pdpParams;
        }

        public void setClick(Click click) {
            this.click = click;
        }
        public Click getClick() {
            return click;
        }

        public void setUtLogMap(UtLogMap utLogMap) {
            this.utLogMap = utLogMap;
        }
        public UtLogMap getUtLogMap() {
            return utLogMap;
        }

    }

    public class DetailPage { }

    public class Custom { }

    public class Trade {

        @SerializedName("tradeDesc")
        String tradeDesc;


        public void setTradeDesc(String tradeDesc) {
            this.tradeDesc = tradeDesc;
        }
        public String getTradeDesc() {
            return tradeDesc;
        }

    }

    public class Title {

        @SerializedName("displayTitle")
        String displayTitle;

        @SerializedName("shortTitle")
        boolean shortTitle;

        @SerializedName("seoTitle")
        String seoTitle;


        public void setDisplayTitle(String displayTitle) {
            this.displayTitle = displayTitle;
        }

        public String getDisplayTitle() {
            return displayTitle;
        }

        public void setShortTitle(boolean shortTitle) {
            this.shortTitle = shortTitle;
        }

        public boolean getShortTitle() {
            return shortTitle;
        }

        public void setSeoTitle(String seoTitle) {
            this.seoTitle = seoTitle;
        }

        public String getSeoTitle() {
            return seoTitle;
        }
    }

    public class SalePrice {

        @SerializedName("formattedPrice")
        String formattedPrice;

        @SerializedName("minPriceDiscount")
        int minPriceDiscount;

        @SerializedName("minPrice")
        double minPrice;

        @SerializedName("priceType")
        String priceType;

        @SerializedName("discount")
        int discount;

        @SerializedName("minPriceType")
        int minPriceType;

        @SerializedName("currencyCode")
        String currencyCode;


        public void setFormattedPrice(String formattedPrice) {
            this.formattedPrice = formattedPrice;
        }
        public String getFormattedPrice() {
            return formattedPrice;
        }

        public void setMinPriceDiscount(int minPriceDiscount) {
            this.minPriceDiscount = minPriceDiscount;
        }
        public int getMinPriceDiscount() {
            return minPriceDiscount;
        }

        public void setMinPrice(double minPrice) {
            this.minPrice = minPrice;
        }
        public double getMinPrice() {
            return minPrice;
        }

        public void setPriceType(String priceType) {
            this.priceType = priceType;
        }
        public String getPriceType() {
            return priceType;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }
        public int getDiscount() {
            return discount;
        }

        public void setMinPriceType(int minPriceType) {
            this.minPriceType = minPriceType;
        }
        public int getMinPriceType() {
            return minPriceType;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }
        public String getCurrencyCode() {
            return currencyCode;
        }

    }

    public class Prices {

        @SerializedName("builderType")
        String builderType;

        @SerializedName("taxRate")
        String taxRate;

        @SerializedName("pricesStyle")
        String pricesStyle;

        @SerializedName("salePrice")
        SalePrice salePrice;

        @SerializedName("prefix")
        String prefix;

        @SerializedName("currencySymbol")
        String currencySymbol;

        @SerializedName("skuId")
        String skuId;


        public void setBuilderType(String builderType) {
            this.builderType = builderType;
        }
        public String getBuilderType() {
            return builderType;
        }

        public void setTaxRate(String taxRate) {
            this.taxRate = taxRate;
        }
        public String getTaxRate() {
            return taxRate;
        }

        public void setPricesStyle(String pricesStyle) {
            this.pricesStyle = pricesStyle;
        }
        public String getPricesStyle() {
            return pricesStyle;
        }

        public void setSalePrice(SalePrice salePrice) {
            this.salePrice = salePrice;
        }
        public SalePrice getSalePrice() {
            return salePrice;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }
        public String getPrefix() {
            return prefix;
        }

        public void setCurrencySymbol(String currencySymbol) {
            this.currencySymbol = currencySymbol;
        }
        public String getCurrencySymbol() {
            return currencySymbol;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }
        public String getSkuId() {
            return skuId;
        }

    }

    public class TagStyle { }

    public class TagContent {

        @SerializedName("tagStyle")
        TagStyle tagStyle;

        @SerializedName("displayTagType")
        String displayTagType;

        @SerializedName("tagText")
        String tagText;


        public void setTagStyle(TagStyle tagStyle) {
            this.tagStyle = tagStyle;
        }
        public TagStyle getTagStyle() {
            return tagStyle;
        }

        public void setDisplayTagType(String displayTagType) {
            this.displayTagType = displayTagType;
        }
        public String getDisplayTagType() {
            return displayTagType;
        }

        public void setTagText(String tagText) {
            this.tagText = tagText;
        }
        public String getTagText() {
            return tagText;
        }

    }

    public class SellingPoints {

        @SerializedName("tagStyleType")
        String tagStyleType;

        @SerializedName("tagContent")
        TagContent tagContent;

        @SerializedName("position")
        int position;

        @SerializedName("sellingPointTagId")
        String sellingPointTagId;

        @SerializedName("group")
        int group;


        public void setTagStyleType(String tagStyleType) {
            this.tagStyleType = tagStyleType;
        }
        public String getTagStyleType() {
            return tagStyleType;
        }

        public void setTagContent(TagContent tagContent) {
            this.tagContent = tagContent;
        }
        public TagContent getTagContent() {
            return tagContent;
        }

        public void setPosition(int position) {
            this.position = position;
        }
        public int getPosition() {
            return position;
        }

        public void setSellingPointTagId(String sellingPointTagId) {
            this.sellingPointTagId = sellingPointTagId;
        }
        public String getSellingPointTagId() {
            return sellingPointTagId;
        }

        public void setGroup(int group) {
            this.group = group;
        }
        public int getGroup() {
            return group;
        }

    }

    public class Metadata {

        @SerializedName("evaluation")
        Evaluation evaluation;

        @SerializedName("lunchTime")
        String lunchTime;

        @SerializedName("image")
        Image image;

        @SerializedName("itemType")
        String itemType;

        @SerializedName("trace")
        Trace trace;

        @SerializedName("trade")
        Trade trade;

        @SerializedName("nativeCardType")
        String nativeCardType;

        @SerializedName("productId")
        String productId;

        @SerializedName("title")
        Title title;

        @SerializedName("prices")
        Prices prices;

        @SerializedName("sellingPoints")
        List<SellingPoints> sellingPoints;

        @SerializedName("productType")
        String productType;


        public void setEvaluation(Evaluation evaluation) {
            this.evaluation = evaluation;
        }
        public Evaluation getEvaluation() {
            return evaluation;
        }

        public void setLunchTime(String lunchTime) {
            this.lunchTime = lunchTime;
        }
        public String getLunchTime() {
            return lunchTime;
        }

        public void setImage(Image image) {
            this.image = image;
        }
        public Image getImage() {
            return image;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }
        public String getItemType() {
            return itemType;
        }

        public void setTrace(Trace trace) {
            this.trace = trace;
        }
        public Trace getTrace() {
            return trace;
        }

        public void setTrade(Trade trade) {
            this.trade = trade;
        }
        public Trade getTrade() {
            return trade;
        }

        public void setNativeCardType(String nativeCardType) {
            this.nativeCardType = nativeCardType;
        }
        public String getNativeCardType() {
            return nativeCardType;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }
        public String getProductId() {
            return productId;
        }

        public void setTitle(Title title) {
            this.title = title;
        }
        public Title getTitle() {
            return title;
        }

        public void setPrices(Prices prices) {
            this.prices = prices;
        }
        public Prices getPrices() {
            return prices;
        }

        public void setSellingPoints(List<SellingPoints> sellingPoints) {
            this.sellingPoints = sellingPoints;
        }
        public List<SellingPoints> getSellingPoints() {
            return sellingPoints;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }
        public String getProductType() {
            return productType;
        }

    }

    public class SearchEngine {

        @SerializedName("shipFromCountry")
        String shipFromCountry;

        @SerializedName("keywords")
        String keywords;

        @SerializedName("page")
        int page;

        @SerializedName("isFastShipping")
        boolean isFastShipping;

        @SerializedName("isFreeShipping")
        boolean isFreeShipping;

        @SerializedName("isPopular")
        boolean isPopular;

        @SerializedName("target_currency")
        String targetCurrency;

        @SerializedName("shipToCountry")
        String shipToCountry;

        @SerializedName("pricerange")
        String pricerange;

        @SerializedName("sortType")
        String sortType;

        @SerializedName("sortOrder")
        String sortOrder;


        public void setShipFromCountry(String shipFromCountry) {
            this.shipFromCountry = shipFromCountry;
        }
        public String getShipFromCountry() {
            return shipFromCountry;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }
        public String getKeywords() {
            return keywords;
        }

        public void setPage(int page) {
            this.page = page;
        }
        public int getPage() {
            return page;
        }

        public void setIsFastShipping(boolean isFastShipping) {
            this.isFastShipping = isFastShipping;
        }
        public boolean getIsFastShipping() {
            return isFastShipping;
        }

        public void setIsFreeShipping(boolean isFreeShipping) {
            this.isFreeShipping = isFreeShipping;
        }
        public boolean getIsFreeShipping() {
            return isFreeShipping;
        }

        public void setIsPopular(boolean isPopular) {
            this.isPopular = isPopular;
        }
        public boolean getIsPopular() {
            return isPopular;
        }

        public void setTargetCurrency(String targetCurrency) {
            this.targetCurrency = targetCurrency;
        }
        public String getTargetCurrency() {
            return targetCurrency;
        }

        public void setShipToCountry(String shipToCountry) {
            this.shipToCountry = shipToCountry;
        }
        public String getShipToCountry() {
            return shipToCountry;
        }

        public void setPricerange(String pricerange) {
            this.pricerange = pricerange;
        }
        public String getPricerange() {
            return pricerange;
        }

        public void setSortType(String sortType) {
            this.sortType = sortType;
        }
        public String getSortType() {
            return sortType;
        }

        public void setSortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
        }
        public String getSortOrder() {
            return sortOrder;
        }

    }

}
