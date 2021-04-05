
package com.flipkart.bean;

import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;

public class Offline extends Payment{
    private Bank bank;
    private PaymentMode mode;

    public Offline(String refId,Long amount, String paymentDescription,Bank bank,String userId){
        super(refId,amount,paymentDescription,userId);
        this.bank = bank;
        this.mode = PaymentMode.OFFLINE;
    }
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }
}