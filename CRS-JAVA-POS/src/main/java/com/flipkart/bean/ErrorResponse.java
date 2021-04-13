package com.flipkart.bean;


/**
 * The type ErrorResponse
 */
public class ErrorResponse {

    private String message;

    private String executionStatus;

    /**
     * Constructor of ErrorResponse
     * @param message
     * @param executionStatus
     */
    public ErrorResponse(String message, String executionStatus) {
        this.message = message;
        this.executionStatus = executionStatus;
    }

    /**
     * Gets the message
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the execution status
     * @return
     */
    public String getExecutionStatus() {
        return executionStatus;
    }

    /**
     * Sets the execution status
     * @param executionStatus
     */
    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }
}
