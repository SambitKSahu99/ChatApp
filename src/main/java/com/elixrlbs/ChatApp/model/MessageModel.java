package com.elixrlbs.ChatApp.model;

import com.elixrlbs.ChatApp.constants.MessageConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * MessageModel class with UUID, Message and TimeStamp
 */
@Document(collection = MessageConstants.MESSAGE_COLLECTION_NAME)
public class MessageModel {

    @Id
    private UUID id;
    private String message;
    private String timeStamp;

    public MessageModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
