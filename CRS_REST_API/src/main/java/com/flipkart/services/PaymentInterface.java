package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;

import java.util.Set;

public interface PaymentInterface {
    /**
     *
     This method makes the Online Payment.
     @Param - paymentDescription ,  card_number , name_on_card , cvv , mode , userId.
     @Throws - Nothing
     @returns - nothing
     **/
    public String makeOnlinePayment(String paymentDescription, String card_number, String name_on_card, String cvv, PaymentMode mode, int userId, Set<Integer> selectedCourses) throws CRSException;
    /**
     *
     This method makes the Online Payment.
     @Param - paymentDescription , bank , userId.
     @Throws - Nothing
     @returns - nothing
     **/
    public String makeOfflinePayment(String paymentDescription, Bank bank, int userId, Set<Integer> selectedCourses) throws CRSException;
}
