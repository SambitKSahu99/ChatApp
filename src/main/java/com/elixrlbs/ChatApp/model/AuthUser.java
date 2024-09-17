package com.elixrlbs.ChatApp.model;

import com.elixrlbs.ChatApp.constants.MessageConstants;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Auth user entity class to keep record of user for login
 */
@Document(collection = MessageConstants.AUTH_USER_COLLECTION_NAME)
public class AuthUser {

    private String userName;
    private String password;
    private boolean isActive;

    public AuthUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}
