package com.flipkart.src.main.java.com.flipkart.services;

import com.flipkart.Exception.NotificationException;
import com.flipkart.bean.Notification;

import java.util.List;

public interface NotificationInterface {

    /**
     *
     This method sends the notification to the User.
     @Param - notification object, userId
     @Throws - NotificationException
     @returns - nothing
     **/
    public void sendNotificationToUser(Notification notification, int userID) throws NotificationException;

}
