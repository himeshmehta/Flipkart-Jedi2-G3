package com.flipkart.services;

import com.flipkart.Exception.NotificationException;
import com.flipkart.bean.Notification;

public interface NotificationInterface {

    /**
     *
     This method sends the notification to the User.
     @param - notification object, userId
     @throws - NotificationException
     @return - nothing
     **/
    public void sendNotificationToUser(Notification notification, int userID) throws NotificationException;

}
