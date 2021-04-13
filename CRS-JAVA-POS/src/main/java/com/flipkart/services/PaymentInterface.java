package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.constants.BankEnum;
import com.flipkart.constants.PaymentMode;

import java.util.Set;

public interface PaymentInterface {
    /**
     * This method makes the Online Payment and send notification to user.
     * @param paymentDescription payment description
     * @param card_number card number
     * @param name_on_card name on card
     * @param cvv cvv code
     * @param mode payment mode
     * @param userId user id
     * @param selectedCourses selected course
     * @throws CRSException crs exception
     */
    public String makeOnlinePayment(String paymentDescription, String card_number, String name_on_card, String cvv, PaymentMode mode, int userId, Set<Integer> selectedCourses) throws CRSException;
    /**
     * This method makes the offline Payment and send notification to user.
     * @param paymentDescription payment description
     * @param bankEnum bank name
     * @param userId user id
     * @param selectedCourses selected course
     * @throws CRSException crs exception
     */
    public String makeOfflinePayment(String paymentDescription, BankEnum bankEnum, int userId, Set<Integer> selectedCourses) throws CRSException;

//    /**
//     * This methode is used complete payment based on type of payment mode.
//     * @param paymentRequest
//     * @return String message
//     * @throws CRSException
//     */
//    public String completePayment(PaymentRequest paymentRequest) throws CRSException;
}
