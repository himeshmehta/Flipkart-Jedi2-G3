package com.flipkart.dao;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.NotificationException;
import com.flipkart.bean.Notification;

public interface NotificationDBInterface {
    /**
     * This method is used to send Notification.
     * @param notification
     * @param userId :- id of course for which professor wants to add grade.
     * @throws NotificationException,CRSException
     */
    public  void sendNotificationToUser(Notification notification, int userId) throws NotificationException, CRSException;
}
