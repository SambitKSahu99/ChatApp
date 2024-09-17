package com.elixrlbs.ChatApp.exceptionhandling;

/**
 * Custom exception class to handle resource not found exception
 */
public class MessageNotFoundException extends Exception {

    public MessageNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
