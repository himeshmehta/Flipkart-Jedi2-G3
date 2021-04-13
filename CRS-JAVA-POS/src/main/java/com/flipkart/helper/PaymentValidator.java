package com.flipkart.helper;

import com.flipkart.Exception.PaymentException;

/**
 * The type payment validator
 */
public class PaymentValidator {
    /**
     * This method is used to validate online payment
     * @param amount
     * @param card_name
     * @param card_no
     * @param cvv
     * @throws PaymentException
     */
    public static void onlinePaymentValidator(long amount,String card_name,String card_no,String cvv) throws PaymentException {
        String exceptionMessage = null;
        if (amount < 0){
            exceptionMessage = "Amount can not be negative.";
        }
        else if( card_no == null || card_no.length() < 4) {
            exceptionMessage = "Number on card should be minimum 4 digit long.";
        }
        else if( cvv == null || cvv.length() != 3){
            exceptionMessage = "CVV must be 3 digits long.";
        }
        else if(card_name != null && card_name.isEmpty()){
            exceptionMessage = "Card name can not be empty";
        }

        if( exceptionMessage != null && exceptionMessage.length()>0){
            throw new PaymentException(exceptionMessage);
        }
    }

}
