package com.flipkart.constants;

/**
 * This enum is used to describe payment type.
 * */
public enum PaymentMode {
    CREDITCARD,
    DEBITCARD,
    OFFLINE;

    /**
     * This method return payment mode in string format
     * @return string
     */
    public String getPaymentMode() {
        return this.name();
    }
}
