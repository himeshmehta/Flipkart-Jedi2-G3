package com.flipkart.services;

import com.flipkart.bean.Payment;
import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;
import com.sun.istack.internal.NotNull;

public interface PaymentInterface {
    public void makeOnlinePayment(String paymentDescription, long amount, String card_number, String name_on_card, String cvv, PaymentMode mode, String userId);
    public void makeOfflinePayment(String paymentDescription,long amount, Bank bank, String userId);
}
