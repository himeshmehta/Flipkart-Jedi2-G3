
package com.flipkart.bean;

import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;

/**
 * The type offline
 */
public class Offline extends Payment{
    private Bank bank;
    private PaymentMode mode;

    public Offline(String refId,Long amount, String paymentDescription,Bank bank,String userId){
        super(refId,amount,paymentDescription,userId);
        this.bank = bank;
        this.mode = PaymentMode.OFFLINE;
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

    /**
     * Gets the payment mode
     * @return
     */
    public PaymentMode getMode() {
        return mode;
    }

    /**
     * Sets the payment mode
     * @param mode
     */
    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }
}