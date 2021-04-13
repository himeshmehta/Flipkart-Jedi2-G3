package com.flipkart.src.main.java.com.flipkart.bean;

import javax.validation.constraints.NotNull;

/**
 * The type Notification
 */
public class Notification {

    @NotNull
    private String notificationId;
    @NotNull
    private String description;
    private String timeStamp;

    /**
     * Gets the notification id
     * @return
     */
    public String getNotificationId() {
        return notificationId;
    }

    /**
     * Sets the notification id
     * @param notificationId
     */
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Gets the description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the time stamp
     * @return
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the time stamp
     * @param timeStamp
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
