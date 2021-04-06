package com.flipkart.bean;

/**
 * The type payment
 */
public class Payment {

    private String referenceId;
    private long amount;
    private String paymentDescription;
    private String userId;

    public Payment(String refId, Long amount, String paymentDescription,String userId) {
        this.referenceId = refId;
        this.amount = amount;
        this.paymentDescription = paymentDescription;
        this.userId = userId;
    }

    /**
     * Gets the user id
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user id
     * @param userId the user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the payment description
     * @return the payment description
     */
    public String getPaymentDescription() {
        return paymentDescription;
    }

    /**
     * Sets the payment description
     * @param paymentDescription
     */
    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    /**
     * Gets reference id
     * @return
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Sets reference id
     * @param referenceId
     */
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    /**
     * Gets the amount
     * @return
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Sets the amount
     * @param amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }
}
