package com.flipkart.bean;

public class Payment {

    private String referenceId;
    private long amount;
    private String paymentDescription;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Payment(String refId, Long amount, String paymentDescription,String userId) {
        this.referenceId = refId;
        this.amount = amount;
        this.paymentDescription = paymentDescription;
        this.userId = userId;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

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
