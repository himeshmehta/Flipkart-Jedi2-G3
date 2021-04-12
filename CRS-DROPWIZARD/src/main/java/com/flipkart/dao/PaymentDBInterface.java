package com.flipkart.dao;

import com.flipkart.Exception.PaymentException;
import com.flipkart.bean.Payment;

public interface PaymentDBInterface {
    /**
     * This method complete the online payment.
     * @Param onlinePayment :- an object of online payment which contains all information regarding payment.
     * @Throws Nothing
     * @return Nothing
     *  */
    public  void completePayment(Payment payment) throws PaymentException;

}
