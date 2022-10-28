package com.example.azmart_android.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesResponse {
    @SerializedName("modificationDate")
    @Expose
    private String modificationDate;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("api_category_id")
    @Expose
    private Integer apiCategoryId;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("alie_parent_id")
    @Expose
    private Integer alieParentId;
    @SerializedName("api_parent_id")
    @Expose
    private Integer apiParentId;
    @SerializedName("alie_category_id")
    @Expose
    private Integer alieCategoryId;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getApiCategoryId() {
        return apiCategoryId;
    }

    public void setApiCategoryId(Integer apiCategoryId) {
        this.apiCategoryId = apiCategoryId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Integer getAlieParentId() {
        return alieParentId;
    }

    public void setAlieParentId(Integer alieParentId) {
        this.alieParentId = alieParentId;
    }

    public Integer getApiParentId() {
        return apiParentId;
    }

    public void setApiParentId(Integer apiParentId) {
        this.apiParentId = apiParentId;
    }

    public Integer getAlieCategoryId() {
        return alieCategoryId;
    }

    public void setAlieCategoryId(Integer alieCategoryId) {
        this.alieCategoryId = alieCategoryId;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
