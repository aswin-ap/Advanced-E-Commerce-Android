
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PromotionSellingPointTag {

    @SerializedName("elementList")
    private List<ElementList> mElementList;

    public List<ElementList> getElementList() {
        return mElementList;
    }

    public void setElementList(List<ElementList> elementList) {
        mElementList = elementList;
    }

}
