
package com.flipkart.bean;

import com.flipkart.constants.PaymentMode;


/**
 * The type online
 */
public class Online extends Payment{
    private String card_number;
    private String name_on_card;
    private String CVV;

    /**
     * Constructor of online
     * @param refId reference id
     * @param amount amount
     * @param paymentDescription payment description
     * @param card_number card number
     * @param name_on_card name on card
     * @param CVV cvv
     * @param mode mode
     * @param userId user id
     */
    public Online(String refId, int amount, String paymentDescription, String card_number,String name_on_card,String CVV,PaymentMode mode,int userId) {
        super(refId, amount, paymentDescription,userId,mode);
        this.card_number = card_number;
        this.CVV = CVV;
        this.name_on_card = name_on_card;

    }

    /**
     * Gets the card number
     * @return String
     */
    public String getCard_number() {
        return card_number;
    }

    /**
     * Sets the card number
     * @param card_number card number
     */
    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    /**
     * Gets name on card
     * @return String
     */
    public String getName_on_card() {
        return name_on_card;
    }

    /**
     * Sets name on card
     * @param name_on_card name on card
     */
    public void setName_on_card(String name_on_card) {
        this.name_on_card = name_on_card;
    }

    /**
     * Gets the cvv
     * @return String
     */
    public String getCVV() {
        return CVV;
    }

    /**
     * Sets the cvv
     * @param CVV cvv code
     */
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

}