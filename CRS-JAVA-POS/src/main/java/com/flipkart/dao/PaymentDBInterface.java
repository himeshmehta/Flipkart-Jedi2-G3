package com.flipkart.dao;

import com.flipkart.Exception.PaymentException;
import com.flipkart.bean.Payment;

public interface PaymentDBInterface {
    /**
     * This method complete the payment.
     * @param payment :- an object of Payment which contains all information regarding payment.
     * @throws PaymentException payment exception
     *  */
    public  void completePayment(Payment payment) throws PaymentException;

}
