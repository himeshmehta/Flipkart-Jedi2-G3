
package com.flipkart.bean;

import com.flipkart.constants.BankEnum;
import com.flipkart.constants.PaymentMode;

/**
 * The type offline
 */
public class Offline extends Payment{
    private BankEnum bankEnum;

    public Offline(String refId, int amount, String paymentDescription, BankEnum bankEnum, int userId){
        super(refId,amount,paymentDescription,userId, PaymentMode.OFFLINE);
        this.bankEnum = bankEnum;
    }

    /**
     * Gets the bank
     * @return
     */
    public BankEnum getBank() {
        return bankEnum;
    }

    /**
     * Sets the bank
     * @param bankEnum
     */
    public void setBank(BankEnum bankEnum) {
        this.bankEnum = bankEnum;
    }
}