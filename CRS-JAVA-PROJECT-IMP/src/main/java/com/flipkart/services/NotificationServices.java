package com.flipkart.services;

import com.flipkart.Exception.NotificationException;
import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class NotificationServices implements NotificationInterface{

    private NotificationDB notificationDB ;

    private static final Logger logger = Logger.getLogger(NotificationServices.class);

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

    @Override
    public void sendNotificationToUsers(final Notification notification, final List<String> userIDs){
        logger.info("Sending Notification to the Users");
    }

    public void paymentNotifier(String refId,long amount,int userId) throws NotificationException {
        String description = "Payment of amount " + String.valueOf(amount) + " is completed. Reference id of transaction is " + refId;
        Notification notification = new Notification();
        notification.setDescription(description);
        notification.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
        sendNotificationToUser(notification,userId);
    }

    public void approvalNotifier(int studentId) throws NotificationException {
        String description = "Admin approved your registration request.";
        String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Notification notification = new Notification();
        notification.setTimeStamp(currentTimeStamp);
        notification.setDescription(description);
        sendNotificationToUser(notification,studentId);
    }
}
