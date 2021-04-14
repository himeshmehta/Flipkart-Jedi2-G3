package com.flipkart.services;

import com.flipkart.Exception.NotificationException;
import com.flipkart.bean.Notification;

public interface NotificationInterface {

    /**
     * This method sends the notification to the User.
     * @param notification notification object
     * @param userID user id
     * @throws NotificationException notification exception
     */
    public void sendNotificationToUser(Notification notification, int userID) throws NotificationException;

}
