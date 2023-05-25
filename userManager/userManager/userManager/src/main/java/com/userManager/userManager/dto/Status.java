package com.userManager.userManager.dto;

public class Status {
    private StatusType status;
    private String message;

    public static enum StatusType {
        SUCCESS, FAILED;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
