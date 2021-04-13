package com.flipkart.src.main.java.com.flipkart.services;

import com.flipkart.Exception.NotificationException;
import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDB;
import com.flipkart.services.NotificationInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class NotificationServices implements NotificationInterface {

    private NotificationDB notificationDB ;

    private static final Logger logger = Logger.getLogger(String.valueOf(NotificationServices.class));

    public NotificationServices(){
        this.notificationDB = new NotificationDB();
    }

    @Override
    public void sendNotificationToUser(final Notification notification, final int userId) throws NotificationException {
        // send the notification to users
        logger.info("Sending Notification to the User " + userId);
       try{
           notificationDB.sendNotificationToUser(notification,userId);
       } catch(Exception ex) {
           throw new NotificationException(ex.getMessage());
       }

    }

    /**
     * This method is used to notify user about payment.
     * @Param referenceId, amount, userId
     * @Throws NotificationException
     * @Return Nothing
     * */
    public void paymentNotifier(String refId,long amount,int userId) throws NotificationException {
        String description = "Payment of amount " + String.valueOf(amount) + " is completed. Reference id of transaction is " + refId;
        Notification notification = new Notification();
        notification.setDescription(description);
        notification.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
        sendNotificationToUser(notification,userId);
    }

    /**
     * This method is used to notify student once admin approve registration request.
     * @Param  userId
     * @Throws NotificationException
     * @Return Nothing
     * */
    public void approvalNotifier(int studentId) throws NotificationException {
        String description = "Admin approved your registration request.";
        String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Notification notification = new Notification();
        notification.setTimeStamp(currentTimeStamp);
        notification.setDescription(description);
        sendNotificationToUser(notification,studentId);
    }
}
