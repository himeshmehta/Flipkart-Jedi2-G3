package com.flipkart.src.main.java.com.flipkart.requestPojo;

import com.flipkart.constants.BankEnum;
import com.flipkart.constants.PaymentMode;

import java.util.Set;

public class PaymentRequest {
    String paymentDescription;
    String card_number;
    String name_on_card;
    String cvv;
    PaymentMode paymentMode;
    int userId;
    Set<Integer> selectedCourses;
    BankEnum bank;

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getName_on_card() {
        return name_on_card;
    }

    public void setName_on_card(String name_on_card) {
        this.name_on_card = name_on_card;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode onlinePaymentMode) {
        this.paymentMode = onlinePaymentMode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<Integer> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(Set<Integer> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public BankEnum getBank() {
        return bank;
    }

    public void setBank(BankEnum bankEnum) {
        this.bank = bankEnum;
    }
}
