package com.flipkart.services;

import com.flipkart.bean.Notification;

import java.util.List;

public interface NotificationInterface {

    /**
     *
     This method sends the notification to the User.
     @Param - notification , userId
     @Throws - Nothing
     @returns - nothing
     **/
    public void sendNotificationToUser(Notification notification, String userID);

    /**
     *
     This method sends the notification to the List of User.
     @Param - notification , List of userIds
     @Throws - Nothing
     @returns - nothing
     **/
    public void sendNotificationToUsers(Notification notification, List<String> userIDs);
}
