package com.flipkart.dao;

import com.flipkart.bean.Notification;

public class NotificationDB implements NotificationDBInterface{

    public  Boolean sendNotificationToUser(Notification notification, String userId){
        return Boolean.TRUE;
    }
}
