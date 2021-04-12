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
import com.flipkart.requestPojo.PaymentRequest;

import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public class PaymentServices implements PaymentInterface{
    private NotificationServices notificationServices = new  NotificationServices();
    private PaymentDB paymentDB = new PaymentDB();
    private CourseDB courseDB= new CourseDB();
    private static final Logger logger = Logger.getLogger(String.valueOf(PaymentServices.class));

    /**
     * This methode is used complete payment based on type of payment mode.
     * @Param  paymentRequest : request payload.
     * @Throws CRSException
     * @Return String : message */
    public String completePayment(PaymentRequest paymentRequest) throws CRSException {
        String message = null;
        if(PaymentMode.OFFLINE.equals(paymentRequest.getPaymentMode())){
            message = makeOfflinePayment(
                    paymentRequest.getPaymentDescription(),
                    paymentRequest.getBank(),
                    paymentRequest.getUserId(),
                    paymentRequest.getSelectedCourses()
            );
        } else {
            message = makeOnlinePayment(
                    paymentRequest.getPaymentDescription(),
                    paymentRequest.getCard_number(),
                    paymentRequest.getName_on_card(),
                    paymentRequest.getCvv(),
                    paymentRequest.getPaymentMode(),
                    paymentRequest.getUserId(),
                    paymentRequest.getSelectedCourses()
            );
        }

        return message;
    }

    @Override
    public String makeOnlinePayment(String paymentDescription, String card_number, String name_on_card, String cvv, PaymentMode onlinePaymentMode, int userId,Set<Integer> selectedCourses) throws CRSException {
        try {

            //First of all fetch total fee to pay here
            int amount = courseDB.getFee(selectedCourses);

            // first validate all fields related to payment
            PaymentValidator.onlinePaymentValidator(amount,name_on_card,card_number,cvv);
            logger.info("Online Payment Initiated");

            // generate an unique payment/ referenceId
            String refId = "PMT"+ UUID.randomUUID().toString();
            Payment onlinePayment = new Payment(refId,amount,paymentDescription,userId,onlinePaymentMode);
            paymentDB.completePayment(onlinePayment);

            // setting isPaidFee to TRUE in registeredcourses database
            courseDB.setPaidFeeToTRUE(userId,selectedCourses);

            // Notify student once payment is confirm(payment is inserted into data)
            notificationServices.paymentNotifier(refId, amount, userId);

            // success message
            String message = "Payment of amount " + String.valueOf(amount) + " is completed. Reference id of transaction is " + refId;
            return message;
        } catch (PaymentException | NotificationException e) {
            throw new CRSException(e.getMessage());
        }
    }

    @Override
    public String makeOfflinePayment(String paymentDescription,  Bank bank, int userId, Set<Integer> selectedCourses ) throws CRSException {
        try {
            logger.info("Offline Payment Initiated");
          int amount =   courseDB.getFee(selectedCourses);
          if(amount < 0 ) throw new PaymentException("Amount can not be negative");
          String refID = "PMT" + UUID.randomUUID().toString();
          Payment offlinePayment = new Payment(refID,amount,paymentDescription,userId,PaymentMode.OFFLINE);

          paymentDB.completePayment(offlinePayment);
          courseDB.setPaidFeeToTRUE(userId,selectedCourses);
          // notify student once payment is done
          notificationServices.paymentNotifier(refID, amount, userId);

            // success message
            String message = "Payment of amount " + String.valueOf(amount) + " is completed. Reference id of transaction is " + refID;
            return message;
        } catch (PaymentException | NotificationException e) {
            throw new CRSException(e.getMessage());
        }
    }
}
