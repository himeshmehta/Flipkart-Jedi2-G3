package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.NotificationException;
import com.flipkart.Exception.PaymentException;
import com.flipkart.bean.Offline;
import com.flipkart.bean.Online;
import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;
import com.flipkart.dao.PaymentDB;
import com.flipkart.helper.PaymentValidator;

import java.util.UUID;
import java.util.logging.Logger;

public class PaymentServices implements PaymentInterface{
    private NotificationServices notificationServices = new  NotificationServices();
    private PaymentDB paymentDB = new PaymentDB();

    private static final Logger logger = Logger.getLogger(String.valueOf(PaymentServices.class));

    @Override
    public void makeOnlinePayment(String paymentDescription, long amount, String card_number, String name_on_card, String cvv, PaymentMode onlinePaymentMode, int userId) throws CRSException {
        try {
            // first validate all fields related to payment
            PaymentValidator.onlinePaymentValidator(amount,name_on_card,card_number,cvv);
            logger.info("Online Payment Initiated");
            // generate an unique payment/ referenceId
            String refId = "PMT"+ UUID.randomUUID().toString();
            Online onlinePayment = new Online(refId,amount,paymentDescription,card_number,name_on_card,cvv,onlinePaymentMode,userId);
            paymentDB.completeOnlinePayment(onlinePayment);

            // Notify student once payment is confirm(payment is inserted into data)
            notificationServices.paymentNotifier(refId, amount, userId);

        } catch (PaymentException | NotificationException e) {
            throw new CRSException(e.getMessage());
        }
    }

    @Override
    public void makeOfflinePayment(String paymentDescription, long amount, Bank bank, int userId) throws CRSException {
        try {
            logger.info("Offline Payment Initiated");
          if(amount < 0 ) throw new PaymentException("Amount can not be negative");
          String refID = "PMT" + UUID.randomUUID().toString();
          Offline offlinePayment = new Offline(refID,amount,paymentDescription,bank,userId);

          paymentDB.completeOfflinePayment(offlinePayment);
          // Notify student once payment is confirm(payment is inserted into data)

          notificationServices.paymentNotifier(refID, amount, userId);
        } catch (PaymentException | NotificationException e) {
            throw new CRSException(e.getMessage());
        }
    }
}
