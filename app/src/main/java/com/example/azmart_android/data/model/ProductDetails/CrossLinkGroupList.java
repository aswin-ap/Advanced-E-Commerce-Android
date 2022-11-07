
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class CrossLinkGroupList {

    @SerializedName("channel")
    private String mChannel;
    @SerializedName("crossLinkList")
    private List<Object> mCrossLinkList;
    @SerializedName("name")
    private String mName;

    public String getChannel() {
        return mChannel;
    }

    public void setChannel(String channel) {
        mChannel = channel;
    }

    public List<Object> getCrossLinkList() {
        return mCrossLinkList;
    }

    public void setCrossLinkList(List<Object> crossLinkList) {
        mCrossLinkList = crossLinkList;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
