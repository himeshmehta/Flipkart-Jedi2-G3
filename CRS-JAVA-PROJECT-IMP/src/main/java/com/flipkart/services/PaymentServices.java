package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.NotificationException;
import com.flipkart.Exception.PaymentException;
import com.flipkart.bean.Payment;
import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;
import com.flipkart.dao.CourseDB;
import com.flipkart.dao.PaymentDB;
import com.flipkart.helper.PaymentValidator;

import java.util.Set;
import java.util.UUID;
import org.apache.log4j.Logger;

public class PaymentServices implements PaymentInterface{
    private NotificationServices notificationServices = new  NotificationServices();
    private PaymentDB paymentDB = new PaymentDB();
    private CourseDB courseDB= new CourseDB();
    private static final Logger logger = Logger.getLogger(PaymentServices.class);

    @Override
    public void makeOnlinePayment(String paymentDescription, int amount, String card_number, String name_on_card, String cvv, PaymentMode onlinePaymentMode, int userId,Set<Integer> selectedCourses) throws CRSException {
        try {
            // first validate all fields related to payment
            PaymentValidator.onlinePaymentValidator(amount,name_on_card,card_number,cvv);
            logger.info("Online Payment Initiated");
            // generate an unique payment/ referenceId
            String refId = "PMT"+ UUID.randomUUID().toString();
            Payment onlinePayment = new Payment(refId,amount,paymentDescription,userId,onlinePaymentMode);
            paymentDB.completePayment(onlinePayment);

            // setting isPaidFee to TRUE in registeredcourses
            courseDB.setPaidFeeToTRUE(userId,selectedCourses);
            // Notify student once payment is confirm(payment is inserted into data)
            notificationServices.paymentNotifier(refId, amount, userId);

        } catch (PaymentException | NotificationException e) {
            throw new CRSException(e.getMessage());
        }
    }

    @Override
    public void makeOfflinePayment(String paymentDescription, int amount, Bank bank, int userId, Set<Integer> selectedCourses ) throws CRSException {
        try {
            logger.info("Offline Payment Initiated");
          if(amount < 0 ) throw new PaymentException("Amount can not be negative");
          String refID = "PMT" + UUID.randomUUID().toString();
          Payment offlinePayment = new Payment(refID,amount,paymentDescription,userId,PaymentMode.OFFLINE);

          paymentDB.completePayment(offlinePayment);
          courseDB.setPaidFeeToTRUE(userId,selectedCourses);
          // notify student once payment is done
          notificationServices.paymentNotifier(refID, amount, userId);
        } catch (PaymentException | NotificationException e) {
            throw new CRSException(e.getMessage());
        }
    }
}
