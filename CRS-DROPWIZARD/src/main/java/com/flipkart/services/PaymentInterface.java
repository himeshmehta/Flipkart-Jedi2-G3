package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;

import java.util.Set;

public interface PaymentInterface {
    /**
     *
     This method makes the Online Payment and send notification to user.
     @Param - paymentDescription ,  card_number , name_on_card , cvv , mode , mode, userId, list of course for which fee need to pay.
     @Throws - CRSException
     @returns - String : message
     **/
    public String makeOnlinePayment(String paymentDescription, String card_number, String name_on_card, String cvv, PaymentMode mode, int userId, Set<Integer> selectedCourses) throws CRSException;
    /**
     *
     This method makes the offline Payment and send notification to user.
     @Param - paymentDescription , bank , userId, list of course for which fee need to pay.
     @Throws - CRSException
     @returns - String : message
     **/
    public String makeOfflinePayment(String paymentDescription, Bank bank, int userId, Set<Integer> selectedCourses) throws CRSException;

    /**
     * This methode is used complete payment based on type of payment mode.
     * @param paymentRequest
     * @return String message
     * @throws CRSException
     */
    public String completePayment(PaymentRequest paymentRequest) throws CRSException
}
