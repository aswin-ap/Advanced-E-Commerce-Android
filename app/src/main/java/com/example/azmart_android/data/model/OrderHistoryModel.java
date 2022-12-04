package com.example.azmart_android.data.model;

import java.io.Serializable;

public class OrderHistoryModel implements Serializable {
    private String orderId;
    private String productId;
    private String productTitle;
    private String productImage;
    private String productQty;
    private String productPrice;
    private String fullName;
    private String phoneNumber;
    private String pinCode;
    private String state;
    private String city;
    private String houseNo;
    private String roadName;
    private String cardNumber;
    private String cardType;
    private String cardHolderName;
    private String cardExpDate;
    private String cardCVVNumber;
    private String paymentMethod;

    public OrderHistoryModel(String orderId,String productId,String productTitle, String productImage, String productQty, String productPrice,String fullName, String phoneNumber,
                             String pinCode, String state, String city, String houseNo, String roadName, String cardNumber,
                             String cardType, String cardHolderName, String cardExpDate,String cardCVVNumber, String paymentMethod) {
        this.orderId = orderId;
        this.productId = productId;
        this.productTitle = productTitle;
        this.productImage = productImage;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.pinCode = pinCode;
        this.state = state;
        this.city = city;
        this.houseNo = houseNo;
        this.roadName = roadName;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardHolderName = cardHolderName;
        this.cardExpDate = cardExpDate;
        this.cardCVVNumber = cardCVVNumber;
        this.paymentMethod = paymentMethod;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
    }

    public String getCardCVVNumber() {
        return cardCVVNumber;
    }

    public void setCardCVVNumber(String cardCVVNumber) {
        this.cardCVVNumber = cardCVVNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }


    @Override
    public String toString() {
        return "AddressModel{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", roadName='" + roadName + '\'' +
                '}';
    }
}
