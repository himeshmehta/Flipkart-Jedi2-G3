package com.flipkart.dao;

import com.flipkart.bean.Notification;

public interface NotificationDBInterface {
    /**
     * This method is used by professor to add grade for a course in grade card of student.
     * @Param profId :- id of professor who wants to add grade
     * @Param courseId :- id of course for which professor wants to add grade.
     * @Param grade :- grades
     * @Param studentId :- id of student.
     * @Throws Nothing
     * @return Nothing
     */
    public  Boolean sendNotificationToUser(Notification notification, String userId);
}
