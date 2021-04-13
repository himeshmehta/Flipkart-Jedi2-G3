package com.flipkart.bean;

import com.flipkart.constants.PaymentMode;


/**
 * The type payment
 */
public class Payment {

    private String referenceId;
    private int amount;
    private String paymentDescription;
    private int userId;
    private PaymentMode mode;

    /**
     * Constructor of Payment
     * @param refId
     * @param amount
     * @param paymentDescription
     * @param userId
     * @param mode
     */
    public Payment(String refId, int amount, String paymentDescription, int userId, PaymentMode mode) {
        this.referenceId = refId;
        this.amount = amount;
        this.paymentDescription = paymentDescription;
        this.userId = userId;
        this.mode = mode;
    }

    /**
     * Gets the user id
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user id
     * @param userId the user id
     */
    public void setUserId(int userId) {
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
     * @return String
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
     * @return int
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the amount
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Gets the payment mode
     * @return PaymentMode
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
