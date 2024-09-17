package com.elixrlbs.ChatApp.exceptionhandling;

/**
 * Custom exception class to handle exception within the application
 */
public class MessageException extends Exception{
    public MessageException(String exceptionMessage){
        super(exceptionMessage);
    }
}
