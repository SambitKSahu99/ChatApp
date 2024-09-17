package com.elixrlbs.ChatApp.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Response Class for success operation
 */
public class SuccessResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object body;

    public SuccessResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
