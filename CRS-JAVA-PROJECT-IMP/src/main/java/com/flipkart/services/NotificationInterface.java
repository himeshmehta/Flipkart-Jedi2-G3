package com.flipkart.services;

import com.flipkart.bean.Notification;

import java.util.List;

public interface NotificationInterface {

    public void sendNotificationToUser(Notification notification, String userID);

    public void sendNotificationToUsers(Notification notification, List<String> userIDs);
}
