package com.flipkart.src.main.java.com.flipkart.constants;

/**
 * This enum is used for offline payment.
 */
public enum BankEnum {
    SBI,
    HDFC,
    OTHER;

    /**
     * This method return name of bank in string format.
     * */
    public String getBank() {
        return this.name();
    }
}
