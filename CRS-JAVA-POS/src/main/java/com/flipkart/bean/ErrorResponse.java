package com.flipkart.bean;


/**
 * The type ErrorResponse
 */
public class ErrorResponse {

    private String message;

    private String executionStatus;

    /**
     * Constructor of ErrorResponse
     * @param message message
     * @param executionStatus execution status
     */
    public ErrorResponse(String message, String executionStatus) {
        this.message = message;
        this.executionStatus = executionStatus;
    }

    /**
     * Gets the message
     * @return String
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message
     * @param message message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the execution status
     * @return String
     */
    public String getExecutionStatus() {
        return executionStatus;
    }

    /**
     * Sets the execution status
     * @param executionStatus execution status
     */
    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }
}
