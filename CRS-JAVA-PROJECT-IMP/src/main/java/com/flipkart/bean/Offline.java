
package com.flipkart.bean;

import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;

/**
 * The type offline
 */
public class Offline extends Payment{
    private Bank bank;

    public Offline(String refId,int amount, String paymentDescription,Bank bank,int userId){
        super(refId,amount,paymentDescription,userId, PaymentMode.OFFLINE);
        this.bank = bank;
    }

    /**
     * Gets the bank
     * @return
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * Sets the bank
     * @param bank
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }
}