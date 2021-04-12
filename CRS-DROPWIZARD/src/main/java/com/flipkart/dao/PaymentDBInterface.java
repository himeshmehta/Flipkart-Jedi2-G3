package com.flipkart.dao;

import com.flipkart.Exception.PaymentException;
import com.flipkart.bean.Payment;

public interface PaymentDBInterface {
    /**
     * This method complete the payment.
     * @Param onlinePayment :- an object of Payment which contains all information regarding payment.
     * @Throws PaymentException
     * @return Nothing
     *  */
    public  void completePayment(Payment payment) throws PaymentException;

}
