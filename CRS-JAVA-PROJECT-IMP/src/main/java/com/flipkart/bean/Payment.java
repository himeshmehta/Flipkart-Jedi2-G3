package com.flipkart.bean;

import com.flipkart.constants.PaymentMode;

public class Payment {

    private String referenceId;
    private long amount;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
