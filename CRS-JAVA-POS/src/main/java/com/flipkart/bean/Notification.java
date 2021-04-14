package com.flipkart.bean;


/**
 * The type Notification
 */
public class Notification {

    private String notificationId;
    private String description;
    private String timeStamp;

    /**
     * Gets the notification id
     * @return String
     */
    public String getNotificationId() {
        return notificationId;
    }

    /**
     * Sets the notification id
     * @param notificationId notification id
     */
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Gets the description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the time stamp
     * @return String
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the time stamp
     * @param timeStamp time stamp
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
