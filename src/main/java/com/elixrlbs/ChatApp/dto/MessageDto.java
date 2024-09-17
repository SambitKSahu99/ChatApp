package com.elixrlbs.ChatApp.dto;

/**
 * MessageDto class with Message and TimeStamp
 */
public class MessageDto {

    private String message;
    private String timeStamp;

    public MessageDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
