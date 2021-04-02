
package com.flipkart.bean;

import com.flipkart.constants.PaymentMode;

public class Online extends Payment{
    private String card_number;
    private String name_on_card;
    private String CVV;
    private PaymentMode mode;

    public Online(String refId, Long amount, String paymentDescription, String card_number,String name_on_card,String CVV,PaymentMode mode,String userId) {
        super(refId, amount, paymentDescription,userId);
        this.card_number = card_number;
        this.CVV = CVV;
        this.name_on_card = name_on_card;
        this.mode = mode;
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

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }
}