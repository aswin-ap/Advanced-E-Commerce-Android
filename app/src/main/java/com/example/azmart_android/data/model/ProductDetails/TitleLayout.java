
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;

public class TitleLayout {

    @SerializedName("blockGroup")
    private String mBlockGroup;
    @SerializedName("blockType")
    private String mBlockType;
    @SerializedName("componentId")
    private String mComponentId;
    @SerializedName("content")
    private String mContent;
    @SerializedName("displayCondition")
    private String mDisplayCondition;
    @SerializedName("distance")
    private Long mDistance;
    @SerializedName("medusaKey")
    private String mMedusaKey;
    @SerializedName("order")
    private Long mOrder;
    @SerializedName("type")
    private String mType;
    @SerializedName("useInDeliveryOptionPanel")
    private Boolean mUseInDeliveryOptionPanel;
    @SerializedName("useInDetailFirstScreen")
    private Boolean mUseInDetailFirstScreen;
    @SerializedName("useInSkuSwitch")
    private Boolean mUseInSkuSwitch;

    public String getBlockGroup() {
        return mBlockGroup;
    }

    public void setBlockGroup(String blockGroup) {
        mBlockGroup = blockGroup;
    }

    public String getBlockType() {
        return mBlockType;
    }

    public void setBlockType(String blockType) {
        mBlockType = blockType;
    }

    public String getComponentId() {
        return mComponentId;
    }

    public void setComponentId(String componentId) {
        mComponentId = componentId;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getDisplayCondition() {
        return mDisplayCondition;
    }

    public void setDisplayCondition(String displayCondition) {
        mDisplayCondition = displayCondition;
    }

    public Long getDistance() {
        return mDistance;
    }

    public void setDistance(Long distance) {
        mDistance = distance;
    }

    public String getMedusaKey() {
        return mMedusaKey;
    }

    public void setMedusaKey(String medusaKey) {
        mMedusaKey = medusaKey;
    }

    public Long getOrder() {
        return mOrder;
    }

    public void setOrder(Long order) {
        mOrder = order;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Boolean getUseInDeliveryOptionPanel() {
        return mUseInDeliveryOptionPanel;
    }

    public void setUseInDeliveryOptionPanel(Boolean useInDeliveryOptionPanel) {
        mUseInDeliveryOptionPanel = useInDeliveryOptionPanel;
    }

    public Boolean getUseInDetailFirstScreen() {
        return mUseInDetailFirstScreen;
    }

    public void setUseInDetailFirstScreen(Boolean useInDetailFirstScreen) {
        mUseInDetailFirstScreen = useInDetailFirstScreen;
    }

    public Boolean getUseInSkuSwitch() {
        return mUseInSkuSwitch;
    }

    public void setUseInSkuSwitch(Boolean useInSkuSwitch) {
        mUseInSkuSwitch = useInSkuSwitch;
    }

}
