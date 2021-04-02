package com.flipkart.services;

import com.flipkart.Exception.PaymentException;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Offline;
import com.flipkart.bean.Online;
import com.flipkart.bean.Payment;
import com.flipkart.constants.Bank;
import com.flipkart.constants.PaymentMode;
import com.flipkart.dao.PaymentDB;
import com.flipkart.helper.PaymentValidator;

import java.util.UUID;

public class PaymentServices implements PaymentInterface{
    private NotificationServices notificationServices;

    public PaymentServices(){
        this.notificationServices = new NotificationServices();
    }


    @Override
    public void makeOnlinePayment(String paymentDescription, long amount, String card_number, String name_on_card, String cvv, PaymentMode onlinePaymentMode, String userId) {
        try {
            // first validate all fields related to payment
            PaymentValidator.onlinePaymentValidator(amount,name_on_card,card_number,cvv);

            // generate an unique payment/ referenceId
            String refId = "PMT"+ UUID.randomUUID().toString();
            Online onlinePayment = new Online(refId,amount,paymentDescription,card_number,name_on_card,cvv,onlinePaymentMode,userId);
            PaymentDB.completeOnlinePayment(onlinePayment);

            // Notify student once payment is confirm(payment is inserted into data)
            notificationServices.paymentNotifier(refId, amount, userId);

        } catch (PaymentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void makeOfflinePayment(String paymentDescription, long amount, Bank bank, String userId) {
        try {
          if(amount < 0 ) throw new PaymentException("Amount can not be negative");
          String refID = "PMT" + UUID.randomUUID().toString();
          Offline offlinePayment = new Offline(refID,amount,paymentDescription,bank,userId);

          PaymentDB.completeOfflinePayment(offlinePayment);
          // Notify student once payment is confirm(payment is inserted into data)

          notificationServices.paymentNotifier(refID, amount, userId);
        } catch (PaymentException e) {
            e.printStackTrace();
        }
    }
}
