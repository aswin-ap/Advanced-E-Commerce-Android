
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;

public class ElementList {

    @SerializedName("elementType")
    private String mElementType;
    @SerializedName("iconHeight")
    private Long mIconHeight;
    @SerializedName("iconWidth")
    private Long mIconWidth;
    @SerializedName("textColor")
    private String mTextColor;
    @SerializedName("textContent")
    private String mTextContent;

    public String getElementType() {
        return mElementType;
    }

    public void setElementType(String elementType) {
        mElementType = elementType;
    }

    public Long getIconHeight() {
        return mIconHeight;
    }

    public void setIconHeight(Long iconHeight) {
        mIconHeight = iconHeight;
    }

    public Long getIconWidth() {
        return mIconWidth;
    }

    public void setIconWidth(Long iconWidth) {
        mIconWidth = iconWidth;
    }

    public String getTextColor() {
        return mTextColor;
    }

    public void setTextColor(String textColor) {
        mTextColor = textColor;
    }

    public String getTextContent() {
        return mTextContent;
    }

    public void setTextContent(String textContent) {
        mTextContent = textContent;
    }

}
