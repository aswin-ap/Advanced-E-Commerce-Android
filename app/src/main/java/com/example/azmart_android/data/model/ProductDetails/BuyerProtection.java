
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class BuyerProtection {

    @SerializedName("brief")
    private String mBrief;
    @SerializedName("detailDescription")
    private String mDetailDescription;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("redirectUrl")
    private String mRedirectUrl;
    @SerializedName("type")
    private Long mType;

    public String getBrief() {
        return mBrief;
    }

    public void setBrief(String brief) {
        mBrief = brief;
    }

    public String getDetailDescription() {
        return mDetailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        mDetailDescription = detailDescription;
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

    public String getRedirectUrl() {
        return mRedirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        mRedirectUrl = redirectUrl;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }

}
