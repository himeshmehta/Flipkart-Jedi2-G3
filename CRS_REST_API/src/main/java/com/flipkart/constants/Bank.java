package com.flipkart.constants;

public enum Bank {
    SBI,
    HDFC,
    OTHER;

    public String getBank() {
        return this.name();
    }
}
