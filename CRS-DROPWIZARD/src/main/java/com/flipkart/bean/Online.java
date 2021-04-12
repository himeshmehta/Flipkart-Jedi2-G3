
package com.flipkart.bean;

import com.flipkart.constants.PaymentMode;

import javax.validation.constraints.NotNull;

/**
 * The type online
 */
public class Online extends Payment{
    @NotNull
    private String card_number;
    @NotNull
    private String name_on_card;
    @NotNull
    private String CVV;

    public Online(String refId, int amount, String paymentDescription, String card_number,String name_on_card,String CVV,PaymentMode mode,int userId) {
        super(refId, amount, paymentDescription,userId,mode);
        this.card_number = card_number;
        this.CVV = CVV;
        this.name_on_card = name_on_card;

    }

    /**
     * Gets the card number
     * @return
     */
    public String getCard_number() {
        return card_number;
    }

    /**
     * Sets the card number
     * @param card_number
     */
    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    /**
     * Gets name on card
     * @return
     */
    public String getName_on_card() {
        return name_on_card;
    }

    /**
     * Sets name on card
     * @param name_on_card
     */
    public void setName_on_card(String name_on_card) {
        this.name_on_card = name_on_card;
    }

    /**
     * Gets the cvv
     * @return
     */
    public String getCVV() {
        return CVV;
    }

    /**
     * Sets the cvv
     * @param CVV
     */
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

}