package com.flipkart.bean;

import javax.validation.constraints.NotNull;

public class ErrorResponse {
    @NotNull
    private String message;
    @NotNull
    private String executionStatus;

    public ErrorResponse(String message, String executionStatus) {
        this.message = message;
        this.executionStatus = executionStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }
}
