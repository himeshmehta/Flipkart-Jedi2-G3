package com.flipkart.services;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDB;
import com.sun.tools.corba.se.idl.constExpr.Not;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NotificationServices implements NotificationInterface{



    public NotificationServices(){

    }

    @Override
    public void sendNotificationToUser(final Notification notification, final String userId){
        // send the notification to users
       try{
           NotificationDB.sendNotificationToUSer(notification,userId);
       } catch(Exception ex) {

        }

    }

    @Override
    public void sendNotificationToUsers(final Notification notification, final List<String> userIDs){

    }

    public void paymentNotifier(String refId,long amount,String userId){
        String description = "Payment of amount " + String.valueOf(amount) + " is completed. Reference id of transaction is " + refId;
        String notificationId =  "NOT" + UUID.randomUUID().toString();
        Notification notification = new Notification();
        notification.setNotificationId(notificationId);
        notification.setDescription(description);
        notification.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
        sendNotificationToUser(notification,userId);
    }

    public void approvalNotifier(String studentId){
        String description = "Hey, congrats ! Admin approved your request.You can login now.";
        String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String notificationId = "NOT" + UUID.randomUUID().toString();
        Notification notification = new Notification();
        notification.setNotificationId(notificationId);
        notification.setTimeStamp(currentTimeStamp);
        notification.setDescription(description);
        sendNotificationToUser(notification,studentId);
    }
}
