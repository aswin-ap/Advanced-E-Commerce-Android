package com.example.azmart_android.data.model;

public class CardsModel {
    private String cardNumber;
    private String cardHolderName;
    private String cardType;
    private String expiryDate;
    private String cvv;

    public CardsModel(String cardNumber, String cardHolderName, String cardType, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    //    @Override
//    public String toString() {
//        return "AddressModel{" +
//                "fullName='" + fullName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", pinCode='" + pinCode + '\'' +
//                ", state='" + state + '\'' +
//                ", city='" + city + '\'' +
//                ", houseNo='" + houseNo + '\'' +
//                ", roadName='" + roadName + '\'' +
//                '}';
//    }
}
