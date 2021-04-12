package com.flipkart.constants;

public enum PaymentMode {
    CREDITCARD,
    DEBITCARD,
    OFFLINE;

    public String getPaymentMode() {
        return this.name();
    }
}
