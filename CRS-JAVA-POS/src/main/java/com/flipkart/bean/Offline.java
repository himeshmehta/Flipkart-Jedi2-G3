
package com.flipkart.bean;

import com.flipkart.constants.BankEnum;
import com.flipkart.constants.PaymentMode;

/**
 * The type offline
 */
public class Offline extends Payment{
    private BankEnum bankEnum;

    /**
     * Constructor of offline
     * @param refId reference id
     * @param amount amount
     * @param paymentDescription payment description
     * @param bankEnum bank name
     * @param userId user id
     */
    public Offline(String refId, int amount, String paymentDescription, BankEnum bankEnum, int userId){
        super(refId,amount,paymentDescription,userId, PaymentMode.OFFLINE);
        this.bankEnum = bankEnum;
    }

    /**
     * Gets the bank name
     * @return BankEnum
     */
    public BankEnum getBank() {
        return bankEnum;
    }

    /**
     * Sets the bank name
     * @param bankEnum bank name
     */
    public void setBank(BankEnum bankEnum) {
        this.bankEnum = bankEnum;
    }
}