
package com.example.azmart_android.data.model.ProductDetails;

import com.google.gson.annotations.SerializedName;

public class ProductCategoriesBreadcrumb {

    @SerializedName("cateId")
    private Long mCateId;
    @SerializedName("name")
    private String mName;
    @SerializedName("remark")
    private String mRemark;
    @SerializedName("url")
    private String mUrl;

    public Long getCateId() {
        return mCateId;
    }

    public void setCateId(Long cateId) {
        mCateId = cateId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getRemark() {
        return mRemark;
    }

    public void setRemark(String remark) {
        mRemark = remark;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
