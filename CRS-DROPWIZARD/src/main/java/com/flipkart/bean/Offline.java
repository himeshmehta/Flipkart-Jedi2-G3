
package com.flipkart.bean;

import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;

/**
 * The type offline
 */
public class Offline extends Payment{
    private Bank bank;

    /**
     * Constructor of offline
     * @param refId
     * @param amount
     * @param paymentDescription
     * @param bank
     * @param userId
     */
    public Offline(String refId,int amount, String paymentDescription,Bank bank,int userId){
        super(refId,amount,paymentDescription,userId, PaymentMode.OFFLINE);
        this.bank = bank;
    }

    /**
     * Gets the bank name
     * @return
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * Sets the bank name
     * @param bank
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }
}