package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;

public interface PaymentInterface {
    /**
     *
     This method makes the Online Payment.
     @Param - paymentDescription , amount , card_number , name_on_card , cvv , mode , userId.
     @Throws - Nothing
     @returns - nothing
     **/
    public void makeOnlinePayment(String paymentDescription, long amount, String card_number, String name_on_card, String cvv, PaymentMode mode, int userId) throws CRSException;
    /**
     *
     This method makes the Online Payment.
     @Param - paymentDescription , amount , bank , userId.
     @Throws - Nothing
     @returns - nothing
     **/
    public void makeOfflinePayment(String paymentDescription,long amount, Bank bank, int userId) throws CRSException;
}
